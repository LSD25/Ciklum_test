package ua.com.lsd25.db.common;

import ua.com.lsd25.common.entity.Book;

import java.util.List;

/**
 * This interface contains method for BookDAO class
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
public interface IBookDao extends IBasicDao<Book> {

    /**
     * Get all books in collection
     * @return all books in collection
     */
    List<Book> getBooks();

}
