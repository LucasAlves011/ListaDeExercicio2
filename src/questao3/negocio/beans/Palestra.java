package questao3.negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Palestra implements Comparable<Palestra>{

    DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

    private long id;
    private String titulo;
    private Palestrante palestrante;
    private String descricao;
    private List<Avaliacao> avaliacoes;
    private LocalDateTime dataHora;
    private String local;
    private Trilha trilha;
    private float media;

    public Palestra(String titulo, Palestrante palestrante, String descricao, LocalDateTime dataHora, String local, Trilha trilha) {
        this.titulo = titulo;
        this.palestrante = palestrante;
        this.descricao = descricao;
        avaliacoes = new ArrayList<>();
        this.dataHora = dataHora;
        this.local = local;
        this.trilha = trilha;
        this.id = hashCode();
    }

    public long getId() {
        return id;
    }

    public float getMedia(){return media;}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        if (avaliacao != null )avaliacoes.add(avaliacao);
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }

    @Override
    public int hashCode(){
        return Math.abs(Objects.hash(titulo,descricao,palestrante,dataHora,trilha));
    }

    public boolean verificar(){
        boolean request = true;
        if( titulo == null || palestrante == null || !palestrante.verificar() ||
        descricao == null || local == null ||dataHora == null || trilha == null) request = false;
        return request;
    }

    public void calcularMediaPalestra(){
       float temp=0;
        for (Avaliacao iterador:avaliacoes){
            temp += iterador.getNota();
        }
        temp = (temp/avaliacoes.toArray().length);
        media = temp;
    }

    @Override
    public int compareTo(Palestra o) {
        float x = this.getMedia() - o.getMedia();
        if (x > 0) return -1;
        else if(x == 0) return 0;
        else return 1;
    }

    public String toString(){
        return dataHora.format(forma) + "\n" +"Título: "+ titulo + "\n" +"Palestrante: "+ palestrante.getNome() + "\n" +
                "Empresa: "+  palestrante.getEmpresa() + "\n" +"Local: "+ local + "\n" +"Trilha: "+ trilha.getDesc() + "\n" +"Descrição: "+ descricao + "\n"+ media + "\n" + quebraLinha();
    }

    private String quebraLinha(){
        return  "-----------------------------------------------------------------------------------------------\n";
    }
}
