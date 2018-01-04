package com.magicsoft.testcode.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import com.magicsoft.testcode.R;

import resonlei.top.popmenuview.PopMenu;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/4
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class PopupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        PopMenu pm = (PopMenu) findViewById(R.id.pm);

        pm.setMenu(R.drawable.composer_button_normal)
                .setItem(R.drawable.composer_camera,"0")
                .setItem(R.drawable.composer_music,"1")
                .setItem(R.drawable.composer_place,"2")
                .setItem(R.drawable.composer_thought,"3");

        pm.setOnMenuItemClickListener(new PopMenu.OnMenuItemClickListener() {
            @Override
            public void onClick(View view, int i) {
                Object tag = view.getTag();
                Toast.makeText(PopupActivity.this, "click"+i+"tag="+tag, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
