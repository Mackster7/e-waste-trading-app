package com.example.reecle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;

public class imageAdapter extends BaseAdapter {

    private Context mContext;
    public int[] imageArray= {R.drawable.smartphone,
            R.drawable.laptop,
            R.drawable.tablet,
           // R.drawable.camera,
            R.drawable.tv,
            R.drawable.ac,
            R.drawable.fridge,
            R.drawable.desktop,
            R.drawable.washingmachine

    };

    public imageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageview=new ImageView(mContext);
        imageview.setImageResource(imageArray[position]);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setLayoutParams(new GridLayout.LayoutParams());
        return imageview;
    }
}
