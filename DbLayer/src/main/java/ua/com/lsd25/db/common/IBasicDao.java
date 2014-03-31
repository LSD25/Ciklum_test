package ua.com.lsd25.db.common;

import com.mongodb.WriteResult;
import org.bson.types.ObjectId;

/**
 * In this dao describe basic method for all DAO
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
public interface IBasicDao<T> {

    /**
     * This method is used for find document by string id
     *
     * @param sId to find in database
     * @return object if entity was found, otherwise null
     */
    T findEntityById(String sId);

    /**
     * This method is used for find document by object id
     *
     * @param id to find in database
     * @return object if entity was found, otherwise null
     */
    T findEntityById(ObjectId id);

    /**
     * Update document in database
     *
     * @param entity to update
     */
    void update(T entity);

    /**
     * Delete document from collection by object id
     *
     * @param id to delete in database
     * @return
     */
    WriteResult delete(ObjectId id);

    /**
     * Delete document from collection by string id
     *
     * @param sId to delete in database
     * @return
     */
    WriteResult delete(String sId);

    /**
     * Save document in collection
     *
     * @param entity to add in collection
     */
    void addDocumentToCollection(T entity);

}
