package ua.com.lsd25.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.lsd25.common.entity.Book;
import ua.com.lsd25.common.response.BasicResponse;
import ua.com.lsd25.common.response.FailResponse;
import ua.com.lsd25.common.response.SuccessResponse;
import ua.com.lsd25.db.common.service.IBookService;

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

    @GET
    @Path(value = "/{id}")
    @Produces(value = "application/json")
    public Response findBookByIdController(@PathParam(value = "id") String id) {
        BasicResponse response = null;
        try {
            response = new SuccessResponse<>(bookService.findEntityById(id));
        } catch (Exception exc) {
            exc.getStackTrace();
            response = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(response.getHttpStatus()).entity(response).build();
        }
    }

    @GET
    @Path(value = "/list")
    @Produces(value = "application/json")
    public Response listBookController() {
        BasicResponse response = null;
        try {
            response = new SuccessResponse<>(bookService.getBooks());
        } catch (Exception exc) {
            exc.getStackTrace();
            response = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(response.getHttpStatus()).entity(response).build();
        }
    }

    @PUT
    @Path(value = "/update")
    @Produces(value = "application/json")
    @Consumes(value = "application/json")
    public Response updateBookController(Book request) {
        BasicResponse response = null;
        try {
            bookService.update(request);
            response = new SuccessResponse<>();
        } catch (Exception exc) {
            exc.getStackTrace();
            response = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(response.getHttpStatus()).entity(response).build();
        }
    }

    @POST
    @Path(value = "/add-book")
    @Produces(value = "application/json")
    @Consumes(value = "application/json")
    public Response addBookController(Book request) {
        BasicResponse response = null;
        try {
            bookService.addDocumentToCollection(request);
            response = new SuccessResponse<>();
        } catch (Exception exc) {
            exc.getStackTrace();
            response = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(response.getHttpStatus()).entity(response).build();
        }
    }

    @DELETE
    @Path(value = "/{id}/delete")
    @Produces(value = "application/json")
    public Response deleteBookController(@PathParam(value = "id") String id) {
        BasicResponse response = null;
        try {
            response = new SuccessResponse<>(bookService.delete(id));
        } catch (Exception exc) {
            exc.getStackTrace();
            response = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(response.getHttpStatus()).entity(response).build();
        }
    }

}
