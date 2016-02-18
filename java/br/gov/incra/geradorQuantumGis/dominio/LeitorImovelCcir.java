package br.gov.incra.geradorQuantumGis.dominio;

import br.gov.incra.geradorQuantumGis.infraestrutura.LeitorDeArquivo;
import br.gov.incra.geradorQuantumGis.infraestrutura.Nomeador;

public class LeitorImovelCcir extends LeitorDeArquivo<ImovelCcir> {

	public LeitorImovelCcir(Nomeador nomeador) {
		super(nomeador, 8);
	}

	@Override
	protected ImovelCcir receberElemento(String... colunas) {
		ImovelCcir imovel = new ImovelCcir();
		imovel.setCodigoSncrImovel(colunas[1]);
		return imovel;
	}

}
