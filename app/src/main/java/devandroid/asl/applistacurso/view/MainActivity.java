package devandroid.asl.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devandroid.asl.applistacurso.R;
import devandroid.asl.applistacurso.control.CursoControl;
import devandroid.asl.applistacurso.control.PessoaControl;
import devandroid.asl.applistacurso.model.Pessoa;
import devandroid.asl.applistacurso.model.curso;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    EditText Txt_Nome;
    Button btnSalvar;
    Button btnLimpar;
    PessoaControl control;
    SharedPreferences preferences;
    Spinner spinner;

    List<String> nomesDosCursos;
    public static final String NOME_PREFERENCES = "pref_lis";
    private devandroid.asl.applistacurso.control.CursoControl CursoControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();
        pessoa = new Pessoa();
        control = new PessoaControl();
        CursoControl = new CursoControl();
        nomesDosCursos = CursoControl.dadosParaSpinner();
        spinner = findViewById(R.id.spinner);
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        Txt_Nome = findViewById(R.id.txt_nome);
        Txt_Nome.setText(pessoa.getPrimeiroNome());
        btnSalvar = findViewById(R.id.btn_salvar);
        btnLimpar = findViewById(R.id.btn_limpar);

// adapter
        //layout
        //injetar adapteer ao spinner

        ArrayAdapter<String> adapter   = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                CursoControl.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(Txt_Nome.getText().toString());
                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.apply();
                control.salvar(pessoa, MainActivity.this);
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Txt_Nome.setText("");
                Toast.makeText(MainActivity.this, "salvar" + pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}