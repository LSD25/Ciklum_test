package ua.com.lsd25.common.response;

import java.io.Serializable;

/**
 * This class describe basic response from the server to backend
 *
 * @author Victor Zagnitko on 01.04.2014.
 */
public abstract class BasicResponse implements Serializable {

    protected int httpStatus;

    protected String messageStatus;

    /**
     *
     */
    public BasicResponse() {
        super();
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

}
