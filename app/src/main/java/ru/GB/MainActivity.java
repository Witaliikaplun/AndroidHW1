package ru.GB;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static ru.GB.R.id.scree;
import static ru.GB.R.id.textView;
import static ru.GB.R.id.textView2;
import static ru.GB.R.id.textView3;
import static ru.GB.R.id.textView4;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button btn1 = findViewById(R.id.button1);
        final TextView t1 = findViewById(textView);
        final TextView t2 = findViewById(textView3);
        final TextView t3 = findViewById(textView2);
        final TextView t4 = findViewById(textView4);

       btn1.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("ResourceAsColor")
           @Override
           public void onClick(View v) {

               if(btn1.getText().equals("DARK")) {
                   ConstraintLayout view = (ConstraintLayout) findViewById(R.id.scree);
                   view.setBackgroundResource(R.color.colorDark);
                   btn1.setText("LIHT");
                   t1.setTextColor(R.color.fontDark);
                   t2.setTextColor(R.color.fontDark);
                   t3.setTextColor(R.color.fontDark);
                   t4.setTextColor(R.color.fontDark);


               } else {
                   ConstraintLayout view = (ConstraintLayout) findViewById(R.id.scree);
                   view.setBackgroundResource(R.color.colorLIHT);
                   btn1.setText("DARK");
                   t1.setTextColor(R.color.colorfontLIHT);
                   t2.setTextColor(R.color.colorfontLIHT);
                   t3.setTextColor(R.color.colorfontLIHT);
                   t4.setTextColor(R.color.colorfontLIHT);
               }

           }
       });






    }
}
