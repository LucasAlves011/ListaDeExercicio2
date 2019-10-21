package questao2.dados;

import questao2.anegocio.beans.Usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario {

    private List<Usuario> array;

    public RepositorioUsuario(){
        array = new ArrayList<Usuario>();
    }

    public void adicionar(Usuario novo){
       if (!buscarEmail(novo)) array.add(novo);
    }

    public void remover(Usuario x){
        array.remove(x);
    }

    public boolean buscar(Usuario x){
        boolean request = false;

        for (Usuario iterador:array ) {
            if (iterador.equals(x)){
                request = true;
                break;
            }
        }
        return request;
    }

    public List<Usuario> listarPorIdade(int ano){
        List<Usuario> solicitado = new ArrayList<>();

        for (Usuario iterador:array)
            if (iterador.getDataNascimento().until(LocalDate.now(), ChronoUnit.YEARS) > ano ) solicitado.add(iterador);

        return solicitado;
    }

    public List<Usuario> listarPorTipo(Class k){
        List<Usuario> solicitado = new ArrayList<>();

        for (Usuario iterador: array) {
            if (iterador.getClass() == k ){
                solicitado.add(iterador);
            }
        }
        return solicitado;
    }

    //CLASSE DE TESTE ,DEVE SER APAGA POSTERIORMENTE
    public List<Usuario> listarTodoMundo(){
        return array;
    }

    public boolean buscarEmail(Usuario x){
        boolean request = false;
        for (Usuario iterador:array) {
            if (iterador.getEmail() == x.getEmail()){
                request = true;
                break;
            }
        }
        return request;
    }
}
