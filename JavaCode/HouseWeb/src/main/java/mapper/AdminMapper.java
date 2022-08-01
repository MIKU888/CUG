package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Adminastrator;
import pojo.users;

public interface AdminMapper {
    /*
     * 根据用户名和密码查询用户
     * */
    @Select("select * from adminastrator where AID = #{AID} and passwd = #{passwd}")
    Adminastrator select(@Param("AID") String AID, @Param("passwd") String passwd);
}
