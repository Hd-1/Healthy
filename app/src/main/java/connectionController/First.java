package connectionController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthy.R;
import com.google.firebase.auth.FirebaseAuth;

import bottomMenuController.Home;


public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Home.class));
        }
    }

    public void logIn(View v){
        startActivity(new Intent(getApplicationContext(),Login.class));
    }

    public void signIn(View v){
        startActivity(new Intent(getApplicationContext(),Register.class));
    }

}
