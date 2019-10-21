package questao3.negocio.beans;

public enum Trilha {

    TECNOLOGIA("Tecnologia"),ECONOMIA_CRIATIVA("Economia Criativa"),CIDADES("Cidades");

    private String desc;

    Trilha(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String toString(){
        return this.getDesc();
    }
}
