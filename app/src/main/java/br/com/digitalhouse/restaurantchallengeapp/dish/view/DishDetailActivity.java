package br.com.digitalhouse.restaurantchallengeapp.dish.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.restaurantchallengeapp.R;
import br.com.digitalhouse.restaurantchallengeapp.model.Dish;

public class DishDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        ImageView dishDetailImageViewImage = findViewById(R.id.dishDetailImageViewImage);
        TextView dishDetailTextViewName = findViewById(R.id.dishDetailTextViewName);
        TextView dishDetailTextViewDescription = findViewById(R.id.dishDetailTextViewDescription);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Dish dish = getIntent().getParcelableExtra("DISH");
            if (dish != null) {
                dishDetailImageViewImage.setImageDrawable(ContextCompat.getDrawable(dishDetailImageViewImage.getContext(), dish.getImage()));
                dishDetailTextViewName.setText(dish.getName());
                dishDetailTextViewDescription.setText(dish.getDescription());
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return true;
    }
}
