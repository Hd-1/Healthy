package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthy.R;
import com.google.firebase.auth.FirebaseAuth;


public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseAuth fAuth;
        Button logInBtn,signInBtn ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

    }

    public void logIn(View v){
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void signIn(View v){
        startActivity(new Intent(getApplicationContext(),Register.class));
        finish();
    }

}
