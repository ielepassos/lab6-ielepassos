package entidades;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import entidades.Pessoa;
import situacoes_possiveis.VacinacaoFinalizada;
import situacoes_possiveis.NaoHabilitadaVacina;
import situacoes_possiveis.PrimeiraDose;
import situacoes_possiveis.SegundaDose;
import situacoes_possiveis.TomouPrimeiraDose;

public class Vacinarias {

	private Map<String, Pessoa> pessoasCadastradas;

	private Set<String> comorbidades;

	private Set<String> profissoes;

	private int idadeMinima;

	public Vacinarias() {
		this.pessoasCadastradas = new HashMap<String, Pessoa>();
		this.comorbidades = new TreeSet<String>();
		this.profissoes = new TreeSet<String>();
		this.idadeMinima = 94;
	}

	public void adicionaPessoa(String nome, String cpf, int idade, String endereco, String cartaoSUS, String email,
			String telefone, String profissao, String comorbidades) {
		if (pessoasCadastradas.containsKey(cpf)) {
			System.out.println("A pessoa com o cpf " + cpf + " já se encontra cadastrada no sistema.\n\n");
		} else {

			Pessoa pessoa = new Pessoa(nome, cpf, idade, endereco, cartaoSUS, email, telefone, profissao, comorbidades);
			atualizaSituacao(pessoa);
			pessoasCadastradas.put(cpf, pessoa);
		}
	}

	public void tomaVacina(String cpf) {
		if (!this.pessoasCadastradas.containsKey(cpf)) {
			System.out.println("A pessoa com cpf: " + cpf + " não se encontra cadastrada no sistema.");
		} else {
			this.pessoasCadastradas.get(cpf).tomarVacina();
		}
	}

	public void setPessoaComorbidades(String cpf, String comorbidades) {
		this.pessoasCadastradas.get(cpf).setComorbidades(comorbidades);
	}

	public void setProfissaoPessoa(String cpf, String profissao) {
		this.pessoasCadastradas.get(cpf).setProfissao(profissao);
	}

	public void getSituacaoPessoa(String cpf) {
		if (!this.pessoasCadastradas.containsKey(cpf)) {
			System.out.println("A pessoa não se encontra cadastrada no sistema.\n\n");
		} else {
			System.out.println(this.pessoasCadastradas.get(cpf).toString() + " \n\n");
		}
	}

	public void avancaEtapa(String cpf) {
		if (!this.pessoasCadastradas.containsKey(cpf)) {
			System.out.println("A pessoa com cpf: " + cpf + " não se encontra cadastrada no sistema.");
		} else if (verificaAptidao(this.pessoasCadastradas.get(cpf))) {
			this.pessoasCadastradas.get(cpf).avancarEtapa();
		} else {
			System.out.println("Infelizmente, a pessoa ainda não está apta para tomar a vacina.");
		}
	}

	public void listaPessoasNaoAptas() {
		String retorna = "";
		for (Pessoa pessoa : pessoasCadastradas.values()) {
			if (pessoa.getSituacao() instanceof NaoHabilitadaVacina)
				retorna += pessoa.toString();
		}
		System.out.print(retorna);
	}

	public void listaPessoasAptas1Dose() {
		String retorna = "";
		for (Pessoa pessoa : pessoasCadastradas.values()) {
			if (pessoa.getSituacao() instanceof PrimeiraDose)
				retorna += pessoa.toString();
		}
		System.out.print(retorna);
	}

	public void listaPessoasAptas2Dose() {
		String retorna = "";
		for (Pessoa pessoa : pessoasCadastradas.values()) {
			if (pessoa.getSituacao() instanceof SegundaDose)
				retorna += pessoa.toString();
		}
		System.out.print(retorna);
	}

	public void listaPessoasQTomaram1Dose() {
		String retorna = "";
		for (Pessoa pessoa : pessoasCadastradas.values()) {
			if (pessoa.getSituacao() instanceof TomouPrimeiraDose)
				retorna += pessoa.toString();
		}
		System.out.print(retorna);
	}

	public void listaPessoasImunizadas() {
		String retorna = "";
		for (Pessoa pessoa : pessoasCadastradas.values()) {
			if (pessoa.getSituacao() instanceof VacinacaoFinalizada)
				retorna += pessoa.toString();
		}
		System.out.print(retorna);
	}

	public void getDetalhes() {
		listaComorbidadesAptas();
		listaProfissoesAptas();
		getIdadeMinimaVacinacao();
	}

	public void listaComorbidadesAptas() {
		String retorna = "Lista de comorbidades que tornam possível o recebimento da vacina: \n";
		for (String comorbidade : this.comorbidades) {
			retorna += comorbidade + "\n";
		}
		System.out.print(retorna);
	}

	public void listaProfissoesAptas() {
		String retorna = "Lista de profissões que tornam possível o recebimento da vacina: \n";
		for (String profissao : this.profissoes) {
			retorna += profissao + "\n";
		}
		System.out.print(retorna);
	}

	public void getIdadeMinimaVacinacao() {
		System.out.println("A idade mínima atual para a vacinação é de " + this.idadeMinima + " anos de idade.");
	}

	public void adicionaComorbidadeApta(String comorbidade) {
		this.comorbidades.add(comorbidade);
		atualizaSituacoes();
	}

	public void adicionaProfissaoApta(String profissao) {
		this.profissoes.add(profissao);
		atualizaSituacoes();
	}

	public void setIdadeMinimaApta(int idade) {
		this.idadeMinima = idade;
		atualizaSituacoes();
	}

	private void atualizaSituacoes() {
		for (Pessoa pessoa : this.pessoasCadastradas.values()) {
			atualizaSituacao(pessoa);
		}
	}

	private void atualizaSituacao(Pessoa pessoa) {
		if (pessoa.getSituacao() instanceof NaoHabilitadaVacina && verificaAptidao(pessoa)) {
			pessoa.getSituacao().mudaSituacao(pessoa);
		}
	}

	private boolean verificaAptidao(Pessoa pessoa) {
		if (pessoa.getIdade() >= idadeMinima)
			return true;
		if (this.profissoes.contains(pessoa.getProfissao()))
			return true;
		for (String comorbidade : pessoa.getComorbidades()) {
			if (comorbidades.contains(comorbidade))
				return true;
		}
		return false;

	}

	public Map<String, Pessoa> getPessoasCadastradas() {
		return this.pessoasCadastradas;
	}

	public void setPessoasCadastradas(Map<String, Pessoa> pessoasCadastradas) {
		this.pessoasCadastradas = pessoasCadastradas;
	}

	public Set<String> getComorbidades() {
		return this.comorbidades;
	}

	public void setComorbidades(Set<String> comorbidades) {
		this.comorbidades = comorbidades;
	}

	public Set<String> getProfissoes() {
		return this.profissoes;
	}

	public void setProfissoes(Set<String> profissoes) {
		this.profissoes = profissoes;
	}

	public int getIdadeMinima() {
		return this.idadeMinima;
	}
}
