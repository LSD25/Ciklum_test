package ua.com.lsd25.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Victor Zagnitko on 02.04.2014.
 */
@Controller
public class HomeController {

    /**
     *
     */
    public HomeController() {
        super();
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String homeController() {
        return "home-page";
    }

}
