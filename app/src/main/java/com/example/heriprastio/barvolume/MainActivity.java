package com.example.heriprastio.barvolume;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.heriprastio.barvolume.intent.MainActivityIntent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate, btnPindah;
    private TextView tvResult;

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_lentgh);
        btnCalculate = findViewById(R.id.btn_calculate);
        btnPindah = findViewById(R.id.btnmove);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
        btnPindah.setOnClickListener(this);
        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_calculate){
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            boolean isEmptyField = false;
            if (TextUtils.isEmpty(length)){
                isEmptyField = true;
                edtLength.setError("Field ini tak boleh kosong");
            }
            if (TextUtils.isEmpty(width)){
                isEmptyField = true;
                edtWidth.setError("Field ini tak boleh kosong") ;
            }
            if (TextUtils.isEmpty(height)){
                isEmptyField = true;
                edtHeight.setError("Field ini tak boleh kosong");
            }
            if (!isEmptyField){
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
