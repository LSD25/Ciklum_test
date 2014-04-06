package ua.com.lsd25.client.controller.book;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.lsd25.client.service.ServerMediatorService;
import ua.com.lsd25.common.entity.Book;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This controller handle request from the client, when client select any book
 *
 * @author Victor Zagnitko on 06.04.2014.
 */
@Controller
@RequestMapping(value = "/book")
public class ConcreteBookController {

    private static final Logger LOG = LoggerFactory.getLogger(ConcreteBookController.class);

    private static final String UPDATE = "update";

    @Autowired
    @Qualifier(value = "serverMediatorService")
    private ServerMediatorService mServerMediatorService;

    /**
     *
     */
    public ConcreteBookController() {
        super();
    }

    @RequestMapping(value = "/concrete", method = RequestMethod.GET)
    public ModelAndView findBookPageController(@RequestParam(required = false) String id) {
        ModelAndView model = new ModelAndView("concrete-book-page");
        if(id != null && !id.isEmpty()) {
            Map<String, Object> response = new LinkedHashMap<>();
            try {
                HttpUriRequest httpUriRequest = new HttpGet(new URI(this.mServerMediatorService.getUrl(id)));
                response.putAll(this.mServerMediatorService.sendJsonRequestWithBody(httpUriRequest));
            } catch (Exception exc) {
                exc.getStackTrace();
            }
            model.addObject("book", response);
        }
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody Map<String, ?> updateBookController(@RequestBody String request) {
        LOG.info("Start update book");
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            HttpUriRequest httpUriRequest = new HttpPut(new URI(this.mServerMediatorService.getUrl(UPDATE)));
            ((HttpPut)httpUriRequest).setEntity(new StringEntity(request));
            response.putAll(this.mServerMediatorService.sendJsonRequestWithBody(httpUriRequest));
        } catch (Exception exc) {
            exc.getStackTrace();
        }
        return response;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    Map<String, ?> deleteBookByIdController(@PathVariable String id) {
        LOG.info("Start find book by id: " + id);
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            HttpUriRequest httpUriRequest = new HttpDelete(new URI(this.mServerMediatorService.getUrl(id)));
            response.putAll(this.mServerMediatorService.sendJsonRequestWithBody(httpUriRequest));
        } catch (Exception exc) {
            exc.getStackTrace();
        }
        return response;
    }

}
