package com.sprint.mvpdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sprint.mvpdemo.R;

import java.util.List;

/**
 * Created by admin on 2017/3/4 0004.
 */

public class NewsAdapter extends BaseAdapter{

    private final Context context;
    private final List<String> lists;

    public NewsAdapter(Context context, List<String> lists)
    {

        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        if(lists != null)
        {
            return lists.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.news_item,null);
            holder = new ViewHolder();
            holder.bindView(view);
            view.setTag(holder);
        }else
        {
            holder = (ViewHolder)view.getTag();
        }
        String s = lists.get(i);
        holder.bindData(s);
        return view;
    }

    class ViewHolder
    {
        TextView title;
        public void bindView(View view)
        {
            title = (TextView) view.findViewById(R.id.textView);
        }
        public void bindData(String str)
        {
            title.setText(str);
        }
    }


}
