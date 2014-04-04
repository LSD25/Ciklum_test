package ua.com.lsd25.db.dao;

import com.mongodb.MongoOptions;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Mongo configuration
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
public class MongoOptionsFactoryBean implements FactoryBean<MongoOptions>, InitializingBean {

    private static final MongoOptions MONGO_OPTIONS = new MongoOptions();
    public boolean socketKeepAlive = MONGO_OPTIONS.socketKeepAlive;
    private int connectionsPerHost = MONGO_OPTIONS.connectionsPerHost;
    private int threadsAllowedToBlockForConnectionMultiplier = MONGO_OPTIONS.threadsAllowedToBlockForConnectionMultiplier;
    private int maxWaitTime = MONGO_OPTIONS.maxWaitTime;
    private int connectTimeout = MONGO_OPTIONS.connectTimeout;
    private int socketTimeout = MONGO_OPTIONS.socketTimeout;
    private boolean autoConnectRetry = MONGO_OPTIONS.autoConnectRetry;

    private long maxAutoConnectRetryTime = MONGO_OPTIONS.maxAutoConnectRetryTime;

    private int writeNumber;

    private int writeTimeout;

    private boolean writeFsync;

    private boolean slaveOk = MONGO_OPTIONS.slaveOk;

    public void setConnectionsPerHost(int connectionsPerHost) {
        this.connectionsPerHost = connectionsPerHost;
    }

    public void setThreadsAllowedToBlockForConnectionMultiplier(int threadsAllowedToBlockForConnectionMultiplier) {
        this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
    }

    public void setMaxWaitTime(int maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }


    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public void setSocketKeepAlive(boolean socketKeepAlive) {
        this.socketKeepAlive = socketKeepAlive;
    }

    public void setWriteNumber(int writeNumber) {
        this.writeNumber = writeNumber;
    }

    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public void setWriteFsync(boolean writeFsync) {
        this.writeFsync = writeFsync;
    }

    public void setAutoConnectRetry(boolean autoConnectRetry) {
        this.autoConnectRetry = autoConnectRetry;
    }

    public void setMaxAutoConnectRetryTime(long maxAutoConnectRetryTime) {
        this.maxAutoConnectRetryTime = maxAutoConnectRetryTime;
    }

    public void setSlaveOk(boolean slaveOk) {
        this.slaveOk = slaveOk;
    }

    @SuppressWarnings("deprecation")
    public void afterPropertiesSet() {
        MONGO_OPTIONS.connectionsPerHost = connectionsPerHost;
        MONGO_OPTIONS.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
        MONGO_OPTIONS.maxWaitTime = maxWaitTime;
        MONGO_OPTIONS.connectTimeout = connectTimeout;
        MONGO_OPTIONS.socketTimeout = socketTimeout;
        MONGO_OPTIONS.socketKeepAlive = socketKeepAlive;
        MONGO_OPTIONS.autoConnectRetry = autoConnectRetry;
        MONGO_OPTIONS.maxAutoConnectRetryTime = maxAutoConnectRetryTime;
        MONGO_OPTIONS.slaveOk = slaveOk;
        MONGO_OPTIONS.w = writeNumber;
        MONGO_OPTIONS.wtimeout = writeTimeout;
        MONGO_OPTIONS.fsync = writeFsync;
    }

    public MongoOptions getObject() {
        return MONGO_OPTIONS;
    }

    public Class<?> getObjectType() {
        return MongoOptions.class;
    }

    public boolean isSingleton() {
        return true;
    }

}

