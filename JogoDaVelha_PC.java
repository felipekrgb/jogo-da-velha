
public class JogoDaVelha_PC {

	private JogoDaVelha_Mapa mapa;
	private static char letra = 'O';

	public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
		this.mapa = mapa;
	}

	public boolean joga() {

		int l = 0;
		int c = 0;
		boolean celulaLivre = false;

		while (!celulaLivre) {
			l = mapa.sortear(0, 3);
			c = mapa.sortear(0, 3);
			celulaLivre = mapa.jogar(l, c, letra);
		}

		System.out.println("PC[" + l + "," + c + "]");
		return true;

	}
}
