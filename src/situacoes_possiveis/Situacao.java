package situacoes_possiveis;

import entidades.Pessoa;

public abstract class Situacao {

	public abstract void tomaVacina(Pessoa pessoa);

	public abstract void mudaSituacao(Pessoa pessoa);

}
