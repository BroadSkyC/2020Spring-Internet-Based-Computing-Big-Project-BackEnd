package com.example.rickymysql.mapper;

import com.example.rickymysql.bean.Danmu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DanmuMapper {
    void insertDanmu(Danmu danmu);

    List<Danmu> getDanmuList(@Param("postid")Integer postid);

    List<Danmu> getAllDanmu();

    void addLike(Integer id);

    List<Danmu> getMyDanmuList(Integer userid);
}
