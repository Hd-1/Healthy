package bottomMenuController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.healthy.R;
import com.example.healthy.dishes;
import com.example.healthy.training;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import connectionController.Login;
import drawerMenuController.Favorite;
import drawerMenuController.Fridge;
import drawerMenuController.Profile;
import drawerMenuController.Settings;
import drawerMenuController.Statistics;

public class Start extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter adapter;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Tab Layout
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new MainAdapter(getSupportFragmentManager());
        adapter.AddFragment(new training(),"training");
        adapter.AddFragment(new dishes(), "dishes");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //Drawer Layout
        drawerLayout = findViewById(R.id.drawerLayout);

        //Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.startPage);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.notificationsPage:
                        startActivity(new Intent(getApplicationContext(), Notifications.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homePage:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.startPage:
                        return true;
                }
                return false;
            }
        });
    }

    //Drawer Layout
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
                startActivity(new Intent(getApplicationContext(), Login.class));
                Toast.makeText(Start.this, "Sign Out Successful", Toast.LENGTH_SHORT).show();
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