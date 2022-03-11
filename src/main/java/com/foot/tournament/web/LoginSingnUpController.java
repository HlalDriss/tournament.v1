package com.foot.tournament.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSingnUpController {

    @GetMapping("/login")
    public String login(Model model){
       model.addAttribute("google","oauth2/authorization/google");
       model.addAttribute("facebook","oauth2/authorization/facebook");
//       model.addAttribute("twitter","oauth2/authorization/twitter");
        model.addAttribute("linkedin","oauth2/authorization/linkedin");
        return "login";
    }
}
