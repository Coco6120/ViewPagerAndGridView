package com.example.administrator.viewpagerandgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14 0014.
*/

public class GirdViewAdapter extends BaseAdapter{
    private List<Model> mDates;
    private LayoutInflater inflater;
    private int curIndex;
    private int pageSize;

    public GirdViewAdapter(Context context, List<Model> mDates, int curIndex, int pageSize) {
       inflater = LayoutInflater.from(context);
        this.mDates = mDates;
        this.curIndex = curIndex;
        this.pageSize = pageSize;
    }

    @Override
    public int getCount() {
        return mDates.size() > (curIndex +1) * pageSize ? pageSize :
                (mDates.size() - curIndex * pageSize);
    }

    @Override
    public Object getItem(int position) {
        return mDates.get(position + curIndex * pageSize);
    }

    @Override
    public long getItemId(int position) {
        return position + curIndex * pageSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder = null;
        if (viewHolder == null) {
            convertView = inflater.inflate(R.layout.ite_gridview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        int pos = position + curIndex * pageSize ;
        viewHolder.tv.setText(mDates.get(pos).name);
        viewHolder.iv.setImageResource(mDates.get(pos).iconRes);

        return null;
    }

    class ViewHolder {
        public TextView tv;
        public ImageView iv;
    }
}
