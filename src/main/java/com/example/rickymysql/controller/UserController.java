package com.example.rickymysql.controller;


import com.example.rickymysql.bean.*;
import com.example.rickymysql.mapper.UserMapper;
import com.example.rickymysql.server.AccountService;
import com.example.rickymysql.server.DanmuService;
import com.example.rickymysql.server.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {
    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    @Autowired
    private AccountService accountService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private DanmuService danmuService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getUserId")
    public Integer getUserId(String name,String img) {
        List<User> users=userMapper.getAllUsers();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(name) && users.get(i).getImg().equals(img)){
                return users.get(i).getId();
            }
        }
        User user=new User();
        user.setName(name);
        user.setImg(img);
        user.setGuanzhu("");
        user.setFans("");
        user.setLikeDanmu("");
        user.setHistory("");
        user.setCollect("");
        user.setLikes("");
        user.setFansNum(0);
        user.setConcern(0);
        userMapper.createNewAccount(user);
        return 0;
    }

    @PostMapping("/addCollect")
    public ResponseVO addCollect(Integer id,Integer postId){
        return ResponseVO.buildSuccess(accountService.addCollect(id,postId));
    }

    @PostMapping("/addHistory")
    public ResponseVO addHistory(Integer id,Integer postId){
        return ResponseVO.buildSuccess(accountService.addHistory(id,postId));
    }

    @PostMapping("/addDanmuLike")
    public ResponseVO addDanmuLike(Integer danmuId,Integer id){
        return ResponseVO.buildSuccess(accountService.addDanmuLike(danmuId,id));
    }

    @PostMapping("/addLike")
    public ResponseVO addLike(Integer id,Integer postId){
        return ResponseVO.buildSuccess(accountService.addLike(id,postId));
    }

    @PostMapping("/addGuanzhu")
    public ResponseVO addGuanzhu(Integer id,Integer upId){
        System.out.println(id+"  "+upId);
        return ResponseVO.buildSuccess(accountService.addGuanZhu(id,upId));
    }

    @GetMapping("/getFans")
    public List<User> getFans(Integer id){
        return accountService.getFans(id);
    }


    @GetMapping("/getGuanZhu")
    public List<User> getGuanZhu(Integer id){
        return accountService.getGuanZhu(id);
    }

    @GetMapping("/isGoodDanmu")
    public Boolean isGoodDanmu(Integer danmuId,Integer id){
        return accountService.isGoodDanmu(danmuId,id);
    }

    @GetMapping("/isCollected")
    public Boolean isCollected(Integer id,Integer postId){
        return accountService.isCollected(id,postId);
    }

    @GetMapping("/isLiked")
    public Boolean isLiked(Integer id,Integer postId){
        return accountService.isLiked(id,postId);
    }

    @GetMapping("/isGuanZhu")
    public Boolean isGuanZhu(Integer id,Integer upId){ return accountService.isGuanZhu(id,upId); }

    @GetMapping("/getUserInfo")
    public User getUserInfo(Integer id){
        return accountService.getUserInfo(id);
    }

    @GetMapping("/getCollects")
    public List<Video> getCollects(Integer id){
        User user=accountService.getUserInfo(id);
        return videoService.getUserCollects(user.getCollect());
    }

    @GetMapping("/getLikes")
    public List<Video> getLikes(Integer id){
        User user=accountService.getUserInfo(id);
        return videoService.getUserLikes(user.getLikes());
    }

    @GetMapping("/getHistory")
    public List<Video> getHistory(Integer id){
        User user=accountService.getUserInfo(id);
        return videoService.getUserHistory(user.getHistory());
    }

    @GetMapping("/getLiangPing")
    public List<LiangPing> getLiangPing(Integer id){
        //System.out.println(id);
        return accountService.getLiangPing(id);
    }

}
