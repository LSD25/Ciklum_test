package ua.com.lsd25.db.service;

import org.bson.types.ObjectId;
import ua.com.lsd25.db.common.dao.IBasicDao;
import ua.com.lsd25.db.common.service.IBasicService;

/**
 * This class contains basic method for all services
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
public abstract class BasicService<T> implements IBasicService<T> {

    protected IBasicDao mBasicDao;

    /**
     *
     */
    public BasicService() {
        super();
    }

    /**
     * This method is used for find document by string id
     *
     * @param sId to find in database
     * @return object if entity was found, otherwise null
     */
    @Override
    public T findEntityById(String sId) {
        return (T) this.mBasicDao.findEntityById(sId);
    }

    /**
     * This method is used for find document by object id
     *
     * @param id to find in database
     * @return object if entity was found, otherwise null
     */
    @Override
    public T findEntityById(ObjectId id) {
        return (T) this.mBasicDao.findEntityById(id);
    }

    /**
     * Update document in database
     *
     * @param entity to update
     */
    @Override
    public String update(T entity) {
        return this.mBasicDao.update(entity);
    }

    /**
     * Delete document from collection by object id
     *
     * @param id to delete in database
     * @return result of operation
     */
    @Override
    public String delete(ObjectId id) {
        return this.mBasicDao.delete(id);
    }

    /**
     * Delete document from collection by string id
     *
     * @param sId to delete in database
     * @return result of operation
     */
    @Override
    public String delete(String sId) {
        return this.mBasicDao.delete(sId);
    }

    /**
     * Save document in collection
     *
     * @param entity to add in collection
     */
    @Override
    public String addDocumentToCollection(T entity) {
        return this.mBasicDao.addDocumentToCollection(entity);
    }

    /**
     * Init Dao with Spring IoC
     *
     * @param basicDao
     */
    protected abstract void initDao(IBasicDao basicDao);

}
