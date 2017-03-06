package com.sprint.mvpdemo.imodel;

import java.util.List;

/**
 * Created by admin on 2017/3/4 0004.
 */

public interface INewsModel {
    void loaderNewsData(NewsLoaderDataListener listener);

    interface NewsLoaderDataListener{
        void onComplete(List<String> news);
    }
}
