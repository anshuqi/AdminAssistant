package com.fibrlink.adminassistant.index.bean;

import java.util.List;

/**
 * @projectName AdminAssistant
 * @package name：com.fibrlink.adminassistant.index.bean
 * @class describe
 * @anthor wolf
 * @time 2017/1/10 14:04
 * @change
 */
public class UserGroup {
    private String groupid;         //id
    private String groupname;       //组名
    private List<UserInfo> userlist;//用户id

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<UserInfo> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserInfo> userlist) {
        this.userlist = userlist;
    }
}
