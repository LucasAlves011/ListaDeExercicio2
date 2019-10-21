package questao3.dados;

import questao3.negocio.beans.*;

import java.lang.management.ThreadInfo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPessoas {

    private ArrayList<Pessoa> pessoas;

    public RepositorioPessoas(){
        pessoas = new ArrayList<>();
    }

    public void inserirPessoa(Pessoa pessoa){
        if (pessoa != null) pessoas.add(pessoa);
    }

    public void removerPessoa(String email){
        if (email != null ){
            Pessoa temp = buscarPessoaPorEmail(email);
            if (temp != null) pessoas.remove(temp);
        }
    }

    public Pessoa buscarPessoaPorEmail(String email){
        Pessoa request = null;
       if (email != null) {
           for (Pessoa iterador : pessoas) {
               if (iterador.getEmail() == email) {
                   request = iterador;
                   break;
               }
           }
       }
        return request;
    }

    public List<Palestrante> buscarPorEmpresa(String empresa){
        ArrayList<Palestrante> request = new ArrayList<>();
        if (empresa !=null) {
            for (Pessoa iterador : pessoas) {
                if (iterador instanceof Palestrante && ((Palestrante) iterador).getEmpresa() == empresa) {
                    request.add((Palestrante) iterador);
                }

            }
        }
        return request;
    }

    public List<Participante> listarParticipanteTrilha(Trilha trilha){
        ArrayList<Participante> request = new ArrayList<>();
        if (trilha != null) {
            for (Pessoa iterador : pessoas) {
                if (iterador instanceof Participante && ((Participante) iterador).getTrilha() == trilha) {
                    request.add((Participante) iterador);
                }
            }
        }
        return request;
    }

    public List<Participante> listarParticipanteComIdadeMaior(int x){
        ArrayList<Participante> request = new ArrayList<>();
        if (x > 0) {
            for (Pessoa iterador : pessoas) {
                if (iterador instanceof Participante && iterador.getDataNascimento().until(LocalDate.now(), ChronoUnit.YEARS) > x)
                    request.add((Participante) iterador);
            }
        }
        return request;
    }

    public List<Pessoa> listarTodoMundo(){
        return pessoas;
    }

    public boolean buscarPalestrantePorEmail(String email){
        boolean request = false;
        for (Pessoa iterador:pessoas) {
            if (iterador instanceof Palestrante && iterador.getEmail()==email) {
                request = true;
                break;
            }
        }
        return request;
    }

}
