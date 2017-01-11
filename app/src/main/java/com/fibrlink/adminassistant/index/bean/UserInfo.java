package com.fibrlink.adminassistant.index.bean;

/**
 * @projectName AdminAssistant
 * @package name：com.fibrlink.adminassistant.index.bean
 * @class describe
 * @anthor wolf
 * @time 2017/1/10 11:06
 * @change
 */
public class UserInfo {

    private String userid;  // 用户ID
    private String username;//用户名称
    private String userphone;//用户电话

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
}
