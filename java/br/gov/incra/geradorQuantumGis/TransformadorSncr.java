package br.gov.incra.geradorQuantumGis;

import java.util.List;

public class TransformadorSncr implements Transformador {

	@Override
	public String obterNomeAba() {
		return "Devedores";
	}

	@Override
	public String[] obterColunas() {
		String[] colunas = new String[8];
		colunas[0] = "CNPJ/CPF";
		colunas[1] = "NOME DA EMPRESA OU PESSOA";
		colunas[2] = "DÍVIDA PGFN";
		colunas[3] = "CÓDIGO INCRA";
		colunas[4] = "NOME DO IMÓVEL";
		colunas[5] = "ÁREA (ha)";
		colunas[6] = "MUNICÍPIO";
		colunas[7] = "UF";
		return colunas;
	}

	@Override
	public ImovelSncr criarRegistro(List<String> celulas) {
		ImovelSncr imovel = new ImovelSncr();
		imovel.setDocumentoProprietario(celulas.get(0));
		imovel.setNomeProprietario(celulas.get(1));
		imovel.setDividaProprietario(celulas.get(2));
		imovel.setCodigoSncrImovel(celulas.get(3));
		imovel.setNomeImovel(celulas.get(4));
		imovel.setAreaImovel(celulas.get(5));
		imovel.setCidadeImovel(celulas.get(6));
		imovel.setEstadoImovel(celulas.get(7));
		return imovel;
	}

}
