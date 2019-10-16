package com.example.myrestaurant.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myrestaurant.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

@BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
//    @BindView(R.id.locationEditText) EditText mLocationEditText;
    private EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
mLocationEditText=(EditText) findViewById(R.id.locationEditText);
        ButterKnife.bind(this);
        mFindRestaurantsButton.setOnClickListener(this);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/delighter.otf"); //change

    }

            @Override
            public void onClick(View v) {
                if (v==mFindRestaurantsButton){
                Intent intent=new Intent(MainActivity.this, RestorActivity.class);
                String location=mLocationEditText.getText().toString();
//                    location.(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                Toast.makeText(MainActivity.this,location, Toast.LENGTH_LONG).show();
                intent.putExtra("location",location);

                startActivity(intent);
            }


        }
        }



