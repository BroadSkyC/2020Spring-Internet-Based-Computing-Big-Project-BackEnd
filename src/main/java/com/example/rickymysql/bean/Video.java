package com.example.rickymysql.bean;

public class Video {
    private int id;// 唯一标识符

    private int userid;// 发布人的唯一标识符

    private int createtime; //视频发布时间 字符串，格式为"yyyy-MM-dd HH:mm:ss"

    private String title;// 标题

    private String coverImg; //视频封面url

    private long playNum; //点击量

    private long commentNum; //评论数

    private long likes; //点赞量

    private String videoUrl;// 视频url

    private String info;// 视频简介

    private String block;// 板块分类

    private String subClass; //子版块分类


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) { this.coverImg = coverImg; }

    public long getPlayNum() {
        return playNum;
    }

    public void setPlayNum(long playNum) {
        this.playNum = playNum;
    }

    public long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(long commentNum) {
        this.commentNum = commentNum;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }
}
