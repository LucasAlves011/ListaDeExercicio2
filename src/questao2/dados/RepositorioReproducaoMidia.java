package questao2.dados;

import questao2.anegocio.beans.Categorias;
import questao2.anegocio.beans.Consumidor;
import questao2.anegocio.beans.ReproduzirMidia;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RepositorioReproducaoMidia {

    private ArrayList<ReproduzirMidia> reproduzirMidiaArray;

    public RepositorioReproducaoMidia(){
        reproduzirMidiaArray = new ArrayList<>();
    }

    public void adicionar(ReproduzirMidia novo){
        reproduzirMidiaArray.add(novo);
    }

    public ArrayList<ReproduzirMidia> listarPorPeriodo(LocalDateTime inicio , LocalDateTime fim){
        ArrayList<ReproduzirMidia> request = new ArrayList();

        for (ReproduzirMidia iterador:reproduzirMidiaArray) {
            if ((inicio.isEqual(iterador.getDataReproducao() ) || inicio.isBefore(iterador.getDataReproducao()))
                    && (fim.isEqual(iterador.getDataReproducao()) || fim.isAfter(iterador.getDataReproducao()))) request.add(iterador);
        }
        return request;
    }

    public ArrayList<ReproduzirMidia> listarPorPessoa(Consumidor pessoa){
        ArrayList<ReproduzirMidia> request = new ArrayList<>();

        for (ReproduzirMidia iterador: reproduzirMidiaArray) {
            if (iterador.getPessoa().equals(pessoa)) request.add(iterador);
        }
        return request;
    }

    public ArrayList<ReproduzirMidia> listarPorCategorias(ArrayList<Categorias> lista){
        ArrayList<ReproduzirMidia> request = new ArrayList<>();

        for (ReproduzirMidia iterador:reproduzirMidiaArray) {
            if (lista.contains(iterador.getMidia().getCategoria())) request.add(iterador);
        }
        return request;
    }

    public ArrayList<ReproduzirMidia> listarTudo(){
        return reproduzirMidiaArray;
    }

}
