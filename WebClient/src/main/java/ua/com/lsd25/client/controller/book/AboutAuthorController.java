package ua.com.lsd25.client.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Victor Zagnitko on 06.04.2014.
 */
@Controller
@RequestMapping(value = "/about")
public class AboutAuthorController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String aboutAuthorPageController() {
        return "about-author-page";
    }

}
