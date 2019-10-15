package questao2.anegocio;

import questao2.dados.RepositorioMidia;
import questao2.dados.RepositorioReproducaoMidia;
import questao2.dados.RepositorioUsuario;
import questao2.dados.beans.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControladorMidia {

    private RepositorioUsuario controlUser;
    private RepositorioMidia controlMidia;
    private RepositorioReproducaoMidia controlRepMidia;
    private static ControladorMidia instance; //Instancia única

    public static ControladorMidia getInstance(){
        if (instance == null){
            instance = new ControladorMidia();
        }
        return instance;
    }

    private ControladorMidia(){
        controlUser = new RepositorioUsuario();
        controlMidia = new RepositorioMidia();
        controlRepMidia = new RepositorioReproducaoMidia();
    }

    //METODOS DELEGATE REPOSITORIO DE USUARIOS
    public List<Usuario> listarPorTipo(Class k) {
        return controlUser.listarPorTipo(k);
    }

    public List<Usuario> listarTodoMundo() {
        return controlUser.listarTodoMundo();
    }


    //METODOS DELEGATE REPOSITORIO DE MIDIA

    public List<Usuario> listarPorIdade(int ano) {
        return controlUser.listarPorIdade(ano);
    }

    public ArrayList<Midia> listarMidiaPorIdade(int num) {
        return controlMidia.listarMidiaPorIdade(num);
    }

    public ArrayList<Midia> listarPorCategoria(Categorias x) {
        return controlMidia.listarPorCategoria(x);
    }

    public boolean buscarPorArquivo(Midia x) {
        return controlMidia.buscarPorArquivo(x);
    }

    //METODOS DO DELEGATE DE REPRODUÇÃO MIDIA
    public void adicionar(ReproduzirMidia novo) {
        controlRepMidia.adicionar(novo);
    }

    public ArrayList<ReproduzirMidia> listarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return controlRepMidia.listarPorPeriodo(inicio, fim);
    }

    public ArrayList<ReproduzirMidia> listarPorPessoa(Consumidor pessoa) {
        return controlRepMidia.listarPorPessoa(pessoa);
    }

    public ArrayList<ReproduzirMidia> listarPorCategorias(ArrayList<Categorias> lista) {
        return controlRepMidia.listarPorCategorias(lista);
    }

    //METODOS ADICIONAIS DO CONTROLADOR
    public void cadastrar(Usuario u){
        if (u != null){
            if (u instanceof Produtor && ((Produtor) u).getCate() != null && !(((Produtor) u).getCate().isEmpty())){
                controlUser.adicionar(u);
            }else
                controlUser.adicionar(u);
        }
    }

    public void remover(Usuario x){
        if (x != null){
            controlUser.remover(x);
        }
    }

    public void cadastrarMidia(Midia x){
        if (x != null && x.getProdutor().getCate().contains(x.getCategoria())){
            controlMidia.cadastrar(x);
        }
    }

    public void removerMidia(Midia x){
        if(x != null && controlMidia.buscarPorArquivo(x)){
            controlMidia.remover(x);
        }
    }

    public void reproduzirMidia(Consumidor c , Midia m){
        if (c != null && m != null){
            if (c.getDataNascimento().until(m.getHoraUpload(), ChronoUnit.YEARS) >= m.getFaixaEtaria()){
                ReproduzirMidia temp = new ReproduzirMidia(m,c);
                controlRepMidia.adicionar(temp);
            }
        }
    }

    public List<Midia> listarTodas(){
        return controlMidia.listarTodas();
    }

    public ArrayList<ReproduzirMidia> listarTudo() {
        return controlRepMidia.listarTudo();
    }
}
