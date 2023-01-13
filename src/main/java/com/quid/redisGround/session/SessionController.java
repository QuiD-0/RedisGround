package com.quid.redisGround.session;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/login")
    public void login(HttpSession session, @RequestParam String name) {
        session.setAttribute("name", name);
    }

    @GetMapping("/myName")
    public String myName(HttpSession session) {
        return (String) session.getAttribute("name");
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

}
