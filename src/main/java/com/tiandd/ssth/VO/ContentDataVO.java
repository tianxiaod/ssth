package com.tiandd.ssth.VO;

public class ContentDataVO
{
    private String id;
    private String username;
    private String createtime;
    private String content;
    private String forward;
    private String comm;
    private String good;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getForward() {
        return this.forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getComm() {
        return this.comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getGood() {
        return this.good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String toString()
    {
        return "ContentDataVO{id='" + this.id + '\'' + ", username='" + this.username + '\'' + ", createtime='" + this.createtime + '\'' + ", content='" + this.content + '\'' + ", forward='" + this.forward + '\'' + ", comm='" + this.comm + '\'' + ", good='" + this.good + '\'' + '}';
    }
}