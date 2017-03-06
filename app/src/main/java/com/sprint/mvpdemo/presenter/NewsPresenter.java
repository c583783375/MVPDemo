package com.sprint.mvpdemo.presenter;

import com.sprint.mvpdemo.base.BasePresenter;
import com.sprint.mvpdemo.imodel.INewsModel;
import com.sprint.mvpdemo.iview.INewsView;
import com.sprint.mvpdemo.model.NewsModel;
import com.sprint.mvpdemo.view.NewsActivity;

import java.util.List;

/**
 * Created by admin on 2017/3/6 0006.
 */

public class NewsPresenter extends BasePresenter<INewsView>{
    //View
    INewsView mNewsView;
    //Model
    INewsModel newsModel = new NewsModel();

    public NewsPresenter(NewsActivity newsView) {
        this.mNewsView = newsView;
    }

    public void fetch()
    {
        mNewsView.showLoading();
        newsModel.loaderNewsData(new INewsModel.NewsLoaderDataListener(){
            @Override
            public void onComplete(List<String> news) {
                mNewsView.showNews(news);
            }
        });
    }

    public void showNews(int position)
    {
        mNewsView.showMessage("点击"+position);
    }

}
