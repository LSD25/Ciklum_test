package ua.com.lsd25.db.common.service;

import ua.com.lsd25.common.entity.Book;

import java.util.List;

/**
 * Describe book service
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
public interface IBookService extends IBasicService<Book> {

    /**
     * Get all books in collection
     *
     * @return all books in collection
     */
    List<Book> getBooks();

}
