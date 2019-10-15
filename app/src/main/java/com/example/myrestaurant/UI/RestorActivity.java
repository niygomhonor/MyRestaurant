package com.example.myrestaurant.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myrestaurant.Adapters.RestaurantListAdapter;


import com.example.myrestaurant.R;
import com.example.myrestaurant.Network.YelpApi;
import com.example.myrestaurant.Network.YelpClient;

import com.example.myrestaurant.models.Business;
import com.example.myrestaurant.models.YelpBusinessesSearchResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestorActivity extends AppCompatActivity {

public List<Business> restaurants;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private RestaurantListAdapter mAdapter;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_restor);
    ButterKnife.bind(this);

    Intent intent = getIntent();
    String location = intent.getStringExtra("location");

    YelpApi client = YelpClient.getClient();

    Call<YelpBusinessesSearchResponse> call = client.getRestaurants(location, "restaurants");

    call.enqueue(new Callback<YelpBusinessesSearchResponse>() {
        @Override
        public void onResponse(Call<YelpBusinessesSearchResponse> call, Response<YelpBusinessesSearchResponse> response) {
            if (response.isSuccessful()) {
//                List<Business> restaurantsList = response.body().getBusinesses();
//                String[] restaurants = new String[restaurantsList.size()];
//                String[] categories = new String[restaurantsList.size()];
//
//                for (int i = 0; i < restaurants.length; i++){
//                    restaurants[i] = restaurantsList.get(i).getName();
//                }
//
//                for (int i = 0; i < categories.length; i++) {
//                    Category category = restaurantsList.get(i).getCategories().get(0);
//                    categories[i] = category.getTitle();
//                }

                restaurants = response.body().getBusinesses();
                mAdapter = new RestaurantListAdapter(RestorActivity.this, restaurants);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(RestorActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);

//                ArrayAdapter adapter
//                        = new MyRestaurantsArrayAdapter(RestorActivity.this, android.R.layout.simple_list_item_1, restaurants, categories);
//                mListView.setAdapter(adapter);
                showRestaurants();
                hideProgressBar();
            }
            else {

                showUnsuccessfulMessage();
            }
        }

        @Override
        public void onFailure(Call<YelpBusinessesSearchResponse> call, Throwable t) {

            hideProgressBar();
            showFailureMessage();

        }

    });
}

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
//        mListView.setVisibility(View.VISIBLE);
//        mLocationTextView.setVisibility(View.VISIBLE);

        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }


}