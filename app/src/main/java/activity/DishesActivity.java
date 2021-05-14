package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.healthy.R;

import java.util.Objects;

public class DishesActivity extends AppCompatActivity {

    TextView mDishesTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

        mDishesTitle = findViewById(R.id.dishesTitle);

        String dishesTitle = "Title not found";

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            dishesTitle = extras.getString("dishesTitle");
        }
        mDishesTitle.setText(dishesTitle);
        Objects.requireNonNull(getSupportActionBar()).setTitle(dishesTitle);
    }
}