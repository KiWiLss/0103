package com.magicsoft.testone.image;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.magicsoft.testone.R;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/8
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class IconActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView mRv;
    int [] mIcon=new int[] {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);
        mRv = (RecyclerView) findViewById(R.id.rv_icon_list);

        mRv.setLayoutManager(new GridLayoutManager(this,3));

        MyAdapter adapter = new MyAdapter();
        mRv.setAdapter(adapter);



    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(IconActivity.this).inflate(R.layout.item_icon, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.ivIcon.setImageResource(mIcon[position]);
            holder.ivIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(IconActivity.this, ImageWatcherActivity.class);
                    intent.putExtra("position",position);
                    startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return mIcon.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivIcon;
            public ViewHolder(View itemView) {
                super(itemView);
               ivIcon= itemView.findViewById(R.id.iv_item_icon_icon);
            }
        }
    }
}
