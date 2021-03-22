package com.cj.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculadoraIMC extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInformacion;
    private TextView tvResultado;
    private EditText txtPeso;
    private EditText txtAltura;
    private Button btnCalcular;
    private ImageView imgEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_i_m_c);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nameValue");
        String apellidos = intent.getStringExtra("surnameValue");
        String message = "Hola " + nombre + " " + apellidos + " Bienvenido";

        tvInformacion = findViewById(R.id.tvInformacion);
        tvResultado = findViewById(R.id.tvResultado);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        imgEstado = findViewById(R.id.imgEstado);

        btnCalcular.setOnClickListener(this);

        tvInformacion.setText(message);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {

        }
    }
}