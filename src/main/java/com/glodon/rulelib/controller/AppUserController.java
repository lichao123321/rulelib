package com.glodon.rulelib.controller;


import org.springframework.web.bind.annotation.*;
import com.glodon.rulelib.entity.dto.ResultBean;
import com.glodon.rulelib.service.AppUserService;
import com.glodon.rulelib.entity.AppUser;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author LC
 * @since 2021-02-20
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/app-user")
public class AppUserController {

    @Resource
    private AppUserService appUserService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(appUserService.listAppUsersByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(appUserService.getAppUserById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody AppUser appUser) {
        return new ResultBean<>(appUserService.insertAppUser(appUser));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(appUserService.deleteAppUserById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody AppUser appUser) {
        return new ResultBean<>(appUserService.updateAppUser(appUser));
    }

    /**
     * 测试LambdaQueryWrapper
     */
    @RequestMapping(method = RequestMethod.GET,value = "/test")
    public ResultBean<?> test() {
        AppUser appUser = appUserService.testSelectFirst();
        return new ResultBean<>(appUser);
    }

    /**
     * 测试mapper.xml
     */
    @RequestMapping(method = RequestMethod.GET,value = "/test1")
    public ResultBean<?> test1() {
        Integer appUser = appUserService.testSelectCount();
        return new ResultBean<>(appUser);
    }
}
