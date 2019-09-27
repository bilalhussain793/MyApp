package com.example.myapp;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView, recyclerView2;
    RecyclerView.Adapter adapter,adapter2;
    ArrayList<String> items,items2;
    ViewFlipper v_flipper;
    DrawerLayout drawer;
    NavigationView navigation;
    Toolbar toolbar;
    Button latest, all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        int images[]={R.drawable.slide, R.drawable.slide};
        v_flipper= (ViewFlipper) findViewById(R.id.v_flipper);
        for (int image:images){
            flipperImages(image);
        }
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        //Recycler view coding below
        items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");

        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
        adapter= new Adapter(this,items);
        recyclerView.setAdapter(adapter);
        //second recycler view

        recyclerView2= (RecyclerView) findViewById(R.id.recyclerview2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
        adapter2= new Adapter2(this,items);
        recyclerView2.setAdapter(adapter2);
        // buttons for both categories
        latest= (Button) findViewById(R.id.latest_button);
        all= (Button) findViewById(R.id.all_button);
        latest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it;
                it=  new Intent(MainActivity.this, latest_videos.class);
                startActivity(it);
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it;
                it=  new Intent(MainActivity.this, All_category.class);
                startActivity(it);
            }
        }); }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Are your sure you want to Exit?");
        //builder.setCancelable(false);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_category:
                Intent a= new Intent(MainActivity.this, category.class);
                startActivity(a);
                break;
            case R.id.nav_home:
                Intent b= new Intent(MainActivity.this, MainActivity.class);
                startActivity(b);
                break;
            case R.id.nav_latest:
                Intent c= new Intent(MainActivity.this, latest_videos.class);
                startActivity(c);
                break;
            case R.id.nav_favourite:
                Intent d= new Intent(MainActivity.this, myFavourite.class);
                startActivity(d);
                break;
            case R.id.nav_about:
                Intent f= new Intent(MainActivity.this, aboutUs.class);
                startActivity(f);
                break;
            case R.id.nav_share_app:
                Intent g= new Intent(Intent.ACTION_SEND);
                g.setType("Enter first text");
                String shareBody="your body here";
                String sharesub="your sub here";
                g.putExtra(Intent.EXTRA_SUBJECT, sharesub);
                g.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(g,"Share Using"));
                break;
            case R.id.privacyPolicy:
                Intent h= new Intent(MainActivity.this, privacy_policy.class);
                startActivity(h);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void flipperImages(int image){
        ImageView imageview=  new ImageView(this);
        imageview.setBackgroundResource(image);
        v_flipper.addView(imageview);
        v_flipper.setFlipInterval(5000);
        v_flipper.setAutoStart(true);
        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setOutAnimation(this, android.R.anim.slide_in_left);
    }
}
