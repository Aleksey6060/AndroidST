package com.example.animationagain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button second;
    private Button firstPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firstPageButton = findViewById(R.id.first_page_button);
        second = findViewById(R.id.second_page_button);
        Animation str = AnimationUtils.loadAnimation(this, R.anim.main_apir);
        firstPageButton.startAnimation(str);
        second.startAnimation(str);
        firstPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation enterAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.entering_page_first_anim);
                Animation exitAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.exit_to_first_page_anim);

                v.startAnimation(enterAnim); // Применяем анимацию на текущей кнопке

                // Создаем интент для перехода к новой активити (в данном случае first_anim)
                Intent intent = new Intent(MainActivity.this, first_anim.class);
                startActivity(intent);

                // Устанавливаем анимацию для входа и выхода при переходе к новой активити
                overridePendingTransition(R.anim.entering_page_first_anim, R.anim.exit_to_first_page_anim);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation enterAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.cool_anim);

                v.startAnimation(enterAnim); // Применяем анимацию на кнопке

                Intent intent = new Intent(MainActivity.this, second_anim.class);
                startActivity(intent);
                overridePendingTransition(R.anim.cool_anim, R.anim.main_apir);
            }
        });

    }
}