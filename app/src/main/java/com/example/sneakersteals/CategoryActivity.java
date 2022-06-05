package com.example.sneakersteals;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sneakersteals.Adaptors.ShoeAdaptor;
import com.example.sneakersteals.Models.Shoe;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

        class ViewHolder {
            TextView noResults;
            TextView bannerText;
            ImageButton returnButton;
            public ViewHolder() {
                noResults = findViewById(R.id.no_results_text);
                bannerText = findViewById(R.id.listview_header);
                returnButton = findViewById(R.id.back_button);
            }
        }

        ViewHolder vh;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout); //Set transitions
            setContentView(R.layout.activity_list);
            ListView listView = findViewById(R.id.list);
            statusBarcolour();


            //Get the info from main activity
            String brand = getIntent().getStringExtra("Brand");
            String searchInput = getIntent().getStringExtra("Search Term");

            //Get singleton database
            Singleton global=Singleton.getInstance();
            DataProvider database = global.getDatabase();



            vh = new ViewHolder();
            //Check which intent to use
            if (searchInput == null) { //If category is clicked
                ShoeAdaptor shoeAdaptor = new ShoeAdaptor(this, R.layout.list_view_shoe_item, database.getBrandShoes(brand));

                listView.setAdapter(shoeAdaptor);
                String mBannerText = "Showing " + brand + " shoes";
                vh.bannerText.setText(mBannerText);
            } else if (brand == null) { //If searchbar is used
                List<Shoe> searchedShoes = database.getSearchShoes(searchInput);
                String mBannerText = "Showing results for: " + searchInput;
                vh.bannerText.setText(mBannerText);
                if (searchedShoes.size() > 0) {
                    ShoeAdaptor shoeAdaptor = new ShoeAdaptor(this, R.layout.list_view_shoe_item, database.getSearchShoes(searchInput));
                    listView.setAdapter(shoeAdaptor);
                } else {
                    //Make no results found text visible
                    vh.noResults.setVisibility(VISIBLE);
                }

            }

            vh.returnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Return to previous activity with transition
                    finish();
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                }
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView myTextView = (TextView) view.findViewById(R.id.category_listview_text);
                    String selectedName = myTextView.getText().toString();
                    Intent nextActivity = new Intent(getBaseContext(), DetailsActivity.class);
                    nextActivity.putExtra("Name", selectedName);
                    startActivity(nextActivity);
                }
            });


        }

        //Set the status bar colour
    public void statusBarcolour() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple,this.getTheme()));
        }else if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)){
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple));
        }
    }
}
