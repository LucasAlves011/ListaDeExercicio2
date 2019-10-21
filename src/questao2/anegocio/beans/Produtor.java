package questao2.anegocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Produtor extends Usuario {
    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String nomeCanal;
    private ArrayList<Categorias> cate ;
    //Sim entra para as categorias serem String's , porém eu queria testar a implementação com enums para aprender

    public Produtor(String nome, String email, LocalDate dataNascimento, String nomeCanal, ArrayList<Categorias> cate) {
        super(nome, email, dataNascimento);
        this.nomeCanal = nomeCanal;
        this.cate = new ArrayList<>();
        this.setCate(cate);
    }

    public String getNomeCanal() {
        return nomeCanal;
    }

    public void setNomeCanal(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }

    public ArrayList<Categorias> getCate() {
        return cate;
    }

    public void setCate(ArrayList<Categorias> cate) {
        this.cate.addAll(cate);
    }

    @Override
    public String toString() {
        return "Produtor  Nome: " + this.getNome() + "       E-mail: " + this.getEmail() + "       Data de Nascimento: " +
                this.getDataNascimento().format(forma) + "\n       Canal: " + nomeCanal + "        Categorias: " +
                cate +"\n\n";
    }

    public boolean equals(Produtor p){
        boolean request = false;

        if (p != null){
            if (this.getDataNascimento().equals(p.getDataNascimento()) && this.getEmail() == p.getEmail() &&
                    this.getNome() == p.getNome() && this.getNomeCanal() == p.getNomeCanal() /*Não coloquei o array de categorias */)
                request = true;
        }
        return request;
    }
}

