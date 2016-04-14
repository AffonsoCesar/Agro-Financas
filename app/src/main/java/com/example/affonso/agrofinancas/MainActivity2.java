package com.example.affonso.agrofinancas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Affonso on 28/03/2016.
 */
public class MainActivity2 extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Opções do Usuário");


        ((Button) findViewById(R.id.button1)).setOnClickListener(new Fazer("FAZER", "CADASTRAR"));
        ((Button) findViewById(R.id.button2)).setOnClickListener(new Fazer("FAZER", "LOGIN"));
    }

    private class Fazer implements View.OnClickListener {
        private String action;
        private String category;

        Fazer(String action, String category) {
            this.action = action;
            this.category = category;
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(this.action);
            if (this.category != null)
                i.addCategory(this.category);
            startActivity(i);
            finish();
        }
    }
}
