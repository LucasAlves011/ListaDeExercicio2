package questao3.negocio.beans;

import java.time.LocalDate;

public class Palestrante extends Pessoa {

    private String empresa;

    public Palestrante(String nome, String email, LocalDate dataNascimento, String cidade, String empresa) {
        super(nome, email, dataNascimento, cidade);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String toString(){
        return super.toString() + "     Empresa : " + empresa +"\n";
    }

    @Override
    public boolean verificar(){
        boolean request = true;
        if (empresa == null || !super.verificar()) request = false;
        return request;
    }
}
