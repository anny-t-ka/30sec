package com.useran.a30sec;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnNext;
    TextView HelloText;
    ImageView trainer;
    ScrollView scroll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        btnNext = (Button) findViewById(R.id.btnNext);
        HelloText = (TextView) findViewById(R.id.HelloText);
        scroll = (ScrollView) findViewById(R.id.scroll);
        trainer = (ImageView) findViewById(R.id.trainer);

        btnNext.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);

    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:
                Intent intent = new Intent(this, MainSpisok.class);
                startActivity(intent);
                break;
        }


    }
}