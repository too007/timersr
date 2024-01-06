package com.learnpainless.timer;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimerAdpter extends RecyclerView.Adapter<TimerAdpter.ViewHolder> {

    private Handler handler = new Handler();
    private ArrayList<Long> al;
    int s;
    Context context;

    public TimerAdpter(Context context, ArrayList<Long> al) {
        this.context =context;
        this.al = al;
        Log.e("TAG", "TimerAdpter: "+al );
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.binding(position);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handler.removeCallbacks(holder.countdownRunnable);

                }
            });


    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) getItemId(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView timeStamp;
        ImageView imageView;
        CountdownRunnable countdownRunnable;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timeStamp = itemView.findViewById(R.id.timestamp);
            imageView=itemView.findViewById(R.id.image_view);

        }

        public void binding(int p) {
            Log.e("TAG", "binding: "+al.get(p) );
            countdownRunnable = new CountdownRunnable(handler, timeStamp, al.get(p), getAdapterPosition());
            handler.postDelayed(countdownRunnable, 100);
        }

    }
    }


