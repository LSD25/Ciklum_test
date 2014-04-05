package ua.com.lsd25.common.response;

/**
 * This class describe entity for fail response
 *
 * @author Victor Zagnitko on 01.04.2014.
 */
public final class FailResponse extends BasicResponse {

    /**
     *
     */
    public FailResponse() {
        this(null);
    }

    public FailResponse(String errorMessage) {
        this.message = errorMessage;
        this.messageStatus = ResponseStatus.INTERNAL_SERVER_ERROR.name();
        this.httpStatus = ResponseStatus.INTERNAL_SERVER_ERROR.getHttpStatus();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
