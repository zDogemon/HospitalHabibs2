package com.example.hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Adicionar extends AppCompatActivity {

    EditText nome;
    EditText idade;
    EditText leucocitos;
    EditText glicemia;
    EditText ast_tgo;
    EditText ldh;
    CheckBox litiase;
    TextView pontuacao;
    TextView mortalidade;
    Button adicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        nome = findViewById(R.id.nome);
        idade = findViewById(R.id.idade);
        leucocitos = findViewById(R.id.leucocitos);
        glicemia = findViewById(R.id.glicemia);
        ast_tgo = findViewById(R.id.ast_tgo);
        ldh = findViewById(R.id.ldh);
        litiase = findViewById(R.id.litiase);
        pontuacao = findViewById(R.id.pontuacao);
        mortalidade = findViewById(R.id.mortalidade);
        adicionar = findViewById(R.id.adicionar);

        adicionar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double score = 0;
                double mort_p = 0;

                if (litiase.isChecked() == false){
                    if(Double.parseDouble(idade.getText().toString()) > 55){
                        score++;
                    }
                    if(Double.parseDouble(leucocitos.getText().toString()) > 16000){
                        score++;
                    }
                    if(Double.parseDouble(glicemia.getText().toString()) > 11){
                        score++;
                    }
                    if(Double.parseDouble(ast_tgo.getText().toString()) > 250){
                        score++;
                    }
                    if(Double.parseDouble(ldh.getText().toString()) > 350){
                        score++;
                    }
                } else if (litiase.isChecked() == true){
                    if(Double.parseDouble(idade.getText().toString()) > 70){
                        score++;
                    }
                    if(Double.parseDouble(leucocitos.getText().toString()) > 18000){
                        score++;
                    }
                    if(Double.parseDouble(glicemia.getText().toString()) > 12.2){
                        score++;
                    }
                    if(Double.parseDouble(ast_tgo.getText().toString()) > 250){
                        score++;
                    }
                    if(Double.parseDouble(ldh.getText().toString()) > 400){
                        score++;
                    }
                }

                if (score > 0 && score <= 2) {
                    mort_p = 2;
                } else if (score >= 3 && score <= 4) {
                    mort_p = 15;
                } else if (score >= 5 && score <= 6) {
                    mort_p = 40;
                } else if (score >= 7 && score <= 8) {
                    mort_p = 100;
                }

                pontuacao.setText(score + "");
                mortalidade.setText(mort_p + "%");

                DAL dal = new DAL(Adicionar.this);


                String nome_s = nome.getText().toString();
                Double idade_s = Double.parseDouble(idade.getText().toString());
                Double leucocitos_s = Double.parseDouble(leucocitos.getText().toString());
                Double glicemia_s = Double.parseDouble(glicemia.getText().toString());
                Double ast_tgo_s = Double.parseDouble(ast_tgo.getText().toString());
                Double ldh_s = Double.parseDouble(ldh.getText().toString());
                boolean litiase_s = Boolean.parseBoolean(litiase.getText().toString());
                Double pontuacao_s = score;
                Double mortalidade_s = mort_p;

                if (dal.insert(nome_s, idade_s, litiase_s, leucocitos_s, glicemia_s, ast_tgo_s, ldh_s, pontuacao_s, mortalidade_s)) {
                    Toast.makeText(Adicionar.this,
                            "Registro Inserido com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Adicionar.this,
                            "Erro ao inserir registro!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
