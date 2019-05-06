package com.bol.cbdstatstracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/*This class is the main activity that handles the majority of the fragments and navigation drawer*/
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    /*Overrides default onCreate of super class creates new instance of main activity */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //checking for saved instance of app and setting main content
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creates nave menu and toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //default to contact information if no saved instance
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ContactFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_contact);
        }
    }
    /*Overrides onNavigationItemSelected of super class switch triggered when menu item selected.
     * chooses correct fragment or activity for display.
     *  */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_bp:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BPFragment()).commit();
                break;
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
            case R.id.nav_dosage:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DosageFragment()).commit();
                break;
            case R.id.nav_mood:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MoodFragment()).commit();
                break;
            case R.id.nav_product:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProductFragment()).commit();
                break;
            case R.id.nav_symptoms:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SymptomsFragment()).commit();
                break;

            case R.id.nav_usage:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UsageFragment()).commit();
                break;
            case R.id.nav_cal:
                Intent calIntent = new Intent(this, CalenderActivity.class);
                startActivity(calIntent);
                break;
        }
        //closes drawer after selection
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*Overrides onBackPressed of super class. will close navigation drawer if open.
    * defaults to super, which closes app. need to add stack to go to previous fragment
    * or activity.
    * */
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
