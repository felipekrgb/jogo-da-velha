import java.util.Scanner;

public class JogoDaVelha_Jogador {

	private JogoDaVelha_Mapa mapa;
	private static char letra = 'X';

	public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
		this.mapa = mapa;
	}

	public boolean joga(Scanner teclado) {
		int l = 0;
		int c = 0;
		boolean celulaLivre = false;

		while (!celulaLivre) {
			do {
				System.out.println("Jogador ..");
				System.out.println("linha: ");
				l = teclado.nextInt();
				System.out.println("coluna: ");
				c = teclado.nextInt();
			} while (l < 0 || l > 2 || c < 0 || c > 2);

			celulaLivre = mapa.jogar(l, c, letra);
		}

		return false;
	}
}

