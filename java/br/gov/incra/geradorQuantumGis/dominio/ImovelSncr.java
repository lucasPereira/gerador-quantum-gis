package br.gov.incra.geradorQuantumGis.dominio;

public class ImovelSncr {
	
	// 00 CNPJ/CPF						(documento do proprietário)				(123.456.789-01 ou 12.345.678/9012-34)
	// 01 NOME DA EMPRESA OU PESSOA		(nome do proprietário)					(-)
	// 02 DÍVIDA PGFN					(dívida do proprietário na receita)		(decimal com separador)
	// 03 CÓDIGO INCRA					(código SNCR do imóvel)					(123.456.789.012-3)
	// 04 NOME DO IMÓVEL				(nome do imóvel)						(-)
	// 05 ÁREA (ha)						(área do imóvel)						(decimal com separador)
	// 06 MUNICÍPIO						(cidade do imóvel)						(-)
	// 07 UF							(estado do imóvel)						(-)

	private String documento;
	private String nomeDoProprietario;
	private String divida;
	private String codigoSncr;
	private String nome;
	private String area;
	private String cidade;
	private String estado;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNomeDoProprietario() {
		return nomeDoProprietario;
	}

	public void setNomeDoProprietario(String nomeDoProprietario) {
		this.nomeDoProprietario = nomeDoProprietario;
	}

	public String getDivida() {
		return divida;
	}

	public void setDivida(String divida) {
		this.divida = divida;
	}

	public String getCodigoSncr() {
		return codigoSncr;
	}

	public void setCodigoSncr(String codigoSncr) {
		this.codigoSncr = codigoSncr;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
