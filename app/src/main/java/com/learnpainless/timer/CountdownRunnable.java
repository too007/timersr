package com.learnpainless.timer;

import android.os.Handler;
import android.widget.TextView;

public class CountdownRunnable implements Runnable {

    private long millisUntilFinished;
    private TextView holder;
    private Handler handler;
//  /  ImageView imageView;

    public CountdownRunnable(Handler handler, TextView holder, long millisUntilFinished, int adapterPosition) {
        this.handler = handler;
        this.holder = holder;
        this.millisUntilFinished = millisUntilFinished;

    }

    @Override
    public void run() {
        /* do what you need to do */
        long seconds = millisUntilFinished / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        String time = days + " " + "days" + " :" + hours % 24 + ":" + minutes % 60 + ":" + seconds % 60;


        millisUntilFinished -= 1000;

        if (millisUntilFinished > -1) {
            handler.postDelayed(this, 1000);
        }
        
        holder.setText(time);
    }
}
