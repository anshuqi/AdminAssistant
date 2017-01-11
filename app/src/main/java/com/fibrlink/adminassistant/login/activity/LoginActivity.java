package com.fibrlink.adminassistant.login.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fibrlink.adminassistant.R;
import com.fibrlink.adminassistant.global.activity.CustomActivityManager;
import com.fibrlink.adminassistant.global.tools.CountDownTimerUtils;
import com.fibrlink.adminassistant.index.activity.IdeasExpandableActivity;
import com.fibrlink.adminassistant.index.activity.LineChartViewActivity;
import com.fibrlink.adminassistant.index.activity.StretchActivity;

public class LoginActivity extends Activity implements View.OnClickListener {

    private Button submitButton;
    private TextView loginTextView;
    private CountDownTimerUtils countDownTimerUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //添加Activity到管理类中
        CustomActivityManager.addActivity(this);

        submitButton = (Button)findViewById(R.id.login_button_submit_id);
        loginTextView = (TextView)findViewById(R.id.login_yz_text_id);

        countDownTimerUtils = new CountDownTimerUtils(loginTextView,60000,1000);

        loginTextView.setOnClickListener(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_button_submit_id:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), IdeasExpandableActivity.class);
                startActivity(intent);
                break;
            case R.id.login_yz_text_id:
                countDownTimerUtils.start();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        submitButton = null;
        loginTextView = null;
        countDownTimerUtils = null;
        setContentView(new View(getApplicationContext()));
    }
}
