package ua.com.lsd25.client.controller.book;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.lsd25.client.service.ServerMediatorService;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This controller handle request from the client, when create a new book
 *
 * @author Victor Zagnitko on 06.04.2014.
 */
@Controller
@RequestMapping(value = "/book")
public class CreateBookController {

    private static final String ADD_BOOK_URI = "add-book";

    @Autowired
    @Qualifier(value = "serverMediatorService")
    private ServerMediatorService mServerMediatorService;

    /**
     *
     */
    public CreateBookController() {
        super();
    }

    @RequestMapping(value = "/create-book", method = RequestMethod.GET)
    public String createBooPageController() {
        return "create-book-page";
    }

    @RequestMapping(value = "/create-book", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ?> createBookController(@RequestBody String request) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            HttpUriRequest httpUriRequest = new HttpPost(new URI(this.mServerMediatorService.getUrl(ADD_BOOK_URI)));
            ((HttpPost) httpUriRequest).setEntity(new StringEntity(request));
            response.putAll(this.mServerMediatorService.sendJsonRequestWithBody(httpUriRequest));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return response;
    }

}
