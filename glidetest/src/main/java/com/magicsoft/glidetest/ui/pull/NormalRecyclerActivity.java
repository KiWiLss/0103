package com.magicsoft.glidetest.ui.pull;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
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


public class NormalRecyclerActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvnormallist;
    private com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout trlnormalrefresh;
    private ArrayList<String> mList;
    private IosAdapter mIosAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        this.trlnormalrefresh = (TwinklingRefreshLayout) findViewById(R.id.trl_normal_refresh);
        this.rvnormallist = (RecyclerView) findViewById(R.id.rv_normal_list);
        mList = new ArrayList<>();

        trlnormalrefresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);

                rvnormallist.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        trlnormalrefresh.finishRefreshing();
                        mList.clear();
                        initData();
                        mIosAdapter.notifyDataSetChanged();

                    }
                }, 4000);

            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                rvnormallist.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        trlnormalrefresh.finishLoadmore();
                        initData();
                        mIosAdapter.notifyDataSetChanged();


                    }
                }, 4000);

            }
        });

        trlnormalrefresh.onFinishRefresh();
        //设置进入刷新
        trlnormalrefresh.startRefresh();
        rvnormallist.setLayoutManager(new LinearLayoutManager(this));
        initData();

        mIosAdapter = new IosAdapter(mList, this);
        rvnormallist.setAdapter(mIosAdapter);


    }

    private void initData() {

        for (int i = 0; i < 20; i++) {
            mList.add("djfie");
        }
    }


}
