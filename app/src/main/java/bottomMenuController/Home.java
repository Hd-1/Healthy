package bottomMenuController;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.healthy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import connectionController.First;
import connectionController.Login;
import content.DishesContent;
import content.TrainingContent;
import drawerMenuController.Equipments;
import drawerMenuController.Favorite;
import drawerMenuController.Fridge;
import drawerMenuController.Ingredients;
import drawerMenuController.MyGym;
import drawerMenuController.Profile;
import drawerMenuController.Schedule;
import drawerMenuController.Settings;
import drawerMenuController.Statistics;

public class Home extends AppCompatActivity {

    //Initialize variable
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        //Drawer Layout
        drawerLayout = findViewById(R.id.drawerLayout);

        //Bottom Navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.homePage);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.notificationsPage:
                        startActivity(new Intent(getApplicationContext(), Notifications.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homePage:
                        return true;
                    case R.id.startPage:
                        startActivity(new Intent(getApplicationContext(), Start.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    //Drawer Layout
    public void clickMenuDrawer(View v){ openDrawer(drawerLayout); }

    public static void openDrawer(DrawerLayout drawerLayout) { drawerLayout.openDrawer(GravityCompat.START); }

    public void navDrawerClickLogo(View v){closeDrawer(drawerLayout); }

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

    public void navDrawerClickProfile(View v){redirectActivity(this, Profile.class); }

    public void navDrawerClickStatistics(View v){redirectActivity(this, Statistics.class); }

    public void navDrawerClickFridge(View v){ redirectActivity(this, Fridge.class); }

    public void navDrawerClickFavorite(View v){ redirectActivity(this, Favorite.class); }

    public void navDrawerClickSettings(View v){ redirectActivity(this, Settings.class); }

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

    public void navDrawerClickLogOut(View v){logout(this); }

    private void logout(Activity a) {
        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), First.class));
                Toast.makeText(Home.this, "Sign Out Successful", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

}