package questao2.dados.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Consumidor extends Usuario {

    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private ArrayList<Categorias> interesse;
    //Sim entra para as categorias serem String's , porém eu queria testar a implementação com enums para aprender

    public Consumidor(String nome, String email, LocalDate dataNascimento, ArrayList<Categorias> interesse) {
        super(nome, email, dataNascimento);
        this.interesse = interesse;
    }

    public ArrayList<Categorias> getInteresse() {
        return interesse;
    }

    public void setInteresse(List<Categorias> interesse) {
        interesse = interesse;
    }


    @Override
    public String   toString() {
        return "Consumidor  Nome: " + this.getNome() + "       Email: " + this.getEmail() + "       Data de Nascimento: " +
                this.getDataNascimento().format(forma) + "\nCategorias de interesse: " + getInteresse() + "\n\n";
    }

    public boolean equals(Consumidor x){
        boolean request = false;

        if(x != null){
            if (this.getNome()==x.getNome() && this.getDataNascimento().isEqual(x.getDataNascimento()) &&
                    this.getEmail() == x.getEmail()) request = true;
        }
        return  request;
    }

}
