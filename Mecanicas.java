package batalhademonstros;

public class Mecanicas {

    public static boolean trocar(Jogador j, int monstro) {
        if (j.getMonstroAtivo() == 0) {
            if (monstro == 1) {
                if (j.getMonstros()[1].check()) {
                    j.setMonstroAtivo(1);
                    System.out.println("\n" + j.getNome() + " trocou psrs o monstro " + j.getMonstros()[j.getMonstroAtivo()].getNome() + ".");
                    return true;
                }
            } else {
                if (j.getMonstros()[2].check()) {
                    j.setMonstroAtivo(2);
                    System.out.println("\n" + j.getNome() + " trocou psrs o monstro " + j.getMonstros()[j.getMonstroAtivo()].getNome() + ".");
                    return true;
                }
            }
        } else if (j.getMonstroAtivo() == 1) {
            if (monstro == 1) {
                if (j.getMonstros()[0].check()) {
                    j.setMonstroAtivo(0);
                    System.out.println("\n" + j.getNome() + " trocou psrs o monstro " + j.getMonstros()[j.getMonstroAtivo()].getNome() + ".");
                    return true;
                }
            } else {
                if (j.getMonstros()[2].check()) {
                    j.setMonstroAtivo(2);
                    System.out.println("\n" + j.getNome() + " trocou psrs o monstro " + j.getMonstros()[j.getMonstroAtivo()].getNome() + ".");
                    return true;
                }
            }
        } else {
            if (monstro == 1) {
                if (j.getMonstros()[0].check()) {
                    j.setMonstroAtivo(0);
                    System.out.println("\n" + j.getNome() + " trocou psrs o monstro " + j.getMonstros()[j.getMonstroAtivo()].getNome() + ".");
                    return true;
                }
            } else {
                if (j.getMonstros()[1].check()) {
                    j.setMonstroAtivo(1);
                    System.out.println("\n" + j.getNome() + " trocou psrs o monstro " + j.getMonstros()[j.getMonstroAtivo()].getNome() + ".");
                    return true;
                }
            }
        }
        System.out.println("\nO monstro escolhido está incapacitado.");
        return false;
    }

    public static void atacar(Golpe g, Monstro m) {
        int dano = g.getPoder();
        boolean efetivo = false;
        if (g.getTipo().vantagem(m.getTipo().fraqueza())) {
            dano *= 2;
            efetivo = true;
        }
        dano -= m.getDefesa();
        if (dano > 0) {
            m.setVida(m.getVida() - dano);
            System.out.println(m.getNome() + " recebeu " + dano + " pontos de dano.");
            if (efetivo) {
                System.out.println("Foi super efetivo!");
            }
        } else {
            System.out.println(m.getNome() + " se defendeu do golpe.");
        }
    }
}
