package com.example.from;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Img extends BaseAdapter {
    Context con;
    public Img(Context c) {
        con=c;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv=new ImageView(con);
        imgv.setLayoutParams(new ViewGroup.LayoutParams(200,200));
        imgv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgv.setImageResource(img[position]);
        return imgv;
    }

    public Integer[] img={R.drawable.baseline_account_circle_24,R.drawable.baseline_access_time_24,R.drawable.baseline_calendar_today_24};
}
