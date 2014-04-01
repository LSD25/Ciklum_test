package ua.com.lsd25.services.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Basic controller describe general logic for all controllers
 *
 * @author Victor Zagnitko on 01.04.2014.
 */
public abstract class BasicController {

    private static final String EMPTY_STRING = "";

    @Autowired
    private Gson gson;

    /**
     *
     */
    public BasicController() {
        super();
    }

    /**
     * @param object to serialize
     * @param <T>    Type of seriliazation object
     * @return String of object
     */
    protected <T> String getSerializationObject(T object) {
        String serializationObj;
        try {
            serializationObj = gson.toJson(object);
        } catch (Exception exc) {
            exc.getStackTrace();
            serializationObj = EMPTY_STRING;
        }
        return serializationObj;
    }

}
