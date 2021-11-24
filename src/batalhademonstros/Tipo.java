package batalhademonstros;

public enum Tipo {
    AGUA,
    FOGO,
    GRAMA,
    ELETRICO,
    TERRA,
    METAL;

    public boolean vantagem(Tipo t) {
        if (this == t) {
            return true;
        } else {
            return false;
        }
    }

    public Tipo fraqueza() {
        if (this == Tipo.AGUA){
            return Tipo.GRAMA;
        } else if (this == Tipo.FOGO){
            return Tipo.AGUA;
        } else if (this == Tipo.GRAMA){
            return Tipo.FOGO;
        } else if (this == Tipo.ELETRICO){
            return Tipo.TERRA;
        } else if (this == Tipo.TERRA){
            return Tipo.METAL;
        } else {
            return Tipo.ELETRICO;
        }
    }
}
