package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.PageBean;
import pojo.housesrc;
import pojo.near;
import service.NearService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Near/*")
public class NearServlet extends BaseServlet{
private NearService service=new NearService();
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String _currentPage=request.getParameter("currentPage");
        String _pageSize=request.getParameter("pageSize");
        int currentPage =Integer.parseInt(_currentPage);
        int pageSize=Integer.parseInt(_pageSize);

        BufferedReader br=request.getReader();
        String params=br.readLine();
//        System.out.println(params);

        near Near = JSON.parseObject(params,near.class);
//        System.out.println(Housesrc.toString());
        /*if(0.0==Housesrc.getPrice()){
            Housesrc.setPrice(null);
        }
        if(0.0==Housesrc.getArea()){
            Housesrc.setArea(null);
        }*/
        PageBean<near> pageBean=new PageBean<>();
if("0".equals(Near.getNearclass())){
         pageBean= service.selectfacByPageAndCondition(currentPage,pageSize,Near);}
else if("1".equals(Near.getNearclass())){
    pageBean= service.selecthosByPageAndCondition(currentPage,pageSize,Near);}
else if("2".equals(Near.getNearclass())){
    pageBean= service.selectparkByPageAndCondition(currentPage,pageSize,Near);}
else if("3".equals(Near.getNearclass())){
    pageBean= service.selectroadByPageAndCondition(currentPage,pageSize,Near);}
else if("4".equals(Near.getNearclass())){
    pageBean= service.selectschByPageAndCondition(currentPage,pageSize,Near);}
else if("5".equals(Near.getNearclass())){
    pageBean= service.selectshopByPageAndCondition(currentPage,pageSize,Near);}
else{
    pageBean= service.selectfacByPageAndCondition(currentPage,pageSize,Near);
}
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
