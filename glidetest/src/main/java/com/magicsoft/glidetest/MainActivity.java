package com.magicsoft.glidetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.deep.imagelib.beans.CompressStyle;
import com.deep.imagelib.beans.ImageConfigure;
import com.magicsoft.glidetest.ui.RecyclerActivity;
import com.magicsoft.glidetest.ui.RecyclerActivity2;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private android.widget.ImageView ivone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ivone = (ImageView) findViewById(R.id.iv_one);


        final ImageConfigure configure = new ImageConfigure();
//        configure.directoryname = "adeep";//目录名
//        configure.filename = "butiful.jpg";//文件名

        configure.compressStyle = CompressStyle.QUALITY;
        ImageConfigure.Expect expect = new ImageConfigure.Expect();
        expect.maxCount = 350*1024;
        configure.expect = expect;


//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
//
//        DeepImage deepImage = new DeepImage(MainActivity.this, bitmap, configure);
//
//
//
//        File file = deepImage.asFile();
//        Bitmap bp = deepImage.asBitmap();
//
//
//        Log.e(TAG, "onCreate: "  + "||" + (bp == null)+"||"+(file==null));
//
//        ivone.setImageBitmap(bp);


//        new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//
//                        DeepImage deepImage = new DeepImage(MainActivity.this,R.drawable.flower,configure);
//                        File file = deepImage.asFile();
////        Bitmap bitmap = deepImage.asBitmap();
////
////        ivone.setImageBitmap(bitmap);
//                        Log.e(TAG, "onCreate: "+(file==null)+"||"+ Environment.getExternalStorageState()+"||"+Environment.getExternalStorageDirectory());
//                        if (file!=null){
//                            Log.e(TAG, "onCreate: file="+file.getPath());
//
//                            DeepImage deepImage2 = new DeepImage(MainActivity.this,file,configure);
//                            ivone.setImageBitmap(deepImage2.asBitmap());
//                        }
//
//                    }
//                }
//        ).start();

    }

    public void button(View view) {
        startActivity(new Intent(this,ButtonActivity.class));
    }

    public void recycler(View view) {
        startActivity(new Intent(this,RecyclerActivity.class));
    }
    public void recycler2(View view) {
        startActivity(new Intent(this,RecyclerActivity2.class));
    }
}
