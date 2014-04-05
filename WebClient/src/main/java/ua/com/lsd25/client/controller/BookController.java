package ua.com.lsd25.client.controller;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.com.lsd25.client.service.ServerMediatorService;
import ua.com.lsd25.common.entity.Book;
import ua.com.lsd25.common.response.BasicResponse;
import ua.com.lsd25.common.response.FailResponse;
import ua.com.lsd25.common.response.SuccessResponse;

import java.net.URI;

/**
 * @author Victor Zagnitko on 02.04.2014.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    private static final String LIST = "list";

    @Autowired
    @Qualifier(value = "serverMediatorService")
    private ServerMediatorService mServerMediatorService;

    /**
     *
     */
    public BookController() {
        super();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView bookPageController() {
        ModelAndView model = new ModelAndView("books-page");
        try {
            LOG.info("Start book page");
            HttpUriRequest httpUriRequest = new HttpGet(new URI(this.mServerMediatorService.getUrl(LIST)));
            model.addObject("books", this.mServerMediatorService.getBooks(httpUriRequest));
        } catch (Exception exc) {
            exc.getStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Book findBookByIdController(@PathVariable String id) {
        LOG.info("Start find book by id: " + id);
        Book book = null;
        try {
            HttpUriRequest httpUriRequest = new HttpGet(new URI(this.mServerMediatorService.getUrl(id)));
            book = this.mServerMediatorService.getEntity(Book.class, httpUriRequest);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return book;
    }

    @RequestMapping(value = "/concrete", method = RequestMethod.GET)
    public String findBookPageController() {
        return "concrete-book-page";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    BasicResponse deleteBookByIdController(@PathVariable String id) {
        LOG.info("Start find book by id: " + id);
        BasicResponse response;
        try {
            HttpUriRequest httpUriRequest = new HttpDelete(new URI(this.mServerMediatorService.getUrl(id)));
            response = new SuccessResponse<>(this.mServerMediatorService.deleteBook(httpUriRequest));
        } catch (Exception exc) {
            exc.getStackTrace();
            response = new FailResponse();
        }
        return response;
    }

}
