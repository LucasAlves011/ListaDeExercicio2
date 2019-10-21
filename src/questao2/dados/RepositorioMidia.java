package questao2.dados;

import questao2.anegocio.beans.Categorias;
import questao2.anegocio.beans.Midia;

import java.util.ArrayList;
import java.util.List;

public class RepositorioMidia {

    private List<Midia> arrayLista;

    public RepositorioMidia(){
        arrayLista = new ArrayList<>();
    }

    public void cadastrar(Midia u){
        arrayLista.add(u);
    }

    public void remover(Midia u){
        arrayLista.remove(u);
    }

    public ArrayList<Midia> listarMidiaPorIdade(int num){
        ArrayList<Midia> request = new ArrayList();
        for (Midia iterador:arrayLista) {
            if (iterador.getFaixaEtaria() > num || iterador.getFaixaEtaria() < 0 ) {
                request.add(iterador);
            }
        }
        return request;
    }

    public ArrayList<Midia> listarPorCategoria(Categorias x){
        ArrayList<Midia> request = new ArrayList();
        for (Midia iterador:arrayLista) {
            if (iterador.getCategoria().getDesc() == x.getDesc()) request.add(iterador);
        }
        return request;
    }

    public boolean buscarPorArquivo(Midia x){
        boolean request = false;
        for (Midia iterador:arrayLista) {
            if (iterador.equals(x)){
                request = true;
                break;
            }
        }
        return request;
    }
    public List<Midia> listarTodas(){
        return arrayLista;
    }
}
