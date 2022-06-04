package com.example.sneakersteals;

import static android.view.View.VISIBLE;

import android.content.Intent;
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
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            setContentView(R.layout.activity_list);
            ListView listView = findViewById(R.id.list);

            //Get the intent (Which brand to display)
            String brand = getIntent().getStringExtra("Brand");
            String searchInput = getIntent().getStringExtra("Search Term");
            Singleton global=Singleton.getInstance();
            DataProvider database = global.getDatabase();



            vh = new ViewHolder();
            //Check which intent to use
            if (searchInput == null) {
                ShoeAdaptor shoeAdaptor = new ShoeAdaptor(this, R.layout.list_view_shoe_item, database.getBrandShoes(brand));

                listView.setAdapter(shoeAdaptor);
                String mBannerText = "Showing " + brand + " shoes";
                vh.bannerText.setText(mBannerText);
            } else if (brand == null) {
                List<Shoe> searchedShoes = database.getSearchShoes(searchInput);
                String mBannerText = "Showing results for: " + searchInput;
                vh.bannerText.setText(mBannerText);
                if (searchedShoes.size() > 0) {
                    ShoeAdaptor shoeAdaptor = new ShoeAdaptor(this, R.layout.list_view_shoe_item, database.getSearchShoes(searchInput));
                    listView.setAdapter(shoeAdaptor);
                } else {
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
                    nextActivity.putExtra("PreviousActivity", "listview");
                    //nextActivity.putExtra("Database", (Parcelable) database);
                    startActivity(nextActivity);
                }
            });


        }
}
