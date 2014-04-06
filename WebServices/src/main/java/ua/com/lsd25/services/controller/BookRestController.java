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
 * This controller handle request from the throught REST
 *
 * @author Victor Zagnitko on 01.04.2014.
 */
@Controller
@Path(value = "/book")
public class BookRestController {

    private final Logger LOG = LoggerFactory.getLogger(BookRestController.class);

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
            LOG.info("Success found the book");
        } catch (Exception exc) {
            exc.getStackTrace();
            LOG.info("Fail found the book");
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
            LOG.info("Success take the list book");
        } catch (Exception exc) {
            exc.getStackTrace();
            LOG.info("Fail take the list book");
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
            response = new SuccessResponse<>(this.mBookService.update(request));
            LOG.info("Success update the book");
        } catch (Exception exc) {
            exc.getStackTrace();
            LOG.info("Fail update the book");
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
            response = new SuccessResponse<>(this.mBookService.addDocumentToCollection(request));
            LOG.info("Success added a new book");
        } catch (Exception exc) {
            exc.getStackTrace();
            LOG.info("Fail added a new book");
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
            LOG.info("Success deleted a new book");
        } catch (Exception exc) {
            exc.getStackTrace();
            LOG.info("Fail deleted a new book");
            response = new FailResponse(exc.getMessage());
        } finally {
            return Response.status(response.getHttpStatus()).entity(response).build();
        }
    }

}
