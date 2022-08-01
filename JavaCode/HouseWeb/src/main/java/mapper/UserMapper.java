 package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.users;

public interface UserMapper {
    /*
    * 根据用户名和密码查询用户
    * */
    @Select("select * from users where ID = #{ID} and passw = #{passw}")
    users select(@Param("ID") String ID, @Param("passw") String passw);
    /**
     * 根据用户名查询用户对象
     * @return
     */
    @Select("select * from users where ID = #{ID}")
    users selectByUsername(String ID);
    /**
     * 添加用户
     */
    @Insert("insert into users values(#{ID},#{passw})")
    void add(users user);


}
