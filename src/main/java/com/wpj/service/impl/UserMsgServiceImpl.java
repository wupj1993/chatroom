/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

package com.wpj.service.impl;

import com.wpj.constant.RedisAboutContant;
import com.wpj.dao.UserMsgMapper;
import com.wpj.domain.UserMsg;
import com.wpj.model.bo.OnlineBO;
import com.wpj.service.BaseService;
import com.wpj.service.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The type User msg service.
 *
 * @author：WPJ587 2017 /1/8 14:04.
 */
@Service
public class UserMsgServiceImpl  extends BaseService<UserMsg> implements UserMsgService {
    @Autowired
    private UserMsgMapper userMsgMapper;
    @Autowired
    private RedisTemplate myRedisTemplate;
    @Override
    public UserMsg selectByUserName(String userName) {

        return userMsgMapper.selectByUserName(userName);
    }


    @Override
    public void saveOnlineBO(OnlineBO onlineBO) {
        myRedisTemplate.opsForSet().add(RedisAboutContant.ONLINE + onlineBO.getUserId(), onlineBO);
        myRedisTemplate.expire(RedisAboutContant.ONLINE + onlineBO.getUserId(), 3600, TimeUnit.SECONDS);

    }

    @Override
    public List<OnlineBO> listOnlineBO(String pattern) {
        myRedisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                ScanOptions options = ScanOptions.scanOptions().match(pattern).build();
                Cursor<byte[]> scan = connection.scan(options);
                while (scan.hasNext()) {
                    myRedisTemplate.opsForSet().scan(scan.next(), null);
                }
                return null;
            }
        });
        return null;
    }
}
