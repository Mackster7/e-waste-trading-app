package com.example.reecle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;

public class imageAdapter extends BaseAdapter {

    private Context mContext;
    public int[] imageArray= {R.drawable.imagesa,R.drawable.imagesb,R.drawable.imagesc,
            R.drawable.cam,R.drawable.gey,R.drawable.other
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
