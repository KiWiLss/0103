package com.magicsoft.testcode.ui.transition;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.magicsoft.testcode.R;
import com.magicsoft.testcode.widget.DragLayout;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/5
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class CommonFragment extends Fragment implements DragLayout.GotoDetailListener {

    private String imageUrl;
    private ImageView imageView;
    private View address1;
    private View address2;
    private View address3;
    private View address4;
    private View address5;
    private RatingBar ratingBar;
    private View head1;
    private View head2;
    private View head3;
    private View head4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_common2, container, false);


        DragLayout dragLayout = (DragLayout) rootView.findViewById(R.id.drag_layout);
        imageView = (ImageView) dragLayout.findViewById(R.id.image);

        ImageLoader.getInstance().displayImage(imageUrl, imageView);


        address1 = dragLayout.findViewById(R.id.address1);
        address2 = dragLayout.findViewById(R.id.address2);
        address3 = dragLayout.findViewById(R.id.address3);
        address4 = dragLayout.findViewById(R.id.address4);
        address5 = dragLayout.findViewById(R.id.address5);
        ratingBar = (RatingBar) dragLayout.findViewById(R.id.rating);

        head1 = dragLayout.findViewById(R.id.head1);
        head2 = dragLayout.findViewById(R.id.head2);
        head3 = dragLayout.findViewById(R.id.head3);
        head4 = dragLayout.findViewById(R.id.head4);

        dragLayout.setGotoDetailListener(this);

        return rootView;
    }


    public void bindData(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void gotoDetail() {



    }


}
