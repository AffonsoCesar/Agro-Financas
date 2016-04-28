package com.example.affonso.agrofinancas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Affonso on 27/03/2016.
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTexto;
    private EditText mGasto;
    private EditText mGanho;

    private Button btnGasto;
    private Button btnGanho;
    private Toolbar toolbar;

    private AgroFinancasApplication application;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Agro Finanças");


        application = (AgroFinancasApplication) getApplicationContext();

        mGasto = (EditText) findViewById(R.id.valorGasto);
        mGanho = (EditText) findViewById(R.id.valorGanho);
        mTexto = (TextView)findViewById(R.id.texto);

        Bundle b = getIntent().getExtras();
        String texto = b.getString("Usuario");
        mTexto.setText("Olá " + texto + " seja bem vindo(a)!");

        btnGasto = (Button) findViewById(R.id.buttonAddGasto);
        btnGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempValor(1);
            }
        });

        btnGanho = (Button) findViewById(R.id.buttonAddGanhos);
        btnGanho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempValor(2);
            }
        });

        Button button = (Button) findViewById(R.id.botao2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Total")
                        .setMessage(messagem())
                        .setPositiveButton("OK PARA DETALHES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this, ControleActivity.class);
                                startActivity(intent);
                            }
                        })
                        .create().show();
            }
        });
    }

    private String messagem(){
        String s = "";
        if (application.calcularTotal() > 0) {
            String l = "O Seu Lucro foi R$ " + application.calcularTotal()+"0";
            s = l;
        }
        else {
            String p = "O Seu Prejuízo foi R$ " + application.calcularTotal()+"0";
            s = p;
        }
        return s;
    }

    private void attempValor(int valor){

        mGasto.setError(null);
        mGanho.setError(null);

        boolean cancel = false;
        View focusView = null;

        if(valor == 1){

            String v = mGasto.getText().toString();

            if(TextUtils.isEmpty(v)){
                mGasto.setError("Campo vazio");
                focusView = mGasto;
                cancel = true;
            }

            if(cancel){
                focusView.requestFocus();
            }else{
                application.addGasto(v);
                Toast.makeText(this, "Valor de Gasto de R$ "+mGasto.getText()+" foi adicionado!", Toast.LENGTH_LONG).show();
                mGasto.setText("");
            }

        }
        else{
            String v = mGanho.getText().toString();

            if (TextUtils.isEmpty(v)) {
                mGanho.setError("Campo vazio");
                focusView = mGanho;
                cancel = true;
            }
            if (cancel) {
                focusView.requestFocus();
            }else{
                application.addGanho(v);
                Toast.makeText(this, "Valor de Ganho de R$ "+mGanho.getText()+" foi adicionado!", Toast.LENGTH_LONG).show();
                mGanho.setText("");
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Criação do Menu
        getMenuInflater().inflate(R.menu.menu_main, menu); //Infalndo o Menu
        return super.onCreateOptionsMenu(menu); //Retorno do Menu
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Funcionalidade do clique no item do menu

        int id = item.getItemId();
        if(id == R.id.action_sobre){ //condição do clique do menu
            Toast.makeText(this, "Projeto Final do Ayty - Agro Finanças", Toast.LENGTH_LONG).show(); //Mensagem que aparece ao clicar sobre o menu "SOBRE"
        }

        return super.onOptionsItemSelected(item);
    }

    public void sair (View view) {
        Intent myIntent = new Intent(this, MainActivity2.class);
        startActivity(myIntent);
        finish();
    }
}

