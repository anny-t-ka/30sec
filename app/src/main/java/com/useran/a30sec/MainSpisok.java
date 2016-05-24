package com.useran.a30sec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainSpisok extends Activity implements View.OnClickListener {

    Button btnPush, btnDip,btnSit,btnLunge,btnThread,btnPike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_spisok);

        btnPush = (Button) findViewById(R.id.btnPush);
        btnDip = (Button) findViewById(R.id.btnDip);
        btnSit = (Button) findViewById(R.id.btnSit);
        btnLunge = (Button) findViewById(R.id.btnLunge);
        btnThread = (Button) findViewById(R.id.btnThread);
        btnPike = (Button) findViewById(R.id.btnPike);

        btnPush.setOnClickListener(this);
        btnDip.setOnClickListener(this);
        btnSit.setOnClickListener(this);
        btnLunge.setOnClickListener(this);
        btnThread.setOnClickListener(this);
        btnPike.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPush:
                Intent intent = new Intent(this,ActivityPush.class);
                startActivity(intent);
                break;
            case R.id.btnDip:
                Intent intent1 = new Intent(this,ActivityDip.class);
                startActivity(intent1);
                break;
            case R.id.btnSit:
                Intent intent2 = new Intent(this,ActivitySit.class);
                startActivity(intent2);
                break;
            case R.id.btnLunge:
                Intent intent3 = new Intent(this,ActivityLunge.class);
                startActivity(intent3);
                break;
            case R.id.btnThread:
                Intent intent4 = new Intent(this,ActivityThread.class);
                startActivity(intent4);
                break;
            case R.id.btnPike:
                Intent intent5 = new Intent(this,ActivityPike.class);
                startActivity(intent5);
                break;

        }


    }
}
