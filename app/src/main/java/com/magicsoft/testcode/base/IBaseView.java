package com.magicsoft.testcode.base;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.view.View;

public abstract interface IBaseView
{
  //public abstract b bindRxRecycleEvent();

  public abstract Activity getContext();

  public abstract FragmentManager getViewFragmentManager();

  public abstract boolean hideLoadingDialog();

  public abstract void hideToast();

  public abstract void showErrorHintDialog(String paramString, View.OnClickListener paramOnClickListener);

  public abstract void showLoadingDialog(String paramString);

  public abstract void showToast(String paramString);
}