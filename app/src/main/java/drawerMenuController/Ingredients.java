package drawerMenuController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.healthy.R;
import com.google.firebase.auth.FirebaseAuth;

import bottomMenuController.Home;
import connectionController.First;

public class Ingredients extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawerLayout);
    }

    public void clickMenuDrawer(View v){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void navDrawerClickLogo(View v){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity a, Class c) {
        Intent intent = new Intent(a,c);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        a.startActivity(intent);
    }

    public void navDrawerClickHome(View v){redirectActivity(this, Home.class);}

    public void navDrawerClickProfile(View v){
        redirectActivity(this, Profile.class);
    }

    public void navDrawerClickStatistics(View v){
        redirectActivity(this, Statistics.class);
    }

    public void navDrawerClickFridge(View v){
        redirectActivity(this, Fridge.class);
    }

    public void navDrawerClickFavorite(View v){
        redirectActivity(this, Favorite.class);
    }

    public void navDrawerClickSettings(View v){
        redirectActivity(this, Settings.class);
    }

    public void navDrawerClickSchedule(View v){
        redirectActivity(this, Schedule.class);
    }

    public void navDrawerClickIngredients(View v){
        redirectActivity(this, Ingredients.class);
    }

    public void navDrawerClickMyGym(View v){
        redirectActivity(this, MyGym.class);
    }

    public void navDrawerClickEquipments(View v){
        redirectActivity(this, Equipments.class);
    }
    public void navDrawerClickLogOut(View v){
        logout(this);
    }

    private void logout(Activity a) {
        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), First.class));
                Toast.makeText(Ingredients.this, "Sign Out Successful", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}