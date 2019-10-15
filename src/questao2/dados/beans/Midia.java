package questao2.dados.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Midia {

    DateTimeFormatter forma1= DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

    private LocalDateTime horaUpload;
    private String arquivo;
    private int faixaEtaria;
    private Categorias categoria;
    private Produtor produtor;

    public Midia(LocalDateTime horaUpload, String arquivo, int faixaEtaria, Categorias categoria, Produtor produtor) {
        this.horaUpload = horaUpload;
        this.arquivo = arquivo;
        this.faixaEtaria = faixaEtaria;
        this.categoria = categoria;
        this.produtor = produtor;
    }

    public LocalDateTime getHoraUpload() {
        return horaUpload;
    }

    public void setHoraUpload(LocalDateTime horaUpload) {
        this.horaUpload = horaUpload;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    @Override
    public String toString() {
        return "Midia" +
                "Hora de Upload: " + horaUpload.format(forma1) +"      Arquivo: " + arquivo +
                "      Faixa Etaria: " + faixaEtaria +"      Categoria : " + categoria +
                "\n " + produtor +
                "\n";
    }

    public boolean equals(Midia k) {
        boolean request = false;

        if (this.getArquivo() == k.getArquivo() && this.getProdutor().equals(k.getProdutor())) request = true;
        return request;
    }
}
