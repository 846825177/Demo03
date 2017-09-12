package com.chenzeyang.demo03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    private XRecyclerView mRecyclerView;
    private ArrayList<MyEntity.DataBean> mList = new ArrayList<>();
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        initView();
        initData();
    }

    private void initData() {
        VolleyUtils.getInstance(HomePageActivity.this).sendGet("http://mobile.hmeili.com/yunifang/mobile/goods/getall", new Response.Listener<String>() {
            private FlyBanner mFlyBanner;

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                MyEntity myEntity = gson.fromJson(response, MyEntity.class);
                List<MyEntity.DataBean> data = myEntity.getData();
                mList.addAll(data);
                recyclerViewAdapter.notifyDataSetChanged();
                if (data.size() > 0 && data != null) {
                    View headerview = LayoutInflater.from(HomePageActivity.this).inflate(R.layout.recyclerview_headeritem, null);
                    FlyBanner mFlyBanner = headerview.findViewById(R.id.mFlyBanner);
                    ArrayList<String> headeritem = new ArrayList<>();
                    String goods_img1 = data.get(0).getGoods_img();
                    String goods_img2 = data.get(1).getGoods_img();
                    String goods_img3 = data.get(2).getGoods_img();
                    headeritem.add(goods_img1);
                    headeritem.add(goods_img2);
                    headeritem.add(goods_img3);
                    mFlyBanner.setImagesUrl(headeritem);
                    mRecyclerView.addHeaderView(headerview);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }

    private void initView() {
        mRecyclerView = (XRecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(HomePageActivity.this, 2));
        recyclerViewAdapter = new RecyclerViewAdapter(mList,HomePageActivity.this);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }
}
