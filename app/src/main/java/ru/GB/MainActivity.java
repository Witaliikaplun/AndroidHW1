package ru.GB;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static ru.GB.R.id.imageView2;
import static ru.GB.R.id.scree;
import static ru.GB.R.id.textView;
import static ru.GB.R.id.textView2;
import static ru.GB.R.id.textView3;
import static ru.GB.R.id.textView4;
import static ru.GB.R.id.textView5;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button btn1 = findViewById(R.id.button1);
        final TextView t1 =  findViewById(textView);
        final TextView t2 =  findViewById(textView3);
        final TextView t3 =  findViewById(textView2);
        final TextView t4 =  findViewById(textView4);
        final TextView t5 =  findViewById(textView5);
        final ImageView imageBack = findViewById(imageView2);



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
