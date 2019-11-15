package com.boicehot.init;

import com.boicehot.cache.SystemCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc: 启动时载入内存
 * @Author: boiceHot
 * @Date: 2019-10-30
 */
@Component
public class StartCache implements ApplicationRunner {
    private static Logger logger = LoggerFactory.getLogger(StartCache.class);

    @Autowired
    private ObjectFactory<SystemCache> systemCacheObjectFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ConcurrentHashMap<String, Object> systemSettingMap = systemCacheObjectFactory.getObject().getSystemSettingMap();
        systemSettingMap.put("systemTime", System.currentTimeMillis());
        logger.info("[application start success...]");
    }
}