package com.cj.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnviar;
    private EditText txtNombre;
    private EditText txtApellidos;
    private EditText txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviar = findViewById(R.id.btnEnviar);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtEmail = findViewById(R.id.txtEmail);
        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEnviar) {
            String name = txtNombre.getText().toString();
            String surname = txtApellidos.getText().toString();
            String email = txtEmail.getText().toString();
            if (name.isEmpty()) {
                CustomToastView.makeErrorToast(this, "Error al validar el nombre", R.layout.custom_toast).show();
                return;
            }
            if (surname.isEmpty()) {
                CustomToastView.makeInfoToast(this, "Error al validar el apellido", R.layout.custom_toast).show();
                return;
            }
            if (!isValidEmail(email)) {
                CustomToastView.makeWarningToast(this, "Error al validar el email", R.layout.custom_toast).show();
                return;
            }
            Intent myIntent = new Intent(this, CalculadoraIMC.class);
            myIntent.putExtra("nameValue", name);
            myIntent.putExtra("surnameValue", surname);
            startActivity(myIntent);
        }
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}