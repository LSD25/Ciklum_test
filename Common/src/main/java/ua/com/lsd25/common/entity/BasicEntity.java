package ua.com.lsd25.common.entity;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import org.bson.types.ObjectId;

import java.io.Serializable;

/**
 * @author Victor Zagnitko on 01.04.2014.
 *         Basic entity for all document, that saved in database
 */
public abstract class BasicEntity implements Serializable {

    @Id
    @Indexed
    protected ObjectId id = new ObjectId();

    /**
     *
     */
    public BasicEntity() {
        super();
    }

    public ObjectId getId() {
        return id;
    }

}
