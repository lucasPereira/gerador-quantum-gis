package br.gov.incra.geradorQuantumGis.dominio;

import java.util.List;

import br.gov.incra.geradorQuantumGis.infraestrutura.LeitorDeArquivo;

public class LeitorImovelSigef extends LeitorDeArquivo<ImovelSigef> {

	public LeitorImovelSigef() {
		super("ods/imoveisCertificadosPeloIncra.ods", 1);
	}

	@Override
	protected ImovelSigef criarRegistro(List<String> celulas) {
		ImovelSigef imovel = new ImovelSigef();
		imovel.setCodigoSncrImovel(celulas.get(6));
		return imovel;
	}

}
