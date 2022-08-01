package web.servlet;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.users;
import service.usersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private usersService service =new usersService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码
        //接收用户名和密码
        String ID=request.getParameter("username");
        String passw=request.getParameter("password");
        String remember=request.getParameter("remember");
        users user=service.login(ID,passw);
        if(user!=null){
            if("1".equals(remember)){
                //创建cookie
                Cookie c_username=new Cookie("username",ID);
                Cookie c_password=new Cookie("password",passw);
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            //跳转
            String contextPath=request.getContextPath();
            response.sendRedirect(contextPath+"/Main.html");
        }
        else{
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
