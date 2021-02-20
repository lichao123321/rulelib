package com.glodon.rulelib.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.glodon.rulelib.entity.dto.ResultBean;
import com.glodon.rulelib.service.SysRoleService;
import com.glodon.rulelib.entity.SysRole;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author LC
 * @since 2021-02-20
 * @version v1.0
 */
@RestController
@RequestMapping("/rulelib/api/v1/sys-role")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(sysRoleService.listSysRolesByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(sysRoleService.getSysRoleById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody SysRole sysRole) {
        return new ResultBean<>(sysRoleService.insertSysRole(sysRole));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(sysRoleService.deleteSysRoleById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody SysRole sysRole) {
        return new ResultBean<>(sysRoleService.updateSysRole(sysRole));
    }
}
