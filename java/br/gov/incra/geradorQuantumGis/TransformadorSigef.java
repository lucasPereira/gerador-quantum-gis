package br.gov.incra.geradorQuantumGis;

import java.util.List;

public class TransformadorSigef implements Transformador {

	private Integer parte;

	public TransformadorSigef(Integer indice) {
		this.parte = indice;
	}

	@Override
	public String obterNomePlanilha() {
		return String.format("ods/sigef%d.ods", parte);
	}

	@Override
	public String obterNomeAba() {
		return "SIGEF";
	}

	@Override
	public String[] obterColunas() {
		String[] colunas = new String[25];
		colunas[0] = "id,N,10,0";
		colunas[1] = "parcela_co,C,64";
		colunas[2] = "rt,C,4";
		colunas[3] = "art,C,254";
		colunas[4] = "situacao_i,C,25";
		colunas[5] = "transcrica,C,100";
		colunas[6] = "codigo_imo,C,13";
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
	public ImovelSigef criarRegistro(List<String> celulas) {
		ImovelSigef imovel = new ImovelSigef();
		imovel.setIdentificador(celulas.get(0));
		imovel.setCodigoSigefImovel(celulas.get(1));
		imovel.setCodigoResponsavelTecnico(celulas.get(2));
		imovel.setNumeroResponsavelTecnico(celulas.get(3));
		imovel.setSituacaoJuridicaImovel(celulas.get(4));
		imovel.setCodigoTranscricaoRegistro(celulas.get(5));
		imovel.setCodigoSncrImovel(celulas.get(6));
		imovel.setCodigoSubmissaoCertificacao(celulas.get(7));
		imovel.setDataSubmissaoCertificacao(celulas.get(8));
		imovel.setDataAprovacaoCertificacao(celulas.get(9));
		imovel.setSituacaoCertificacao(celulas.get(10));
		imovel.setAreaImovel(celulas.get(11));
		imovel.setNomeImovel(celulas.get(12));
		imovel.setNomeProprietario(celulas.get(13));
		imovel.setCpfProprietario(celulas.get(14));
		imovel.setCnpjProprietario(celulas.get(15));
		imovel.setNaturezaImovel(celulas.get(16));
		imovel.setCodigoCnsRegistro(celulas.get(17));
		imovel.setMatriculaRegistro(celulas.get(18));
		imovel.setDataRegistro(celulas.get(19));
		imovel.setCpfRegistrador(celulas.get(20));
		imovel.setNomeRegistrador(celulas.get(21));
		imovel.setCnpjRegistrador(celulas.get(22));
		imovel.setCodigoCidade(celulas.get(23));
		imovel.setCodigoEstado(celulas.get(24));
		return imovel;
	}

}
