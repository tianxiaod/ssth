package com.tiandd.ssth.dto;

import java.util.List;

public class ContentDTO
{
  private int userid;
  private String content;
  private List<String> contenttype;

  public int getUserid()
  {
    return this.userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<String> getContenttype() {
    return this.contenttype;
  }

  public void setContenttype(List<String> contenttype) {
    this.contenttype = contenttype;
  }

  public String toString()
  {
    return "ContentDTO{userid=" + this.userid + ", content='" + this.content + '\'' + ", contenttype=" + this.contenttype + '}';
  }
}
