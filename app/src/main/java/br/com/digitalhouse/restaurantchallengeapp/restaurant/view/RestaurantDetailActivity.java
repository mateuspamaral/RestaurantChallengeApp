package br.com.digitalhouse.restaurantchallengeapp.restaurant.view;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

import br.com.digitalhouse.restaurantchallengeapp.R;
import br.com.digitalhouse.restaurantchallengeapp.dish.view.DishDetailActivity;
import br.com.digitalhouse.restaurantchallengeapp.model.Dish;
import br.com.digitalhouse.restaurantchallengeapp.model.Restaurant;
import br.com.digitalhouse.restaurantchallengeapp.restaurant.adapter.RecyclerViewDishAdapter;
import br.com.digitalhouse.restaurantchallengeapp.restaurant.listener.RecyclerViewDishClickListener;

public class RestaurantDetailActivity extends AppCompatActivity implements RecyclerViewDishClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewDishAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        try {
            recyclerView = findViewById(R.id.dishRecyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            adapter = new RecyclerViewDishAdapter(getDishes(Objects.requireNonNull(getRestaurantIntent(), "Restaurant must not be null.")), this);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "We are still working on that back button. Sorry for the inconvenience", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, RestaurantActivity.class);
            startActivity(intent);
        }
    }

    private List<Dish> getDishes(Restaurant restaurant) {
        return restaurant.getDishList();
    }

    private Restaurant getRestaurantIntent() {
        ImageView restaurantDetailImageViewImage = findViewById(R.id.restaurantDetailImageViewImage);
        TextView restaurantDetailTextViewName = findViewById(R.id.restaurantDetailTextViewName);
        if (getIntent() != null && getIntent().getExtras() != null) {
            Restaurant restaurant = getIntent().getParcelableExtra("RESTAURANT");
            if (restaurant != null) {
                restaurantDetailImageViewImage.setImageDrawable(ContextCompat.getDrawable(restaurantDetailImageViewImage.getContext(), restaurant.getImage()));
                restaurantDetailTextViewName.setText(restaurant.getName());
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public void onClick(Dish dish) {
        Intent intent = new Intent(this, DishDetailActivity.class);
        intent.putExtra("DISH", dish);
        startActivity(intent);
    }
}
