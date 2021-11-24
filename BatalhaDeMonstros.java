package batalhademonstros;

import java.util.Scanner;

public class BatalhaDeMonstros {

    public static Scanner sc = new Scanner(System.in);

    public static Golpe[] golpes = new Golpe[12];
    public static Monstro[] monstros = new Monstro[6];

    public static Jogador j1 = new Jogador("Jogador 1");
    public static Jogador j2 = new Jogador("Jogador 2");

    public static void main(String[] args) {

        golpes[0] = new Golpe("Jato d´água", Tipo.AGUA, 10);
        golpes[1] = new Golpe("Bolhas", Tipo.AGUA, 8);
        golpes[2] = new Golpe("Bola de fogo", Tipo.FOGO, 7);
        golpes[3] = new Golpe("Brasas", Tipo.FOGO, 15);
        golpes[4] = new Golpe("Lâminas verdes", Tipo.GRAMA, 8);
        golpes[5] = new Golpe("Chicote de vinhas", Tipo.GRAMA, 9);
        golpes[6] = new Golpe("Eletricidade estática", Tipo.ELETRICO, 11);
        golpes[7] = new Golpe("Trovão", Tipo.ELETRICO, 10);
        golpes[8] = new Golpe("Atração magnética", Tipo.METAL, 7);
        golpes[9] = new Golpe("Garras de ferro", Tipo.METAL, 12);
        golpes[10] = new Golpe("Terremoto", Tipo.TERRA, 9);
        golpes[11] = new Golpe("Tempestade de areia", Tipo.TERRA, 10);

        monstros[0] = new Monstro("Pluvial", Tipo.AGUA, 30, 3, 6, 3, new Golpe[]{golpes[0], golpes[1]});
        monstros[1] = new Monstro("Chamuscado", Tipo.FOGO, 32, 6, 5, 8, new Golpe[]{golpes[2], golpes[3]});
        monstros[2] = new Monstro("Clorofíla", Tipo.GRAMA, 35, 4, 4, 4, new Golpe[]{golpes[4], golpes[5]});
        monstros[3] = new Monstro("Voltagem", Tipo.ELETRICO, 28, 5, 6, 2, new Golpe[]{golpes[6], golpes[7]});
        monstros[4] = new Monstro("Hardware", Tipo.METAL, 33, 5, 3, 5, new Golpe[]{golpes[8], golpes[9]});
        monstros[5] = new Monstro("Terreno", Tipo.TERRA, 29, 7, 7, 10, new Golpe[]{golpes[10], golpes[11]});

        escolherMonstros(j1);

        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.println((i + 1) + " - " + j1.getMonstros()[i].getNome());
        }

