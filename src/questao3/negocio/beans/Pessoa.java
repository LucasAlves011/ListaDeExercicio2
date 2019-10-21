package questao3.negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pessoa {

   private DateTimeFormatter forma =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private long codigo;
    private String email;
    private String nome;
    private LocalDate dataNascimento;
    private String cidade;

    public Pessoa(String nome, String email, LocalDate dataNascimento, String cidade) {
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
        this.codigo = hashCode();
    }

    public long getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "     Email : " + email + "     Nome: " + nome + "     Data Nascimento: " + dataNascimento.format(forma) + "     Cidade: " + cidade;
    }

    public boolean equals(Pessoa x){
        boolean request = false;
        if (x!= null){
            if (this.getNome() == x.getNome() && this.getEmail() == x.getEmail() && this.getDataNascimento().isEqual(x.getDataNascimento())) request = true;
        }
        return request;
    }

    @Override
    public int hashCode() {
        return Math.abs(Objects.hash(email, nome, dataNascimento,cidade));
    }

    public boolean verificar(){
        boolean request = true;
        if (email == null  || nome == null ||
                dataNascimento == null || cidade == null ) request = false;
        return request;
    }
}
