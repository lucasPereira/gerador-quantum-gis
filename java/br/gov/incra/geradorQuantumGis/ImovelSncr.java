package br.gov.incra.geradorQuantumGis;

public class ImovelSncr implements Imovel {

	private String documentoProprietario;
	private String nomeProprietario;
	private String dividaProprietario;
	private String codigoSncrImovel;
	private String nomeImovel;
	private String areaImovel;
	private String cidadeImovel;
	private String estadoImovel;

	@Override
	public String[] comoRegistro() {
		String[] colunas = new String[8];
		colunas[0] = documentoProprietario;
		colunas[1] = nomeProprietario;
		colunas[2] = dividaProprietario;
		colunas[3] = codigoSncrImovel;
		colunas[4] = nomeImovel;
		colunas[5] = areaImovel;
		colunas[6] = cidadeImovel;
		colunas[7] = estadoImovel;
		return colunas;
	}

	public String getDocumentoProprietario() {
		return documentoProprietario;
	}

	public void setDocumentoProprietario(String documentoProprietario) {
		this.documentoProprietario = documentoProprietario;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getDividaProprietario() {
		return dividaProprietario;
	}

	public void setDividaProprietario(String dividaProprietario) {
		this.dividaProprietario = dividaProprietario;
	}

	@Override
	public String getCodigoSncrImovel() {
		return codigoSncrImovel;
	}

	public void setCodigoSncrImovel(String codigoSncrImovel) {
		this.codigoSncrImovel = codigoSncrImovel.replaceAll("[.]|[-]", "");
	}

	public String getNomeImovel() {
		return nomeImovel;
	}

	public void setNomeImovel(String nomeImovel) {
		this.nomeImovel = nomeImovel;
	}

	public String getAreaImovel() {
		return areaImovel;
	}

	public void setAreaImovel(String areaImovel) {
		this.areaImovel = areaImovel;
	}

	public String getCidadeImovel() {
		return cidadeImovel;
	}

	public void setCidadeImovel(String cidadeImovel) {
		this.cidadeImovel = cidadeImovel;
	}

	public String getEstadoImovel() {
		return estadoImovel;
	}

	public void setEstadoImovel(String estadoImovel) {
		this.estadoImovel = estadoImovel;
	}

}
