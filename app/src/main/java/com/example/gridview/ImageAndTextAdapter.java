package com.example.gridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ImageAndTextAdapter extends ArrayAdapter<String> {

    private LayoutInflater mInflater;

    private String[] mStrings;
    private TypedArray mStringArr;

    private int mViewResourceId;

    public ImageAndTextAdapter(Context ctx, int viewResourceId, String[] strings, TypedArray stringArr) {
        super(ctx, viewResourceId, strings);

        mInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mStrings = strings;
        mStringArr = stringArr;

        mViewResourceId = viewResourceId;
    }

    @Override
    public int getCount() {
        return mStrings.length;
    }

    @Override
    public String getItem(int position) {
        return mStrings[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        ImageView iv = (ImageView) convertView.findViewById(R.id.imgView);
        iv.setImageDrawable(mStringArr.getDrawable(position));

        TextView tv = (TextView) convertView.findViewById(R.id.txtView);
        tv.setText(mStrings[position]);

        return convertView;
    }

}
