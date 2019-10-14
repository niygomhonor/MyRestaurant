package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//    public static final String TAG =MainActivity.class.getSimpleName();
//private Button mFindRestaurantsButton;
//private EditText mLocationEditText;
//    private TextView mAppNameTextView;
//GridView gridView;
//    String[] letters = new String[] {
//            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
@BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mLocationEditText=(EditText)findViewById(R.id.locationEditText);
//        mFindRestaurantsButton =(Button)findViewById(R.id.findRestaurantsButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);

        ButterKnife.bind(this);
//        Typeface caviarFont = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams.ttf");
//        mAppNameTextView.setTypeface(caviarFont);
        mFindRestaurantsButton.setOnClickListener(this);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/delighter.otf"); //change
//        gridView = (GridView) findViewById(R.id.baseGridView);
//        gridView = (GridView) findViewById(R.id.baseGridView);
//        gridView.setAdapter(new AlphabetAdapter(this, letters));
    }
//        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==mFindRestaurantsButton){
                Intent intent=new Intent(MainActivity.this,RestorActivity.class);
                String location=mLocationEditText.getText().toString();
//
                Toast.makeText(MainActivity.this,location, Toast.LENGTH_LONG).show();
                intent.putExtra("location",location);
                startActivity(intent);
            }


        }
        }



