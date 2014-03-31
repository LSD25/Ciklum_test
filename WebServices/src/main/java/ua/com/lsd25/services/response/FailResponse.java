package ua.com.lsd25.services.response;

/**
 * This class describe entity for fail response
 *
 * @author Victor Zagnitko on 01.04.2014.
 */
public final class FailResponse extends BasicResponse {

    private String errorMessage;

    /**
     *
     */
    public FailResponse() {
        super();
    }

    public FailResponse(String errorMessage) {
        this.errorMessage = errorMessage;
        this.messageStatus = ResponseStatus.INTERNAL_SERVER_ERROR.name();
        this.httpStatus = ResponseStatus.INTERNAL_SERVER_ERROR.getHttpStatus();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
