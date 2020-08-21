package com.example.rickymysql.bean;

public class LiangPing {
    private String coverImg;
    private String title;
    private String text;
    private Integer avid;

    public void setCoverImg(String coverImg){ this.coverImg=coverImg; }

    public void setTitle(String title){ this.title=title; }

    public void setText(String text){ this.text=text; }

    public void setAvid(Integer avid){ this.avid=avid; }

    public String getCoverImg(){ return this.coverImg; }

    public String getTitle(){ return this.title; }

    public String getText(){ return this.text; }

    public Integer getAvid(){ return this.avid; }
}
