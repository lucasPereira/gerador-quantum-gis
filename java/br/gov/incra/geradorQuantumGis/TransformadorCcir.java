package br.gov.incra.geradorQuantumGis;

import java.util.List;

public class TransformadorCcir implements Transformador {

	@Override
	public String obterNomePlanilha() {
		return "ods/ccir.ods";
	}

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
	public ImovelCcir criarRegistro(List<String> celulas) {
		ImovelCcir imovel = new ImovelCcir();
		imovel.setCodigoSncrImovel(celulas.get(1));
		return imovel;
	}

}
