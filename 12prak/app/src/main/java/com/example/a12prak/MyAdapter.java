package com.example.a12prak;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Watch> watchList;
    private Context context;

    public MyAdapter(Context context, List<Watch> watchList) {
        this.context = context;
        this.watchList = watchList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Watch watch = watchList.get(position);
        holder.titleTextView.setText(watch.getModel());
        holder.descriptionTextView.setText(watch.getDescription());
        holder.imageView.setImageResource(watch.getImageResource());
    }

    @Override
    public int getItemCount() {
        return watchList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.item_title);
            descriptionTextView = itemView.findViewById(R.id.item_description);
            imageView = itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Watch clickedWatch = watchList.get(position);

                // Показ всплывающего сообщения
                Toast.makeText(context, clickedWatch.getModel(), Toast.LENGTH_SHORT).show();

                // Переход на новую активити
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("model", clickedWatch.getModel());
                intent.putExtra("description", clickedWatch.getDescription());
                intent.putExtra("imageResource", clickedWatch.getImageResource());
                context.startActivity(intent);
            }
        }
    }
}