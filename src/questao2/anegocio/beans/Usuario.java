package questao2.anegocio.beans;

import java.time.LocalDate;

public abstract  class Usuario {

    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public Usuario(String nome, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean equals(Usuario x){
        boolean retorno = false;

        if(x != null){
            if (this.getEmail() == x.getEmail() && this.getDataNascimento().equals(x.getDataNascimento())  &&
                    this.nome == x.getNome()) retorno = true;
        }
        return  retorno;
    }
}