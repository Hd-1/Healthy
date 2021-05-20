package drawerMenuController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.healthy.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import activity.FavoriteTrainingActivity;
import activity.TrainingFromScheduleActivity;
import adapterRecyclerView.AdapterSchedule;
import bottomMenuController.Home;
import connectionController.First;
import content.ScheduleContent;

public class Schedule extends AppCompatActivity implements AdapterSchedule.onScheduleListener{

    DrawerLayout drawerLayout;
    RecyclerView scheduleList;
    AdapterSchedule adapter;
    ArrayList<data.Schedule> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getSupportActionBar().hide();

        list = ScheduleContent.getSchedule();

        drawerLayout = findViewById(R.id.drawerLayout);
        scheduleList = findViewById(R.id.scheduleList);

        scheduleList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterSchedule(list,this);
        scheduleList.setAdapter(adapter);

    }

    @Override
    public void onScheduleClick(int position) {
        list.get(position);
        Intent intent = new Intent(this, TrainingFromScheduleActivity.class);
        String date = list.get(position).getDay() + "\n" + list.get(position).getHours() + "h" + list.get(position).getMinutes();
        intent.putExtra("trainingDate",date);
        intent.putExtra("trainingTitle",list.get(position).getTitle());
        intent.putExtra("trainingDescription",list.get(position).getDescription());
        intent.putExtra("trainingWarning",list.get(position).getWarning());
        intent.putExtra("trainingChallenge",list.get(position).getChallenge());
        intent.putExtra("trainingSteps",list.get(position).getSteps());
        intent.putExtra("imageOne",list.get(position).getImage1());
        intent.putExtra("imageTwo",list.get(position).getImage2());
        intent.putExtra("imageThree",list.get(position).getImage3());
        startActivity(intent);
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
                Toast.makeText(Schedule.this, "Sign Out Successful", Toast.LENGTH_SHORT).show();
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