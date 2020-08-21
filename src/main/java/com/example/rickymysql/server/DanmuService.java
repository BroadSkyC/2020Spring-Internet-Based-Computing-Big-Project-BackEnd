package com.example.rickymysql.server;

import com.example.rickymysql.bean.Danmu;
import com.example.rickymysql.bean.Video;
import com.example.rickymysql.mapper.DanmuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * todo:发布弹幕和返回弹幕列表（和视频类似，比视频简单，不用处理视频流），完成相应的controller和mapper
 *      三个功能点：get弹幕list、发布弹幕、getMyDanmuList（pzf的要求）
 */
@Service
public class DanmuService {
    @Autowired
    DanmuMapper danmuMapper;
    public void uplodeDanmu(Danmu danmu){
        danmuMapper.insertDanmu(danmu);
    }

    public void addLike(Integer id){ danmuMapper.addLike(id); }

    public List<Danmu> getAllDanmu(){ return danmuMapper.getAllDanmu(); }

    public List<Danmu> getDanmuList(Integer postid){
        return danmuMapper.getDanmuList(postid);
    }

    public List<Danmu> getMyDanmuList(Integer userid){
        return danmuMapper.getMyDanmuList(userid);
    }

}
