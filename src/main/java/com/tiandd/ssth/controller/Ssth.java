package com.tiandd.ssth.controller;

import com.tiandd.ssth.dto.ContentDTO;
import com.tiandd.ssth.dto.RegisterDTO;
import com.tiandd.ssth.dto.UserDTO;
import com.tiandd.ssth.entity.User;
import com.tiandd.ssth.service.SsthService;
import com.tiandd.ssth.util.ResultTest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ssth
{

  @Resource
  private SsthService ssthService;

  @RequestMapping({"/login"})
  public ResultTest login(UserDTO user)
  {
    List<User> list = this.ssthService.selectUser(user);
    for (User u : list)
    {
      System.out.println(u.toString());
    }
    return new ResultTest().success(list);
  }
  @RequestMapping({"/register"})
  public ResultTest register(RegisterDTO registerDTO) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date d = new Date();
    String str = sdf.format(d);
    User user = new User();

    user.setPassWord(registerDTO.getPass());
    user.setUserName(registerDTO.getUserName());
    user.setOpenTime(str);
    user.setEffTime(str);
    int i = this.ssthService.insertUser(user);
    return new ResultTest().success(Integer.valueOf(i));
  }

  @RequestMapping({"/insertText"})
  public ResultTest insertText(ContentDTO contentDTO) {
    int i = this.ssthService.insertContent(contentDTO);
    return new ResultTest().success(Integer.valueOf(i));
  }
  @RequestMapping({"/selectContent"})
  public ResultTest selectContent(User user) {
    return new ResultTest().success(this.ssthService.selectContent(user));
  }
}
