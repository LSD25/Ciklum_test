package ua.com.lsd25.db.dao;

import com.google.code.morphia.DatastoreImpl;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.Query;
import com.google.common.base.Preconditions;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @param <T> Collection to store in db
 * @param <K> Key in Collection
 * @author Victor Zagnitko on 31.03.2014.
 *         <p/>
 *         This class contains constructor's for auth
 */
public class AuthenticationBasicDAO<T, K> extends BasicDAO<T, K> {

    private final Logger log = LoggerFactory.getLogger(AuthenticationBasicDAO.class);

    /**
     * Constructor for create connection to database
     *
     * @param mongo           object, connection for Db
     * @param morphia         ORM for MongoDB
     * @param dbName          collection name
     * @param username        to connect to database
     * @param password        to connect to database
     * @param isAuthenticated
     */
    protected AuthenticationBasicDAO(Mongo mongo, Morphia morphia, String dbName, String username, String password,
                                     boolean isAuthenticated, Class<T> entityClazz) {
        super(new DatastoreImpl(morphia, mongo, dbName));
        if (isAuthenticated) {
            if (!this.ds.getDB().isAuthenticated() && !this.ds.getDB().authenticate(username, password.toCharArray())) {
                throw new RuntimeException("MongoDB authentication failed: " + dbName);
            }
        }
        log.info("Loaded entity: " + this.entityClazz.getSimpleName());
    }

    /**
     * This method is used for find document by string id
     *
     * @param sId to find in database
     * @return object if entity was found, otherwise null
     */
    public T findEntityById(String sId) {
        if (sId == null || sId.isEmpty() || !ObjectId.isValid(sId)) {
            throw new IllegalArgumentException("Id argument: " + sId + "!");
        }
        return findEntityById(new ObjectId(sId));
    }

    /**
     * This method is used for find document by object id
     *
     * @param id to find in database
     * @return object if entity was found, otherwise null
     */
    public T findEntityById(ObjectId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id argument: " + id + "!");
        }
        Query<T> query = getDatastore().createQuery(this.entityClazz);
        query = query.field("_id").equal(id);
        return query.get();
    }

    /**
     * Update document in database
     *
     * @param entity to update
     */
    public void update(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity argument is wrong!");
        }
        Key<T> key = getDatastore().merge(entity);
        Preconditions.checkNotNull(key, "Entity don't merged");
    }

    /**
     * Delete document from collection by object id
     *
     * @param id to delete in database
     * @return
     */
    public WriteResult delete(ObjectId id) {
        T entity = findEntityById(id);
        Preconditions.checkNotNull(entity, "Entity not found in database");
        return delete(entity);
    }

    /**
     * Delete document from collection by string id
     *
     * @param sId to delete in database
     * @return
     */
    public WriteResult delete(String sId) {
        T entity = findEntityById(sId);
        Preconditions.checkNotNull(entity, "Entity not found in database");
        return delete(entity);
    }

    /**
     * Save document in collection
     *
     * @param entity to add in collection
     */
    public void addDocumentToCollection(T entity) {
        Preconditions.checkNotNull(entity, "Entity argument is wrong");
        Key<T> key = getDatastore().save(entity);
        Preconditions.checkNotNull(key, "Entity don't saved");
    }

}
