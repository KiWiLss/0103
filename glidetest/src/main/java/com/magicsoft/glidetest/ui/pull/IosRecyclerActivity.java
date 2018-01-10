package com.magicsoft.glidetest.ui.pull;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.magicsoft.glidetest.R;
import com.magicsoft.glidetest.adapter.IosAdapter;

import java.util.ArrayList;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/10
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class IosRecyclerActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvioslist;
    private com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout trliosrefresh;
    private ArrayList<String> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ios);
        this.trliosrefresh = (TwinklingRefreshLayout) findViewById(R.id.trl_ios_refresh);
        this.rvioslist = (RecyclerView) findViewById(R.id.rv_ios_list);

        rvioslist.setLayoutManager(new LinearLayoutManager(this));

        initData();

        //设置是否允许越界回弹
        trliosrefresh.setEnableOverScroll(true);
        //设置开启纯净模式越界回弹
        trliosrefresh.setPureScrollModeOn();

    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mList.add("djfie");
        }

        IosAdapter iosAdapter = new IosAdapter(mList, this);
        rvioslist.setAdapter(iosAdapter);

    }
}
