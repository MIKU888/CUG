package web.servlet;

import pojo.users;
import service.usersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {
    private usersService  service=new usersService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码
        String ID=request.getParameter("username");
        String passw=request.getParameter("password");
        String checkCode=request.getParameter("checkCode");
        HttpSession session=request.getSession();
        String checckCodeGen=(String)session.getAttribute("checkCodeGen");
        if(!checckCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        users user=new users();
        user.setID(ID);
        user.setPassw(passw);
        boolean flag = service.register(user);
        if(flag){
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
