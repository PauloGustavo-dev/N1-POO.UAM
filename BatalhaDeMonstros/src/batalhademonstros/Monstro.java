package batalhademonstros;

public class Monstro {
    private String nome;
    private Tipo tipo;
    private int  vida, forca, defesa, velocidade;
    private Golpe [] golpes;

    public Monstro(String nome, Tipo tipo, int vida, int forca, int defesa, int velocidade, Golpe[] golpes) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.golpes = golpes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public Golpe[] getGolpes() {
        return golpes;
    }

    public void setGolpes(Golpe[] golpes) {
        this.golpes = golpes;
    }

    public boolean check() {
        if (vida > 0){
            return true;
        } else {
            return false;
        }
    }
}
