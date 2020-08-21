package com.example.rickymysql.controller;

import com.example.rickymysql.bean.ResponseVO;
import com.example.rickymysql.bean.Video;
import com.example.rickymysql.server.AccountService;
import com.example.rickymysql.server.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequestMapping("/api/video")
@RestController
public class VideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    AccountService accountService;

    @PostMapping("/uploadVideo")
    public ResponseVO upload(Integer userid,String title,String coverImg,String videoUrl,String info,String block,String subClass){
        Video video=new Video();
        //处理两个url
        coverImg=coverImg.substring(0,48)+"/"+coverImg.substring(48,coverImg.length());
        videoUrl=videoUrl.substring(0,48)+"/"+videoUrl.substring(48,videoUrl.length());
        //对video赋值
        video.setUserid(userid);
        video.setTitle(title);
        video.setCoverImg(coverImg);
        video.setVideoUrl(videoUrl);
        video.setInfo(info);
        video.setBlock(block);
        video.setSubClass(subClass);
        video.setCreatetime(20200625);
        //获取年月日
        Calendar calendar = Calendar.getInstance();
        int time=calendar.get(Calendar.YEAR)*10000+(calendar.get(Calendar.MONTH)+1)*100+calendar.get(Calendar.DATE);
        video.setCreatetime(time);
        videoService.uploadVideo(video);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/addLikes")
    public ResponseVO addLikes(Integer id){
        videoService.addLikes(id);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/addCommentNum")
    public ResponseVO addCommentNum(Integer id){
        videoService.addCommentNum(id);
        return ResponseVO.buildSuccess(true);
    }

    @PostMapping("/addPlayNum")
    public ResponseVO addPlayNum(Integer id){
        videoService.addPlayNum(id);
        return ResponseVO.buildSuccess(true);
    }

    @GetMapping("/searchVideo")
    public List<Video> searchVideo(String str){ return videoService.searchVideo(str); }

    @GetMapping("/getVideoById")
    public Video getVideoById(Integer id){
        return videoService.getVideoById(id);
    }

    @GetMapping("/getHotVideoByBlcok")
    public List<Video> getHotVideoByBlock(String block,String sub){
        return videoService.getHotVideoByBlock(block,sub);
    }

    @GetMapping("/getNewVideoByBlcok")
    public List<Video> getNewVideoByBlock(String block,String sub){
        return videoService.getNewVideoByBlock(block,sub);
    }

    @GetMapping("/getHotVideo")
    public List<Video> getHotVideo(){
        return videoService.getHotVideo();
    }

    @GetMapping("/getNewVideo")
    public List<Video> getNewVideo(){
        return videoService.getNewVideo();
    }

    @GetMapping("/all")
    public ResponseVO getVideoList(){
        return ResponseVO.buildSuccess(videoService.getVideoList());
    }

    @GetMapping("/getMyVideoList")
    public List<Video> getMyVideoList(Integer userid){
        return videoService.getMyVideoList(userid);
    }

    @GetMapping("/getVideoPostedTime")
    public Integer getVideoPostedTime(Integer id) throws ParseException {
        Video video=videoService.getVideoById(id);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        int start=video.getCreatetime();
        String create=start+"";
        create=create.substring(0,4)+"-"+create.substring(4,6)+"-"+create.substring(6,8);
        return videoService.daysBetween(create);
    }

    @GetMapping("/getVideoByVideoUrl")
    public Video getVideoByVideoUrl(String videoUrl){
        videoUrl=videoUrl.substring(0,48)+"/"+videoUrl.substring(48,videoUrl.length());
        List<Video> videos=videoService.getVideoList();
        for(int i=0;i<videos.size();i++){
            if(videos.get(i).getVideoUrl().equals(videoUrl)) {
                return videos.get(i);
            }
        }
        return new Video();
    }

    @GetMapping("/getVideoAuthor")
    public Integer getVideoAuthor(Integer postId){
        //System.out.println(postId);
        return videoService.getVideoAuthor(postId);
    }
}
