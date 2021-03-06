package com.magicsoft.testcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.magicsoft.testcode.ui.AreMenuActivity;
import com.magicsoft.testcode.ui.MoonMenuActivity;
import com.magicsoft.testcode.ui.PopupActivity;
import com.magicsoft.testcode.ui.ShadowActivity;
import com.magicsoft.testcode.ui.ViewActivity;
import com.magicsoft.testcode.ui.transition.TransitonActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }

    public void view(View view) {
        startActivity(new Intent(this, ViewActivity.class));
    }

    public void popup(View view) {
        startActivity(new Intent(this, PopupActivity.class));
    }

    public void moon(View view) {
        startActivity(new Intent(this, MoonMenuActivity.class));
    }

    public void arc(View view) {
        startActivity(new Intent(this, AreMenuActivity.class));
    }

    public void transition(View view) {
        startActivity(new Intent(this, TransitonActivity.class));
    }

    public void shadow(View view) {
        startActivity(new Intent(this, ShadowActivity.class));
    }
}
