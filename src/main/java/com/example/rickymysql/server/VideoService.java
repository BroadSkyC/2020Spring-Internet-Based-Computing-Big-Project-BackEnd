package com.example.rickymysql.server;

import com.example.rickymysql.bean.Danmu;
import com.example.rickymysql.bean.Video;
import com.example.rickymysql.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * todo:1.处理前端的post请求，接受前端用户发布的视频并保存相关信息到数据库，注意初始化的逻辑，比如点赞数默认为0等
 *      2.处理前端的get请求，返回按时间顺序排列全部视频列表切片[a:b]（sql里正常情况下是时间顺序，无需排序,a和b为前端参数，如果b大于length则取length，这里的a从0开始（吴凯程做数据交互时需要注意ab范围），吴凯程利用这个方法拿到视频列表，在前端生产潘子凡写的那几个花式list）
 *      3.处理前端的get请求，根据用户id返回某个特定用户发布的所有视频的list（pzf的要求）
 *      4.处理前端的get请求，获取post表的长度
 *      5.前端2和4配合着用，如果这种格式麻烦，2和4不用写，就直接返回一个总的list就行，这是考虑到后期维护的问题，不过仅仅是大作业我们用不到这么复杂
 *      6.完成相应的controller和mapper
 *      7.以上实现仅供参考，但是目前阶段大致要完成三个功能点：发布视频、get所有发布列表、get我的发布列表
 *      8.后期根据pzf的要求可能还会实现一些简单的增删改查
 *
 */

@Service
public class VideoService {
    @Autowired
    VideoMapper videoMapper;
    public void uploadVideo(Video video){
        videoMapper.insertVideo(video);
    }

    public void addLikes(Integer id){ videoMapper.addLikes(id); }

    public void addPlayNum(Integer id){ videoMapper.addPlayNum(id); }

    public void addCommentNum(Integer id){ videoMapper.addCommentNum(id); }

    public List<Video> searchVideo(String str){
        List<Video> allVideos=videoMapper.getVideoList();
        List<Video> res=new ArrayList<>();
        String[] strs=str.split("");
        for(int i=0;i<allVideos.size();i++){
            for(int j=0;j<strs.length;j++){
                if(allVideos.get(i).getTitle().contains(strs[j])){
                    res.add(allVideos.get(i));
                    break;
                }
            }
        }
        return res;
    }

    public Video getVideoById(Integer id){ return videoMapper.getVideoById(id); }

    public List<Video> getHotVideoByBlock(String block,String sub){ return videoMapper.getHotVideoByBlock(block,sub); }

    public List<Video> getNewVideoByBlock(String block,String sub){ return videoMapper.getNewVideoByBlock(block,sub); }

    public List<Video> getHotVideo(){ return videoMapper.getHotVideo(); }

    public List<Video> getNewVideo(){ return videoMapper.getNewVideo(); }

    public List<Video> getVideoList(){
        return videoMapper.getVideoList();
    }

    public List<Video> getMyVideoList(int userid){
        return videoMapper.getMyVideoList(userid);
    }

    public List<Video> getUserLikes(String str){
        List<Video> likes=new ArrayList<>();
        List<Integer> postIds=new ArrayList<>();
        if(str.equals("")) return likes;
        String[] ids=str.split(",");
        for(int i=0;i<ids.length;i++){
            postIds.add(Integer.parseInt(ids[i]));
        }
        for(int i=0;i<postIds.size();i++){
            likes.add(videoMapper.getVideoById(postIds.get(i)));
        }
        return likes;
    }

    public List<Video> getUserCollects(String str){
        List<Video> collects=new ArrayList<>();
        List<Integer> postIds=new ArrayList<>();
        if(str.equals("")) return collects;
        String[] postIds_str=str.split(",");
        for(int i=0;i<postIds_str.length;i++){
            postIds.add(Integer.parseInt(postIds_str[i]));
        }
        for(int i=0;i<postIds.size();i++){
            collects.add(videoMapper.getVideoById(postIds.get(i)));
        }
        return collects;
    }

    public List<Video> getUserReleases(String str){
        List<Video> releases=new ArrayList<>();
        List<Integer> postIds=new ArrayList<>();
        if(str.equals("")) return releases;
        String[] postIds_str=str.split(",");
        for(int i=0;i<postIds_str.length;i++){
            postIds.add(Integer.parseInt(postIds_str[i]));
        }
        for(int i=0;i<postIds.size();i++){
            releases.add(videoMapper.getVideoById(postIds.get(i)));
        }
        return releases;
    }

    public List<Video> getUserHistory(String str){
        List<Video> history=new ArrayList<>();
        List<Integer> postIds=new ArrayList<>();
        if(str.equals("")) return history;
        String[] postIds_str=str.split(",");
        for(int i=0;i<postIds_str.length;i++){
            postIds.add(Integer.parseInt(postIds_str[i]));
        }
        for(int i=0;i<postIds.size();i++){
            history.add(videoMapper.getVideoById(postIds.get(i)));
        }
        return history;
    }

    public int daysBetween(String dateStr) throws ParseException {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date compareDate = sdf.parse(dateStr);

        Calendar cal = Calendar.getInstance();
        cal.setTime(compareDate);
        long time1 = cal.getTimeInMillis();

        cal.setTime(today);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public Integer getVideoAuthor(Integer postId){
        return videoMapper.getVideoAuthor(postId).getUserid();
    }

}
