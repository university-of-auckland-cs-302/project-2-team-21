package com.example.sneakersteals.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.sneakersteals.R;

import java.util.List;
import java.util.Objects;

public class ViewPageAdapter extends PagerAdapter {

    Context mContext;
    List<String> images;
    LayoutInflater mLayoutInflater;

    public ViewPageAdapter(Context context, List<String> images) {
        this.mContext = context;
        this.images = images;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //Return the number of images
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        View itemView = mLayoutInflater.inflate(R.layout.image, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        //Get and set image
        int i = mContext.getResources().getIdentifier(
                images.get(position), "drawable",
                mContext.getPackageName());
        imageView.setImageResource(i);

        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }
}

