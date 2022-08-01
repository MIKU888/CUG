package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.housesrc;
import pojo.near;

import java.util.List;

public interface NearMapper {

    /*设施*/
    List<near> selectfacByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("Near")near Near);

    int selectfacTotalCountByCondition(near Near);

    List<near> selecthosByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("Near")near Near);

    int selecthosTotalCountByCondition(near Near);

    List<near> selectparkByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("Near")near Near);

    int selectparkTotalCountByCondition(near Near);

    List<near> selectroadByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("Near")near Near);

    int selectroadTotalCountByCondition(near Near);


    List<near> selectschByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("Near")near Near);

    int selectschTotalCountByCondition(near Near);


    List<near> selectshopByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("Near")near Near);

    int selectshopTotalCountByCondition(near Near);
}
