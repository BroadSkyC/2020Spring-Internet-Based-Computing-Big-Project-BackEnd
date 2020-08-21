package com.example.rickymysql.bean;

public class Danmu {
    private int id; //唯一标识符

    private int postid;// 视频唯一标识符

    private int userid; //发弹幕的用户唯一标识符

    private String userImg;

    private String userName;

    private String text; //弹幕内容

    private String color; //颜色，字符串

    private int likes; //弹幕喜爱数

    private long time; //弹幕在视频中出现的时间，整数，单位为s


    public void setId(int id) {
        this.id = id;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUserImg(String t) {
        this.userImg = t;
    }

    public String getUserImg() { return this.userImg; }

    public void setUserName(String userName){ this.userName=userName; }

    public String getUserName(){ return this.userName; }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPostid() {
        return postid;
    }

    public int getUserid() {
        return userid;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public int getLikes() {
        return likes;
    }

    public long getTime() {
        return time;
    }

}
