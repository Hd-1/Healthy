package connectionController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthy.R;
import com.google.firebase.auth.FirebaseAuth;

import bottomMenuController.Home;
import content.DishesContent;
import content.TrainingContent;


public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        DishesContent.removeAllDishes();
        TrainingContent.removeAllTrainings();

        new DishesContent(getApplicationContext());
        DishesContent.addDishes();

        new TrainingContent(getApplicationContext());
        TrainingContent.addTrainings();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Home.class));
            getSupportActionBar().hide();
        }
    }

    public void logIn(View v){
        startActivity(new Intent(getApplicationContext(),Login.class));
    }

    public void signIn(View v){
        startActivity(new Intent(getApplicationContext(),Register.class));
    }

}
