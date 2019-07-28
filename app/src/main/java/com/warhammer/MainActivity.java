package com.warhammer;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> qoutes = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("qoutes.txt")));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                qoutes.add(mLine);
            }
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
        notifications();
    }

    public void notifications() {
        Random random = new Random();
        Button button = (Button) findViewById(R.id.button);
        final TextView qoute = (TextView) findViewById(R.id.warhammer_qoute);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "notify_001")
                .setSmallIcon(R.drawable.ic_stat_onesignal_default)
                .setContentTitle("Warhammer Qoute of The Day")
                .setContentText("test")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qoute.setText("text");
            }
        });

    }
}
