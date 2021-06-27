package cuifua.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginHandlerInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //登陆成功之后，应该有用户的Session
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser==null)
        {
            request.setAttribute("msg","请登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        else
            return true;
    }
}
