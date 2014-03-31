package ua.com.lsd25.services.response;

/**
 * This class describe entity for success response
 * @author Victor Zagnitko on 01.04.2014.
 */
public final class SuccessResponse extends BasicResponse {

    /**
     *
     */
    public SuccessResponse() {
        super();
        this.httpStatus = ResponseStatus.OK.getHttpStatus();
        this.messageStatus = ResponseStatus.OK.name();
    }

}
