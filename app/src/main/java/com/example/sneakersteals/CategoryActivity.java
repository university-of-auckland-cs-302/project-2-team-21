package com.example.sneakersteals;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
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
            ListView listView = findViewById(R.id.list);

            //Get the intent (Which brand to display)
            String brand = getIntent().getStringExtra("Brand");
            String searchInput = getIntent().getStringExtra("Search Term");
            Singleton global=Singleton.getInstance();
            DataProvider database = global.getDatabase();

            vh = new ViewHolder();
            //Check which intent to use.
            if (searchInput == null) {
                ShoeAdaptor shoeAdaptor = new ShoeAdaptor(this, R.layout.list_view_shoe_item, database.getBrandShoes(brand));

                listView.setAdapter(shoeAdaptor);
            } else if (brand == null) {
                ShoeAdaptor shoeAdaptor = new ShoeAdaptor(this, R.layout.list_view_shoe_item, database.getSearchShoes(searchInput));
                listView.setAdapter(shoeAdaptor);


            }


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView myTextView = (TextView) view.findViewById(R.id.category_listview_text);
                    String selectedName = myTextView.getText().toString();
                    Intent nextActivity = new Intent(getBaseContext(), DetailsActivity.class);
                    nextActivity.putExtra("Name", selectedName);
                    //nextActivity.putExtra("Database", (Parcelable) database);
                    startActivity(nextActivity);
                }
            });


        }
}
