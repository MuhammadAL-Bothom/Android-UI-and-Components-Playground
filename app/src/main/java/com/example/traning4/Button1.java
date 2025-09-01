package com.example.traning4;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class Button1 extends AppCompatActivity {
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private boolean switchOn = false, btnlike = false,btnFav = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button rotateButton = findViewById(R.id.animated_button);
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(rotateButton, "rotation", 0f, 360f);
        rotationAnimator.setDuration(1000); // 1 second
        rotationAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateButton.setOnClickListener(v -> rotationAnimator.start());


        LottieAnimationView lottieButton = findViewById(R.id.lottieButton);

        lottieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchOn) {
                    lottieButton.setMinAndMaxProgress(0.5f, 1.0f);
                    lottieButton.playAnimation();
                    switchOn = false;
                } else {
                    lottieButton.setMinAndMaxProgress(0.0f, 0.5f);
                    lottieButton.playAnimation();
                    switchOn = true;
                }
            }
        });
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
            Intent intent = new Intent(Button1.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.Settingpage) {
            Intent intent = new Intent(Button1.this, SettingActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.Button1) {
            Intent intent = new Intent(Button1.this, Button1.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.Button2) {
            Intent intent = new Intent(Button1.this, Button2.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.GridView) {
            Intent intent = new Intent(Button1.this, GridViewActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.List) {
            Intent intent = new Intent(Button1.this, List.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
