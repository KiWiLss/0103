package com.magicsoft.testone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.magicsoft.testone.image.IconActivity;
import com.magicsoft.testone.widget.ArcMenu;

public class MainActivity extends AppCompatActivity {

    private com.magicsoft.testone.widget.ArcMenu ammainarc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ammainarc = (ArcMenu) findViewById(R.id.am_main_arc);


    ammainarc.setOnMenuItemClickListener(new ArcMenu.OnMenuItemClickListener() {
        @Override
        public void onClick(View view, int pos) {
            switch (pos) {
                case 0://imagewatcher图片列表
                    startActivity(new Intent(MainActivity.this, IconActivity.class));
                    break;
                case 1:
                    break;
            }
        }
    });


    }

    public void album(View view) {


    }
}
