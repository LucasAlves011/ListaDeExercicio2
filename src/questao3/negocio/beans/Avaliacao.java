package questao3.negocio.beans;

public class Avaliacao  {

    private Palestra palestra;
    private int nota;
    private String comentario;
    private Participante avaliador;

    public Avaliacao(Palestra palestra, int nota, String comentario, Participante avaliador) {
        this.palestra = palestra;
        this.nota = nota;
        this.comentario = comentario;
        this.avaliador = avaliador;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public  int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public Participante getAvaliador() {
        return avaliador;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setAvaliador(Participante avaliador) {
        this.avaliador = avaliador;
    }

    public String toString(){
        return palestra.getTitulo()  + "   Palestrante : " + palestra.getPalestrante().getNome() + "\n" +
                "Avaliador: "+ avaliador.getNome() + " --> "  +comentario + "\n" + "Nota: " + nota+"\n";
    }

}
