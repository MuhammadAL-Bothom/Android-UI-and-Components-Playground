package com.example.traning4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.traning4.disign.GridviewAdapter; // Ensure this import statement is correct
import com.example.traning4.modle.ArrayListModel;
import com.example.traning4.modle.Models;

public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.maine), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView gridView = findViewById(R.id.my_grid_view);

        // Initialize GridviewAdapter with context and data
        GridviewAdapter gridviewAdapter = new GridviewAdapter(GridViewActivity.this, new ArrayListModel().setListData());
        gridView.setAdapter(gridviewAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle != null && actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        if (id == R.id.Profilepage) {
            Intent intent = new Intent(GridViewActivity.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.Settingpage) {
            Intent intent = new Intent(GridViewActivity.this, SettingActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.Button1) {
            Intent intent = new Intent(GridViewActivity.this, Button1.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.Button2) {
            Intent intent = new Intent(GridViewActivity.this, Button2.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.GridView) {
            Intent intent = new Intent(GridViewActivity.this, GridViewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.List) {
            Intent intent = new Intent(GridViewActivity.this, List.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        Models model = (Models) parent.getItemAtPosition(position);
        Toast.makeText(GridViewActivity.this, model.getName(), Toast.LENGTH_SHORT).show();
    }
}
