package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splashscreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread td= new Thread(){
        public void run() {
            try {
                sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();

            }finally {
                Intent it= new Intent(splashscreen.this, MainActivity.class);
                startActivity(it);
            }
        }


        };td.start();

    }
}
