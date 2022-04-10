package br.gov.incra.geradorQuantumGis;

public class ImovelSigef implements Imovel {

	private String identificador;
	private String codigoSigefImovel;
	private String codigoResponsavelTecnico;
	private String numeroResponsavelTecnico;
	private String situacaoJuridicaImovel;
	private String codigoTranscricaoRegistro;
	private String codigoSncrImovel;
	private String codigoSubmissaoCertificacao;
	private String dataSubmissaoCertificacao;
	private String dataAprovacaoCertificacao;
	private String situacaoCertificacao;
	private String areaImovel;
	private String nomeImovel;
	private String nomeProprietario;
	private String cpfProprietario;
	private String cnpjProprietario;
	private String naturezaImovel;
	private String codigoCnsRegistro;
	private String matriculaRegistro;
	private String dataRegistro;
	private String cpfRegistrador;
	private String nomeRegistrador;
	private String cnpjRegistrador;
	private String codigoCidade;
	private String codigoEstado;

	@Override
	public String[] comoRegistro() {
		String[] colunas = new String[25];
		colunas[0] = identificador;
		colunas[1] = codigoSigefImovel;
		colunas[2] = codigoResponsavelTecnico;
		colunas[3] = numeroResponsavelTecnico;
		colunas[4] = situacaoJuridicaImovel;
		colunas[5] = codigoTranscricaoRegistro;
		colunas[6] = codigoSncrImovel;
		colunas[7] = codigoSubmissaoCertificacao;
		colunas[8] = dataSubmissaoCertificacao;
		colunas[9] = dataAprovacaoCertificacao;
		colunas[10] = situacaoCertificacao;
		colunas[11] = areaImovel;
		colunas[12] = nomeImovel;
		colunas[13] = nomeProprietario;
		colunas[14] = cpfProprietario;
		colunas[15] = cnpjProprietario;
		colunas[16] = naturezaImovel;
		colunas[17] = codigoCnsRegistro;
		colunas[18] = matriculaRegistro;
		colunas[19] = dataRegistro;
		colunas[20] = cpfRegistrador;
		colunas[21] = nomeRegistrador;
		colunas[22] = cnpjRegistrador;
		colunas[23] = codigoCidade;
		colunas[24] = codigoEstado;
		return colunas;
	}

	@Override
	public String getCodigoSncrImovel() {
		return codigoSncrImovel;
	}

	@Override
	public String getDocumentoProprietario() {
		if (!cpfProprietario.trim().isEmpty()) {
			return cpfProprietario;
		} else if (!cnpjProprietario.trim().isEmpty()) {
			return cnpjProprietario;
		} else if (!cpfRegistrador.trim().isEmpty()) {
			return cpfRegistrador;
		} else if (!cnpjRegistrador.trim().isEmpty()) {
			return cnpjRegistrador;
		}
		return "";
	}

	public void setCodigoSncrImovel(String codigoSncrImovel) {
		this.codigoSncrImovel = codigoSncrImovel;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getCodigoSigefImovel() {
		return codigoSigefImovel;
	}

	public void setCodigoSigefImovel(String codigoSigefImovel) {
		this.codigoSigefImovel = codigoSigefImovel;
	}

	public String getCodigoResponsavelTecnico() {
		return codigoResponsavelTecnico;
	}

	public void setCodigoResponsavelTecnico(String codigoResponsavelTecnico) {
		this.codigoResponsavelTecnico = codigoResponsavelTecnico;
	}

	public String getNumeroResponsavelTecnico() {
		return numeroResponsavelTecnico;
	}

	public void setNumeroResponsavelTecnico(String numeroResponsavelTecnico) {
		this.numeroResponsavelTecnico = numeroResponsavelTecnico;
	}

	public String getSituacaoJuridicaImovel() {
		return situacaoJuridicaImovel;
	}

	public void setSituacaoJuridicaImovel(String situacaoJuridicaImovel) {
		this.situacaoJuridicaImovel = situacaoJuridicaImovel;
	}

	public String getCodigoTranscricaoRegistro() {
		return codigoTranscricaoRegistro;
	}

	public void setCodigoTranscricaoRegistro(String codigoTranscricaoRegistro) {
		this.codigoTranscricaoRegistro = codigoTranscricaoRegistro;
	}

	public String getCodigoSubmissaoCertificacao() {
		return codigoSubmissaoCertificacao;
	}

	public void setCodigoSubmissaoCertificacao(String codigoSubmissaoCertificacao) {
		this.codigoSubmissaoCertificacao = codigoSubmissaoCertificacao;
	}

	public String getDataSubmissaoCertificacao() {
		return dataSubmissaoCertificacao;
	}

	public void setDataSubmissaoCertificacao(String dataSubmissaoCertificacao) {
		this.dataSubmissaoCertificacao = dataSubmissaoCertificacao;
	}

	public String getDataAprovacaoCertificacao() {
		return dataAprovacaoCertificacao;
	}

	public void setDataAprovacaoCertificacao(String dataAprovacaoCertificacao) {
		this.dataAprovacaoCertificacao = dataAprovacaoCertificacao;
	}

	public String getSituacaoCertificacao() {
		return situacaoCertificacao;
	}

	public void setSituacaoCertificacao(String situacaoCertificacao) {
		this.situacaoCertificacao = situacaoCertificacao;
	}

	public String getAreaImovel() {
		return areaImovel;
	}

	public void setAreaImovel(String areaImovel) {
		this.areaImovel = areaImovel;
	}

	public String getNomeImovel() {
		return nomeImovel;
	}

	public void setNomeImovel(String nomeImovel) {
		this.nomeImovel = nomeImovel;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getCpfProprietario() {
		return cpfProprietario;
	}

	public void setCpfProprietario(String cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

	public String getCnpjProprietario() {
		return cnpjProprietario;
	}

	public void setCnpjProprietario(String cnpjProprietario) {
		this.cnpjProprietario = cnpjProprietario;
	}

	public String getNaturezaImovel() {
		return naturezaImovel;
	}

	public void setNaturezaImovel(String naturezaImovel) {
		this.naturezaImovel = naturezaImovel;
	}

	public String getCodigoCnsRegistro() {
		return codigoCnsRegistro;
	}

	public void setCodigoCnsRegistro(String codigoCnsRegistro) {
		this.codigoCnsRegistro = codigoCnsRegistro;
	}

	public String getMatriculaRegistro() {
		return matriculaRegistro;
	}

	public void setMatriculaRegistro(String matriculaRegistro) {
		this.matriculaRegistro = matriculaRegistro;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getCpfRegistrador() {
		return cpfRegistrador;
	}

	public void setCpfRegistrador(String cpfRegistrador) {
		this.cpfRegistrador = cpfRegistrador;
	}

	public String getNomeRegistrador() {
		return nomeRegistrador;
	}

	public void setNomeRegistrador(String nomeRegistrador) {
		this.nomeRegistrador = nomeRegistrador;
	}

	public String getCnpjRegistrador() {
		return cnpjRegistrador;
	}

	public void setCnpjRegistrador(String cnpjRegistrador) {
		this.cnpjRegistrador = cnpjRegistrador;
	}

	public String getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(String codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

}
