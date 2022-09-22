package com.example.financeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_dados;
    Button bt_dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_dados = findViewById(R.id.tv_dados);
        bt_dados = findViewById(R.id.bt_dados);

        bt_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarefa tarefa = new Tarefa();
                tarefa.execute("https://api.hgbrasil.com/finance?array_limit=1&fields=only_results,taxes&key=9a70284e");
            }
        });
    }

    private class Tarefa extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            tv_dados.setText(s);
        }
    }
}