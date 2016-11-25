package com.example.yurynoh.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    EditText pizza, spaghetti, salad;
    TextView orderCnt, totalCheck, extraChoice;
    CheckBox membership;
    RadioGroup extras;
    ImageView extraPics;
    Button order;
    int extraWH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza = (EditText) findViewById(R.id.pizzaCnt);
        spaghetti = (EditText)findViewById(R.id.spaghettiCnt);
        salad = (EditText)findViewById(R.id.saladCnt);
        orderCnt = (TextView)findViewById(R.id.orderCnt);
        totalCheck = (TextView)findViewById(R.id.totalCheck);
        extraChoice = (TextView)findViewById(R.id.extraChoice);
        membership = (CheckBox)findViewById(R.id.membership);
        extras = (RadioGroup)findViewById(R.id.extras);
        extraPics = (ImageView)findViewById(R.id.extraPics);
        order = (Button)findViewById(R.id.order);



        extras.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.pickles) {
                    extraPics.setImageResource(R.drawable.pickles);
                    extraWH = 0;
                } else if(checkedId == R.id.sauces) {
                    extraPics.setImageResource(R.drawable.sauces);
                    extraWH = 1;
                }
            }
        });

        order.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int orders = 0;
                double price = 0;
                String choice = "";
                if(!pizza.getText().toString().equals("")) {
                    int cnt = Integer.parseInt(pizza.getText().toString());
                    orders += cnt;
                    price += cnt * 16;
                }
                if(!spaghetti.getText().toString().equals("")) {
                    int cnt = Integer.parseInt(spaghetti.getText().toString());
                    orders += cnt;
                    price += cnt * 11;
                }
                if(!salad.getText().toString().equals("")) {
                    int cnt = Integer.parseInt(salad.getText().toString());
                    orders += cnt;
                    price += cnt * 4;
                }

                if(membership.isChecked()) {
                    price = price * 0.93;

                }

                if(extraWH == 0) {
                    choice = "you chose pickles";
                } else {
                    choice = "you chose sauces";
                }

                orderCnt.setText(Integer.toString(orders));
                totalCheck.setText(Double.toString(price));
                extraChoice.setText(choice);

            }
        });
    }
}
