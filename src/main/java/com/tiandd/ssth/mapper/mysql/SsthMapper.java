package com.tiandd.ssth.mapper.mysql;

import com.tiandd.ssth.VO.ContentDataVO;
import com.tiandd.ssth.dto.UserDTO;
import com.tiandd.ssth.entity.Content;
import com.tiandd.ssth.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public  interface SsthMapper
{
    List selectUser(@Param("params") UserDTO paramUserDTO);

    int insertUser(@Param("params") User paramUser);

    int insertContent(@Param("params") Content paramContent);

    List<ContentDataVO> selectContent(@Param("params") User paramUser);

}
