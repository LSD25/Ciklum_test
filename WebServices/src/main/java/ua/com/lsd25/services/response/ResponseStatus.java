package ua.com.lsd25.services.response;

/**
 * Contains main http response status
 *
 * @author Victor Zagnitko on 01.04.2014.
 */
public enum ResponseStatus {

    OK(200), INTERNAL_SERVER_ERROR(500);

    private int httpStatus;

    ResponseStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

}
