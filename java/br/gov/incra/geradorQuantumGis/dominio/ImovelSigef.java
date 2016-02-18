package br.gov.incra.geradorQuantumGis.dominio;

public class ImovelSigef {

	// 00		id,N,10,0				(identificador)						(-)
	// 01		parcela_co,C,64			(código SIGEF imóvel)				(12345678-9abc-def0-1234-56789abcdef0)
	// 02		rt,C,4					(código responsável técnico)		(-)
	// 03		art,C,254				(número responsável técnico)		(-)
	// 04		situacao_i,C,25			(situação jurídica)		 			(Imóvel Registrado; Área Titulada não Registrada; Área não Titulada)
	// 05		transcrica,C,100		(código transcrição registro)		(-)
	// 06		codigo_imo,C,13			(código SNCR imóvel)				(1234567890123)
	// 07		id_envio,N,10,0			(código submissão certificação)		(inteiro sem separador)
	// 08		data_submi,D			(data submissão certificação)		(dd/MM/yyyy)
	// 09		data_aprov,D			(data aprovação certificação)		(dd/MM/yyyy)
	// 10		status,C,32				(situação certificação)				(Certificada e registrada em cartório; Certificada)
	// 11		area_hecta,N,24,15		(área imóvel)						(decimal por virgula sem separador)
	// 12		nome_area,C,141			(nome imóvel)						(-)
	// 13		detentor_n,C,252		(nome proprietário)					(-)
	// 14		detentor_c,C,14			(CPF proprietário)					(12345678901)
	// 15		detentor_1,C,18			(CNPJ proprietário)					(12345678901234)
	// 16		natureza,C,100			(natureza imóvel)					(Assentamento; Estrada; Ferrovia; Floresta Pública; Gleba Pública; Particular; Perímetro Urbano; Terra Indígena; Terreno de Marinha; Terreno Marginal; Território Quilombola; Unidade de Conservação)
	// 17		registro_c,C,254		(código CNS registro)				(12.345-6)
	// 18		registro_m,C,254		(matrícula registro)				(-)
	// 19		registro_d,D			(data registro)						(dd/MM/yyyy)
	// 20		registro_1,C,254		(CPF registrador)					(12345678901)
	// 21		registro_n,C,254		(nome registrador)					(-)
	// 22		registro_2,C,254		(CNPJ registrador)					(12345678901234)
	// 23		municipio_,N,10,0		(código cidade imóvel)				(-)
	// 24		uf_id,N,10,0			(código estado imóvel)				(-)

	private String codigoSncrImovel;

	public String getCodigoSncrImovel() {
		return codigoSncrImovel;
	}

	public void setCodigoSncrImovel(String codigoSncrImovel) {
		this.codigoSncrImovel = codigoSncrImovel;
	}

}
