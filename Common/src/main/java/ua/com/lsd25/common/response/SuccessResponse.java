package ua.com.lsd25.common.response;

/**
 * This class describe entity for success response
 *
 * @param <T> Describe entity for send client
 * @author Victor Zagnitko on 01.04.2014.
 */
public final class SuccessResponse<T> extends BasicResponse {

    private T entity;

    /**
     *
     */
    public SuccessResponse() {
        super();
        this.httpStatus = ResponseStatus.OK.getHttpStatus();
        this.messageStatus = ResponseStatus.OK.name();
    }

    public SuccessResponse(String message) {
        this();
        this.message = message;
    }

    public SuccessResponse(T entity) {
        this();
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
