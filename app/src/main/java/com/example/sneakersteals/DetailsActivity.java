package com.example.sneakersteals;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;

import com.example.sneakersteals.Models.Shoe;

public class DetailsActivity extends AppCompatActivity {

    class ViewHolder {
        TextView nameTextView, descriptionTextView, sizeTextView;
        ImageView shoeImageView;

        public ViewHolder() {
            nameTextView = findViewById(R.id.details_name);
            descriptionTextView = findViewById(R.id.details_description);
            sizeTextView = findViewById(R.id.details_size);
            shoeImageView = findViewById(R.id.details_image);
        }
    }

    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        vh = new DetailsActivity.ViewHolder();

        Singleton global=Singleton.getInstance();
        DataProvider database = global.getDatabase();


        String selectedName = getIntent().getStringExtra("Name");
        Shoe currentShoe = database.getOneShoe(selectedName);
        global.incrementViewCount(currentShoe);


        vh.nameTextView.setText(currentShoe.getName());
        vh.descriptionTextView.setText(currentShoe.getDescription());
        vh.sizeTextView.setText(currentShoe.getSizeList().toString());
    }






}
