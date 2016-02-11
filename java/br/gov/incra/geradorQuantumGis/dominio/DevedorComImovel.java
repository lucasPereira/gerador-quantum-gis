package br.gov.incra.geradorQuantumGis.dominio;

public class DevedorComImovel {

	private String documento;
	private String nomeDoProprietario;
	private String divida;
	private String codigo;
	private String nomeDoImovel;
	private String area;
	private String cidade;
	private String estado;
	private String dataDeEntrega;
	private String situacaoDaDeclaracao;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeDoImovel() {
		return nomeDoImovel;
	}

	public void setNomeDoImovel(String nomeDoImovel) {
		this.nomeDoImovel = nomeDoImovel;
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

	public String getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(String dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	public String getSituacaoDaDeclaracao() {
		return situacaoDaDeclaracao;
	}

	public void setSituacaoDaDeclaracao(String situacaoDaDeclaracao) {
		this.situacaoDaDeclaracao = situacaoDaDeclaracao;
	}

}
