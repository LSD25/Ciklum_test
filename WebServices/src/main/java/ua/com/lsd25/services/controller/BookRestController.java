package ua.com.lsd25.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class BookRestController {

    private final Logger log = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    @Qualifier(value = "bookService")
    private IBookService mBookService;

    /**
     *
     */
    public BookRestController() {
        super();
    }

    @GET
    @Path(value = "/{id}")
    @Produces(value = "application/json")
    public Response findBookByIdController(@PathParam(value = "id") String id) {
        BasicResponse response = null;
        try {
            response = new SuccessResponse<>(this.mBookService.findEntityById(id));
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
            response = new SuccessResponse<>(this.mBookService.getBooks());
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
            this.mBookService.update(request);
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
            this.mBookService.addDocumentToCollection(request);
            response = new SuccessResponse<>();
        } catch (Exception exc) {
            exc.getStackTrace();
            response = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(response.getHttpStatus()).entity(response).build();
        }
    }

    @DELETE
    @Path(value = "/{id}")
    @Produces(value = "application/json")
    public Response deleteBookController(@PathParam(value = "id") String id) {
        BasicResponse response = null;
        try {
            response = new SuccessResponse<>(this.mBookService.delete(id));
        } catch (Exception exc) {
            exc.getStackTrace();
            response = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(response.getHttpStatus()).entity(response).build();
        }
    }

}
