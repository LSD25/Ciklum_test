package ua.com.lsd25.client.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Victor Zagnitko on 02.04.2014.
 */
@ManagedBean(name = "navigator")
@SessionScoped
public class Navigator {

    private String mPageToNavigate = "";

    /**
     *
     */
    public Navigator() {
        super();
    }

    public String navigateTo() {
        if ("ToSecure".equalsIgnoreCase(mPageToNavigate)) {
            return "Secured";
        } else if ("ToUnSecure".equalsIgnoreCase(mPageToNavigate)) {
            return "UnSecured";
        } else {
            //This will never happen but we will use this to extend this application
            return "none";
        }
    }

    public String getPageToNavigate() {
        return mPageToNavigate;
    }

    public void setPageToNavigate(String option) {
        this.mPageToNavigate = option;
    }

}
