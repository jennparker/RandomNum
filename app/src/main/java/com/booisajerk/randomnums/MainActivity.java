package com.booisajerk.randomnums;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private EditText minValue, maxValue;

    private static final String MIN_VALUE = "0";
    private static final String MAX_VALUE = "100";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        minValue = findViewById(R.id.min_field);
        maxValue = findViewById(R.id.max_field);
        Button generateButton = findViewById(R.id.generate_button);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String minString = (minValue.getText().toString().equals(""))
                        ? MIN_VALUE : minValue.getText().toString();

                int minVal = Integer.parseInt(minString);

                String maxString = (maxValue.getText().toString().equals(""))
                        ? MAX_VALUE : maxValue.getText().toString();

                int maxVal = Integer.parseInt(maxString);

                final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();

                dialog.setTitle(getString(R.string.dialog_title));
                dialog.setMessage(String.format(getResources().getString(R.string.dialog_description), calculateRandomNumber(minVal, maxVal)));
                dialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(android.R.string.ok), new DialogInterface.OnClickListener() {
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

    private static int calculateRandomNumber(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
