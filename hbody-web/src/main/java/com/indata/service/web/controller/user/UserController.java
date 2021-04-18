package com.indata.service.web.controller.user;

import com.indata.service.common.model.ResultModel;
import com.indata.service.core.vo.request.UserUpdateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author byai
 * @create 2021/4/18 15:59
 */
@RestController
@RequestMapping("api/user/common")
public class UserController {


    @PostMapping("/add")
    public ResultModel add(@RequestBody UserUpdateRequest userUpdateRequest){
        return null;
    }
}
