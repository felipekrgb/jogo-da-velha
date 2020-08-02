import java.util.Scanner;

public class JogoDaVelha {

	private static JogoDaVelha_Mapa jogoMapa;
	private static JogoDaVelha_PC jogoPC;
	private static JogoDaVelha_Jogador jogoJogador;

	private static void jogar(Scanner teclado) {

		boolean jogadorJoga;
		int quantidadeJogadas = 0;

		jogoMapa.limpaMapa();
		jogoMapa.desenha(quantidadeJogadas);

		int sorteio = jogoMapa.sortear(0, 2);
		if (sorteio == 0) { // JOGADOR INICIA
			jogadorJoga = true;
		} else { // PC INICIA
			jogadorJoga = false;
		}

		do {
			if (jogadorJoga) {
				jogadorJoga = jogoJogador.joga(teclado);
				quantidadeJogadas++;
				jogoMapa.desenha(quantidadeJogadas);
				if (jogoMapa.testeGanhou) {
					break;
				}
			} else {
				jogadorJoga = jogoPC.joga();
				quantidadeJogadas++;
				jogoMapa.desenha(quantidadeJogadas);
				if (jogoMapa.testeGanhou) {
					break;
				}
			}

		} while (quantidadeJogadas < 9);

		if (quantidadeJogadas == 9 && jogoMapa.testeGanhou == false) {
			System.out.println("... EMPATOU!");
		}

	}

	public static void main(String[] args) {

		char jogarNovamente;

		Scanner teclado = new Scanner(System.in);

		jogoMapa = new JogoDaVelha_Mapa();
		jogoPC = new JogoDaVelha_PC(jogoMapa);
		jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

		jogar(teclado);

		do {
			System.out.println("Deseja jogar novamente (s/n)?");
			jogarNovamente = teclado.next().charAt(0);
			jogarNovamente = Character.toUpperCase(jogarNovamente);
			if (jogarNovamente == 'S') {
				jogar(teclado);
			} else if (jogarNovamente == 'N') {
				System.out.println("--FIM--");
				break;
			} else {
				System.out.println("RESPOSTA INVALIDA");
			}
		} while (jogarNovamente != 'S' || jogarNovamente != 'N');
	}

}
