package situacoes_possiveis;

import entidades.Pessoa;

public class VacinacaoFinalizada extends Situacao {

	@Override
	public void mudaSituacao(Pessoa pessoa) {
		System.out.println("A pessoa já está com seu processo de vacinação finalizado.\n\n");

	}

	@Override
	public void tomaVacina(Pessoa pessoa) {
		System.out.println("A pessoa já está com seu processo de vacinação finalizado.\n\n");
	}

	@Override
	public String toString() {
		return "já tomou as duas doses da vacina e está imunizada. Viva o SUS!";
	}

}
