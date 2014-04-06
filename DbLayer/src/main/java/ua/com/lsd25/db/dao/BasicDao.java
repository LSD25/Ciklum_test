package ua.com.lsd25.db.dao;

import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.google.common.base.Preconditions;
import com.mongodb.Mongo;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.lsd25.db.common.dao.IBasicDao;
import ua.com.lsd25.db.dao.status.DaoStatusOperation;

/**
 * Basic DAO for all DAO, this class contains general method
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
public abstract class BasicDao<T, K> extends AuthenticationBasicDAO<T, K> implements IBasicDao<T> {

    private static final Logger LOG = LoggerFactory.getLogger(BasicDao.class);

    /**
     * Constructor for create connection to database
     *
     * @param mongo           object, connection for Db
     * @param morphia         ORM for MongoDB
     * @param dbName          collection name
     * @param username        to connect to database
     * @param password        to connect to database
     * @param isAuthenticated check auth
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
    @Override
    public T findEntityById(String sId) {
        if (sId == null || sId.isEmpty() || !ObjectId.isValid(sId)) {
            throw new IllegalArgumentException("Id argument: '" + sId + "' is wrong!");
        }
        return findEntityById(new ObjectId(sId));
    }

    /**
     * This method is used for find document by object id
     *
     * @param id to find in database
     * @return object if entity was found, otherwise null
     */
    @Override
    public T findEntityById(ObjectId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id argument: '" + id + "' is wrong!");
        }
        LOG.info("id: " + id.toStringMongod() + " is valid");
        Query<T> query = getDatastore().createQuery(this.entityClazz);
        query = query.field("_id").equal(id);
        T entity = query.get();
        if (entity != null) {
            LOG.info("Find entity: " + entity.toString());
        } else {
            LOG.info("Not found entity: " + id);
            throw new NullPointerException(DaoStatusOperation.FAIL_FOUND_ENTITY);
        }
        return entity;
    }

    /**
     * Update document in database
     *
     * @param entity to update
     */
    @Override
    public String update(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity argument is wrong!");
        }
        Key<T> key = getDatastore().merge(entity);
        if (key == null) {
            LOG.info("Entity don't merged");
            throw new NullPointerException(DaoStatusOperation.FAIL_UPDATE_ENTITY);
        }
        LOG.info("Success merged");
        return DaoStatusOperation.SUCCESS_UPDATE_ENTITY;
    }

    /**
     * Delete document from collection by object id
     *
     * @param id to delete in database
     * @return result of operation
     */
    @Override
    public String delete(ObjectId id) {
        T entity = findEntityById(id);
        Preconditions.checkNotNull(entity, "Entity not found in database");
        LOG.info("id: " + id.toStringMongod() + " is valid");
        try {
            delete(entity);
            LOG.info("Success delete entity: " + id.toStringMongod());
            return DaoStatusOperation.SUCCESS_DELETE_ENTITY;
        } catch (Exception exc) {
            exc.getStackTrace();
            LOG.info("Fail delete entity: " + id.toStringMongod());
            throw new UnsupportedOperationException(DaoStatusOperation.FAIL_DELETE_ENTITY);
        }
    }

    /**
     * Delete document from collection by string id
     *
     * @param sId to delete in database
     * @return result of operation
     */
    @Override
    public String delete(String sId) {
        T entity = findEntityById(sId);
        Preconditions.checkNotNull(entity, "Entity not found in database");
        LOG.info("id: " + sId + " is valid");
        try {
            delete(entity);
            LOG.info("Success delete entity: " + sId);
            return DaoStatusOperation.SUCCESS_DELETE_ENTITY;
        } catch (Exception exc) {
            exc.getStackTrace();
            LOG.info("Fail delete entity: " + sId);
            throw new UnsupportedOperationException(DaoStatusOperation.FAIL_DELETE_ENTITY);
        }
    }

    /**
     * Save document in collection
     *
     * @param entity to add in collection
     */
    @Override
    public String addDocumentToCollection(T entity) {
        Preconditions.checkNotNull(entity, "Entity argument is wrong");
        Key<T> key = getDatastore().save(entity);
        Preconditions.checkNotNull(key, "Entity don't saved");
        if (key == null) {
            LOG.info("Entity don't saved");
            throw new NullPointerException(DaoStatusOperation.FAIL_ADDED_NEW_ENTITY);
        }
        LOG.info("Success added new document");
        return DaoStatusOperation.SUCCESS_ADDED_NEW_ENTITY;
    }

}
