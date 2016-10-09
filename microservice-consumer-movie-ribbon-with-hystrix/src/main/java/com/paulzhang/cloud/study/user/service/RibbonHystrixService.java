package com.paulzhang.cloud.study.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.paulzhang.cloud.study.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by PaulZhang on 2016/10/9.
 */
@Service
public class RibbonHystrixService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(long id) {
        return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

    public User fallback(long id) {
        RibbonHystrixService.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }

}
