package com.coderminion.connectionstatus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button status = (Button)findViewById(R.id.button);

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStatus(Utils.isNetworkAvailable());
            }
        });


    }

    private void getStatus(boolean isConnected) {
        String message = "Internet is working";

        if (!isConnected)
            message = "Internet is not working";

        Snackbar snack = Snackbar.make(findViewById(R.id.fab), message, Snackbar.LENGTH_LONG);

        if(!isConnected)
        {
            snack.setAction("Re-try", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStatus(Utils.isNetworkAvailable());
            }
        });
        }
        snack.show();

    }

}
