package com.example.traning4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class SettingActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "LanguagePrefs";
    private static final String LANGUAGE_KEY = "Language";
    private static final String DEFAULT_OLD_PASSWORD = "1234";
    private String currentPassword = DEFAULT_OLD_PASSWORD; // Stores the current password
    private EditText oldPasswordInput;
    private EditText newPasswordInput;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private RadioGroup languageRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sitting);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        oldPasswordInput = findViewById(R.id.editTextTextPassword);
        newPasswordInput = findViewById(R.id.editTextTextPassword2);
        Button saveButton = findViewById(R.id.saveButton);
        Button languageConfirmButton = findViewById(R.id.languageConfirmButton);
        languageRadioGroup = findViewById(R.id.radioGroup);

        // Load saved language preference
        loadLanguagePreference();

        // Set click listener for the save button
        saveButton.setOnClickListener(v -> updatePassword());

        // Set language change listener
        languageConfirmButton.setOnClickListener(v -> {
            int selectedId = languageRadioGroup.getCheckedRadioButtonId();
            if (selectedId == R.id.radioButton) { // AR
                setLocale("ar");
            } else if (selectedId == R.id.radioButton2) { // EN
                setLocale("en");
            }
            // Optionally, you can show a toast or some feedback to the user
            Toast.makeText(this, getString(R.string.language_changed), Toast.LENGTH_SHORT).show();
            // After changing the locale, you should update the UI
            updateUI();
        });
    }

    private void loadLanguagePreference() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String language = prefs.getString(LANGUAGE_KEY, "en");
        setLocale(language);

        if (language.equals("ar")) {
            languageRadioGroup.check(R.id.radioButton);
        } else {
            languageRadioGroup.check(R.id.radioButton2);
        }
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        config.setLayoutDirection(locale);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        resources.updateConfiguration(config, displayMetrics);

        // Save the language preference
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(LANGUAGE_KEY, lang);
        editor.apply();
    }

    private void updateUI() {
        // Update text views and other UI elements here
        ((TextView) findViewById(R.id.textView5)).setText(getString(R.string.setting_title));
        ((TextView) findViewById(R.id.textView6)).setText(getString(R.string.change_password));
        ((EditText) findViewById(R.id.editTextTextPassword)).setHint(getString(R.string.old_password_hint));
        ((EditText) findViewById(R.id.editTextTextPassword2)).setHint(getString(R.string.new_password_hint));
        ((Button) findViewById(R.id.saveButton)).setText(getString(R.string.save_button));
        ((Button) findViewById(R.id.languageConfirmButton)).setText(getString(R.string.language_changed));
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
            Intent intent = new Intent(SettingActivity.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.Settingpage) {
            Intent intent = new Intent(SettingActivity.this, SettingActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.Button1) {
            Intent intent = new Intent(SettingActivity.this, Button1.class);

            startActivity(intent);
            return true;
        }
        else if (id == R.id.Button2) {
            Intent intent = new Intent(SettingActivity.this, Button2.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.GridView) {
            Intent intent = new Intent(SettingActivity.this, GridViewActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.List) {
            Intent intent = new Intent(SettingActivity.this, List.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    private void updatePassword() {
        String enteredOldPassword = oldPasswordInput.getText().toString();
        String enteredNewPassword = newPasswordInput.getText().toString();

        if (enteredOldPassword.equals(currentPassword)) {
            if (!enteredNewPassword.isEmpty()) {
                currentPassword = enteredNewPassword; // Update the password
                oldPasswordInput.setText(""); // Clear the input fields
                newPasswordInput.setText("");
                Toast.makeText(this, getString(R.string.password_updated_successfully), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.new_password_empty), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.incorrect_old_password), Toast.LENGTH_SHORT).show();
        }
    }
}
