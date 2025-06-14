package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText number1 = binding.editTextNumber1;
        EditText number2 = binding.editTextNumber2;
        TextView resultText = binding.textViewResult;
        Button addButton = binding.buttonAdd;
        Button subtractButton = binding.buttonSubtract;
        Button multiplyButton = binding.buttonMultiply;
        Button divideButton = binding.buttonDivide;

        Calculator calculator = new Calculator();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double result = calculator.add(num1, num2);
                    resultText.setText("Результат: " + result);
                } catch (NumberFormatException e) {
                    resultText.setText("Пожалуйста, введите корректные числа");
                }
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double result = calculator.subtract(num1, num2);
                    resultText.setText("Результат: " + result);
                } catch (NumberFormatException e) {
                    resultText.setText("Пожалуйста, введите корректные числа");
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double result = calculator.multiply(num1, num2);
                    resultText.setText("Результат: " + result);
                } catch (NumberFormatException e) {
                    resultText.setText("Пожалуйста, введите корректные числа");
                }
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double result = calculator.divide(num1, num2);
                    resultText.setText("Результат: " + result);
                } catch (NumberFormatException e) {
                    resultText.setText("Пожалуйста, введите корректные числа");
                } catch (IllegalArgumentException e) {
                    resultText.setText(e.getMessage());
                }
            }
        });
    }
}