package com.example.sneakersteals;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    class ViewHolder {
        CardView cardviewNike;
        CardView cardviewAddidas;
        SearchView searchView;

        public ViewHolder() {
            cardviewNike = findViewById(R.id.cardview_nike);
            cardviewAddidas = findViewById(R.id.cardview_addidas);
            searchView = findViewById(R.id.searchView);
        }
    }

    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vh = new ViewHolder();

        vh.cardviewNike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Brand", "Nike");
                startActivity(listActivity);
            }
        });

        vh.cardviewAddidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Brand", "Addidas");
                startActivity(listActivity);
            }
        });

        vh.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Search Term", query);
                startActivity(listActivity);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }


        });
    }

}