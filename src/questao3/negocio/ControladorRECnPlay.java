package questao3.negocio;

import questao3.dados.RepositorioPalestra;
import questao3.dados.RepositorioPessoas;
import questao3.negocio.beans.*;

import java.util.ArrayList;
import java.util.List;

public class ControladorRECnPlay {

    private RepositorioPalestra repositorioPalestra;
    private RepositorioPessoas repositorioPessoas;
    private static ControladorRECnPlay instace;

    public static ControladorRECnPlay getInstace(){
        if (instace == null){
            instace = new ControladorRECnPlay();
        }
        return instace;
    }

    private ControladorRECnPlay(){
        repositorioPalestra = new RepositorioPalestra();
        repositorioPessoas = new RepositorioPessoas();
    }

    //Delegate
    public List<Palestra> listarPalestra() {
        return repositorioPalestra.listarPalestra();
    }

    public ArrayList<Palestra> listarPalestraPorNota(int nota) {
        return repositorioPalestra.listarPalestraPorNota(nota);
    }

    public ArrayList<Avaliacao> listarAvaliacao() {
        return repositorioPalestra.listarAvaliacao();
    }


    //Delegate Pessoa
    public Pessoa buscarPessoaPorEmail(String email) {//Check
        return repositorioPessoas.buscarPessoaPorEmail(email);
    }

    public List<Palestrante> buscarPorEmpresa(String empresa) {//Check
        return repositorioPessoas.buscarPorEmpresa(empresa);
    }

    public List<Participante> listarParticipanteTrilha(Trilha trilha) {//check
        return repositorioPessoas.listarParticipanteTrilha(trilha);
    }

    public List<Participante> listarParticipanteComIdadeMaior(int x) {//check
        return repositorioPessoas.listarParticipanteComIdadeMaior(x);
    }

    public void removerPessoa(String email) {//Check
        repositorioPessoas.removerPessoa(email);
    }

    public List<Pessoa> listarTodoMundo() {//check
        return repositorioPessoas.listarTodoMundo();
    }

    //Regras de Negocio
    public void realizarInscricao(Participante p){ //check
        if (p != null && p.getTrilha() != null){
            Pessoa temp = repositorioPessoas.buscarPessoaPorEmail(p.getEmail());
            if(temp == null) repositorioPessoas.inserirPessoa(p);
        }
    }

    public void cadastrarPalestra(Palestra palestra) {
        if (palestra != null && palestra.getPalestrante() != null) {
            if (palestra.verificar() && repositorioPalestra.verificarHoraLocal(palestra)) {
                if (repositorioPessoas.buscarPalestrantePorEmail(palestra.getPalestrante().getEmail())) {
                    repositorioPalestra.inserirPalestra(palestra);
                } else {
                    repositorioPessoas.inserirPessoa(palestra.getPalestrante());
                    repositorioPalestra.inserirPalestra(palestra);
                }
            }
        }
    }

    public void avaliarPalestra(Avaliacao aval){
        if (aval.getAvaliador() != null && aval.getPalestra() != null && aval.getNota() >= 0 && aval.getNota() <= 5){
            aval.getPalestra().addAvaliacao(aval);
        }
    }




    public List<Palestra> listarOrdenadas(){
        return repositorioPalestra.listarOrdenadas();
    }

}
