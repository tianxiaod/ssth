package com.tiandd.ssth.service;

import com.tiandd.ssth.VO.ContentDataVO;
import com.tiandd.ssth.dto.ContentDTO;
import com.tiandd.ssth.dto.UserDTO;
import com.tiandd.ssth.entity.User;
import java.util.List;

public  interface SsthService
{
    List selectUser(UserDTO paramUserDTO);

    int insertUser(User paramUser);

    int insertContent(ContentDTO paramContentDTO);

    List<ContentDataVO> selectContent(User paramUser);
}
