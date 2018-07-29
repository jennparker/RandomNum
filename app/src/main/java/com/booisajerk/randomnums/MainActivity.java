package com.booisajerk.randomnums;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    Button generateButton;
    EditText minValue, maxValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        minValue = (EditText) findViewById(R.id.min_field);
        maxValue = (EditText) findViewById(R.id.max_field);
        generateButton = (Button) findViewById(R.id.generate_button);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String minString = (minValue.getText() != null)
                        ? minValue.getText().toString() : "0";

                int minVal = Integer.parseInt(minString);

                String maxString = (maxValue.getText() != null)
                        ? maxValue.getText().toString() : "100";

                int maxVal = Integer.parseInt(maxString);

                final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();

                dialog.setTitle("Voila");
                dialog.setMessage("Your random number is " + calculateRandomNumber(minVal, maxVal));
                dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    static int calculateRandomNumber(int min, int max) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        return randomNum;
    }
}
