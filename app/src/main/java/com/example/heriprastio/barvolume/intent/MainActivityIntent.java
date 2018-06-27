package com.example.heriprastio.barvolume.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.heriprastio.barvolume.MainActivity;
import com.example.heriprastio.barvolume.R;
import com.example.heriprastio.barvolume.model.Person;

public class MainActivityIntent extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveWithDataActivity;
    private Button btnMoveWithObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        btnMoveWithDataActivity = findViewById(R.id.btn_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject = (Button) findViewById(R.id.btnmove_actv_object);
        btnMoveWithObject.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivityIntent.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Heri Prastio");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 22);
                startActivity(moveWithDataIntent);
                break;
            case  R.id.btnmove_actv_object:
                Person mPerson = new Person();
                mPerson.setName("Aplikasi");
                mPerson.setAge(5);
                mPerson.setEmail("email@gmail.com");
                mPerson.setCity("Jakarta");

                Intent moveWithObject = new Intent(MainActivityIntent.this, MoveWithObjectActivity.class);
                moveWithObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObject);
                break;
        }
    }
}
