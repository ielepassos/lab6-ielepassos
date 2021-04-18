package main;

import java.util.Scanner;

import entidades.Vacinarias;

public class Main {
	
	public static void main(String[] args) {
		
		Vacinarias sistema = new Vacinarias();
		
		String menu = "\n\n------------- Seja Bem-Vinde ao 'Vacinarias?' -------------\n\n" + "Por favor, escolha o número que melhor corresponde ao serviço desejado: \n\n"
				+ "1  - Cadastrar pessoa \n" 
				+ "2  - Alterar comorbidades de uma pessoa \n"
				+ "3  - Alterar profissão de uma pessoa \n" 
				+ "4  - Consultar a situação de uma pessoa \n"
				+ "5  - Vacinar pessoa \n" 
				+ "6  - Passar pessoa para próxima etapa de vacinação \n"
				+ "7  - Listar pessoas que que não estão aptas para se vacinarem\n"
				+ "8  - Listar pessoas aptas a tomar a 1ª dose \n"
				+ "9  - Listar pessoas aptas a tomar a 2ª dose  \n" 
				+ "10 - Listar pessoas que já tomaram a 1ª dose \n"
				+ "11 - Listar pessoas que já foram imunizadas \n" 
				+ "12 - Detalhes da vacinação \n"
				+ "13 - Adicionar comorbidade apta para vacinação\n"
				+ "14 - Adicionar profissão apta para vacinação\n"
				+ "15 - Atualizar idade mínima para vacinação\n" 
				+ "0  - Sair\n";

		Scanner scan = new Scanner(System.in);
		int nEscolhido;

		while (true) {
			System.out.println(menu);
			System.out.println("Por favor, digite o número escolhido: ");
			nEscolhido = scan.nextInt();
			scan.nextLine();
			String cpf;
			String comorbidades;
			String profissao;
			switch (nEscolhido) {
			case (1):
				cadastrarPessoa(scan, sistema);
				break;
				
			case (2):
				System.out.println("Por favor, digite o cpf da pessoa:");
				cpf = scan.nextLine();
				System.out.println("Por favor, informe as comorbidades da pessoa (separadas por espaço):");
				comorbidades = scan.nextLine();
				sistema.setPessoaComorbidades(cpf, comorbidades);
				break;
				
			case (3):
				System.out.println("Por favor, digite o cpf da pessoa:");
				cpf = scan.nextLine();
				System.out.println("Por favor, informe a profissão da pessoa:");
				profissao = scan.nextLine();
				sistema.setProfissaoPessoa(cpf, profissao);
				break;
				
			case (4):
				System.out.println("Por favor, digite o cpf da pessoa:");
				cpf = scan.nextLine();
				sistema.getSituacaoPessoa(cpf);
				break;
				
			case (5):
				System.out.println("Por favor, digite o cpf da pessoa:");
				cpf = scan.nextLine();
				sistema.tomaVacina(cpf);
				break;
			case (6):
				System.out.println("Por favor, digite o cpf da pessoa:");
				cpf = scan.nextLine();
				sistema.avancaEtapa(cpf);
				break;
				
			case (7):
				sistema.listaPessoasNaoAptas();
				break;
				
			case (8):
				sistema.listaPessoasAptas1Dose();
				break;
				
			case (9):
				sistema.listaPessoasAptas2Dose();
				break;
				
			case (10):
				sistema.listaPessoasQTomaram1Dose();
				break;
				
			case (11):
				sistema.listaPessoasImunizadas();
				break;
				
			case (12):
				sistema.getDetalhes();
				break;
				
			case (13):
				System.out.println("Por favor, informe a comorbidade a ser adicionada como apta para a vacinação:");
				comorbidades = scan.nextLine();
				sistema.adicionaComorbidadeApta(comorbidades);
				break;
				
			case (14):
				System.out.println("Por favor,informe a a profissão que será adicionada como apta para a vacinaçao:");
				profissao = scan.nextLine();
				sistema.adicionaProfissaoApta(profissao);
				break;
				
			case (15):
				System.out.println("Por favor,informe a nova idade mínima para vacinação:");
				int idade = scan.nextInt();
				scan.nextLine();
				sistema.setIdadeMinimaApta(idade);
				break;
				
			case (0):
				break;
			default:
				System.out.println("Essa opção não faz parte do sistema.\n\n");
			}

			if (nEscolhido == 0) {
				System.out.println("Obrigade por usar o dosso sistema! \nDEFENDA O SUS!");
				break;
			}
		}

	}

	public static void cadastrarPessoa(Scanner scan, Vacinarias sistema) {

		String nome;
		String cpf;
		int idade;
		String endereco;
		String cartaoSUS;
		String email;
		String telefone;
		String profissao;
		String comorbidades;

		System.out.println("Por favor, informe o nome completo da pessoa:");
		nome = scan.nextLine();

		System.out.println("Por favor, digite o cpf da pessoa:");
		cpf = scan.nextLine();

		System.out.println("Por favor, informe a idade da pessoa:");
		idade = scan.nextInt();
		scan.nextLine();

		System.out.println("Por favor, informe o endereço da pessoa:");
		endereco = scan.nextLine();

		System.out.println("Por favor, informe o número do cartão do SUS:");
		cartaoSUS = scan.nextLine();

		System.out.println("Por favor, informe o email da pessoa:");
		email = scan.nextLine();

		System.out.println("Por favor, informe o telefone da pessoa:");
		telefone = scan.nextLine();

		System.out.println("Por favor, informe a profissão da pessoa:");
		profissao = scan.nextLine();

		System.out.println("Por favor,informe as comorbidades da pessoa (separadas por espaço):");
		comorbidades = scan.nextLine();

		sistema.adicionaPessoa(nome, cpf, idade, endereco, cartaoSUS, email, telefone, profissao, comorbidades);

	}

}
