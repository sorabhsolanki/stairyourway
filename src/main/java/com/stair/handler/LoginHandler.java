package com.stair.handler;

import com.stair.dto.LoginDto;
import com.stair.persistent.entity.Login;
import com.stair.persistent.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class LoginHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LoginHandler.class);

    @Autowired
    LoginRepository loginRepository;

    public HttpSession authenticate(HttpServletRequest request, LoginDto loginDto) {
        // check if user exist inside the DB
        Login login = loginRepository.checkIfUserExist(loginDto.getEmail(), loginDto.getPassword());
        if(login == null)
            return null;
        HttpSession httpSession = request.getSession(true);
        return httpSession;
    }

    public boolean authorizeUser(HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        LOG.info("session alive ", httpSession == null ?false : httpSession.getId());
        return httpSession == null ?false : true;
    }
}
