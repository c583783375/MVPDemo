package com.sprint.mvpdemo.iview;

import java.util.List;

/**
 * Created by admin on 2017/3/4 0004.
 */

public interface INewsView {

    /*显示进度条*/
    void showLoading();

    void showNews(List<String> datas);

    void showMessage(String str);

}
