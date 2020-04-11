package ru.GB;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class ClassScreen2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);



        final Button btn3 = findViewById(R.id.button3);
        final Button btn4 = findViewById(R.id.button4);
        final ImageView imageBack = findViewById(R.id.imageView4);

        String msk = (String) getText(R.string.MSK);
        String spb = (String) getText(R.string.SPB);
        String krd = (String) getText(R.string.CRD);
        final TextView t6 =  findViewById(R.id.textView6);
        final String[] data = {msk, spb, krd};

        final Switch s2 = findViewById(R.id.switch2);
        final Switch s3 = findViewById(R.id.switch3);


         //адаптер----------------------------------------------------
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spiner);
        spinner.setAdapter(adapter);
        // заголовок--------------------------------------------------
        spinner.setPrompt("Title");
        // выделяем элемент-------------------------------------------
        spinner.setSelection(2);
        // устанавливаем обработчик нажатия---------------------------
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                //Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0: t6.setText(data[position]);
                        //t2.setText(data[position]);
                    break;

                    case 1: t6.setText(data[position]);
                        //t2.setText(data[position]);
                        break;

                    case 2: t6.setText(data[position]);
                        //t2.setText(data[position]);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                if(btn3.getText().equals("DARK")) {
                    setDarkTeme(btn3, s2, s3, R.color.colorDark, "LIGHT", R.color.fontDark);
                    imageBack.setAlpha((float) 0.3);


                } else {
                    setLightTeme(btn3, s2, s3, R.color.colorLIHT, "DARK", R.color.colorfontLIHT);
                    imageBack.setAlpha((float) 1.0);
                }

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClassScreen2.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
    private void setLightTeme(Button btn3, Switch s2, Switch s3, int p, String dark, int p2) {
        ConstraintLayout view = (ConstraintLayout) findViewById(R.id.scree2);
        view.setBackgroundResource(p);
        btn3.setText(dark);
        s2.setTextColor(getResources().getColor(p2));
        s3.setTextColor(getResources().getColor(p2));

    }

    private void setDarkTeme(Button btn3, Switch s2, Switch s3, int p, String liht, int p2) {
        ConstraintLayout view = (ConstraintLayout) findViewById(R.id.scree2);
        view.setBackgroundResource(p);
        btn3.setText(liht);
        s2.setTextColor(getResources().getColor(p2));
        s3.setTextColor(getResources().getColor(p2));

    }
}
