package com.glodon.rulelib.mapper;

import com.glodon.rulelib.entity.AppUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 用户表 Mapper 接口
* </p>
*
* @author LC
* @since 2021-02-20
*/
@Mapper
@Repository
public interface AppUserMapper extends BaseMapper<AppUser> {

    int selectAppUser();

}
