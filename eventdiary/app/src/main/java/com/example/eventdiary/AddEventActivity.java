package com.example.eventdiary;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddEventActivity extends AppCompatActivity {

    private EditText titleEditText, dateEditText;
    private Spinner prioritySpinner;
    private Button saveButton;
    private DatabaseHelper databaseHelper;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        titleEditText = findViewById(R.id.titleEditText);
        dateEditText = findViewById(R.id.dateEditText);
        prioritySpinner = findViewById(R.id.prioritySpinner);
        saveButton = findViewById(R.id.saveButton);
        databaseHelper = new DatabaseHelper(this);
        calendar = Calendar.getInstance();

        // Делаем dateEditText некликабельным для ввода текста
        dateEditText.setKeyListener(null);
        dateEditText.setOnClickListener(v -> showDateTimePicker());

        saveButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString().trim();
            String date = dateEditText.getText().toString().trim();
            String priority = prioritySpinner.getSelectedItem().toString();

            // Валидация ввода
            if (title.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            long eventTime = calendar.getTimeInMillis();
            if (eventTime < System.currentTimeMillis()) {
                Toast.makeText(this, "Выберите дату и время в будущем", Toast.LENGTH_SHORT).show();
                return;
            }

            Event event = new Event(title, date, priority, eventTime);
            long eventId = databaseHelper.addEvent(event); // Получаем ID события

            setReminder(eventId, eventTime);

            Toast.makeText(this, "Событие добавлено", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void showDateTimePicker() {
        // Показываем DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    calendar.set(year, month, dayOfMonth);
                    // После выбора даты показываем TimePickerDialog
                    showTimePicker();
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000); // Запрещаем выбор прошлых дат
        datePickerDialog.show();
    }

    private void showTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (view, hourOfDay, minute) -> {
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute);
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);

                    // Форматируем дату и время для отображения
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
                    dateEditText.setText(sdf.format(calendar.getTime()));
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.show();
    }

    private void setReminder(long eventId, long eventTime) {
        android.app.AlarmManager alarmManager = (android.app.AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, EventReceiver.class);
        android.app.PendingIntent pendingIntent = android.app.PendingIntent.getBroadcast(
                this, (int) eventId, intent, android.app.PendingIntent.FLAG_UPDATE_CURRENT | android.app.PendingIntent.FLAG_IMMUTABLE
        );

        alarmManager.setExact(android.app.AlarmManager.RTC_WAKEUP, eventTime, pendingIntent);
    }
}