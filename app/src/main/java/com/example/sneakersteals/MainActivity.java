package com.example.sneakersteals;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sneakersteals.Adaptors.ShoeAdaptor;
import com.example.sneakersteals.Adaptors.TopPicksAdaptor;
import com.example.sneakersteals.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements TopPicksAdaptor.ItemClickListener {


    class ViewHolder {
        CircleImageView circleNike;
        CircleImageView circleAdidas;
        CircleImageView circlePuma;
        SearchView searchView;
        RecyclerView topPicks;

        public ViewHolder() {
            circleNike = findViewById(R.id.NikeClouds);
            circleAdidas = findViewById(R.id.adidasclouds);
            circlePuma = findViewById(R.id.pumalogo);
            searchView = findViewById(R.id.searchview);
            topPicks = findViewById(R.id.recyclerview);
        }
    }

    ViewHolder vh;


    Singleton global=Singleton.getInstance();
    DataProvider database = global.getDatabase();

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ImageView supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //((SneakSteals) this.getApplication()).initialize();
        vh = new ViewHolder();

        TopPicksAdaptor topPicksAdaptor = new TopPicksAdaptor(this, database.getTopPicks());
        recyclerView.setLayoutManager(layoutManager);
        //TopPicksAdaptor.setClickListener(this);
        recyclerView.setAdapter(topPicksAdaptor);

        vh.circleNike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Brand", "Nike");
                //listActivity.putExtra("Database", (Parcelable) database);
                startActivity(listActivity);
            }
        });

        vh.circleAdidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Brand", "Adidas");
                //listActivity.putExtra("Database", (Parcelable) database);
                startActivity(listActivity);
            }
        });
        vh.circlePuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Brand", "Puma");
                //listActivity.putExtra("Database", (Parcelable) database);
                startActivity(listActivity);
            }
        });

        vh.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Search Term", query);
                //listActivity.putExtra("Database", (Parcelable) database);
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
               // nextActivity.putExtra("Database", (Parcelable) database);
                startActivity(nextActivity);
            }
        });

    }

    //Update the top picks section
    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        TopPicksAdaptor topPicksAdaptor = new TopPicksAdaptor(this, database.getTopPicks());
        recyclerView.setLayoutManager(layoutManager);
        //TopPicksAdaptor.setClickListener(this);
        recyclerView.setAdapter(topPicksAdaptor);


        topPicksAdaptor.setClickListener(new TopPicksAdaptor.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TextView myTextView = (TextView) view.findViewById(R.id.category_listview_text);
                String selectedName = myTextView.getText().toString();
                Intent nextActivity = new Intent(getBaseContext(), DetailsActivity.class);
                nextActivity.putExtra("Name", selectedName);
                nextActivity.putExtra("PreviousActivity", "mainactivity");
                // nextActivity.putExtra("Database", (Parcelable) database);
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
       // nextActivity.putExtra("Database", (Parcelable) database);
        startActivity(nextActivity);
    }

    public void setSupportActionBar(ImageView supportActionBar) {
        this.supportActionBar = supportActionBar;
    }


}