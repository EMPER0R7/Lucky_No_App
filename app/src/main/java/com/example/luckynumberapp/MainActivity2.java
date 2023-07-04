package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
TextView no;
Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt2=findViewById(R.id.button2);
        no=findViewById(R.id.textView3);

        Intent i =getIntent();
        String user_name=i.getStringExtra("username");
        Toast.makeText(this, " Hello "+user_name, Toast.LENGTH_LONG).show();

         int num =generateRandom();
         no.setText(" "+num);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(user_name,num);

            }
        });

    }public int generateRandom(){
        Random random= new Random();
     int upper_limit=1000;
     int randomNumberGenerated =random.nextInt(1000);
     return randomNumberGenerated;
    }
    public void sendData(String user_name, int num){
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String number=String.valueOf(num);
        i.putExtra(Intent.EXTRA_SUBJECT,user_name+" have a lucky day!!");
        i.putExtra(Intent.EXTRA_TEXT, num);
        startActivity(Intent.createChooser(i,"chose a platform"));
    }
}