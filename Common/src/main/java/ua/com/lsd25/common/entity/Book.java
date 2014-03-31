package ua.com.lsd25.common.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import org.bson.types.ObjectId;

import java.io.Serializable;

/**
 * @author Victor Zagnitko on 31.03.2014.
 *         This entity describe Book
 */
@Entity(noClassnameStored = true)
public final class Book implements Serializable {

    @Id
    @Indexed
    private ObjectId id = new ObjectId();

    private String name;

    private String author;

    private String description;

    private String pictureOfCover;

    /**
     *
     */
    public Book() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureOfCover() {
        return pictureOfCover;
    }

    public void setPictureOfCover(String pictureOfCover) {
        this.pictureOfCover = pictureOfCover;
    }

    public ObjectId getId() {
        return id;
    }

}
