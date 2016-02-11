package br.gov.incra.geradorQuantumGis.dominio;

import br.gov.incra.geradorQuantumGis.infraestrutura.LeitorDeArquivo;
import br.gov.incra.geradorQuantumGis.infraestrutura.Nomeador;

public class LeitorDeDevedoresDaReceita extends LeitorDeArquivo<DevedorComImovel> {

	public LeitorDeDevedoresDaReceita(Nomeador nomeador) {
		super(nomeador);
	}

	@Override
	protected DevedorComImovel receberElemento(String... colunas) {
		DevedorComImovel devedorComImovel = new DevedorComImovel();

		devedorComImovel.setDocumento(colunas[1]);
		devedorComImovel.setNomeDoProprietario(colunas[2]);
		devedorComImovel.setDivida(colunas[4]);

		devedorComImovel.setCodigo(colunas[6]);
		devedorComImovel.setNomeDoImovel(colunas[7]);
		devedorComImovel.setArea(colunas[9]);
		devedorComImovel.setCidade(colunas[10]);
		devedorComImovel.setEstado(colunas[11]);
		devedorComImovel.setDataDeEntrega(colunas[12]);
		devedorComImovel.setSituacaoDaDeclaracao(colunas[13]);

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
