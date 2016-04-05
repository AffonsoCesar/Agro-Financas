package com.example.affonso.agrofinancas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Affonso on 28/03/2016.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText mUsuarioLog;
    private EditText mSenhaLog;
    private Button button;
    private Button nButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mUsuarioLog = (EditText) findViewById(R.id.usuarioLog);
        mSenhaLog = (EditText) findViewById(R.id.senhaLog);
        button = (Button) findViewById(R.id.botaoLog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
    }

    private void logar() {

        String usuario = mUsuarioLog.getText().toString();
        String senha = mSenhaLog.getText().toString();

        View focus = null;
        if (TextUtils.isEmpty(usuario)) {
            mUsuarioLog.setError("Campo Vazio");
            focus = mUsuarioLog;
            focus.requestFocus();
        }
        if (TextUtils.isEmpty(senha)) {
            mSenhaLog.setError("Campo Vazio");
            focus = mSenhaLog;
            focus.requestFocus();
        } else if (usuario.equalsIgnoreCase(mUsuarioLog.getText().toString()) && senha.equalsIgnoreCase("123456")) {
            Intent i = new Intent(this, MainActivity.class);
            Bundle b = new Bundle();
            b.putString("Usuario", usuario);
            i.putExtras(b);
            startActivity(i);
            Toast.makeText(this, "Usuário "+usuario+" Logado com Sucesso!", Toast.LENGTH_LONG).show();
            finish();
        } else if (senha != ("123456")) {
            mSenhaLog.setError("Senha Inválida!");
            focus = mSenhaLog;
            focus.requestFocus();
        } else {
            mUsuarioLog.setError("Usuário ou Senha Inválidos!");
            focus = mUsuarioLog;
            focus.requestFocus();
        }
    }
}