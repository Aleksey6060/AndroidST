package com.example.eventdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView eventListView;
    private Button addEventButton;
    private EventAdapter eventAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventListView = findViewById(R.id.eventListView);
        addEventButton = findViewById(R.id.addEventButton);
        databaseHelper = new DatabaseHelper(this);

        // Кнопка для добавления события
        addEventButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEventActivity.class);
            startActivity(intent);
        });

        // Получение списка событий из базы данных
        List<Event> events = databaseHelper.getAllEvents();
        eventAdapter = new EventAdapter(this, events);
        eventListView.setAdapter(eventAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Обновляем список событий после возвращения с экрана добавления
        List<Event> events = databaseHelper.getAllEvents();
        eventAdapter.updateEvents(events);
    }
}
