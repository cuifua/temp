package cuifua.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController
{

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,//html中的name="username" 属性和这里@RequestParam("username")连接
                        @RequestParam("password") String password,
                        Model model, HttpSession session)//model回显的页面
    {
        if (!StringUtils.isEmpty(username) && password.equals("123456"))
        {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else
        {
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index.html";
    }
}
