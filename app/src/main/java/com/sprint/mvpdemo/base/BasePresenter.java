package com.sprint.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
 * Created by admin on 2017/3/6 0006.
 */

public abstract class BasePresenter<T> {
    /*当内存不足可释放内存*/
    private WeakReference<T> mViewRef = null;

    /*
    * bind p with v
    * @param view
    * */
    public void onAttachView(T view)
    {
        mViewRef = new WeakReference<T>(view);
    }
    /*
    * 解除管理*/

    public void onDetachView()
    {
        if(mViewRef != null)
        {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public boolean isAttach(){
                return null != mViewRef && null != mViewRef.get();
             }

    protected T getView()
    {
        return mViewRef.get();
    }
}
