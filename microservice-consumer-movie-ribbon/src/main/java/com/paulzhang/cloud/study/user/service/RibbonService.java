package com.paulzhang.cloud.study.user.service;

import com.paulzhang.cloud.study.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by PaulZhang on 2016/10/9.
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public User findById(long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }
}
