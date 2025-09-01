package com.example.traning4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class List extends AppCompatActivity {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    ExpandableListView expandableListView;
    ArrayList<String> listGroup=new ArrayList<>();
    HashMap<String,ArrayList<String>> listChild=new HashMap<>();
    MainAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        expandableListView = findViewById(R.id.exp_list_view);

        for (int i = 0; i < 5; i++) {
            listGroup.add("Group" + i);
            ArrayList<String> arrayList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                arrayList.add("item" + j);
            }
            listChild.put(listGroup.get(i), arrayList);
        }
    adapter = new MainAdapter(listGroup, listChild);
        expandableListView.setAdapter(adapter);

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
            Intent intent = new Intent(List.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.Settingpage) {
            Intent intent = new Intent(List.this, SettingActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.Button1) {
            Intent intent = new Intent(List.this, Button1.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.Button2) {
            Intent intent = new Intent(List.this, Button2.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.GridView) {
            Intent intent = new Intent(List.this, GridViewActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.List) {
            Intent intent = new Intent(List.this, List.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}