package devandroid.asl.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.asl.applistacurso.R;
import devandroid.asl.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    EditText Txt_Nome;
    Button btnSalvar;
    Button btnLimpar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        Txt_Nome = findViewById(R.id.txt_nome);
        Txt_Nome.setText(pessoa.getPrimeiroNome());
        btnSalvar = findViewById(R.id.btn_salvar);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(Txt_Nome.getText().toString());
                Toast.makeText(MainActivity.this, "salvar" + pessoa.getPrimeiroNome().toString(), Toast.LENGTH_LONG).show();

            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Txt_Nome.setText("");
            }
        });

    }
}