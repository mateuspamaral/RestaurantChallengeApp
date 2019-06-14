package br.com.digitalhouse.restaurantchallengeapp.restaurant.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.restaurantchallengeapp.R;
import br.com.digitalhouse.restaurantchallengeapp.model.Dish;
import br.com.digitalhouse.restaurantchallengeapp.model.Restaurant;
import br.com.digitalhouse.restaurantchallengeapp.profile.view.ProfileActivity;
import br.com.digitalhouse.restaurantchallengeapp.restaurant.adapter.RecyclerViewRestaurantAdapter;
import br.com.digitalhouse.restaurantchallengeapp.restaurant.listener.RecyclerViewRestaurantClickListener;

public class RestaurantActivity extends AppCompatActivity implements RecyclerViewRestaurantClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewRestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        recyclerView = findViewById(R.id.restaurantRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewRestaurantAdapter(getRestaurant(), this);
        recyclerView.setAdapter(adapter);
    }

    private List<Restaurant> getRestaurant() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Cozy", "Av. Silva Lobo, 1934 - Alto Barroca, Belo Horizonte", "11:00", "22:00", R.drawable.restaurant1, getDishes()));
        restaurants.add(new Restaurant("Sunset Rooftop", "Av. José Lindoia, 35 - Topo do Mundo, Belo Horizonte", "17:00", "23:00", R.drawable.restaurant2, getDishes()));
        restaurants.add(new Restaurant("Rich in Black", "R. 3, 999 - Manhattan, New York", "10:00", "21:00", R.drawable.restaurant3, getDishes()));
        restaurants.add(new Restaurant("Hipster Home", "R. Jarvis, 437 - Vila Madalena, São Paulo", "18:00", "00:00", R.drawable.restaurant4, getDishes()));
        restaurants.add(new Restaurant("By the Beach", "Alameda Da Hora, 4 - Beautiful Place, My Dreams", "10:00", "02:00", R.drawable.restaurant5, getDishes()));
        return restaurants;
    }

    private List<Dish> getDishes() {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Camarão à junina", "Lindos e suculentos camaões servidos no melhor estilo junino, com fogueira de São João e mais!", R.drawable.dish1));
        dishes.add(new Dish("Ceviche Miranda", "Inspirado na nossa cantora e atriz Carmem Miranda, este prato tem cubos de ceviche com deliciosas frutas na parte de cima. Ah! Não esqueça de pedir o pão para limpar todo o molho do fundo!", R.drawable.dish2));
        dishes.add(new Dish("Ensopado do chef", "Sabe tudo aquilo de bom que você pensa, então colocamos numa cumbuca, uma pitada de amor(Sazon) e água do Imalaia. Hummm super top!", R.drawable.dish3));
        dishes.add(new Dish("Exploded Pancake", "Em seu retiro espiritual, mais conhecido como casa, o Chef visualizou este lindo prato. PS: O filho dele jogou a panqueca no prato e o molho explodiu...", R.drawable.dish4));
        dishes.add(new Dish("Red Fruits Pie", "Come, só come, nem pensa muito não, só não olha o preço, porque é caro.", R.drawable.dish5));
        dishes.add(new Dish("Gelado`s", "A chapa não estava quente ainda, então pegamos tudo que tinha na geladeira, cortamos em tiras finas, como um sashimi e deixamos bonito com molho e ervas finas. Ótimo para dias quentes...", R.drawable.dish6));
        dishes.add(new Dish("Combo da Hora", "Eu tenho fome, você também? Então pede que eu agarantio.", R.drawable.dish7));
        dishes.add(new Dish("Bolo no Pote", "Ah o bolo no pote, sim ele mesmo. Só está no pote porque fica difícil de pegar o último pedaço somente com a colher, no pote podemos usar as paredes para encher a colher sem problemas!", R.drawable.dish8));
        dishes.add(new Dish("Misto com zoiudo", "Nada demais, só um misto com ovo em cima.", R.drawable.dish9));
        dishes.add(new Dish("Cordeiro Viking", "Deu fome na hora que eu peguei esta foto viu, me imaginei comendo com a mão e lambuznado inteiro. Partiu saquear depois deste rango?", R.drawable.dish10));
        return dishes;
    }

    @Override
    public void onClick(Restaurant restaurant) {
        Intent intent = new Intent(this, RestaurantDetailActivity.class);
        intent.putExtra("RESTAURANT", restaurant);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.upper_right_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
