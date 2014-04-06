package ua.com.lsd25.client.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home controller for home page
 *
 * @author Victor Zagnitko on 06.04.2014.
 */
@Controller
public class HomeController {

    /**
     *
     */
    public HomeController() {
        super();
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String homePageController() {
        return "redirect:/book/list";
    }

}
