package service;

import mapper.AdminMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Adminastrator;
import pojo.users;
import util.SqlSessionFactoryUtils;

public class AdminService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */

    public Adminastrator login(String username, String password){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        //4. 调用方法
        Adminastrator Admin = mapper.select(username, password);

        //释放资源
        sqlSession.close();

        return Admin;
    }

}
