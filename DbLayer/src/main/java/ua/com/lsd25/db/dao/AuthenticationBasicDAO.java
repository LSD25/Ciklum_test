package ua.com.lsd25.db.dao;

import com.google.code.morphia.DatastoreImpl;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @param <T> Collection to store in db
 * @param <K> Key in Collection
 * @author Victor Zagnitko on 31.03.2014.
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
     * @param isAuthenticated check auth
     */
    protected AuthenticationBasicDAO(Mongo mongo, Morphia morphia, String dbName, String username, String password,
                                     boolean isAuthenticated) {
        super(new DatastoreImpl(morphia, mongo, dbName));
        if (isAuthenticated) {
            if (!this.ds.getDB().isAuthenticated() && !this.ds.getDB().authenticate(username, password.toCharArray())) {
                throw new RuntimeException("MongoDB authentication failed: " + dbName);
            }
        }
        log.info("Loaded entity: " + this.entityClazz.getSimpleName());
    }

}
