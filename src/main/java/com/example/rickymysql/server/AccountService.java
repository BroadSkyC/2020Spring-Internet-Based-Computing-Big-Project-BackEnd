package com.example.rickymysql.server;


import com.example.rickymysql.bean.*;
import com.example.rickymysql.mapper.UserMapper;
import com.example.rickymysql.util.LoginCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static ch.qos.logback.core.joran.action.ActionConst.NULL;

@Service
public class AccountService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    DanmuService danmuService;
    @Autowired
    VideoService videoService;

    public User login(String code){
        String[] idAndKey= LoginCheck.getIdAndKey(code);
        if (idAndKey==null){
            return null;
        }
        String openid=idAndKey[0];
        String sessionkey=idAndKey[1];
        User user=userMapper.getAccountByOpenId(openid);
        if (null==user){
            User newUser=new User();
            userMapper.createNewAccount(newUser);
        }
        return user;
    }

    public boolean isGoodDanmu(Integer danmuId,Integer id){
        User user=userMapper.getAccountById(id);
        if(user.getLikeDanmu().equals("")) return false;
        String[] danmus=user.getLikeDanmu().split(",");
        for(int i=0;i<danmus.length;i++){
            if(Integer.parseInt(danmus[i])==danmuId) return true;
        }
        return false;
    }

    public Boolean isCollected(Integer id,Integer postId){
        User user=userMapper.getAccountById(id);
        if(user.getCollect().equals("")) return false;
        String[] videos=user.getCollect().split(",");
        for(int i=0;i<videos.length;i++){
            if(Integer.parseInt(videos[i])==postId) return true;
        }
        return false;
    }

    public Boolean isLiked(Integer id,Integer postId){
        User user=userMapper.getAccountById(id);
        if(user.getLikes().equals("")) return false;
        String[] videos=user.getLikes().split(",");
        for(int i=0;i<videos.length;i++){
            if(Integer.parseInt(videos[i])==postId) return true;
        }
        return false;
    }

    public Boolean isGuanZhu(Integer id,Integer upId){
        User user=userMapper.getAccountById(id);
        if(user.getGuanzhu().equals("")) return false;
        String[] ups=user.getGuanzhu().split(",");
        for(int i=0;i<ups.length;i++){
            if(Integer.parseInt(ups[i])==upId) return true;
        }
        return false;
    }

    public User getUserInfo(Integer id){
        return userMapper.getAccountById(id);
    }

    public List<LiangPing> getLiangPing(Integer id){
        List<LiangPing> liangPings=new ArrayList<>();
        List<Danmu> myDanmus=danmuService.getMyDanmuList(id);
        for(int i=0;i<myDanmus.size();i++){
            if(myDanmus.get(i).getLikes()>500){
                LiangPing lp=new LiangPing();
                lp.setAvid(myDanmus.get(i).getPostid());
                lp.setText(myDanmus.get(i).getText());
                Video video=videoService.getVideoById(myDanmus.get(i).getPostid());
                lp.setCoverImg(video.getCoverImg());
                lp.setTitle(video.getTitle());
                liangPings.add(lp);
            }
        }
        return liangPings;
    }

    public boolean addDanmuLike(Integer danmuId,Integer id){
        User user=userMapper.getAccountById(id);
        String[] likeDanmus=user.getLikeDanmu().split(",");
        for(int i=0;i<likeDanmus.length;i++){
            if(likeDanmus[i].equals(danmuId+"")) return true;
        }
        if(user.getLikeDanmu().equals("")) user.setLikeDanmu(danmuId+"");
        else{
            user.setLikeDanmu(danmuId+","+user.getLikeDanmu());
        }
        userMapper.addDanmuLike(id,user.getLikeDanmu());
        danmuService.addLike(danmuId);
        return true;

    }

    public boolean addLike(Integer id, Integer postId){
        User user=userMapper.getAccountById(id);
        String[] posts=user.getLikes().split(",");
        for(int i=0;i<posts.length;i++){
            if(posts[i].equals(postId+"")) return true;
        }
        if(user.getLikes().equals("")) user.setLikes(postId+"");
        else user.setLikes(postId+","+user.getLikes());
        userMapper.addLike(id,user.getLikes());
        return true;
    }

    public boolean addCollect(Integer id, Integer postId){
        User user=userMapper.getAccountById(id);
        String[] posts=user.getCollect().split(",");
        for(int i=0;i<posts.length;i++){
            if(posts[i].equals(postId+"")) return true;
        }
        if(user.getCollect().equals("")) user.setCollect(postId+"");
        else user.setCollect(postId+","+user.getCollect());
        userMapper.addCollect(id,user.getCollect());
        return true;
    }

    public boolean addHistory(Integer id, Integer postId){
        User user=userMapper.getAccountById(id);
        if(user.getHistory().equals("")) user.setHistory(postId+"");
        else user.setHistory(postId+","+user.getHistory());
        userMapper.addHistory(id,user.getHistory());
        return true;
    }

    public boolean addFan(Integer id,Integer fanId){
        User user=userMapper.getAccountById(id);
        if(user.getFans().equals("")) user.setFans(fanId+"");
        else{
            user.setFans(fanId+","+user.getFans());
        }
        userMapper.addFansNum(id);
        userMapper.addFans(id,user.getFans());
        return true;
    }

    public boolean addGuanZhu(Integer id, Integer upId){
        addFan(upId,id);
        User user=userMapper.getAccountById(id);
        if(user.getGuanzhu().equals("")) user.setGuanzhu(upId+"");
        else user.setGuanzhu(upId+","+user.getGuanzhu());
        userMapper.addConcern(id);
        userMapper.addGuanzhu(id,user.getGuanzhu());
        return true;
    }

    public List<User> getFans(Integer id){
        User user=userMapper.getAccountById(id);
        List<User> res=new ArrayList<>();
        if(user.getFans().equals("")) return res;
        String[] fans=user.getFans().split(",");
        for(int i=0;i<fans.length;i++){
            User f=userMapper.getAccountById(Integer.parseInt(fans[i]));
        }
        return res;
    }

    public List<User> getGuanZhu(Integer id){
        User user=userMapper.getAccountById(id);
        List<User> res=new ArrayList<>();
        if(user.getGuanzhu().equals("")) return res;
        String[] gzs=user.getGuanzhu().split(",");
        for(int i=0;i<gzs.length;i++){
            User f=userMapper.getAccountById(Integer.parseInt(gzs[i]));
            res.add(f);
        }
        return res;
    }

}
