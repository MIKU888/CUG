package service;

import mapper.AdminMapper;
import mapper.HouseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Adminastrator;
import pojo.PageBean;
import pojo.housesrc;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class HouseService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<housesrc> SelectAll(){
        SqlSession sqlSession = factory.openSession();
        //3. 获取
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        //4. 调用方法
        List<housesrc> house = mapper.SelectAll();

        //释放资源
        sqlSession.close();

        return house;
    }
    //分页查询
    public PageBean<housesrc> selectByPage(int currentPage,int pageSize){
        SqlSession sqlSession = factory.openSession();
        //3. 获取
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size = pageSize;
        List<housesrc> rows=mapper.selectByPage(begin,size);
        int totalCount= mapper.selectTotalCount();
        PageBean<housesrc> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    public PageBean<housesrc> selectByPageAndCondition(int currentPage,int pageSize,housesrc Housesrc){
        SqlSession sqlSession = factory.openSession();
        //3. 获取
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size = pageSize;

        /*模糊查询*/
        String community=Housesrc.getCommunity();
        if(community!=null&&community.length()>0){
            Housesrc.setCommunity("%"+community+"%");
        }
        String roomtype=Housesrc.getRoomtype();
        if(roomtype!=null&&roomtype.length()>0){
            Housesrc.setRoomtype("%"+roomtype+"%");
        }

        List<housesrc> rows=mapper.selectByPageAndCondition(begin,size,Housesrc);
        int totalCount= mapper.selectTotalCountByCondition(Housesrc);
        PageBean<housesrc> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
    public void add(housesrc Housesrc){
        SqlSession sqlSession = factory.openSession();
        //3. 获取
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        mapper.add(Housesrc);
        sqlSession.commit();
        sqlSession.close();
    }
    public void deleteHouse(housesrc Housesrc){
        SqlSession sqlSession = factory.openSession();
        //3. 获取
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        mapper.deleteHouse(Housesrc);
        sqlSession.commit();
        sqlSession.close();
    }
    public void updateHouse(housesrc Housesrc){
        SqlSession sqlSession = factory.openSession();
        //3. 获取
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        mapper.updateHouse(Housesrc);
        sqlSession.commit();
        sqlSession.close();
    }
}
