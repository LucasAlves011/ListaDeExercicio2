package questao2.anegocio.beans;

public enum Categorias {

    COMEDIA("Comédia"),ADULTO("Adulto"),ACAO("Ação"),TEEN("Teen"),DRAMA("Drama"),
    POLICIAL("Policial"),MUSICA("Música"),PEGADINHA("Pegadinha"),GAMEPLAY("Game Play"),
    VIDEOAULA("Vídeo Aula"),CULINARIA("Culinária"),REVIEW("Review"),VLOG("Vlog"),
    TUTORIAL("Tutorial"),INFANTIL("Infantil"),;

    private String desc;

    Categorias(String descricao){
        desc = descricao;
    }

    public String getDesc() {
        return desc;
    }

    public String toString() {return getDesc();}

    public boolean equals(Categorias x){
        boolean request = false;
        if(x != null){
            if (x.getDesc() == this.getDesc()) request = true;
        }
        return request;
    }

}
