package com.lcm.mybatisplus.work.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lcm.mybatisplus.main.ApiRes;
import com.lcm.mybatisplus.work.entity.User;
import com.lcm.mybatisplus.work.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lcm
 * @since 2019-07-18
 */
@Api(tags = "1.0.1", value = "用户接口", description = "用户接口")
@RestController
@RequestMapping("/work/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("add")
    @ApiOperation("新增接口")
    @ApiImplicitParam(value = "用户信息")
    public ApiRes add(@RequestBody User user) {
        boolean save = userService.save(user);
        return ApiRes.ofStatus(save);

    }

    @GetMapping("getOne")
    @ApiOperation("查找")
    public ApiRes getOne(@RequestParam String userName) {
        User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, userName));
        return ApiRes.ofSuccess(one);
    }

    @ApiOperation("修改接口")
    @PostMapping("update")
    public ApiRes update(@RequestBody User user) {
        boolean b = userService.updateById(user);
        return ApiRes.ofStatus(b);

    }


    @GetMapping("delete")
    @ApiOperation("删除接口")
    @ApiImplicitParam(name = "id", value = "主键id", type = "int")
    public ApiRes delete(Integer id) {
        boolean b = userService.removeById(id);
        return ApiRes.ofStatus(b);
    }

    @GetMapping("listByJdbc")
    @ApiOperation("列表接口")
    public ApiRes listByJdbc() {
        List<User> userList = userService.selectListByTemp();
        return ApiRes.ofSuccess(userList);
    }

}
