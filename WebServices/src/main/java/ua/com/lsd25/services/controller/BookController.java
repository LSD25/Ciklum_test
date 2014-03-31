package ua.com.lsd25.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.lsd25.common.entity.Book;
import ua.com.lsd25.db.common.service.IBookService;
import ua.com.lsd25.services.response.BasicResponse;
import ua.com.lsd25.services.response.FailResponse;
import ua.com.lsd25.services.response.SuccessResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Book webservice
 *
 * @author Victor Zagnitko on 01.04.2014.
 */
@Controller
@Path(value = "/book")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    /**
     *
     */
    public BookController() {
        super();
    }

    @POST
    @Path(value = "/add-book")
    @Produces(value = "application/json")
    @Consumes(value = "application/json")
    public Response addBook(Book request) {
        BasicResponse basicResponse = null;
        try {
            bookService.addDocumentToCollection(request);
            basicResponse = new SuccessResponse();
        } catch (Exception exc) {
            exc.getStackTrace();
            basicResponse = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(basicResponse.getHttpStatus()).entity(basicResponse).build();
        }
    }

    private Book initBook(Map<String, ?> request) {
        Book book = new Book();
        book.setAuthor(String.valueOf(request.get("author")));
        book.setDescription(String.valueOf(request.get("description")));
        book.setName(String.valueOf(request.get("name")));
        book.setPictureOfCover(String.valueOf(request.get("pictureOfCover")));
        return book;
    }

}
