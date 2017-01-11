package com.fibrlink.adminassistant.index.activity;

import android.Manifest;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.fibrlink.adminassistant.global.tools.DataTools;
import com.fibrlink.adminassistant.index.adapter.IdeasExpandableListAdapter;

import java.util.prefs.Preferences;

public class IdeasExpandableActivity extends ExpandableListActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new IdeasExpandableListAdapter(getApplicationContext()));

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        System.out.println("Tel ID：" + DataTools.groupList.get(groupPosition).getUserlist().get(childPosition).getUserphone() );

        // 检查是否获得了权限（Android6.0运行时权限）
        if (ContextCompat.checkSelfPermission(IdeasExpandableActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(IdeasExpandableActivity.this,
                    Manifest.permission.CALL_PHONE)) {
                // 返回值：
//                          如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                          如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                          如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                // 弹窗需要解释为何需要该权限，再次请求授权
                Toast.makeText(IdeasExpandableActivity.this, "请授权！", Toast.LENGTH_LONG).show();

                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }else{
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(IdeasExpandableActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
        }else {
            // 已经获得授权，可以打电话
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                    + DataTools.groupList.get(groupPosition).getUserlist().get(childPosition).getUserphone()));
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onGroupExpand(int groupPosition) {
        for (int i = 0, count = getExpandableListView().getExpandableListAdapter().getGroupCount(); i < count; i++) {
            if (groupPosition != i) {// 关闭其他分组
                getExpandableListView().collapseGroup(i);
            }
        }
    }
}
