package com.cj.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalculadoraIMC extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInformacion;
    private TextView tvResultado;
    private EditText txtPeso;
    private EditText txtAltura;
    private Button btnCalcular;
    private ImageView imgEstado;
    private Double peso;
    private Double altura;
    private Double resultado;

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
            peso = Double.parseDouble(txtPeso.getText().toString());
            altura = Double.parseDouble(txtAltura.getText().toString());
            String res = calcularIMC(peso, altura);
            tvResultado.setText(res);
        }
    }

    private String calcularIMC(Double peso, Double altura) {
        DecimalFormat formato = new DecimalFormat();
        formato.setMaximumFractionDigits(1);
        Double alturaMts;
        alturaMts= altura / 100;
        resultado = peso / Math.pow(alturaMts, 2);
        cambiarImagen(resultado);
        return formato.format(resultado);
    }

    private void cambiarImagen(Double res){
        if (res < 18.5){
            imgEstado.setImageResource(R.drawable.bajo_peso);
        }
        else if (res >= 18.5 && res <= 24.9) {
            imgEstado.setImageResource(R.drawable.peso_normal);
        }
        else if (res >= 25.0 && res <= 29.9) {
            imgEstado.setImageResource(R.drawable.sobrepeso);
        }
        else if (res >= 30.0 && res <= 34.9) {
            imgEstado.setImageResource(R.drawable.obesidad);
        }
        else {
            imgEstado.setImageResource(R.drawable.obesidad_extrema);
        }
    }
}