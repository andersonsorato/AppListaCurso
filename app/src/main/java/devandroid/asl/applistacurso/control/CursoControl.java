package devandroid.asl.applistacurso.control;

import java.util.ArrayList;
import java.util.List;

import devandroid.asl.applistacurso.model.curso;

public class CursoControl {
private List ListCursos;
    public List getListaCurso(){
        ListCursos = new ArrayList<curso>();
        ListCursos.add(new curso("Java"));
        ListCursos.add(new curso("PHP"));
        ListCursos.add(new curso("Linux"));
        ListCursos.add(new curso("Android"));
        ListCursos.add(new curso("Pascal"));
        ListCursos.add(new curso("Abap"));
        ListCursos.add(new curso("Go"));

        return ListCursos;

    }
    public ArrayList<String> dadosParaSpinner(){
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaCurso().size(); i++){
            curso objeto = (curso) getListaCurso().get(i);
           dados.add(objeto.getNomeDoCursoDesejado());
        }
        return dados;
    }
}
