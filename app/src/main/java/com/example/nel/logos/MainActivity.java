package com.example.nel.logos;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final int WORD_LOADER_ID = 0;
    public static final String QUERY_KEY = "query";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, dl, tb, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView nv = (NavigationView) findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(this);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            Bundle bundle = new Bundle();
            bundle.putString(QUERY_KEY, query);

            LogosLoaderCallbacks lcb = new LogosLoaderCallbacks(this);
            getLoaderManager().restartLoader(WORD_LOADER_ID, bundle, lcb);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);

        MenuItem mi = menu.findItem(R.id.search);
        SearchView sv = (SearchView) MenuItemCompat.getActionView(mi);
        SearchManager sm = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        sv.setSearchableInfo(sm.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){
        case R.id.settings:
            Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
            break;
        case R.id.dictionaries:
            Toast.makeText(MainActivity.this, "Dictionaries", Toast.LENGTH_SHORT).show();
            break;
        case R.id.feedback:
            Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
            break;
        }

        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        dl.closeDrawer(GravityCompat.START);

        return true;
    }
}
