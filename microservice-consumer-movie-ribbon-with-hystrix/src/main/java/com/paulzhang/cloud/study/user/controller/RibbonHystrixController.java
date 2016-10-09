package com.paulzhang.cloud.study.user.controller;

import com.paulzhang.cloud.study.user.entity.User;
import com.paulzhang.cloud.study.user.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PaulZhang on 2016/10/9.
 */
@RestController
public class RibbonHystrixController {

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable("id") long id) {
        return ribbonHystrixService.findById(id);
    }
}
