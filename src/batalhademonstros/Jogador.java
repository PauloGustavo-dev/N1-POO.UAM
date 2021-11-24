package batalhademonstros;

public class Jogador {

    private String nome;
    private int monstroAtivo, monstrosVivos = 3;
    private Monstro [] monstros = new Monstro[3];

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMonstroAtivo() {
        return monstroAtivo;
    }

    public void setMonstroAtivo(int monstroAtivo) {
        this.monstroAtivo = monstroAtivo;
    }

    public Monstro[] getMonstros() {
        return monstros;
    }

    public void setMonstros(Monstro[] monstros) {
        this.monstros = monstros;
    }

    public int getMonstrosVivos() {
        return monstrosVivos;
    }

    public void setMonstrosVivos(int monstrosVivos) {
        this.monstrosVivos = monstrosVivos;
    }
}
