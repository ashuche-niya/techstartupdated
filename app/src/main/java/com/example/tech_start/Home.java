package com.example.tech_start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements GridAdapter.OnItemClickListener, View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ArrayList<String> imageList = new ArrayList<>();
        final ArrayList<String> index = new ArrayList<>();

        imageList.add("R.drawable.clothing");
        imageList.add("R.drawable.gym");
        imageList.add("R.drawable.decor");
        imageList.add("R.drawable.electronics");
        imageList.add("R.drawable.footwear");
        imageList.add("R.drawable.toys");

        index.add("Clothing");
        index.add("Gym");
        index.add("Decor");
        index.add("Electronics");
        index.add("Footwear");
        index.add("Toys");

        RecyclerView rv = findViewById(R.id.itemscategory);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        GridAdapter iga = new GridAdapter(Home.this, imageList, index);
        rv.setAdapter(iga);
        iga.setOnItemClickListener(Home.this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(int position) {

    }
}
