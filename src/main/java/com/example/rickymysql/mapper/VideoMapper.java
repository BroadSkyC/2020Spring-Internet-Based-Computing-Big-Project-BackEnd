package com.example.rickymysql.mapper;

import com.example.rickymysql.bean.Danmu;
import com.example.rickymysql.bean.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VideoMapper {
    void insertVideo(Video video);

    void addLikes(Integer id);

    void addPlayNum(Integer id);

    void addCommentNum(Integer id);

    Video getVideoById(Integer id);

    List<Video> getHotVideoByBlock(String block,String subClass);

    List<Video> getNewVideoByBlock(String block,String subClass);

    List<Video> getHotVideo();

    List<Video> getNewVideo();

    List<Video> getVideoList();

    List<Video> getMyVideoList(Integer userid);

    Video getVideoAuthor(Integer id);
}
