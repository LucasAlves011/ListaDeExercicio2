package questao2.dados.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReproduzirMidia {
    DateTimeFormatter forma3 = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

    private Midia midia;
    private Consumidor pessoa;
    private LocalDateTime dataReproducao;

    public ReproduzirMidia() {
    }

    public ReproduzirMidia(Midia midia, Consumidor pessoa) {
        this.midia = midia;
        this.pessoa = pessoa;
        this.dataReproducao = LocalDateTime.now();
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public Consumidor getPessoa() {
        return pessoa;
    }

    public void setPessoa(Consumidor pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDateTime getDataReproducao() {
        return dataReproducao;
    }

    public void setDataReproducao(LocalDateTime dataReproducao) {
        this.dataReproducao = dataReproducao;
    }

    @Override
    public String toString() {
        return separador() + midia + pessoa + "Data de Reprodução: " + dataReproducao.format(forma3) +"\n\n";
    }

    private String separador(){
        return "----------------------------------------------------------------------------------------------------------------------------\n";
    }
}
