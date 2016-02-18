package br.gov.incra.geradorQuantumGis;

public class ImovelCcir implements Imovel {

	//	00		ID10,C,254			(identificador)					(-)
	//	01		COD_IMOV1,C,254		(código SNCR imóvel)			(1234567890123)
	//	02		NUM_PROC2,C,254		(número procedimento)			(-)
	//	03		SR3,C,254			(código superintendência)		(01)	
	//	04		NUM_CERT4,C,254		(número certificação)			(-)
	//	05		DATA_CER5,C,254		(data certificação)				(dd-MM-yyyy hh:mm:ss.N ou dd-MM-yyyy hh:mm:ss)
	//	06		QTD_AREA6,C,254		(área imóvel)					(decimal por ponto sem separador)
	//	07		COD_PROF7,C,254		(código responsável técnico)	(-)

	private String codigoSncrImovel;

	@Override
	public String getCodigoSncrImovel() {
		return codigoSncrImovel;
	}

	public void setCodigoSncrImovel(String codigoSncrImovel) {
		this.codigoSncrImovel = codigoSncrImovel;
	}
	
}
