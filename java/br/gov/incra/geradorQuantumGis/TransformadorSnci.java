package br.gov.incra.geradorQuantumGis;

import java.util.List;

public class TransformadorSnci implements Transformador {

	@Override
	public String obterNomeAba() {
		return "10267_privados";
	}

	@Override
	public String[] obterColunas() {
		String[] colunas = new String[8];
		colunas[0] = "ID10,C,254";
		colunas[1] = "COD_IMOV1,C,254";
		colunas[2] = "NUM_PROC2,C,254";
		colunas[3] = "SR3,C,254";
		colunas[4] = "NUM_CERT4,C,254";
		colunas[5] = "DATA_CER5,C,254";
		colunas[6] = "QTD_AREA6,C,254";
		colunas[7] = "COD_PROF7,C,254";
		return colunas;
	}

	@Override
	public ImovelSnci criarRegistro(List<String> celulas) {
		ImovelSnci imovel = new ImovelSnci();
		imovel.setIdentificador(celulas.get(0));
		imovel.setCodigoSncrImovel(celulas.get(1));
		imovel.setNumero(celulas.get(2));
		imovel.setCodigoSuperintendencia(celulas.get(3));
		imovel.setNumeroCertificacao(celulas.get(4));
		imovel.setDataCertificacao(celulas.get(5));
		imovel.setAreaImovel(celulas.get(6));
		imovel.setCodigoResponsavelTecnico(celulas.get(7));
		return imovel;
	}

}
