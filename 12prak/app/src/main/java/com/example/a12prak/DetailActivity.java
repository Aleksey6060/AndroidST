package com.example.a12prak;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView modelTextView = findViewById(R.id.detail_title);
        TextView descriptionTextView = findViewById(R.id.detail_description);
        ImageView imageView = findViewById(R.id.detail_image);

        String model = getIntent().getStringExtra("model");
        String description = getIntent().getStringExtra("description");
        int imageResource = getIntent().getIntExtra("imageResource", R.drawable.default_image);

        modelTextView.setText(model);
        descriptionTextView.setText(description);
        imageView.setImageResource(imageResource);
    }
}