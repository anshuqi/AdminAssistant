package com.fibrlink.adminassistant.global.tools;

import com.fibrlink.adminassistant.index.bean.UserGroup;
import com.fibrlink.adminassistant.index.bean.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据公共类
 *  @author wolf
 *  @time 2017/1/10  14:32
 */
public class DataTools {
    //工资列表之横坐标-年月
    public static String[] date = {"14年","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月","15年","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月","16年","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月","17年"};//X轴的标注
    //工资列表之纵坐标-数值
    public static float[] score= {2436,2636,2536,2836,3036,3736,3636,3736,3836,4086,4036,4136,4136,4536,4636,4636,4736,4836,5036,5836,5984,5935,5946,6257,6306,6209,6838,6800,6900,6945,6947,6804,6835,6736,6895,6964,6947};//图表的数据点

    public static List<UserGroup> groupList = null;

    static{
        groupList = new ArrayList<>();

        List<UserInfo> userInfos1 = new ArrayList<>();

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserid("1");
        userInfo1.setUsername("老王");
        userInfo1.setUserphone("18210791916");

        userInfos1.add(userInfo1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserid("2");
        userInfo2.setUsername("老言");
        userInfo2.setUserphone("18210791916");

        userInfos1.add(userInfo2);

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserid("3");
        userInfo3.setUsername("老尹");
        userInfo3.setUserphone("18210791916");

        userInfos1.add(userInfo3);

        UserInfo userInfo4 = new UserInfo();
        userInfo4.setUserid("4");
        userInfo4.setUsername("老薛");
        userInfo4.setUserphone("18210791916");

        userInfos1.add(userInfo4);

        UserGroup userGroup1 = new UserGroup();
        userGroup1.setGroupid("1");
        userGroup1.setGroupname("家人");

        userGroup1.setUserlist(userInfos1);
        groupList.add(userGroup1);

        List<UserInfo> userInfos2 = new ArrayList<>();

        UserInfo userInfo5 = new UserInfo();
        userInfo5.setUserid("5");
        userInfo5.setUsername("老安");
        userInfo5.setUserphone("18210791916");

        userInfos2.add(userInfo5);

        UserInfo userInfo6 = new UserInfo();
        userInfo6.setUserid("6");
        userInfo6.setUsername("老程");
        userInfo6.setUserphone("18210791916");

        userInfos2.add(userInfo6);

        UserInfo userInfo7 = new UserInfo();
        userInfo7.setUserid("7");
        userInfo7.setUsername("老牛");
        userInfo7.setUserphone("18210791916");

        userInfos2.add(userInfo7);

        UserInfo userInfo8 = new UserInfo();
        userInfo8.setUserid("8");
        userInfo8.setUsername("老崔");
        userInfo8.setUserphone("18210791916");
        userInfos2.add(userInfo8);

        UserGroup userGroup2 = new UserGroup();
        userGroup2.setGroupid("2");
        userGroup2.setGroupname("朋友");

        userGroup2.setUserlist(userInfos2);
        groupList.add(userGroup2);

        List<UserInfo> userInfos3 = new ArrayList<>();


        UserInfo userInfo9 = new UserInfo();
        userInfo9.setUserid("9");
        userInfo9.setUsername("老湛");
        userInfo9.setUserphone("18210791916");

        userInfos3.add(userInfo9);

        UserInfo userInfo10 = new UserInfo();
        userInfo10.setUserid("10");
        userInfo10.setUsername("老宋");
        userInfo10.setUserphone("18210791916");

        userInfos3.add(userInfo10);

        UserInfo userInfo11 = new UserInfo();
        userInfo11.setUserid("11");
        userInfo11.setUsername("老张");
        userInfo11.setUserphone("18210791916");

        userInfos3.add(userInfo11);

        UserInfo userInfo12 = new UserInfo();
        userInfo12.setUserid("12");
        userInfo12.setUsername("老李");
        userInfo12.setUserphone("18210791916");

        userInfos3.add(userInfo12);

        UserGroup userGroup3 = new UserGroup();
        userGroup3.setGroupid("3");
        userGroup3.setGroupname("同学");
        userGroup3.setUserlist(userInfos3);
        groupList.add(userGroup3);
    }

    static{







    }

}
