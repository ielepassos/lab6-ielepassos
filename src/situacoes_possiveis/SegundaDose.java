package situacoes_possiveis;

import entidades.Pessoa; 

public class SegundaDose extends Situacao{

    @Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " não é possível ir para a próxima fase sem ter tomado a primeira dose da vacina.\n\n");
        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        pessoa.setSituacao(new VacinacaoFinalizada());
        System.out.println(pessoa.getNome() + "já tomou a segunda dose da vacina e está imunizada! Viva ao SUS!\n\n");
        
    }

    @Override
    public String toString(){
        return "Habilitada para a 2ª dose da vacina!";
    }
    
}
