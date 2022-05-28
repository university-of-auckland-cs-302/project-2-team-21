package com.example.sneakersteals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sneakersteals.Adaptors.ShoeAdaptor;

public class CategoryActivity extends AppCompatActivity {

        class ViewHolder {

            public ViewHolder() {

            }
        }



        ViewHolder vh;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);

            //Get the intent (Which brand to display)
            String brand = getIntent().getStringExtra("Brand");
            String searchInput = getIntent().getStringExtra("Search Term");

            vh = new ViewHolder();
            //Check which intent to use.
            if (searchInput == null) {
                ShoeAdaptor shoeAdaptor = new ShoeAdaptor(this, R.layout.list_view_shoe_item, DataProvider.getBrandShoes(brand));
                ListView listView = findViewById(R.id.list);
                listView.setAdapter(shoeAdaptor);
            } else if (brand == null) {
                ShoeAdaptor shoeAdaptor = new ShoeAdaptor(this, R.layout.list_view_shoe_item, DataProvider.getSearchShoes(searchInput));
                ListView listView = findViewById(R.id.list);
                listView.setAdapter(shoeAdaptor);
            }

        }
}
