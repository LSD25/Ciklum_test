package ua.com.lsd25.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.lsd25.client.service.ServerMediatorService;

/**
 * @author Victor Zagnitko on 02.04.2014.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

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
        ModelAndView model = new ModelAndView("book-page");
        try {
            LOG.info("Start book page");
            model.addObject("books", this.mServerMediatorService.getBooks());
        } catch (Exception exc) {
            exc.getStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findBookByIdController(@PathVariable String id) {
        LOG.info("Start find book by id: " + id);
        ModelAndView model = new ModelAndView("book-page");
        try {
            model.addObject("book", this.mServerMediatorService.getBook(id));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return model;
    }

}
