package br.gov.incra.geradorQuantumGis;

public class ImovelSnci implements Imovel {

	private String identificador;
	private String codigoSncrImovel;
	private String numero;
	private String codigoSuperintendencia;
	private String numeroCertificacao;
	private String dataCertificacao;
	private String areaImovel;
	private String codigoResponsavelTecnico;

	@Override
	public String[] comoRegistro() {
		String[] colunas = new String[8];
		colunas[0] = identificador;
		colunas[1] = codigoSncrImovel;
		colunas[2] = numero;
		colunas[3] = codigoSuperintendencia;
		colunas[4] = numeroCertificacao;
		colunas[5] = dataCertificacao;
		colunas[6] = areaImovel;
		colunas[7] = codigoResponsavelTecnico;
		return colunas;
	}

	@Override
	public String getCodigoSncrImovel() {
		return codigoSncrImovel;
	}
	
	public void setCodigoSncrImovel(String codigoSncrImovel) {
		this.codigoSncrImovel = codigoSncrImovel;
	}

	@Override
	public String getDocumentoProprietario() {
		return "";
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoSuperintendencia() {
		return codigoSuperintendencia;
	}

	public void setCodigoSuperintendencia(String codigoSuperintendencia) {
		this.codigoSuperintendencia = codigoSuperintendencia;
	}

	public String getNumeroCertificacao() {
		return numeroCertificacao;
	}

	public void setNumeroCertificacao(String numeroCertificacao) {
		this.numeroCertificacao = numeroCertificacao;
	}

	public String getDataCertificacao() {
		return dataCertificacao;
	}

	public void setDataCertificacao(String dataCertificacao) {
		this.dataCertificacao = dataCertificacao;
	}

	public String getAreaImovel() {
		return areaImovel;
	}

	public void setAreaImovel(String areaImovel) {
		this.areaImovel = areaImovel;
	}

	public String getCodigoResponsavelTecnico() {
		return codigoResponsavelTecnico;
	}

	public void setCodigoResponsavelTecnico(String codigoResponsavelTecnico) {
		this.codigoResponsavelTecnico = codigoResponsavelTecnico;
	}

}
