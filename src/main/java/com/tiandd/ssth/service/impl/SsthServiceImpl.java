package com.tiandd.ssth.service.impl;

import com.tiandd.ssth.VO.ContentDataVO;
import com.tiandd.ssth.dto.ContentDTO;
import com.tiandd.ssth.dto.UserDTO;
import com.tiandd.ssth.entity.Content;
import com.tiandd.ssth.entity.User;
import com.tiandd.ssth.mapper.mysql.SsthMapper;
import com.tiandd.ssth.mapper.oracle.SsthMapperORACL;
import com.tiandd.ssth.service.SsthService;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SsthServiceImpl
  implements SsthService
{

  @Resource
  private SsthMapper ssthMapper;

  @Resource
  private SsthMapperORACL ssthMapperORACL;

  public List selectUser(UserDTO userDTO)
  {
    return this.ssthMapper.selectUser(userDTO);
  }

  public int insertUser(User user)
  {
    return this.ssthMapper.insertUser(user);
  }

  public int insertContent(ContentDTO contentDTO)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date d = new Date();
    String str = sdf.format(d);
    Content content = new Content();
    content.setUserId(contentDTO.getUserid());
    content.setCreateTime(str);
    content.setContent(contentDTO.getContent());
    content.setStatus("1");
    int i = this.ssthMapper.insertContent(content);
    return i;
  }

  public List selectContent(User user)
  {
    System.out.println(user);
    List<ContentDataVO> contentDataVOS = this.ssthMapper.selectContent(user);
    for (ContentDataVO contentDataVO : contentDataVOS) {
      System.out.println(contentDataVO);
    }
    return contentDataVOS;
  }
}
