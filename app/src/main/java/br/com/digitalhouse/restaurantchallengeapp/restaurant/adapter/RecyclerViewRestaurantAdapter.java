package br.com.digitalhouse.restaurantchallengeapp.restaurant.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.restaurantchallengeapp.R;
import br.com.digitalhouse.restaurantchallengeapp.model.Restaurant;
import br.com.digitalhouse.restaurantchallengeapp.restaurant.listener.RecyclerViewRestaurantClickListener;

public class RecyclerViewRestaurantAdapter extends RecyclerView.Adapter<RecyclerViewRestaurantAdapter.ViewHolder> {

    private List<Restaurant> restaurants;
    private RecyclerViewRestaurantClickListener listener;

    public RecyclerViewRestaurantAdapter(List<Restaurant> restaurants, RecyclerViewRestaurantClickListener listener) {
        this.restaurants = restaurants;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurant_recyclerview_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Restaurant restaurant = restaurants.get(i);
        viewHolder.bind(restaurant);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(restaurant);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView restaurantImageViewImage;
        private TextView restaurantTextViewName;
        private TextView restaurantTextViewAddress;
        private TextView restaurantTextViewCloseTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImageViewImage = itemView.findViewById(R.id.restaurantImageViewImage);
            restaurantTextViewName = itemView.findViewById(R.id.restaurantTextViewName);
            restaurantTextViewAddress = itemView.findViewById(R.id.restaurantTextViewAddress);
            restaurantTextViewCloseTime = itemView.findViewById(R.id.restaurantTextViewCloseTime);
        }

        public void bind(Restaurant restaurant) {
            restaurantImageViewImage.setImageDrawable(ContextCompat.getDrawable(restaurantImageViewImage.getContext(), restaurant.getImage()));
            restaurantTextViewName.setText(restaurant.getName());
            restaurantTextViewAddress.setText(restaurant.getAddress());
            restaurantTextViewCloseTime.setText(restaurant.getClose());
        }
    }
}
