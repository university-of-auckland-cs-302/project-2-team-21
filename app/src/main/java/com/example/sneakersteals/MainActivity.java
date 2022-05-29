package com.example.sneakersteals;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sneakersteals.Adaptors.ShoeAdaptor;
import com.example.sneakersteals.Adaptors.TopPicksAdaptor;

public class MainActivity extends AppCompatActivity implements TopPicksAdaptor.ItemClickListener {


    class ViewHolder {
        CardView cardviewNike;
        CardView cardviewAddidas;
        SearchView searchView;
        RecyclerView topPicks;

        public ViewHolder() {
            cardviewNike = findViewById(R.id.cardview_nike);
            cardviewAddidas = findViewById(R.id.cardview_addidas);
            searchView = findViewById(R.id.searchView);
            topPicks = findViewById(R.id.recyclerview);
        }
    }

    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        vh = new ViewHolder();

        TopPicksAdaptor topPicksAdaptor = new TopPicksAdaptor(this, DataProvider.getTopPicks("Shoe"));
        recyclerView.setLayoutManager(layoutManager);
        //TopPicksAdaptor.setClickListener(this);
        recyclerView.setAdapter(topPicksAdaptor);

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

        topPicksAdaptor.setClickListener(new TopPicksAdaptor.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TextView myTextView = (TextView) view.findViewById(R.id.category_listview_text);
                String selectedName = myTextView.getText().toString();
                Intent nextActivity = new Intent(getBaseContext(), DetailsActivity.class);
                nextActivity.putExtra("Name", selectedName);
                startActivity(nextActivity);
            }
        });

    }
    @Override
    public void onItemClick(View view, int position) {
        TextView myTextView = (TextView) view.findViewById(R.id.category_listview_text);
        String selectedName = myTextView.getText().toString();
        Intent nextActivity = new Intent(getBaseContext(), DetailsActivity.class);
        nextActivity.putExtra("Name", selectedName);
        startActivity(nextActivity);
    }



}