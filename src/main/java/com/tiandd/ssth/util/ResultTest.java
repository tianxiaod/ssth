package com.tiandd.ssth.util;

import java.io.Serializable;

public class ResultTest<T>
  implements Serializable
{
  private final String code = "200";
  private final String msg = "success";
  private T data;

  public ResultTest<T> success(T data)
  {
    this.data = data;
    return this;
  }

  public String getCode() {
    return "200";
  }

  public String getMsg() {
    return "success";
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
