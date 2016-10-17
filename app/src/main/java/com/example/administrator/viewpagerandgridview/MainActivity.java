package com.example.administrator.viewpagerandgridview;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] titles = {"美食", "电影", "酒店住宿", "休闲娱乐", "外卖", "自助餐", "KTV", "机票/火车票", "周边游", "美甲美睫",
            "火锅", "生日蛋糕", "甜品饮品", "水上乐园", "汽车服务", "美发", "丽人", "景点", "足疗按摩", "运动健身", "健身", "超市", "买菜",
            "今日新单", "小吃快餐", "面膜", "洗浴/汗蒸", "母婴亲子", "生活服务", "婚纱摄影", "学习培训", "家装", "结婚", "全部分配"};
    private ViewPager mPager;
    private List<View> mPagerList;
    private List<Model> mDatas;
    private LinearLayout mLlDot;
    private LayoutInflater inflater;
    private int pageCount;
    private int pageSize = 10;
    private int curIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mLlDot = (LinearLayout) findViewById(R.id.ll_dot);
        initDatas();
        inflater = LayoutInflater.from(this);
        pageCount = (int) Math.ceil(mDatas.size() * 1.0/ pageSize);
        mPagerList = new ArrayList<View>();
        for (int i = 0; i < pageCount; i++){
            GridView gridView = (GridView) inflater.inflate(R.layout.gridview, mPager, false);
            gridView.setAdapter(new GirdViewAdapter(this, mDatas, i, pageSize));
            mPagerList.add(gridView);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position + curIndex * pageSize;
                    Toast.makeText(MainActivity.this, mDatas.get(pos).getName(), Toast.LENGTH_SHORT).show();
                    
                }
            });
        }
        mPager.setAdapter(new ViewPageAdapter(mPagerList));
        setOvalLayout();
    }



    private  void initDatas() {
        mDatas = new ArrayList<Model>();
        for (int i = 0; i < titles.length; i++){
            int imageId = getResources().getIdentifier("ic_category_" + i,"mipmap", getPackageName());
            mDatas.add(new Model(titles[i], imageId));
        }
    }

    public void setOvalLayout() {
        for (int i = 0; i < pageCount; i++){
            mLlDot.addView(inflater.inflate(R.layout.dot, null));

        }
        mLlDot.getChildAt(0).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mLlDot.getChildAt(curIndex).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_normal);
                mLlDot.getChildAt(position).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);
                curIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
