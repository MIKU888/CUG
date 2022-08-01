package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.housesrc;

import java.util.List;

public interface HouseMapper {
    @Select("select * from housesrc")
    /*查询所有*/
    List<housesrc> SelectAll();

    //分页查询
    @Select(("select * from housesrc limit #{begin} , #{size}"))
    List<housesrc> selectByPage(@Param("begin") int begin,@Param("size") int size);
//    查询总记录数
    @Select(("select count(*) from housesrc"))
    int selectTotalCount();




    List<housesrc> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("Housesrc") housesrc Housesrc);
    //    查询总记录数

    int selectTotalCountByCondition(housesrc Housesrc);
    void deleteHouse(housesrc Housesrc);

    @Insert("insert into housesrc values(#{district},#{community},#{building},#{room},#{r_layer},#{roomtype},#{area},#{price},#{av_price},#{turn})")
    void add(housesrc Housesrc);

    @Update("update housesrc set r_layer=#{r_layer},roomtype=#{roomtype},area=#{area},price=#{price},av_price=#{av_price},turn=#{turn} where district=#{district} and community=#{community} and building=#{building} and room=#{room}")


    void updateHouse(housesrc Housesrc);

}
