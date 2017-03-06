package com.sprint.mvpdemo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sprint.mvpdemo.R;
import com.sprint.mvpdemo.adapter.NewsAdapter;
import com.sprint.mvpdemo.base.MVPBaseActivity;
import com.sprint.mvpdemo.iview.INewsView;
import com.sprint.mvpdemo.presenter.NewsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends MVPBaseActivity<INewsView,NewsPresenter> implements INewsView{

    private NewsPresenter newsPresenter;
    public Toast mToast;
    NewsAdapter newsAdapter;
    @BindView(R.id.listview)
    ListView mListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
      //  newsPresenter = new NewsPresenter(this);
        mPresenter.fetch();
        initView();
    }

    @Override
    protected NewsPresenter createPresenter() {
        return new NewsPresenter(this);
    }


    private void initView() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mPresenter.showNews(i);
            }
        });
    }


    @Override
    public void showLoading() {
        showMessage("正在加载数据中...");
    }

    @Override
    public void showNews(List<String> datas) {
         newsAdapter = new NewsAdapter(this, datas);
        mListView.setAdapter(newsAdapter);
    }

    @Override
    public void showMessage(String str) {
        if(mToast == null){
            mToast = Toast.makeText(NewsActivity.this,str,Toast.LENGTH_SHORT);
        } else{
            mToast.setText(str);
        }
        mToast.show();
    }

    //刷新listview 数据
    public void refresh()
    {
        newsAdapter.notifyDataSetChanged();
    }



}
