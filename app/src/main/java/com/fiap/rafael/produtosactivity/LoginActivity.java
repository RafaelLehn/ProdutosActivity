package com.fiap.rafael.produtosactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText nome = (EditText) findViewById(R.id.etNome);
        final TextView login = (TextView) findViewById(R.id.tvLogin);

        final Button salvar = (Button) findViewById(R.id.btsalvar);

        atualizarConectado();

        salvar.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){

                SharedPreferences pref = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();
                ed.putString("nome", nome.getText().toString());
                ed.apply();
                Toast.makeText(getBaseContext(), "salvo com sucesso", Toast.LENGTH_SHORT).show();

                login.setText(pref.getString("nome", "não encontrado"));


            }


        });
    }

    private void atualizarConectado() {
        SharedPreferences shared = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        String login = shared.getString("preferencias", "");

    }


    private void iniciarApp() {
        startActivity(new Intent(this, ProdutosActivity.class));
        finish();
    }


}
