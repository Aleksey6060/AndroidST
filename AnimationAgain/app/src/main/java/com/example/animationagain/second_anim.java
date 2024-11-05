package com.example.animationagain;



import android.content.Intent;
import android.media.Image;
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

import com.example.animationagain.MainActivity;
import com.example.animationagain.R;
import com.example.animationagain.first_anim;

public class second_anim extends AppCompatActivity {

    private ImageView imgAn;
    private Button starte;
    private Button stope;
    private  Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_anim);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgAn = findViewById(R.id.monkey_flash_bank);
        starte = findViewById(R.id.anim_start);
        stope = findViewById(R.id.anim_stop);
        back = findViewById(R.id.back_to_main);
        Animation flash = AnimationUtils.loadAnimation(this, R.anim.cool_anim);
        Animation ap = AnimationUtils.loadAnimation(this,R.anim.appir_second_page);

        starte.startAnimation(ap);
        imgAn.startAnimation(ap);
        stope.startAnimation(ap);
        back.startAnimation(ap);

        starte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAn.startAnimation(flash);
            }
        });
        stope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAn.clearAnimation();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_anim.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}