package com.example.sneakersteals;


import static android.view.View.INVISIBLE;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
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
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {




    class ViewHolder {
        TextView nameTextView, descriptionTextView, sizeTextView;
        ImageView shoeImageView;
        ViewPager mViewPager;
        TabLayout mTabLayout;
        Spinner sizeDropdown;
        ImageButton returnButton;
        CircleImageView colourImageView1, colourImageView2, colourImageView3, colourImageView4;

        public ViewHolder() {
            nameTextView = findViewById(R.id.details_name);
            descriptionTextView = findViewById(R.id.details_description);
            sizeTextView = findViewById(R.id.size_text);
            shoeImageView = findViewById(R.id.imageView);
            mViewPager = findViewById(R.id.viewPager);
           // colourTextView = findViewById(R.id.details_colour);
            colourImageView1 = findViewById(R.id.firstcolour);
            colourImageView2 = findViewById(R.id.secondcolour);
            colourImageView3 = findViewById(R.id.thirdcolour);
            colourImageView4 = findViewById(R.id.fourthcolour);
            sizeDropdown = findViewById(R.id.size_dropdown);
            returnButton = findViewById(R.id.back_button_details);
            mTabLayout = findViewById(R.id.tablayout);
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
        statusBarcolour();


        String selectedName = getIntent().getStringExtra("Name");
        Shoe currentShoe = database.getOneShoe(selectedName);
        global.incrementViewCount(currentShoe);
        String previousActivity = getIntent().getStringExtra("PreviousActivity");


        ViewPageAdapter mViewPagerAdapter = new ViewPageAdapter(this, currentShoe.getImageFilenameList());
        ViewPager viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(mViewPagerAdapter);
        vh.mTabLayout.setupWithViewPager(viewPager, true);

        ArrayAdapter<String> dropdownAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currentShoe.getSizeList());
        dropdownAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        vh.sizeDropdown.setAdapter(dropdownAdapter);

        vh.sizeDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sizeText = "Pick a size:   " + currentShoe.getSizeList().get(position);
                vh.sizeTextView.setText(sizeText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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

//        vh.sizeDropdown.setOnItemClickListener(this);
        //vh.colourTextView.setText("Colours available: " + currentShoe.getColourList().toString());
        //Set colours
        if (currentShoe.getColourList().size() == 1) {
            vh.colourImageView1.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(0)));
            vh.colourImageView2.setVisibility(View.GONE);
            vh.colourImageView3.setVisibility(View.GONE);
            vh.colourImageView4.setVisibility(View.GONE);
        } else if (currentShoe.getColourList().size() == 2) {
            vh.colourImageView1.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(0)));
            vh.colourImageView2.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(1)));
            vh.colourImageView3.setVisibility(View.GONE);
            vh.colourImageView4.setVisibility(View.GONE);
        } else if (currentShoe.getColourList().size() == 3) {
            vh.colourImageView1.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(0)));
            vh.colourImageView2.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(1)));
            vh.colourImageView3.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(2)));
            vh.colourImageView4.setVisibility(View.GONE);
        } else if (currentShoe.getColourList().size() == 4) {
            vh.colourImageView1.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(0)));
            vh.colourImageView2.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(1)));
            vh.colourImageView3.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(2)));
            vh.colourImageView4.setImageResource(getDrawbleId(this, currentShoe.getColourList().get(3)));
        }


    }

    public static int getDrawbleId(Context context, String string) {
        int i = context.getResources().getIdentifier(
                (string.toLowerCase() + "colour"), "drawable",
                context.getPackageName());

        return i;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sizeText = "Pick a size: " + parent.getItemAtPosition(position);
        vh.sizeTextView.setText(sizeText);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void statusBarcolour() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple,this.getTheme()));
        }else if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)){
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple));
        }
    }






}
