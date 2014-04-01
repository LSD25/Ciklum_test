package ua.com.lsd25.services.response;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * This class describe entity for success response
 *
 * @param <T> Describe entity for send client
 * @author Victor Zagnitko on 01.04.2014.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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
