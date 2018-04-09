package com.youxiang.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Rivers
 * @date: 2018/4/9
 */
@Component
@ConfigurationProperties
public class AmazonProperties {

    private String associatedId;

    public String getAssociatedId() {
        return associatedId;
    }

    public void setAssociatedId(String associatedId) {
        this.associatedId = associatedId;
    }
}
