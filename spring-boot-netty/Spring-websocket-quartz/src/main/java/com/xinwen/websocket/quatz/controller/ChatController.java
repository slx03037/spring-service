package com.xinwen.websocket.quatz.controller;

import com.xinwen.websocket.quatz.entity.LoginForm;
import com.xinwen.websocket.quatz.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author shenlx
 * @description
 * @date 2024/9/21 19:03
 */
@RestController
@RequestMapping("/socket")
public class ChatController {
    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String goLogin(){
        return "login";
    }

    /**
     * 跳转到聊天页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String goMain(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (null == session.getAttribute("USER_SESSION")){
            return "login";
        }
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        //将用户放入session
        session.setAttribute("USER_SESSION",user);
        return "redirect:home";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute LoginForm loginForm) {
        // 这里添加登录验证逻辑
        boolean isValid = authenticate(loginForm.getUsername(), loginForm.getPassword());
        if (isValid) {
            return "welcome";
        } else {
            return "loginError";
        }
    }

    private boolean authenticate(String username, String password) {
        // 这里添加具体的登录验证逻辑，比如查询数据库等
        return "user".equals(username) && "pass".equals(password);
    }
}
