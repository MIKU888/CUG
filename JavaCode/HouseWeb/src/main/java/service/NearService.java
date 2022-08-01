package service;

import mapper.HouseMapper;
import mapper.NearMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.PageBean;
import pojo.housesrc;
import pojo.near;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class NearService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public PageBean<near> selectfacByPageAndCondition(int currentPage, int pageSize, near Near){
        
        SqlSession sqlSession = factory.openSession();
        //3. 获取
        NearMapper mapper = sqlSession.getMapper(NearMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size = pageSize;

        /*模糊查询*/
        String communame=Near.getCommuname();
        if(communame!=null&&communame.length()>0){
            Near.setCommuname("%"+communame+"%");
        }
        String nearName=Near.getNearName();
        if(nearName!=null&&nearName.length()>0){
            Near.setNearName("%"+nearName+"%");
        }

        List<near> rows=mapper.selectfacByPageAndCondition(begin,size,Near);
        int totalCount= mapper.selectfacTotalCountByCondition(Near);
        PageBean<near> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    public PageBean<near> selecthosByPageAndCondition(int currentPage, int pageSize, near Near){

        SqlSession sqlSession = factory.openSession();
        //3. 获取
        NearMapper mapper = sqlSession.getMapper(NearMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size = pageSize;

        /*模糊查询*/
        String communame=Near.getCommuname();
        if(communame!=null&&communame.length()>0){
            Near.setCommuname("%"+communame+"%");
        }
        String nearName=Near.getNearName();
        if(nearName!=null&&nearName.length()>0){
            Near.setNearName("%"+nearName+"%");
        }

        List<near> rows=mapper.selecthosByPageAndCondition(begin,size,Near);
        int totalCount= mapper.selecthosTotalCountByCondition(Near);
        PageBean<near> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    public PageBean<near> selectparkByPageAndCondition(int currentPage, int pageSize, near Near){

        SqlSession sqlSession = factory.openSession();
        //3. 获取
        NearMapper mapper = sqlSession.getMapper(NearMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size = pageSize;

        /*模糊查询*/
        String communame=Near.getCommuname();
        if(communame!=null&&communame.length()>0){
            Near.setCommuname("%"+communame+"%");
        }
        String nearName=Near.getNearName();
        if(nearName!=null&&nearName.length()>0){
            Near.setNearName("%"+nearName+"%");
        }

        List<near> rows=mapper.selectparkByPageAndCondition(begin,size,Near);
        int totalCount= mapper.selectparkTotalCountByCondition(Near);
        PageBean<near> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    public PageBean<near> selectroadByPageAndCondition(int currentPage, int pageSize, near Near){

        SqlSession sqlSession = factory.openSession();
        //3. 获取
        NearMapper mapper = sqlSession.getMapper(NearMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size = pageSize;

        /*模糊查询*/
        String communame=Near.getCommuname();
        if(communame!=null&&communame.length()>0){
            Near.setCommuname("%"+communame+"%");
        }
        String nearName=Near.getNearName();
        if(nearName!=null&&nearName.length()>0){
            Near.setNearName("%"+nearName+"%");
        }

        List<near> rows=mapper.selectroadByPageAndCondition(begin,size,Near);
        int totalCount= mapper.selectroadTotalCountByCondition(Near);
        PageBean<near> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    public PageBean<near> selectschByPageAndCondition(int currentPage, int pageSize, near Near){

        SqlSession sqlSession = factory.openSession();
        //3. 获取
        NearMapper mapper = sqlSession.getMapper(NearMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size = pageSize;

        /*模糊查询*/
        String communame=Near.getCommuname();
        if(communame!=null&&communame.length()>0){
            Near.setCommuname("%"+communame+"%");
        }
        String nearName=Near.getNearName();
        if(nearName!=null&&nearName.length()>0){
            Near.setNearName("%"+nearName+"%");
        }

        List<near> rows=mapper.selectschByPageAndCondition(begin,size,Near);
        int totalCount= mapper.selectschTotalCountByCondition(Near);
        PageBean<near> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    public PageBean<near> selectshopByPageAndCondition(int currentPage, int pageSize, near Near){

        SqlSession sqlSession = factory.openSession();
        //3. 获取
        NearMapper mapper = sqlSession.getMapper(NearMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size = pageSize;

        /*模糊查询*/
        String communame=Near.getCommuname();
        if(communame!=null&&communame.length()>0){
            Near.setCommuname("%"+communame+"%");
        }
        String nearName=Near.getNearName();
        if(nearName!=null&&nearName.length()>0){
            Near.setNearName("%"+nearName+"%");
        }

        List<near> rows=mapper.selectshopByPageAndCondition(begin,size,Near);
        int totalCount= mapper.selectshopTotalCountByCondition(Near);
        PageBean<near> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
}
