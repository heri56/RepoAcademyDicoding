package com.example.heriprastio.barvolume.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.heriprastio.barvolume.R;
import com.example.heriprastio.barvolume.model.Person;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObject = (TextView) findViewById(R.id.txtviewdatareceieved);
        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+mPerson.getName()+", Email: "+mPerson.getEmail()+", Age : "+mPerson.getAge()
                + ", Location : "+mPerson.getCity();
        tvObject.setText(text);
    }
}
