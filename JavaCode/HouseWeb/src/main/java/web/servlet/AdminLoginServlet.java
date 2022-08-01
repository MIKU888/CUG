package web.servlet;

import pojo.Adminastrator;
import pojo.users;
import service.AdminService;
import service.usersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private AdminService service =new AdminService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码/
        //接收用户名和密码
        String ID=request.getParameter("username");
        String passw=request.getParameter("password");
        Adminastrator adminastrator =service.login(ID,passw);
        if(adminastrator!=null){
            HttpSession session=request.getSession();
            session.setAttribute("adminastrator",adminastrator);
            //跳转
            //跳转到管理员界面
            String contextPath=request.getContextPath();
            response.sendRedirect(contextPath+"/AdminSystem.html");


        }
        else{
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/Adminlogin.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
