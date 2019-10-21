package questao3.negocio.beans;

import java.time.LocalDate;

public class Participante extends Pessoa {

    private Trilha trilha;

    public Participante(String nome, String email, LocalDate dataNascimento, String cidade, Trilha trilha) {
        super(nome, email, dataNascimento, cidade);
        this.trilha = trilha;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }

    public String toString(){
        return super.toString() + "     Aérea de interesse: " + this.trilha+"\n";
    }
}
