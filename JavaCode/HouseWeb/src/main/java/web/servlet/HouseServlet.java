package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.PageBean;
import pojo.housesrc;
import service.HouseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/House/*")
public class HouseServlet extends BaseServlet{
    private HouseService service=new HouseService();
      public void selectAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
          List<housesrc> house=service.SelectAll();
          String jsonString = JSON.toJSONString(house);
          response.setContentType("text/json;charset=utf-8");
          response.getWriter().write(jsonString);
      }
    public void selectByPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String _currentPage=request.getParameter("currentPage");
        String _pageSize=request.getParameter("pageSize");
        int currentPage =Integer.parseInt(_currentPage);
        int pageSize=Integer.parseInt(_pageSize);
        PageBean<housesrc> pageBean= service.selectByPage(currentPage,pageSize);
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    /*分页条件查询*/
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String _currentPage=request.getParameter("currentPage");
        String _pageSize=request.getParameter("pageSize");
        int currentPage =Integer.parseInt(_currentPage);
        int pageSize=Integer.parseInt(_pageSize);

        BufferedReader br=request.getReader();
        String params=br.readLine();
//        System.out.println(params);

        housesrc Housesrc =JSON.parseObject(params,housesrc.class);
//        System.out.println(Housesrc.toString());
        /*if(0.0==Housesrc.getPrice()){
            Housesrc.setPrice(null);
        }
        if(0.0==Housesrc.getArea()){
            Housesrc.setArea(null);
        }*/


        PageBean<housesrc> pageBean= service.selectByPageAndCondition(currentPage,pageSize,Housesrc);
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public void addHouse(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        BufferedReader br =request.getReader();
        String params=br.readLine();
        housesrc Housesrc=JSON.parseObject(params,housesrc.class);
        service.add(Housesrc);
        response.getWriter().write("success");
    }
    public void deleteHouse(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        BufferedReader br =request.getReader();
        String params=br.readLine();
        housesrc Housesrc=JSON.parseObject(params,housesrc.class);
        service.deleteHouse(Housesrc);
        response.getWriter().write("success");
    }
    public void updateHouse(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        BufferedReader br =request.getReader();
        String params=br.readLine();
        housesrc Housesrc=JSON.parseObject(params,housesrc.class);
        service.updateHouse(Housesrc);
        response.getWriter().write("success");
    }
}
