package com.example.sneakersteals;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.sneakersteals.Adaptors.ShoeAdaptor;
import com.example.sneakersteals.Adaptors.ViewPageAdapter;
import com.example.sneakersteals.Models.Shoe;

public class DetailsActivity extends AppCompatActivity {

    class ViewHolder {
        TextView nameTextView, descriptionTextView, sizeTextView, colourTextView;
        ImageView shoeImageView;
        ViewPager mViewPager;
        Spinner sizeDropdown;
        ImageButton returnButton;

        public ViewHolder() {
            nameTextView = findViewById(R.id.details_name);
            descriptionTextView = findViewById(R.id.details_description);
            sizeTextView = findViewById(R.id.details_size);
            shoeImageView = findViewById(R.id.imageView);
            mViewPager = findViewById(R.id.viewPager);
            colourTextView = findViewById(R.id.details_colour);
            sizeDropdown = findViewById(R.id.size_dropdown);
            returnButton = findViewById(R.id.back_button_details);
        }
    }

    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_details);

        vh = new DetailsActivity.ViewHolder();

        Singleton global=Singleton.getInstance();
        DataProvider database = global.getDatabase();


        String selectedName = getIntent().getStringExtra("Name");
        Shoe currentShoe = database.getOneShoe(selectedName);
        global.incrementViewCount(currentShoe);
        String previousActivity = getIntent().getStringExtra("PreviousActivity");


        ViewPageAdapter mViewPagerAdapter = new ViewPageAdapter(this, currentShoe.getImageFilenameList());
        ViewPager viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(mViewPagerAdapter);

        ArrayAdapter<String> dropdownAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currentShoe.getSizeList());

        vh.returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Return to previous activity with transition
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        vh.nameTextView.setText(currentShoe.getName());
        vh.descriptionTextView.setText(currentShoe.getDescription());
        //vh.sizeTextView.setText("Sizes available: " + currentShoe.getSizeList().toString());
        vh.sizeDropdown.setAdapter(dropdownAdapter);
        vh.colourTextView.setText("Colours available: " + currentShoe.getColourList().toString());
    }






}
