package drawerMenuController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.healthy.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import bottomMenuController.Home;
import bottomMenuController.Start;
import connectionController.First;
import fragment.DishesFragment;
import fragment.FavoriteDishesFragment;
import fragment.FavoriteTrainingFragment;
import fragment.TrainingFragment;

public class Favorite extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawerLayout);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new MainAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FavoriteTrainingFragment(),"training");
        adapter.AddFragment(new FavoriteDishesFragment(), "dishes");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

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
                Toast.makeText(Favorite.this, "Sign Out Successful", Toast.LENGTH_SHORT).show();
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

    private class MainAdapter extends FragmentPagerAdapter {
        //Initialize ArrayList
        ArrayList<Fragment> fragmentsArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        //Constructor
        public void AddFragment(Fragment f, String s){
            fragmentsArrayList.add(f);
            stringArrayList.add(s);
        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentsArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentsArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return  stringArrayList.get(position);
        }
    }
}