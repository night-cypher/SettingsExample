package com.questdot.settingsexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSettings=(Button)findViewById(R.id.btnSettings);
    btnSettings.setOnClickListener(this);
        loadPreference();

    }



    public void loadPreference(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isBackgroundDark = sharedPreferences.getBoolean("background",false);

        if(isBackgroundDark){


            RelativeLayout mainLayout = (RelativeLayout)findViewById(R.id.relativelayout);
            mainLayout.setBackgroundColor(Color.parseColor("#3c3f41"));

        }
        else{
            RelativeLayout mainLayout = (RelativeLayout)findViewById(R.id.relativelayout);
            mainLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        String notebookTitle = sharedPreferences.getString("title","hehee");

        setTitle(notebookTitle);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnSettings:
                Intent intent = new Intent(this,SettingsActivity.class);

                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
            loadPreference();
    }
}
