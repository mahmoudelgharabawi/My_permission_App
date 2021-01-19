package com.example.mypermapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btnShow);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if (checkSelfPermission("course.labs.permissions.DANGEROUS_ACTIVITY_PERM") !=
                PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{"course.labs.permissions.DANGEROUS_ACTIVITY_PERM"},1);
                }else{

                    startDangerousActivity();

                }



            }
        });



    }

    private void startDangerousActivity() {

        startActivity(new Intent("course.labs.permissions.DANGEROUS_ACTIVITY_PERM"));
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case 1:
                startDangerousActivity();

        }


    }
}