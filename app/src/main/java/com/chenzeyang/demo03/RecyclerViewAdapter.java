package com.chenzeyang.demo03;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * ----------------Dragon be here!------------------
 * 　   　　┏┓　　　┏┓
 * 　   　┏┛┻━━━┛┻┓
 * 　   　┃　　　　　　　┃
 * 　   　┃　　　━　　　┃
 * 　   　┃　┳┛　┗┳　┃
 * 　   　┃　　　　　　　┃
 * 　   　┃　　　┻　　　┃
 * 　   　┃　　　　　　　┃
 * 　   　┗━┓　　　┏━┛
 * 　   　　　┃　　　┃神兽保佑
 * 　   　　　┃　　　┃代码无BUG！
 * 　   　　　┃　　　┗━━━┓
 * 　   　　　┃　神兽出品　　┣┓
 * 　   　　　┃　必属精品　　┏┛
 * 　   　　　┗┓┓┏━┳┓┏┛
 * 　   　　　　┃┫┫　┃┫┫
 * 　   　　　　┗┻┛　┗┻┛
 * ━━━━━━━━神兽出没━━━━━━━━
 * <p>
 * Created by Mr Chen on 2017/9/12 0012 下午 4:03.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<MyEntity.DataBean> mList;
    private Context context;

    public RecyclerViewAdapter(ArrayList<MyEntity.DataBean> mList, HomePageActivity homePageActivity) {

        this.mList = mList;
        this.context = homePageActivity;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getGoods_img()).into(holder.mImageView);
        holder.mTextView.setText(mList.get(position).getGoods_name());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.mImageView);
            mTextView = itemView.findViewById(R.id.mTextView);
        }
    }
}
