package br.gov.incra.geradorQuantumGis;

public class ImovelSigef implements Imovel {

	private String codigoSncrImovel;

	@Override
	public String[] comoRegistro() {
		String[] colunas = new String[25];
		colunas[0] = "id,N,10,0";
		colunas[1] = "parcela_co,C,64";
		colunas[2] = "rt,C,4";
		colunas[3] = "art,C,254";
		colunas[4] = "situacao_i,C,25";
		colunas[5] = "transcrica,C,100";
		colunas[6] = codigoSncrImovel;
		colunas[7] = "id_envio,N,10,0";
		colunas[8] = "data_submi,D";
		colunas[9] = "data_aprov,D";
		colunas[10] = "status,C,32";
		colunas[11] = "area_hecta,N,24,15";
		colunas[12] = "nome_area,C,141";
		colunas[13] = "detentor_n,C,252";
		colunas[14] = "detentor_c,C,14";
		colunas[15] = "detentor_1,C,18";
		colunas[16] = "natureza,C,100";
		colunas[17] = "registro_c,C,254";
		colunas[18] = "registro_m,C,254";
		colunas[19] = "registro_d,D";
		colunas[20] = "registro_1,C,254";
		colunas[21] = "registro_n,C,254";
		colunas[22] = "registro_2,C,254";
		colunas[23] = "municipio_,N,10,0";
		colunas[24] = "uf_id,N,10,0";
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
