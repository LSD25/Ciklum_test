package ua.com.lsd25.client.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller handle request from the client, when client select any book login
 *
 * @author Victor Zagnitko on 02.04.2014.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    /**
     *
     */
    public LoginController() {
        super();
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String loginPageController() {
        LOG.info("Start login page");
        return "login-page";
    }

}
