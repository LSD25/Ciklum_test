package ua.com.lsd25.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.lsd25.common.entity.Book;
import ua.com.lsd25.db.common.dao.IBookDao;
import ua.com.lsd25.db.common.service.IBookService;
import ua.com.lsd25.db.dao.BasicDao;

import java.util.List;

/**
 * This class contains all method's for work with database
 *
 * @author Victor Zagnitko on 31.03.2014.
 */
@Service
public class BookService extends BasicService<Book> implements IBookService {

    /**
     *
     */
    public BookService() {
        super();
    }

    @Autowired
    public void setDao(BasicDao bookDao) {
        this.mBasicDao = bookDao;
    }

    @Override
    public List<Book> getBooks() {
        return ((IBookDao) this.mBasicDao).getBooks();
    }

}
