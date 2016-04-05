package com.example.affonso.agrofinancas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private Button mCalcular;
    private TextView mResultado;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGasto = (EditText)findViewById(R.id.valorGasto);
        mGanho = (EditText)findViewById(R.id.valorGanho);
        mResultado = (TextView)findViewById(R.id.resultado);
        mTexto = (TextView)findViewById(R.id.texto);
        mCalcular = (Button)findViewById(R.id.botao2);

        Bundle b = getIntent().getExtras();
        String texto = b.getString("Usuario");
        mTexto.setText("Olá " + texto + " seja bem vindo!");

        mCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calcular();
                } catch (NumberFormatException ne) {
                    Toast.makeText(v.getContext(), "Valor Inválido Digitado, Tente Novamente!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void calcular() {

            double numGasto = Double.parseDouble(mGasto.getText().toString());
            double numGanho = Double.parseDouble(mGanho.getText().toString());

            double res = numGanho - numGasto;
            if (res > 0) {

                mResultado = (TextView) findViewById(R.id.resultado);
                mResultado.setText("O seu Lucro foi de: R$" + String.valueOf(res) + "0");
            } else if (res < 0) {
                mResultado = (TextView) findViewById(R.id.resultado);
                mResultado.setText("O seu Prejuízo foi de: R$" + String.valueOf(res) + "0");
            }
    }
}

