package com.example.eventdiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends ArrayAdapter<Event> {

    private Context context;
    private List<Event> events;

    public EventAdapter(Context context, List<Event> events) {
        super(context, 0, events);
        this.context = context;
        this.events = events;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event event = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
        }

        TextView eventTitle = convertView.findViewById(R.id.eventTitle);
        TextView eventDate = convertView.findViewById(R.id.eventDate);
        TextView eventPriority = convertView.findViewById(R.id.eventPriority);

        eventTitle.setText(event.getTitle());
        eventDate.setText(event.getDate());
        eventPriority.setText(event.getPriority());

        // Выделяем события по приоритету
        switch (event.getPriority()) {
            case "High":
                convertView.setBackgroundColor(context.getResources().getColor(R.color.high_priority));
                break;
            case "Medium":
                convertView.setBackgroundColor(context.getResources().getColor(R.color.medium_priority));
                break;
            case "Low":
                convertView.setBackgroundColor(context.getResources().getColor(R.color.low_priority));
                break;
        }

        return convertView;
    }

    // Метод обновления списка событий
    public void updateEvents(List<Event> events) {
        this.events.clear();
        this.events.addAll(events);
        notifyDataSetChanged();
    }
}
