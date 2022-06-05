package com.example.sneakersteals.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.sneakersteals.CategoryActivity;
import com.example.sneakersteals.Models.Shoe;
import com.example.sneakersteals.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class ShoeAdaptor extends ArrayAdapter<Shoe> {

    int mLayout;
    Context mContext;
    List<Shoe> mShoes;

    class ViewHolder {
        TextView shoeTextView;
        CardView shoeCardView;
        CircleImageView shoeImageView;

        public ViewHolder(View currentView) {
            shoeTextView = (TextView) currentView.findViewById(R.id.category_listview_text);
            shoeImageView =  currentView.findViewById(R.id.category_listview_icon);
            shoeCardView = (CardView) currentView.findViewById(R.id.category_listview_card);
        }
    }

    public ShoeAdaptor(@NonNull Context context, int resource, @NonNull List<Shoe> objects) {
        super(context, resource, objects);

        mContext = context;
        mLayout = resource;
        mShoes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayout, parent, false);
        }


        ViewHolder vh = new ViewHolder(currentListViewItem);


            //Get the Number object for the current position
            Shoe currentShoe = mShoes.get(position);

            //Set image
            int i = mContext.getResources().getIdentifier(
                    currentShoe.getImageFilenameList().get(0), "drawable",
                    mContext.getPackageName());
            vh.shoeImageView.setImageResource(i);

            //Set text
            vh.shoeTextView.setText(currentShoe.getName());

        return currentListViewItem;
    }

}
