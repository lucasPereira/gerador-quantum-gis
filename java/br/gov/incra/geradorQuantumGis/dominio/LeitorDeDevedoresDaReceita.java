package br.gov.incra.geradorQuantumGis.dominio;

import br.gov.incra.geradorQuantumGis.infraestrutura.LeitorDeArquivo;
import br.gov.incra.geradorQuantumGis.infraestrutura.Nomeador;

public class LeitorDeDevedoresDaReceita extends LeitorDeArquivo<ImovelSncr> {

	public LeitorDeDevedoresDaReceita(Nomeador nomeador) {
		super(nomeador);
	}

	@Override
	protected ImovelSncr receberElemento(String... colunas) {
		ImovelSncr devedorComImovel = new ImovelSncr();

		devedorComImovel.setDocumento(colunas[0]);
		devedorComImovel.setNomeDoProprietario(colunas[1]);
		devedorComImovel.setDivida(colunas[2]);

		devedorComImovel.setCodigoSncr(colunas[3]);
		devedorComImovel.setNome(colunas[4]);
		devedorComImovel.setArea(colunas[5]);
		devedorComImovel.setCidade(colunas[6]);
		devedorComImovel.setEstado(colunas[7]);

		
		// 00 devedor.obterIdentificador()
		// 01 devedor.obterIdentificadorApenasComNumeros()
		// 02 devedor.obterNome()
		// 03 devedor.obterValorDaDivida()
		// 04 devedor.obterValorDaDividaDecimal()

		// 05 imovel.obterCodigo()
		// 06 imovel.obterCodigoApenasComNumeros()
		// 07 imovel.obterNome()
		// 08 imovel.obterArea()
		// 09 imovel.obterAreaApenasComNumeros()
		// 10 imovel.obterCidade()
		// 11 imovel.obterEstado()
		// 12 imovel.obterDataDeEntrega()
		// 13 imovel.obterSituacaoDaDeclaracao()

		return devedorComImovel;
	}

}
