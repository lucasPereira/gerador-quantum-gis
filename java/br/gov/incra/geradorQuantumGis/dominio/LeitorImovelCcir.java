package br.gov.incra.geradorQuantumGis.dominio;

import java.util.List;

import br.gov.incra.geradorQuantumGis.infraestrutura.LeitorDeArquivo;

public class LeitorImovelCcir extends LeitorDeArquivo<ImovelCcir> {

	public LeitorImovelCcir() {
		super("ods/imoveisCertificadosPeloIncra.ods", 0);
	}

	@Override
	protected ImovelCcir criarRegistro(List<String> celulas) {
		ImovelCcir imovel = new ImovelCcir();
		imovel.setCodigoSncrImovel(celulas.get(1));
		return imovel;
	}

}
