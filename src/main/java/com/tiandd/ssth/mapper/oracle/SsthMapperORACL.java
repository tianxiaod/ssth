package com.tiandd.ssth.mapper.oracle;

import com.tiandd.ssth.dto.UserDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public  interface SsthMapperORACL
{
    List selectUser(@Param("params") UserDTO paramUserDTO);
}
