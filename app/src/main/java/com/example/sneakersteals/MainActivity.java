package com.example.sneakersteals;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sneakersteals.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    class ViewHolder {
        CardView cardviewNike;
        CardView cardviewAddidas;

        public ViewHolder() {
            cardviewNike = findViewById(R.id.cardview_nike);
            cardviewAddidas = findViewById(R.id.cardview_addidas);
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
    }

}