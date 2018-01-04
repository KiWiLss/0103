package com.magicsoft.testcode.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
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

        ivmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //openAll();

            }
        });

        getWidthHeight();
    }

    private void getWidthHeight() {

        ViewTreeObserver viewTreeObserver = mIvSleep.getViewTreeObserver();

        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                int height = mIvSleep.getMeasuredHeight();
                int width = mIvSleep.getMeasuredWidth();

                Log.e(TAG, "onPreDraw: "+height+"|"+width );
                return true;
            }
        });


        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int height = mIvSleep.getMeasuredHeight();
                int width = mIvSleep.getMeasuredWidth();

                Log.e(TAG, "onGlobalLayout: "+height+"|"+width );
            }
        });

    }

    boolean isOpen;
    private void openAll() {

        if (isOpen){
            ivcamera.setVisibility(View.VISIBLE);
            ivmusic.setVisibility(View.VISIBLE);
            mIvSleep.setVisibility(View.VISIBLE);
            ObjectAnimator translationY1 = ObjectAnimator.ofFloat(mIvSleep, "translationY", 0);
            ObjectAnimator translationY2 = ObjectAnimator.ofFloat(ivcamera, "translationY", 0);
            ObjectAnimator translationY3 = ObjectAnimator.ofFloat(ivmusic, "translationY", 0);


//                translationY1.setDuration(2000);
//                translationY2.setDuration(2000);
//                translationY3.setDuration(2000);
//
//                translationY3.start();
//                translationY2.start();
//                translationY1.start();
                isOpen=false;

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(translationY1).with(translationY2).after(translationY3);
            animatorSet.setDuration(2000);
            animatorSet.start();

        }else {





        }

    }

    private void initView() {
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {

                Log.e(TAG, "run: "+mIvSleep.getWidth()+"||"+mIvSleep.getHeight() );

                Log.e(TAG, "run: ###"+mIvSleep.getMeasuredWidth()+"||"+mIvSleep.getMeasuredHeight() );

               /* final int caremaY = ivmenu.getTop() - ivcamera.getTop();
                final int height = ivcamera.getHeight();


//                ivcamera.setTranslationY(0);

                int musicY = ivmenu.getTop() - ivmusic.getTop();
                int sleepY = ivmenu.getTop() - mIvSleep.getTop();

                Log.e(TAG, "run: "+caremaY +"|"+height+"|"+musicY+"|"+sleepY);

                ivcamera.setTranslationY(caremaY);
                ivmusic.setTranslationY(musicY);
                mIvSleep.setTranslationY(sleepY);


                ivcamera.setVisibility(View.GONE);
                ivmusic.setVisibility(View.GONE);
                mIvSleep.setVisibility(View.GONE);
                isOpen=true;*/
//                ObjectAnimator translationY = ObjectAnimator.ofFloat(ivcamera, "translationY", 0);
//                translationY.setDuration(2000);
//                translationY.start();


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
