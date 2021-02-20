package com.glodon.rulelib.service;

import com.glodon.rulelib.entity.AppUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 用户表 服务类
* </p>
*
* @author LC
* @since 2021-02-20
*/
public interface AppUserService {

    /**
    * 分页查询AppUser
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author LC
    * @since 2021-02-20
    */
    Page<AppUser> listAppUsersByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询AppUser
    *
    * @param id 需要查询的AppUser的id
    * @return 返回对应id的AppUser对象
    * @author LC
    * @since 2021-02-20
    */
    AppUser getAppUserById(int id);

    /**
    * 插入AppUser
    *
    * @param appUser 需要插入的AppUser对象
    * @return 返回插入成功之后AppUser对象的id
    * @author LC
    * @since 2021-02-20
    */
    int insertAppUser(AppUser appUser);

    /**
    * 根据id删除AppUser
    *
    * @param id 需要删除的AppUser对象的id
    * @return 返回被删除的AppUser对象的id
    * @author LC
    * @since 2021-02-20
    */
    int deleteAppUserById(int id);

    /**
    * 根据id更新AppUser
    *
    * @param appUser 需要更新的AppUser对象
    * @return 返回被更新的AppUser对象的id
    * @author LC
    * @since 2021-02-20
    */
    int updateAppUser(AppUser appUser);

    AppUser testSelectFirst();

    Integer testSelectCount();
}
