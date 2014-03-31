package ua.com.lsd25.common.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.sun.corba.se.spi.ior.ObjectId;

/**
 * @author Victor Zagnitko on 31.03.2014.
 *         This entity describe Book
 */
@Entity(noClassnameStored = true)
public class Book {

    @Id
    @Indexed
    private ObjectId id;

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

    public void setId(ObjectId id) {
        this.id = id;
    }



}
