package com.example.affonso.agrofinancas;

/**
 * Created by Affonso on 27/03/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText mUsuario;
    private EditText mSenha;
    private EditText mConfSenha;
    private Button mBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mUsuario = (EditText)findViewById(R.id.usuario);
        mSenha = (EditText)findViewById(R.id.senha);
        mConfSenha = (EditText)findViewById(R.id.confSenha);
        mBotao = (Button)findViewById(R.id.botao);

        mBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
    }
    private void cadastrar() {

        String usuario = mUsuario.getText().toString();
        String senha = mSenha.getText().toString();
        String confmSenha = mConfSenha.getText().toString();

        View focus = null;
        if (TextUtils.isEmpty(usuario)) {
            mUsuario.setError("Campo Vazio");
            focus = mUsuario;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(senha)) {
            mSenha.setError("Campo Vazio");
            focus = mSenha;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(confmSenha)) {
            mConfSenha.setError("Campo Vazio");
            focus = mConfSenha;
            focus.requestFocus();
        } else if (senha.equalsIgnoreCase(mSenha.getText().toString()) && confmSenha.equalsIgnoreCase(mSenha.getText().toString())) {
            Intent i = new Intent(this, MainActivity.class);
            Bundle b = new Bundle();
            b.putString("Usuario", usuario);
            i.putExtras(b);
            startActivity(i);
            Toast.makeText(this, "Usuário "+usuario+" Cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
            finish();
        } else if (senha.equals(mSenha.getText().toString()) != confmSenha.equals(mSenha.getText().toString())) {
            mSenha.setError("Senhas Cadastradas Não São Iguais!");
            focus = mSenha;
            focus.requestFocus();
            mConfSenha.setError("Senhas Cadastradas Não São Iguais!");
            focus = mConfSenha;
            focus.requestFocus();
        } else {
            mUsuario.setError("Usuário ou Senha Inválidos!");
            focus = mUsuario;
            focus.requestFocus();
        }
    }

}
