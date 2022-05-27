package com.example.sneakersteals.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sneakersteals.Models.Shoe;
import com.example.sneakersteals.R;

import java.util.List;


public class ShoeAdaptor extends ArrayAdapter<Shoe> {

    int mLayout;
    Context mContext;
    List<Shoe> mShoes;

    class ViewHolder {
        TextView shoeTextView;
        ImageView shoeImageView;

        public ViewHolder(View currentView) {
            shoeTextView = (TextView) currentView.findViewById(R.id.category_listview_text);
            shoeImageView = (ImageView) currentView.findViewById(R.id.category_listview_icon);
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

        //Set the attributed of list_view_number_item views

        int i = mContext.getResources().getIdentifier(
                currentShoe.getImageFilenameList().get(0), "drawable",
                mContext.getPackageName());
        vh.shoeTextView.setText(currentShoe.getName());
        //Setting the icon\
        vh.shoeImageView.setImageResource(i);


        //iconImageView.setImageResource(i);


//        //Getting the audio resource id for the current Number object
//        final String audio = currentNumber.getAudioFilename();
//        final ImageView play = (ImageView) currentListViewItem.findViewById(R.id.play_image_view);

//        //Setting the image click handler
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Operations to perform when the play ImageView is clicked
//                int i = mContext.getResources().getIdentifier(
//                        audio, "raw",
//                        mContext.getPackageName());
//                //Using MediaPlayer to play the audio file
//                if (mediaPlayer != null)
//                    mediaPlayer.release();
//                mediaPlayer = MediaPlayer.create(mContext, i);
//                mediaPlayer.start();
//
//            }
//        }


        return currentListViewItem;
    }

}
