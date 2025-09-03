package com.example.aula5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfigActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    SharedPreferences.Editor sharedPreferencesEditor;

    EditText editTextNome;
    RadioButton radioButtonMasculino;
    RadioButton radioButtonFeminino;
    Button button_aplicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
        String nome_recuperado = sharedPreferences.getString("name_key", "João Ninguém");
        editTextNome = (EditText) findViewById(R.id.editTextText);
        editTextNome.setText(nome_recuperado);
        int sexo = sharedPreferences.getInt("sex_key", 0);
        radioButtonMasculino=(RadioButton)  findViewById(R.id.radioButton);
        radioButtonFeminino=(RadioButton) findViewById(R.id.radioButton2);
        if (sexo == 0)
            radioButtonMasculino.setChecked(true);
        else
            radioButtonFeminino.setChecked(true);
        button_aplicar = findViewById(R.id.button_apply);
    }


    public void onClick(View view) {
        String nome = editTextNome.getText().toString();
        sharedPreferencesEditor.putString("nome", nome);
        int sexo;
        if (radioButtonMasculino.isChecked())
            sexo = 0;
        else
            sexo = 1;
        sharedPreferencesEditor.putInt("sex_key", sexo);
        sharedPreferencesEditor.commit();
        finish();
    }
}