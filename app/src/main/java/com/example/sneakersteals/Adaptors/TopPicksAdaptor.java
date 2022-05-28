package com.example.sneakersteals.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sneakersteals.Models.Shoe;
import com.example.sneakersteals.R;

import java.util.List;

public class TopPicksAdaptor extends RecyclerView.Adapter<TopPicksAdaptor.ViewHolder> {

    private List<Shoe> mShoes;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context mContext;



    // data is passed into the constructor
    public TopPicksAdaptor(Context context, List<Shoe> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mShoes = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_view_shoe_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Shoe currentShoe = mShoes.get(position);

        int i = mContext.getResources().getIdentifier(
                currentShoe.getImageFilenameList().get(0), "drawable",
                mContext.getPackageName());
        holder.shoeTextView.setText(currentShoe.getName());
        //Setting the icon\
        holder.shoeImageView.setImageResource(i);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mShoes.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView shoeTextView;
        ImageView shoeImageView;
        CardView shoeCardView;

        ViewHolder(View itemView) {
            super(itemView);
            shoeTextView = (TextView)itemView.findViewById(R.id.category_listview_text);
            shoeImageView = (ImageView) itemView.findViewById(R.id.category_listview_icon);
            shoeCardView = (CardView) itemView.findViewById(R.id.category_listview_card);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Shoe getItem(int id) {
        return mShoes.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
            
    }
}
