package com.example.weatherapp1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.core.motion.utils.Utils;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import okhttp3.internal.Util;

public class MyFlagBaseAdapter extends BaseAdapter {
ArrayList<MyFlag> list;
Context context;

    public MyFlagBaseAdapter(ArrayList<MyFlag> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public MyFlag getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.activity_raw_flag,null);
        ImageView imageView=view.findViewById(R.id.flag_image);
        TextView textView=view.findViewById(R.id.flag_name);
        String url="https://flagcdn.com/64x48/"+list.get(i).getCode().toString().toLowerCase()+".png";
        textView.setText(list.get(i).getName());
        Glide.with(context).load(url).into(imageView);
//        context.Utils.fetchSvg(context,list.get(i).getImage(),imageView);


        return view;
    }
}
