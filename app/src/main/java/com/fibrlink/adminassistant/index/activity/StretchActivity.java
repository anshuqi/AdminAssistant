package com.fibrlink.adminassistant.index.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.fibrlink.adminassistant.R;
import com.fibrlink.adminassistant.global.view.StretchPanel;

public class StretchActivity extends Activity implements StretchPanel.OnStretchListener {

    private StretchPanel stretchPanelSecond;
    private StretchPanel stretchPanel;
    private ImageView arrowView;
    private boolean isCurrentChangingStretchView = false;
    private int changeToLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretch);

        stretchPanel  = (StretchPanel)findViewById(R.id.stretch_view_id);
        stretchPanelSecond = (StretchPanel) findViewById(R.id.stretch_view_second_id);

        final View contentView = View.inflate(this, R.layout.view_content, null);
        final View stretchView = View.inflate(this, R.layout.view_stretch, null);

        final View contentView1 = View.inflate(this, R.layout.view_content, null);
        final View stretchView1 = View.inflate(this, R.layout.view_stretch, null);

        arrowView = (ImageView) contentView.findViewById(R.id.imageView1);

        stretchPanel.setStretchView(stretchView);
        stretchPanel.setContentView(contentView);

        stretchPanelSecond.setStretchView(stretchView1);
        stretchPanelSecond.setContentView(contentView1);

        stretchPanel.setOnStretchListener(this);
        stretchPanelSecond.setOnStretchListener(this);

        contentView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.arrowrote);

                if (isCurrentChangingStretchView) {
                    isCurrentChangingStretchView = false;
                    addStretchView(changeToLayoutId);
                    stretchPanel.openStretchView();
                }
                if (stretchPanelSecond.isStretchViewOpened()) {
                    stretchPanelSecond.closeStretchView();
                    arrowView.setImageResource(R.drawable.up);
                    arrowView.startAnimation(animation);
                } else {
                    stretchPanelSecond.openStretchView();
                    arrowView.setImageResource(R.drawable.down);
                    arrowView.startAnimation(animation);
                }
            }
        });

        contentView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.arrowrote);
                if (stretchPanel.isStretchViewOpened()) {
                    stretchPanel.closeStretchView();
                    arrowView.setImageResource(R.drawable.up);
                    arrowView.startAnimation(animation);
                } else {
                    stretchPanel.openStretchView();
                    arrowView.setImageResource(R.drawable.down);
                    arrowView.startAnimation(animation);
                }
            }
        });
    }

    @Override
    public void onStretchFinished(boolean isOpened) {

    }

    private void addStretchView(int layoutId) {
        if (stretchPanel != null) {
            View stretchView = View.inflate(this, layoutId, null);
            stretchPanel.setStretchView(stretchView);
        }
    }
}
