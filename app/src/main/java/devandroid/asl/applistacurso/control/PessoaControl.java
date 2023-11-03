package devandroid.asl.applistacurso.control;

import android.content.Context;
import android.widget.Toast;

import devandroid.asl.applistacurso.model.Pessoa;
import devandroid.asl.applistacurso.view.MainActivity;

public class PessoaControl {

     public void salvar(Pessoa pessoa, Context mContext) {
         Toast.makeText(mContext, "control salvar" + pessoa.getPrimeiroNome().toString(), Toast.LENGTH_LONG).show();
    }
}
