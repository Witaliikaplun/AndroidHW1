package ru.GB;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static ru.GB.R.id.imageView2;
import static ru.GB.R.id.textView;
import static ru.GB.R.id.textView10;
import static ru.GB.R.id.textView2;
import static ru.GB.R.id.textView3;
import static ru.GB.R.id.textView4;
import static ru.GB.R.id.textView5;
import static ru.GB.R.id.textView6;
import static ru.GB.R.id.textView9;

public class MainActivity extends AppCompatActivity implements Constants{

    private static final String LIFECYCLE = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String instanceState;
        if (savedInstanceState == null ){
            instanceState = "MainActivity Первый запуск!" ;
        }
        else {
            instanceState = "MainActivity Повторный запуск!" ;
        }
        messToast("MainActivity  - onCreate()");

        //получаем ссылки на визуальные элементы----------------------
        final Button btn1 = findViewById(R.id.button1);
        final Button btn2 = findViewById(R.id.button2);
        final Button btnGo = findViewById(R.id.button);
        final TextView t1 =  findViewById(textView);
        final TextView t2 =  findViewById(textView3);
        final TextView t3 =  findViewById(textView2);
        final TextView t4 =  findViewById(textView4);
        final TextView t5 =  findViewById(textView5);
        final TextView t9 = findViewById(textView9);
        final TextView t10 = findViewById(textView10);
        final ImageView imageBack = findViewById(imageView2);


        if(getIntent().getExtras() != null){
            t3.setText(getIntent().getExtras().getString(CITY));
            if(getIntent().getExtras().getInt(S3) == 1) t9.setVisibility(View.VISIBLE);
            if(getIntent().getExtras().getInt(S2) == 1) t10.setVisibility(View.VISIBLE);


        }

       btn1.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("ResourceAsColor")
           @Override
           public void onClick(View v) {
               if(btn1.getText().equals("DARK")) {
                   setDarkTeme(btn1, t1, t2, t3, t4, t5, R.color.colorDark, "LIGHT", R.color.fontDark);
                   imageBack.setAlpha((float) 0.3);
               } else {
                   setLightTeme(btn1, t1, t2, t3, t4, t5, R.color.colorLIHT, "DARK", R.color.colorfontLIHT);
                   imageBack.setAlpha((float) 1.0);
               }
           }
       });
        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClassScreen2.class);
                startActivity(intent);
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site = "https://yandex.ru/pogoda/krasnodar";
                Uri uri = Uri.parse(site);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
            }
        });
    }

    @Override
    protected void onStart() {
        super .onStart();
        messToast("MainActivity onStart()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        messToast("MainActivity onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        messToast("MainActivity Повторный запуск!!-onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super .onResume();
        messToast("MainActivity onResume()");
    }

    @Override
    protected void onPause() {
        super .onPause();
        messToast("MainActivity onPause()");

    }

    @Override
    protected void onStop() {
        super .onStop();
        messToast("MainActivity onStop()");
    }

    @Override
    protected void onRestart() {
        super .onRestart();
        messToast("MainActivity onRestart()");

    }

    @Override
    protected void onDestroy() {
        super .onDestroy();
        messToast("MainActivity onDestroy()");
    }

    private void messToast(String mes){
        Toast.makeText(getApplicationContext(), mes, Toast.LENGTH_SHORT).show();
        Log.d(LIFECYCLE, mes);
    }


    private void setLightTeme(Button btn1, TextView t1, TextView t2, TextView t3, TextView t4, TextView t5, int p, String dark, int p2) {
        ConstraintLayout view = (ConstraintLayout) findViewById(R.id.scree);
        view.setBackgroundResource(p);
        btn1.setText(dark);
        t1.setTextColor(getResources().getColor(p2));
        t2.setTextColor(getResources().getColor(p2));
        t3.setTextColor(getResources().getColor(p2));
        t4.setTextColor(getResources().getColor(p2));
        t5.setTextColor(getResources().getColor(p2));
    }

    private void setDarkTeme(Button btn1, TextView t1, TextView t2, TextView t3, TextView t4, TextView t5, int p, String liht, int p2) {
        ConstraintLayout view = (ConstraintLayout) findViewById(R.id.scree);
        view.setBackgroundResource(p);
        btn1.setText(liht);
        t1.setTextColor(getResources().getColor(p2));
        t2.setTextColor(getResources().getColor(p2));
        t3.setTextColor(getResources().getColor(p2));
        t4.setTextColor(getResources().getColor(p2));
        t5.setTextColor(getResources().getColor(p2));
    }
}
