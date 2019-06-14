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
import br.com.digitalhouse.restaurantchallengeapp.restaurant.listener.RecyclerViewDishClickListener;
import br.com.digitalhouse.restaurantchallengeapp.model.Dish;

public class RecyclerViewDishAdapter extends RecyclerView.Adapter<RecyclerViewDishAdapter.ViewHolder> {

    private List<Dish> dishes;
    private RecyclerViewDishClickListener listener;

    public RecyclerViewDishAdapter(List<Dish> dishes, RecyclerViewDishClickListener listener) {
        this.dishes = dishes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dish_recyclerview_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Dish dish = dishes.get(i);
        viewHolder.bind(dish);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(dish);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView dishImageViewImage;
        private TextView dishTextViewName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dishImageViewImage = itemView.findViewById(R.id.dishImageViewImage);
            dishTextViewName = itemView.findViewById(R.id.dishTextViewName);
        }

        public void bind(Dish dish) {
            dishImageViewImage.setImageDrawable(ContextCompat.getDrawable(dishImageViewImage.getContext(), dish.getImage()));
            dishTextViewName.setText(dish.getName());
        }
    }
}
