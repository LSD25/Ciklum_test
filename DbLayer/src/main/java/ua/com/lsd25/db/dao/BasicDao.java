package ua.com.lsd25.db.dao;

import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.google.common.base.Preconditions;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Victor Zagnitko on 31.03.2014.
 */
public abstract class BasicDao<T, K> extends AuthenticationBasicDAO<T, K> {

    private final Logger log = LoggerFactory.getLogger(BasicDao.class);

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
    protected BasicDao(Mongo mongo, Morphia morphia, String dbName, String username, String password, boolean isAuthenticated) {
        super(mongo, morphia, dbName, username, password, isAuthenticated);
    }


    /**
     * This method is used for find document by string id
     *
     * @param sId to find in database
     * @return object if entity was found, otherwise null
     */
    public T findEntityById(String sId) {
        if (sId == null || sId.isEmpty() || !ObjectId.isValid(sId)) {
            throw new IllegalArgumentException("Id argument: " + sId + " is wrong!");
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
            throw new IllegalArgumentException("Id argument: " + id + " is wrong!");
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
        log.info("Success merged");
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
        log.info("Success added new document");
    }

}
