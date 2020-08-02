
public class JogoDaVelha_Mapa {

	private char[][] mapa = new char[3][3];
	public boolean testeGanhou;

	public int sortear(int inicio, int fim) {
		return (int) ((Math.random() * fim) - inicio);
	}

	public void limpaMapa() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				mapa[i][j] = ' ';
			}
		}
	}

	public void desenha(int jogada) {
		System.out.println("------------- .. jogada: " + jogada);
		System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
		System.out.println("-------------");
		System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
		System.out.println("-------------");
		System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");
		System.out.println("-----------------------------");

	}

	public boolean jogar(int l, int c, char jogador) {
		if (mapa[l][c] == ' ') {
			mapa[l][c] = jogador;
			testeGanhou = ganhou(jogador);
			if (testeGanhou) {
				if (jogador == 'X') {
					System.out.println("... Jogador GANHOU!!!");
				} else {
					System.out.println("... PC GANHOU!!!");
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean ganhou(char jogador) {
		if (mapa[0][0] == jogador && mapa[0][1] == jogador && mapa[0][2] == jogador) {
			return true;
		} else if (mapa[1][0] == jogador && mapa[1][1] == jogador && mapa[1][2] == jogador) {
			return true;
		} else if (mapa[2][0] == jogador && mapa[2][1] == jogador && mapa[2][2] == jogador) {
			return true;
		} else if (mapa[0][0] == jogador && mapa[1][0] == jogador && mapa[2][0] == jogador) {
			return true;
		} else if (mapa[0][0] == jogador && mapa[1][0] == jogador && mapa[2][0] == jogador) {
			return true;
		} else if (mapa[0][1] == jogador && mapa[1][1] == jogador && mapa[2][1] == jogador) {
			return true;
		} else if (mapa[0][2] == jogador && mapa[1][2] == jogador && mapa[2][2] == jogador) {
			return true;
		} else if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) {
			return true;
		} else if (mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador) {
			return true;
		} else {
			return false;
		}
	}

}
