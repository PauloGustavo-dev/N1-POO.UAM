package batalhademonstros;

public class Golpe {
    private String nome;
    private Tipo tipo;
    private int poder;

    public Golpe(String nome, Tipo tipo, int poder) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
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

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }
}