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

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

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
    public Response addBookController(Book request) {
        BasicResponse basicResponse = null;
        try {
            bookService.addDocumentToCollection(request);
            basicResponse = new SuccessResponse<>();
        } catch (Exception exc) {
            exc.getStackTrace();
            basicResponse = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(basicResponse.getHttpStatus()).entity(basicResponse).build();
        }
    }

    @GET
    @Path(value = "/{id}")
    @Produces(value = "application/json")
    public Response findBookByIdController(@PathParam(value = "id") String id) {
        BasicResponse basicResponse = null;
        try {
            basicResponse = new SuccessResponse<>(bookService.findEntityById(id));
        } catch (Exception exc) {
            exc.getStackTrace();
            basicResponse = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(basicResponse.getHttpStatus()).entity(basicResponse).build();
        }
    }

    @PUT
    @Path(value = "/update")
    @Produces(value = "application/json")
    @Consumes(value = "application/json")
    public Response updateBookController(Book request) {
        BasicResponse basicResponse = null;
        try {
            bookService.update(request);
            basicResponse = new SuccessResponse<>();
        } catch (Exception exc) {
            exc.getStackTrace();
            basicResponse = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(basicResponse.getHttpStatus()).entity(basicResponse).build();
        }
    }

    @DELETE
    @Path(value = "/{id}/delete")
    @Produces(value = "application/json")
    public Response deleteBookController(@PathParam(value = "id") String id) {
        BasicResponse basicResponse = null;
        try {
            basicResponse = new SuccessResponse<>(bookService.delete(id));
        } catch (Exception exc) {
            exc.getStackTrace();
            basicResponse = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(basicResponse.getHttpStatus()).entity(basicResponse).build();
        }
    }

    @GET
    @Path(value = "/list")
    @Produces(value = "application/json")
    public Response listBookController() {
        BasicResponse basicResponse = null;
        try {
            basicResponse = new SuccessResponse<>(bookService.getBooks());
        } catch (Exception exc) {
            exc.getStackTrace();
            basicResponse = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(basicResponse.getHttpStatus()).entity(basicResponse).build();
        }
    }

}
