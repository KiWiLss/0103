package com.magicsoft.glidetest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.magicsoft.glidetest.R;
import com.magicsoft.glidetest.ui.pull.IosRecyclerActivity;
import com.magicsoft.glidetest.ui.pull.NormalRecyclerActivity;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/9
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class RecyclerActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button mPullZoomFooterView;
    private Button mPullZoomHeaderView;
    //private com.dinuscxj.pullzoom.PullZoomRecyclerView pzrv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);
        //this.pzrv = (PullZoomRecyclerView) findViewById(R.id.pzrv);


//        pzrv.setAdapter(new RecyclerView.Adapter());
//        pzrv.setLayoutMannager(new LinearLayoutManager(context));
//        pzrv.setZoomView(zoomView);
//        pzrv.setHeaderContainer(headerContainer);
        mPullZoomFooterView = (Button) findViewById(R.id.pull_zoom_footer);
        mPullZoomHeaderView = (Button) findViewById(R.id.pull_zoom_header);

        mPullZoomHeaderView.setOnClickListener(this);
        mPullZoomFooterView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pull_zoom_header://ios
                    startActivity(new Intent(this, IosRecyclerActivity.class));

                break;
            case R.id.pull_zoom_footer:
                startActivity(new Intent(this, NormalRecyclerActivity.class));
                break;
            default:
                break;
        }
    }
}
