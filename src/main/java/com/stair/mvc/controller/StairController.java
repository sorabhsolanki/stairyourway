package com.stair.mvc.controller;

import com.stair.dto.LoginDto;
import com.stair.exception.GeneralException;
import com.stair.handler.LoginHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class StairController {

    private static final Logger LOG = LoggerFactory.getLogger(StairController.class);

    @Autowired
    private LoginHandler loginHandler;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("user", "Unknown");
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model){
        return "signin";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "signup";
    }

    @RequestMapping(value = "/dosignup", method = RequestMethod.POST)
    public String doSignUp(Model model, HttpServletRequest request, HttpServletResponse response){
        LOG.info("Email: " + request.getParameter("email"));
        LOG.info("Name: " + request.getParameter("username"));
        LOG.info("Password: " + request.getParameter("password"));

        LoginDto loginDto = new LoginDto(request.getParameter("username"), request.getParameter("email"),
                request.getParameter("username"), request.getParameter("password"));

        String name = loginDto.getName();
        try {
            loginHandler.registerUser(loginDto);
        } catch (GeneralException e) {
            name = "unknown";
            LOG.warn(e.getMessage());
        }
        model.addAttribute("user", loginDto.getName());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request) {
        LOG.info("Request came for login");
        LOG.info("Name: " + request.getParameter("username"));
        LOG.info("Password: " + request.getParameter("password"));

        LoginDto loginDto = new LoginDto(request.getParameter("username"), null,
                request.getParameter("password"), null);
        HttpSession session = loginHandler.authenticate(request, loginDto);

        // ToDO: return custom message.
        if (session == null){
            LOG.info("Either username or password is incorrect.");
            model.addAttribute("user", "unknown");
            return "signin";
        }else{
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Cookie", "JSESSIONID=" + session.getId());
        }

        model.addAttribute("user", loginDto.getName());

        return "index";
    }
}
