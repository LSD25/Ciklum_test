package ua.com.lsd25.db.dao;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.lsd25.common.entity.Book;
import ua.com.lsd25.db.common.dao.IBookDao;

import java.util.List;

/**
 * This class contains all methods for Book DAO
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
@Repository
public class BookDao extends BasicDao<Book, ObjectId> implements IBookDao {

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
    @Autowired
    protected BookDao(Mongo mongo, Morphia morphia, String dbName, String username, String password, boolean isAuthenticated) {
        super(mongo, morphia, dbName, username, password, isAuthenticated);
    }

    @Override
    public List<Book> getBooks() {
        return getDatastore().createQuery(Book.class).asList();
    }

}
