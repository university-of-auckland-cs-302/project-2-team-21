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


    public TopPicksAdaptor(Context context, List<Shoe> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mShoes = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_view_shoe_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Get current shoe
        Shoe currentShoe = mShoes.get(position);

        //Get and set image
        int i = mContext.getResources().getIdentifier(
                currentShoe.getImageFilenameList().get(0), "drawable",
                mContext.getPackageName());
        holder.shoeImageView.setImageResource(i);

        //Set text
        holder.shoeTextView.setText(currentShoe.getName());


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


    //Sets up the click listener
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    //Used by activities when item is clicked
    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }
}
