package questao3.dados;

import questao3.negocio.beans.Avaliacao;
import questao3.negocio.beans.Palestra;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class RepositorioPalestra {

    private ArrayList<Palestra> array;

    public RepositorioPalestra(){
        array = new ArrayList<>();
    }

    public void inserirPalestra(Palestra palestra){
        if (palestra != null) array.add(palestra);
    }

    public Palestra buscarPalestra(long id){
        Palestra request = null;
        for (Palestra iterador:array) {
            if (iterador.getId() == id) {
                request = iterador;
                break;
            }
        }
        return  request;
    }

    public List<Palestra> listarPalestra(){
        return array;
    }

    public Palestra listarPorLocalEHora(String local, LocalDateTime hora){
        Palestra request = null;

        for (Palestra iterador :array) {
            if (iterador.getLocal() == local && iterador.getDataHora().isEqual(hora)){
                request = iterador;
                break;
            }
        }
        return request;
    }

    public ArrayList<Palestra> listarPalestraPorNota(int nota){
        ArrayList<Palestra> request = new ArrayList<>();

        for (Palestra iterador:array) {
            iterador.calcularMediaPalestra();
            if (iterador.getMedia() >= nota)request.add(iterador);

        }
        return request;
    }

    public ArrayList<Avaliacao> listarAvaliacao(){
       ArrayList<Avaliacao> request = new ArrayList<>();
        for (Palestra iterador:array) {
            request.addAll(iterador.getAvaliacoes());
        }
        return request;
    }

    public boolean verificarHoraLocal(Palestra p){
        boolean request = true;
        for (Palestra iterador:array) {
            if (p.getDataHora().isEqual(iterador.getDataHora()) && p.getLocal() == iterador.getLocal()) {
                request = false;
                break;
            }
        }
        return request;
    }

    public List<Palestra> listarOrdenadas(){
        ArrayList<Palestra> temp = new ArrayList<>();
        for (Palestra iterador:array) {
            iterador.calcularMediaPalestra();
        }
        temp.addAll(array);
        Collections.sort(temp);
        return temp;
    }


}
