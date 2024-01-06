package com.learnpainless.timer;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private OnItemClickListener onItemClickListener;
    private Handler handler = new Handler();

    public RecyclerViewAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void clearAll() {
        handler.removeCallbacksAndMessages(null);
    }



    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);

        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(onItemClickListener);
    }

    @Override public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView timeStamp;
        ImageView imageView;
        CountdownRunnable countdownRunnable;

        public ViewHolder(View itemView) {
            super(itemView);
            timeStamp = itemView.findViewById(R.id.timestamp);
            imageView = itemView.findViewById(R.id.image_view);
            countdownRunnable = new CountdownRunnable(handler,timeStamp,120000,getAdapterPosition());
        }

        public void bind(final OnItemClickListener listener) {
            handler.removeCallbacks(countdownRunnable);
//            countdownRunnable.holder = timeStamp;
//            countdownRunnable.millisUntilFinished = 10000 * getAdapterPosition(); //because i want all timers run separately.
            handler.postDelayed(countdownRunnable, 100);


        }
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
