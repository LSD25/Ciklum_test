package ua.com.lsd25.db.service;

import com.mongodb.WriteResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.lsd25.db.common.service.IBasicService;
import ua.com.lsd25.db.dao.BasicDao;

/**
 * This class contains basic method for all services
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
public abstract class BasicService<T> implements IBasicService<T> {

    @Autowired
    protected BasicDao mBasicDao;

    /**
     *
     */
    public BasicService() {
        super();
    }

    abstract void setDao(BasicDao basicDao);

    @Override
    public T findEntityById(String sId) {
        return (T) this.mBasicDao.findEntityById(sId);
    }

    @Override
    public T findEntityById(ObjectId id) {
        return (T) this.mBasicDao.findEntityById(id);
    }

    @Override
    public void update(T entity) {
        this.mBasicDao.update(entity);
    }

    @Override
    public WriteResult delete(ObjectId id) {
        return this.mBasicDao.delete(id);
    }

    @Override
    public WriteResult delete(String sId) {
        return this.mBasicDao.delete(sId);
    }

    @Override
    public void addDocumentToCollection(T entity) {
        this.mBasicDao.addDocumentToCollection(entity);
    }

}
