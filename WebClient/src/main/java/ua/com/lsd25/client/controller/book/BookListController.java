package ua.com.lsd25.client.controller.book;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.lsd25.client.service.ServerMediatorService;

import java.net.URI;

/**
 * This controller handle request from the client, when client select list book's
 *
 * @author Victor Zagnitko on 02.04.2014.
 */
@Controller
@RequestMapping(value = "/book")
public class BookListController {

    private static final Logger LOG = LoggerFactory.getLogger(BookListController.class);

    private static final String LIST_URI = "list";

    @Autowired
    @Qualifier(value = "serverMediatorService")
    private ServerMediatorService mServerMediatorService;

    /**
     *
     */
    public BookListController() {
        super();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView bookPageController() {
        ModelAndView model = new ModelAndView("books-page");
        try {
            LOG.info("Start book page");
            HttpUriRequest httpUriRequest = new HttpGet(new URI(this.mServerMediatorService.getUrl(LIST_URI)));
            model.addObject("books", this.mServerMediatorService.getListEntities(httpUriRequest));
        } catch (Exception exc) {
            exc.getStackTrace();
        }
        return model;
    }

}
