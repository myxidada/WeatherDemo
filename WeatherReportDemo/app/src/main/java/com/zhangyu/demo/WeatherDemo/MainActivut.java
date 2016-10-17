package com.zhangyu.demo.WeatherDemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/9/7.
 */
public class MainActivut {

    private ImageView welcome,appIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        welcome= (ImageView) findViewById(R.id.welcome_guide);
        appIcon= (ImageView) findViewById(R.id.appIcon_guide);
        //设置渐变
        final AlphaAnimation alpha_welcome=new AlphaAnimation(0,1);
        alpha_welcome.setDuration(3000);
        alpha_welcome.setFillAfter(true);
        welcome.startAnimation(alpha_welcome);
        final AlphaAnimation alpha_appIcon=new AlphaAnimation(1,0);
        alpha_appIcon.setDuration(3000);
        alpha_appIcon.setFillAfter(true);
        appIcon.startAnimation(alpha_appIcon);

        handler.sendEmptyMessage(1);
    }
    int time=5;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time--;
            if (time>0){
                handler.sendEmptyMessageDelayed(1,1000);
            }
            if (time<=0){
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    };

}
