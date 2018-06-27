package com.example.heriprastio.barvolume.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.heriprastio.barvolume.R;

public class MoveWithDataActivity extends AppCompatActivity {

    public static String EXTRA_AGE = "extra_age";
    public static String EXTRA_NAME = "extra_name";
    private TextView tvDataReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);
        tvDataReceived = findViewById(R.id.txtviewdatareceieved);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);
        String text = "Nama :"+name+", Umur Anda : "+age;
        tvDataReceived.setText(text);
    }
}
