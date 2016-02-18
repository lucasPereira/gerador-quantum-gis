package br.gov.incra.geradorQuantumGis;

public class ImovelSncr implements Imovel {

	// 00 CNPJ/CPF (documento proprietário) (123.456.789-01 ou
	// 12.345.678/9012-34)
	// 01 NOME DA EMPRESA OU PESSOA (nome proprietário) (-)
	// 02 DÍVIDA PGFN (dívida proprietário) (decimal com separador)
	// 03 CÓDIGO INCRA (código SNCR imóvel) (123.456.789.012-3)
	// 04 NOME DO IMÓVEL (nome imóvel) (-)
	// 05 ÁREA (ha) (área imóvel) (decimal com separador)
	// 06 MUNICÍPIO (cidade imóvel) (-)
	// 07 UF (estado imóvel) (-)

	private String documentoProprietario;
	private String nomeProprietario;
	private String dividaProprietario;
	private String codigoSncrImovel;
	private String nomeImovel;
	private String areaImovel;
	private String cidadeImovel;
	private String estadoImovel;

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
