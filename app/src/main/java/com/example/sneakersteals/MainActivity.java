package com.example.sneakersteals;

import android.content.Intent;
import android.os.Build;
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

    //Get singleton database
    Singleton global=Singleton.getInstance();
    DataProvider database = global.getDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout); //Set transition
        setContentView(R.layout.activity_main);
        statusBarcolour();
        vh = new ViewHolder();

        //Set layout manager and adaptor for top picks section
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        TopPicksAdaptor topPicksAdaptor = new TopPicksAdaptor(this, database.getTopPicks());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(topPicksAdaptor);

        //Click listener when user clicks on nike category
        vh.circleNike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Brand", "Nike");
                startActivity(listActivity);
            }
        });

        //Click listener when user clicks on adidas category
        vh.circleAdidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Brand", "Adidas");
                startActivity(listActivity);
            }
        });

        //Click listener when user clicks on puma category
        vh.circlePuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivity = new Intent(getBaseContext(), CategoryActivity.class);
                listActivity.putExtra("Brand", "Puma");
                startActivity(listActivity);
            }
        });

        //Click listener when user makes a search enquiry
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

        //Click listener when user clicks an item in top picks
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

    //Update the top picks section when resume activity
    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        TopPicksAdaptor topPicksAdaptor = new TopPicksAdaptor(this, database.getTopPicks());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(topPicksAdaptor);


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

    //Set status bar colour
    public void statusBarcolour() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple,this.getTheme()));
        }else if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)){
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple));
        }
    }
}