package com.sprint.mvpdemo.model;

import com.sprint.mvpdemo.imodel.INewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/4 0004.
 */

public class NewsModel implements INewsModel {
    @Override
    public void loaderNewsData(NewsLoaderDataListener listener) {
        List<String> newsData = new ArrayList<>();
        for (int i =0;i< 30 ;i++)
        {
            newsData.add("title"+i);
        }
        listener.onComplete(newsData);
    }
}
