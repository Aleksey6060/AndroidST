package com.example.a12prak;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Watch> watchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        watchList = new ArrayList<>();
        watchList.add(new Watch("Rolex Submariner", "Rolex Submariner — классические водолазные часы с водонепроницаемостью до 300 метров.", R.drawable.submariner));
        watchList.add(new Watch("Rolex Daytona", "Rolex Daytona — хронограф, разработанный для любителей автогонок.", R.drawable.daytona));
        watchList.add(new Watch("Rolex GMT-Master II", "Rolex GMT-Master II — часы с двойным часовым поясом, позволяющие отслеживать два часовых пояса одновременно.", R.drawable.gmt_master_ii));
        watchList.add(new Watch("Rolex Datejust", "Rolex Datejust — универсальные и элегантные часы с функцией отображения даты.", R.drawable.datejust));
        watchList.add(new Watch("Rolex Sky-Dweller", "Rolex Sky-Dweller — сложные часы с функцией двойного часового пояса и годового календаря.", R.drawable.sky_dweller));

        adapter = new MyAdapter(this, watchList);
        recyclerView.setAdapter(adapter);
    }
}