package com.glodon.rulelib.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.glodon.rulelib.entity.AppUser;
import com.glodon.rulelib.mapper.AppUserMapper;
import com.glodon.rulelib.service.AppUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.glodon.rulelib.exception.bizException.BizException;

import java.util.List;

/**
* <p>
* 用户表 服务实现类
* </p>
*
* @author LC
* @since 2021-02-20
*/
@Slf4j
@Service
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements AppUserService {

    @Autowired
    private AppUserMapper appUserMapper;

    @Override
    public Page<AppUser> listAppUsersByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询appUser: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<AppUser> queryWrapper =  new QueryWrapper<AppUser>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<AppUser> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询appUser完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public AppUser getAppUserById(int id) {
        log.info("正在查询appUser中id为{}的数据",id);
        AppUser appUser = super.getById(id);
        log.info("查询id为{}的appUser{}",id,(null == appUser?"无结果":"成功"));
        return appUser;
    }

    @Override
    public int insertAppUser(AppUser appUser) {
        log.info("正在插入appUser");
        if (super.save(appUser)) {
            log.info("插入appUser成功,id为{}",appUser.getAppUserId());
            return appUser.getAppUserId();
        } else {
            log.error("插入appUser失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteAppUserById(int id) {
        log.info("正在删除id为{}的appUser",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的appUser成功",id);
            return id;
        } else {
            log.error("删除id为{}的appUser失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateAppUser(AppUser appUser) {
        log.info("正在更新id为{}的appUser",appUser.getAppUserId());
        if (super.updateById(appUser)) {
            log.info("更新d为{}的appUser成功",appUser.getAppUserId());
            return appUser.getAppUserId();
        } else {
            log.error("更新id为{}的appUser失败",appUser.getAppUserId());
            throw new BizException("更新失败[id=" + appUser.getAppUserId() + "]");
        }
    }

    @Override
    public AppUser testSelectFirst() {
        LambdaQueryWrapper<AppUser> wrapper = new LambdaQueryWrapper<>();
        List<AppUser> appUsers = appUserMapper.selectList(wrapper);
        AppUser appUser = appUsers.get(0);
        return appUser;
    }

    @Override
    public Integer testSelectCount() {
        int i = appUserMapper.selectAppUser();
        return i;
    }

}
