package com.example.rickymysql.bean;

public class User {
    private Integer id;
    private String img;
    private String name;
    private Integer fansNum;
    private Integer concern;
    private String collect;
    private String history;
    private String likes;
    private String likeDanmu;
    private String guanzhu;
    private String fans;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() { return this.img; }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() { return this.name; }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFansNum() {
        return this.fansNum;
    }

    public void setFansNum(Integer fn) {
        this.fansNum = fn;
    }

    public Integer getConcern() {
        return this.concern;
    }

    public void setConcern(Integer cn) {
        this.concern = cn;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getCollect() { return this.collect; }

    public void setHistory(String history) { this.history = history; }

    public String getHistory() { return this.history; }

    public void setLikes(String like){ this.likes=like; }

    public String getLikes(){ return this.likes; }

    public void setLikeDanmu(String str){ this.likeDanmu=str; }

    public String getLikeDanmu(){ return this.likeDanmu; }

    public String getGuanzhu(){ return this.guanzhu; }

    public void setGuanzhu(String guanzhu){ this.guanzhu=guanzhu; }

    public String getFans(){ return this.fans; }

    public void setFans(String fans){ this.fans=fans; }
}

