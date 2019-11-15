package com.boicehot.cache;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc: 系统内存缓存
 * @Author: boiceHot
 * @Date: 2019-10-30
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SystemCache {

    private ConcurrentHashMap<String, Object> systemSettingMap = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, Object> getSystemSettingMap() {
        return systemSettingMap;
    }

    public void setSystemSettingMap(ConcurrentHashMap<String, Object> systemSettingMap) {
        this.systemSettingMap = systemSettingMap;
    }
}