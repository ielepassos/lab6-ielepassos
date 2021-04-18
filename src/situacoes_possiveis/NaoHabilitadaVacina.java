package situacoes_possiveis;

import entidades.Pessoa;

public class NaoHabilitadaVacina extends Situacao{
    @Override
    public void mudaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new PrimeiraDose());
        System.out.println(pessoa.getNome() + " está apta para tomar a primeira dose da vacina. \n\n");
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println(pessoa.getNome()+ " ainda não está apta para tomar a primeira dose da vacina.\n\n");
        
    }
    @Override
    public String toString() {
        return "Não apta para a primeira dose da vacina";
    }
}
