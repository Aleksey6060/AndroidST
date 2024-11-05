package com.example.animationagain;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class first_anim extends AppCompatActivity {

    private ImageView monki_dance;
    private Button start_btn;
    private Button conec_btn;
    private Button back_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first_anim);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        monki_dance = findViewById(R.id.monke_dance);
        start_btn = findViewById(R.id.start_but);
        conec_btn = findViewById(R.id.stop_but);
        back_but = findViewById(R.id.back_to_main);
        AnimationDrawable Monke = (AnimationDrawable) monki_dance.getDrawable();
        Animation apearance = AnimationUtils.loadAnimation(this, R.anim.apearience);
        Animation ap = AnimationUtils.loadAnimation(this, R.anim.apearience_reverse);
        monki_dance.startAnimation(apearance);
        start_btn.startAnimation(apearance);
        conec_btn.startAnimation(ap);
        back_but.startAnimation(ap);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Monke.start();
            }
        });
        conec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Monke.stop();
            }
        });

        back_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(first_anim.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}