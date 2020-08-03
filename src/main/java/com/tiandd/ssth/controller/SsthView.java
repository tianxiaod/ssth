package com.tiandd.ssth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SsthView
{
  @RequestMapping("/hello")
  public String hello()
  {
    return "hello";
  }
  @RequestMapping("/")
  public String index() {
    return "hello";
  }
}