package com.magicsoft.testcode.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.magicsoft.testcode.R;

public class MoonMenu extends ViewGroup {
    private int cl = 0, ct = 0;  
    private Position position;  
    private int childCount;  
    private boolean isMenuClose = true;  
    private View centerButton;  
    private boolean isOnce;  
  
    public MoonMenu(Context context) {
        this(context, null);  
    }  
  
    public MoonMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);  
    }  
  
    public MoonMenu(Context context, AttributeSet attrs, int defStyleAttr) {  
        super(context, attrs, defStyleAttr);  
  
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MoonMenu,
                defStyleAttr, 0);  
        int n = a.getIndexCount();  
        for (int i = 0; i < n; i++) {  
            int attr = a.getIndex(i);  
            if (attr == R.styleable.MoonMenu_menu_position) {  
                int value = a.getInt(attr, 0);  
                switch (value) {  
                    case 0:  
                        position = Position.LEFT_TOP;  
                        break;  
                    case 1:  
                        position = Position.RIGHT_TOP;  
                        break;  
                    case 2:  
                        position = Position.LEFT_BOTTOM;  
                        break;  
                    case 3:  
                        position = Position.RIGHT_BOTTOM;  
                        break;  
                }  
            }  
        }  
        a.recycle();  
    }  
  
    @Override  
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        measureChildren(widthMeasureSpec, heightMeasureSpec);  
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
    }  
  
    @Override  
    protected void onLayout(boolean changed, int l, int t, int r, int b) {  
        //避免多次加载  
        if (isOnce) {  
            childCount = getChildCount();  
            for (int i = 0; i < childCount; i++) {  
                View childView = getChildAt(i);
                int width = childView.getMeasuredWidth();  
                int height = childView.getMeasuredHeight();  
                switch (position) {  
                    case LEFT_TOP:  
                        cl = 0;  
                        ct = 0;  
                        break;  
                    case RIGHT_TOP:  
                        cl = getMeasuredWidth() - width;  
                        ct = 0;  
                        break;  
                    case LEFT_BOTTOM:  
                        cl = 0;  
                        ct = getMeasuredHeight() - height;  
                        break;  
                    case RIGHT_BOTTOM:  
                        cl = getMeasuredWidth() - width;  
                        ct = getMeasuredHeight() - height;  
                        break;  
                }  
                childView.layout(cl, ct, cl + width, ct + height);  
            }  
  
            //主菜单按钮，布局里的最后一个View  
            centerButton = getChildAt(childCount - 1);  
            centerButton.setOnClickListener(new OnClickListener() {  
                @Override  
                public void onClick(View v) {  
                    RotateAnimation rotate;
                    if (isMenuClose) {  
                        rotate = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f,
                                Animation.RELATIVE_TO_SELF, 0.5f);  
                    } else {  
                        rotate = new RotateAnimation(0f, -360f, Animation.RELATIVE_TO_SELF, 0.5f,  
                                Animation.RELATIVE_TO_SELF, 0.5f);  
                    }  
  
                    rotate.setDuration(300);  
                    rotate.setFillAfter(true);  
                    centerButton.startAnimation(rotate);  
                    menuAnim();  
                    isMenuClose = !isMenuClose;  
                }  
            });  
            isOnce = false;  
        }  
    }  
  
    //子按钮展开动画  
    private void menuAnim() {  
        int moveDuration = 100;  
        int delay = 50;  
        int radius = (int) (getMeasuredWidth() * (1f / 3 + (childCount - 4) / 10f));  
        for (int i = 0; i < childCount - 1; i++) {  
            double angle = ((Math.PI / 2) / (childCount - 2) * i);  
            final View child = getChildAt(i);  
            int x = (position == Position.LEFT_BOTTOM || position == Position.LEFT_TOP) ? (int) (radius * Math.cos(angle)) : cl - (int) (radius * Math.cos(angle));  
            int y = (position == Position.LEFT_TOP || position == Position.RIGHT_TOP) ? (int) (radius * Math.sin(angle)) : ct - (int) (radius * Math.sin(angle));  
            final ObjectAnimator moveX;
            final ObjectAnimator moveY;  
            ObjectAnimator alpha;  
            if (isMenuClose) {  
                moveX = ObjectAnimator.ofFloat(child, "x", cl, x);  
                moveY = ObjectAnimator.ofFloat(child, "y", ct, y);  
                child.setClickable(true);  
                alpha = ObjectAnimator.ofFloat(child, "alpha", 0, 1);  
            } else {  
                moveX = ObjectAnimator.ofFloat(child, "x", x, cl);  
                moveY = ObjectAnimator.ofFloat(child, "y", y, ct);  
                alpha = ObjectAnimator.ofFloat(child, "alpha", 1, 0);  
            }  
            moveX.setInterpolator(new DecelerateInterpolator());
            moveY.setInterpolator(new DecelerateInterpolator());  
            moveX.setStartDelay(delay * i);  
            moveY.setStartDelay(delay * i);  
            moveX.setDuration(moveDuration);  
            moveY.setDuration(moveDuration);  
            moveX.start();  
            moveY.start();  
            alpha.setStartDelay(delay * i);  
            alpha.start();  
            moveX.addListener(new Animator.AnimatorListener() {
                @Override  
                public void onAnimationStart(Animator animation) {  
                    child.setVisibility(View.VISIBLE);  
                }  
  
                @Override  
                public void onAnimationEnd(Animator animation) { /*前面设置为VISIBLE后有一个子按钮人不能显示，未找到原因。 在此处设置后能却能显示，知道原因的朋友请告知博主。*/  
                    child.setVisibility(View.VISIBLE);  
                }  
  
                @Override  
                public void onAnimationCancel(Animator animation) {  
                }  
  
                @Override  
                public void onAnimationRepeat(Animator animation) {  
                }  
            });  
            final int index = i;  
            final int cx = x;  
            final int cy = y;  
            child.setOnClickListener(new OnClickListener() {  
                @Override  
                public void onClick(View v) {  
                    thisMenuItemAnim(index, cx, cy);  
                    otherMenuItemAnim(index);  
                    isMenuClose = true;  
                    Toast.makeText(getContext(), "you click", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "click");
                }  
            });  
        }  
    }  
  
    //用户点击的子菜单的显示动画  
    private void thisMenuItemAnim(int index, int cx, int cy) {  
        final View thisMenuItem = getChildAt(index);  
        Animation alphaAnim = new AlphaAnimation(1, 0);
        //ScaleAnimation的后两个参数，即缩放中心的xy坐标，所处坐标系原点是这个View本身的左上角  
        Animation scaleAnim = new ScaleAnimation(1f, 4f, 1f, 4f, cx - cl + thisMenuItem.getMeasuredWidth() / 2, cy - ct + thisMenuItem.getMeasuredHeight() / 2);
        scaleAnim.setFillAfter(false);  
        alphaAnim.setFillAfter(false);  
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnim);  
        animationSet.addAnimation(scaleAnim);  
        animationSet.setDuration(200);  
        thisMenuItem.startAnimation(animationSet);  
        animationSet.setAnimationListener(new Animation.AnimationListener() {  
            @Override  
            public void onAnimationStart(Animation animation) {  
            }  
  
            @Override  
            public void onAnimationEnd(Animation animation) {  
                thisMenuItem.setVisibility(View.GONE);  
            }  
  
            @Override  
            public void onAnimationRepeat(Animation animation) {  
            }  
        });  
        thisMenuItem.setClickable(false);  
    }  
  
    //其他未点击的子菜单的自动消失动画  
    private void otherMenuItemAnim(int index) {  
        for (int i = 0; i < childCount - 1; i++) {  
            final View otherMenuItem = getChildAt(i);  
            if (i != index) {  
                Animation alphaAnim = new AlphaAnimation(1, 0);  
                alphaAnim.setDuration(200);  
                alphaAnim.setFillAfter(false);  
                otherMenuItem.startAnimation(alphaAnim);  
                alphaAnim.setAnimationListener(new Animation.AnimationListener() {  
                    @Override  
                    public void onAnimationStart(Animation animation) {  
                    }  
  
                    @Override  
                    public void onAnimationEnd(Animation animation) {  
                        otherMenuItem.setVisibility(View.GONE);  
                    }  
  
                    @Override  
                    public void onAnimationRepeat(Animation animation) {  
                    }  
                });  
                otherMenuItem.setClickable(false);  
            }  
        }  
    }  
  
    public enum Position {  
        LEFT_TOP, RIGHT_TOP, RIGHT_BOTTOM, LEFT_BOTTOM  
    }  
}  