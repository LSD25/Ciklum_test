package ua.com.lsd25.services.controller;

import org.springframework.http.HttpStatus;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Test connection with server
 *
 * @author Victor Zagnitko on 06.04.2014.
 */
@Path(value = "/test")
public class TestServerConnectionServer {

    /**
     *
     */
    public TestServerConnectionServer() {
        super();
    }

    @POST
    @Path(value = "/server")
    public Response findBookByIdController() {
        return Response.status(HttpStatus.OK.value()).build();
    }

}
