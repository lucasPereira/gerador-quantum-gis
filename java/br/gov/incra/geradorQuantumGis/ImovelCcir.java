package br.gov.incra.geradorQuantumGis;

public class ImovelCcir implements Imovel {

	private String codigoSncrImovel;
	
	@Override
	public String[] comoRegistro() {
		String[] colunas = new String[8];
		colunas[0] = "ID10,C,254";
		colunas[1] = codigoSncrImovel;
		colunas[2] = "NUM_PROC2,C,254";
		colunas[3] = "SR3,C,254";
		colunas[4] = "NUM_CERT4,C,254";
		colunas[5] = "DATA_CER5,C,254";
		colunas[6] = "QTD_AREA6,C,254";
		colunas[7] = "COD_PROF7,C,254";
		return colunas;
	}

	@Override
	public String getCodigoSncrImovel() {
		return codigoSncrImovel;
	}

	public void setCodigoSncrImovel(String codigoSncrImovel) {
		this.codigoSncrImovel = codigoSncrImovel;
	}

}
