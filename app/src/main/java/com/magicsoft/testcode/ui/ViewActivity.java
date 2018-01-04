package com.magicsoft.testcode.ui;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.magicsoft.testcode.R;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/4
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class ViewActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    private ImageView ivmenu;
    private ImageView ivcamera;
    private ImageView ivmusic;
    private ImageView mIvSleep;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        this.ivmusic = (ImageView) findViewById(R.id.iv_music);
        this.ivcamera = (ImageView) findViewById(R.id.iv_camera);
        this.ivmenu = (ImageView) findViewById(R.id.iv_menu);
        mIvSleep = (ImageView) findViewById(R.id.iv_sleep);

        initView();


        ivcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewActivity.this, "camera", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                final int caremaY = ivmenu.getTop() - ivcamera.getTop();
                final int height = ivcamera.getHeight();
                Log.e(TAG, "run: "+caremaY +"|"+height);
                ivcamera.setTranslationY(caremaY);
//                ivcamera.setTranslationY(0);


                mIvSleep.setPivotX(0);
                mIvSleep.setPivotY(0);
              mIvSleep.setRotation(90);



                ObjectAnimator translationY = ObjectAnimator.ofFloat(ivcamera, "translationY", 0);
                translationY.setDuration(2000);
                translationY.start();


//                ObjectAnimator rotation = ObjectAnimator.ofFloat(mIvSleep, "rotation", 30);
//                rotation.setDuration(2000);
//                rotation.start();

//
//                ObjectAnimator translationY = ObjectAnimator.ofFloat(ivcamera, "translationY", 0,caremaY,0);
//                translationY.setDuration(2000);
//                translationY.start();


//                ObjectAnimator translationY2 = ObjectAnimator.ofFloat(ivcamera, "translationY", -caremaY);
//                translationY2.setDuration(2000);
//                translationY2.setStartDelay(2000);
//                translationY2.start();

            }
        });



    }
}
