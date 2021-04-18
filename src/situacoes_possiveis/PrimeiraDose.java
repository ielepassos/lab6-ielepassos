package situacoes_possiveis;

import entidades.Pessoa;

public class PrimeiraDose extends Situacao{

    @Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " não é possível ir para a próxima fase sem ter tomado a primeira dose da vacina.\n\n");
        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        pessoa.setSituacao(new TomouPrimeiraDose());
        System.out.println(pessoa.getNome() + " tomou a primeira dose da vacina e está em fase de espera(20 dias) para a próxima dose.\n\n");
        
    }

    @Override
    public String toString(){
        return "Habilitada para a primiera dose da vacina";
    }
    
}