        escolherMonstros(j2);

        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.println((i + 1) + " - " + j2.getMonstros()[i].getNome());
        }

        do {
            rodada();
        } while (j1.getMonstrosVivos() > 0 && j2.getMonstrosVivos() > 0);
    }

    public static void escolherMonstros(Jogador jo) {
        int escolha;
        Monstro[] mons = new Monstro[3];
        int monsNum = 0;
        boolean check = false;
        do {
            System.out.println("\n" + jo.getNome() + ", escolha seus monstros:");
            for (int i = 0; i < 6; i++) {
                System.out.println((i + 1) + " - " + monstros[i].getNome());
            }
            System.out.print("Escolha: ");
            escolha = Integer.parseInt(sc.nextLine());
            if (escolha > 0 && escolha < 7) {
                for (Monstro m : mons) {
                    if (m != null) {
                        if (m.getTipo() == monstros[escolha - 1].getTipo()) {
                            System.out.println("\nEsse monstro já está no seu time.");
                            check = true;
                        }
                    }
                }
                if (!check) {
                    mons[monsNum] = monstros[escolha - 1];
                    monsNum++;
                }
                check = false;
            } else {
                System.out.println("\nPor favor, insira um número válido.");
            }
        } while (monsNum < 3);
        jo.setMonstros(mons);
    }

    public static void rodada() {
        int escolhaJ1, escolhaJ2;
        System.out.println("\n" + j1.getMonstros()[j1.getMonstroAtivo()].getNome() + " de "
                + j1.getNome() + " tem " + j1.getMonstros()[j1.getMonstroAtivo()].getVida() + " pontos de vida");
        System.out.println(j2.getMonstros()[j1.getMonstroAtivo()].getNome() + " de "
                + j2.getNome() + " tem " + j2.getMonstros()[j2.getMonstroAtivo()].getVida() + " pontos de vida");
        System.out.print("\n" + j1.getNome() + ", escolha uma ação:"
                + "\n1 - Atacar oponente"
                + "\n2 - Trocar monstro"
                + "\nEscolha: ");
        escolhaJ1 = Integer.parseInt(sc.nextLine());
        System.out.print("\n" + j2.getNome() + ", escolha uma ação:"
                + "\n1 - Atacar oponente"
                + "\n2 - Trocar monstro"
                + "\nEscolha: ");
        escolhaJ2 = Integer.parseInt(sc.nextLine());

        if (escolhaJ1 == 2) {
            int id = 0;
            System.out.println("\n" + j1.getNome() + ", escolha um monstro:");
            for (int i = 0; i < 3; i++) {
                if (i != j1.getMonstroAtivo()) {
                    id++;
                    System.out.println(id + " - " + j1.getMonstros()[i].getNome());
                }
            }
            System.out.print("Escolha: ");
            if (!Mecanicas.trocar(j1, Integer.parseInt(sc.nextLine()))) {
                if (j1.getMonstros()[1].check()) {
                    Mecanicas.trocar(j1, 1);
                } else if (j1.getMonstros()[2].check()) {
                    Mecanicas.trocar(j2, 2);
                } else {
                    System.out.println("\n" + j1.getNome() + " não possui mais monstros disponiveis."
                            + "\n" + j2.getNome() + " venceu.");
                }
            }
        }
        if (escolhaJ2 == 2) {
            int id = 0;
            System.out.println("\n" + j2.getNome() + ", escolha um monstro:");
            for (int i = 0; i < 3; i++) {
                if (i != j2.getMonstroAtivo()) {
                    id++;
                    System.out.println(id + " - " + j2.getMonstros()[i].getNome());
                }
            }
            System.out.print("Escolha: ");
            if (!Mecanicas.trocar(j2, Integer.parseInt(sc.nextLine()))) {
                if (j2.getMonstros()[1].check()) {
                    Mecanicas.trocar(j2, 1);
                } else if (j2.getMonstros()[2].check()) {
                    Mecanicas.trocar(j2, 2);
                } else {
                    System.out.println("\n" + j2.getNome() + " não possui mais monstros disponiveis."
                            + "\n" + j1.getNome() + " venceu.");
                }
            }
        }

        int escolha1, escolha2, jog1, jog2;
        Jogador[] jos = new Jogador[]{j1, j2};

        if (j1.getMonstros()[j1.getMonstroAtivo()].getVelocidade() > j2.getMonstros()[j2.getMonstroAtivo()].getVelocidade()) {
            escolha1 = escolhaJ1;
            escolha2 = escolhaJ2;
            jog1 = 0;
            jog2 = 1;
        } else if (j1.getMonstros()[j1.getMonstroAtivo()].getVelocidade() < j2.getMonstros()[j2.getMonstroAtivo()].getVelocidade()) {
            escolha1 = escolhaJ2;
            escolha2 = escolhaJ1;
            jog1 = 1;
            jog2 = 0;
        } else {
            if (j1.getMonstros()[j1.getMonstroAtivo()].getForca() > j2.getMonstros()[j2.getMonstroAtivo()].getForca()) {
                escolha1 = escolhaJ1;
                escolha2 = escolhaJ2;
                jog1 = 0;
                jog2 = 1;
            } else if (j1.getMonstros()[j1.getMonstroAtivo()].getForca() < j2.getMonstros()[j2.getMonstroAtivo()].getForca()) {
                escolha1 = escolhaJ2;
                escolha2 = escolhaJ1;
                jog1 = 1;
                jog2 = 0;
            } else {
                if (j1.getMonstros()[j1.getMonstroAtivo()].getDefesa() > j2.getMonstros()[j2.getMonstroAtivo()].getDefesa()) {
                    escolha1 = escolhaJ1;
                    escolha2 = escolhaJ2;
                    jog1 = 0;
                    jog2 = 1;
                } else if (j1.getMonstros()[j1.getMonstroAtivo()].getDefesa() < j2.getMonstros()[j2.getMonstroAtivo()].getDefesa()) {
                    escolha1 = escolhaJ2;
                    escolha2 = escolhaJ1;
                    jog1 = 1;
                    jog2 = 0;
                } else {
                    escolha1 = escolhaJ1;
                    escolha2 = escolhaJ2;
                    jog1 = 0;
                    jog2 = 1;
                }
            }
        }

        if (escolha1 == 1) {
            if (!jos[jog1].getMonstros()[jos[jog1].getMonstroAtivo()].check()) {
                System.out.println("\nO monstro de " + jos[jog1].getNome() + " está incapacitado.");
            } else {
                int id = 0;
                System.out.println("\n" + jos[jog1].getNome() + ", escolha um golpe:");
                for (int i = 0; i < 2; i++) {
                    System.out.println((i + 1) + " - " + jos[jog1].getMonstros()[jos[jog1].getMonstroAtivo()].getGolpes()[i].getNome());
                }
                System.out.print("Escolha: ");
                Mecanicas.atacar(jos[jog1].getMonstros()[jos[jog1].getMonstroAtivo()].getGolpes()[Integer.parseInt(sc.nextLine()) - 1], jos[jog2].getMonstros()[jos[jog2].getMonstroAtivo()]);
            }
        }

        if (escolha2 == 1) {
            {
                if (!jos[jog2].getMonstros()[jos[jog2].getMonstroAtivo()].check()) {
                    System.out.println("\nO monstro de " + jos[jog2].getNome() + " está incapacitado.");
                } else {
                    int id = 0;
                    System.out.println("\n" + jos[jog2].getNome() + ", escolha um golpe:");
                    for (int i = 0; i < 2; i++) {
                        System.out.println((i + 1) + " - " + jos[jog2].getMonstros()[jos[jog2].getMonstroAtivo()].getGolpes()[i].getNome());
                    }
                    System.out.print("Escolha: ");
                    Mecanicas.atacar(jos[jog2].getMonstros()[jos[jog2].getMonstroAtivo()].getGolpes()[Integer.parseInt(sc.nextLine()) - 1], jos[jog1].getMonstros()[jos[jog1].getMonstroAtivo()]);
                }
            }
        }

        if (!j1.getMonstros()[j1.getMonstroAtivo()].check()) {
            j1.setMonstrosVivos(j1.getMonstrosVivos() - 1);
            if (j1.getMonstrosVivos() == 0) {
                System.out.println("\n" + j1.getNome() + " não possui mais monstros disponiveis."
                        + "\n" + j2.getNome() + " venceu.");
                return;
            }
            int id = 0;
            System.out.println("\n" + j1.getNome() + ", escolha um monstro:");
            for (int i = 0; i < 3; i++) {
                if (i != j1.getMonstroAtivo()) {
                    id++;
                    System.out.println(id + " - " + j1.getMonstros()[i].getNome());
                }
            }
            System.out.print("Escolha: ");
            Mecanicas.trocar(j1, Integer.parseInt(sc.nextLine()));
        }

        if (!j2.getMonstros()[j2.getMonstroAtivo()].check()) {
            j2.setMonstrosVivos(j2.getMonstrosVivos() - 1);
            if (j2.getMonstrosVivos() == 0) {
                System.out.println("\n" + j2.getNome() + " não possui mais monstros disponiveis."
                        + "\n" + j1.getNome() + " venceu.");
                return;
            }
            int id = 0;
            System.out.println("\n" + j2.getNome() + ", escolha um monstro:");
            for (int i = 0; i < 3; i++) {
                if (i != j2.getMonstroAtivo()) {
                    id++;
                    System.out.println(id + " - " + j2.getMonstros()[i].getNome());
                }
            }
            System.out.print("Escolha: ");
            Mecanicas.trocar(j2, Integer.parseInt(sc.nextLine()));
        }
    }

}