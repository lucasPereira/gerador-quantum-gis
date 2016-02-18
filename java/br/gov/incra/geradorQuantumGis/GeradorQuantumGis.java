package br.gov.incra.geradorQuantumGis;

import java.io.IOException;
import java.util.List;

import br.gov.incra.geradorQuantumGis.dominio.ImovelCcir;
import br.gov.incra.geradorQuantumGis.dominio.ImovelSigef;
import br.gov.incra.geradorQuantumGis.dominio.ImovelSncr;
import br.gov.incra.geradorQuantumGis.dominio.LeitorImovelCcir;
import br.gov.incra.geradorQuantumGis.dominio.LeitorImovelSigef;
import br.gov.incra.geradorQuantumGis.dominio.LeitorImovelSncr;

public class GeradorQuantumGis {

	public static void main(String[] argumentos) throws IOException {
		sncr();
		ccir();
		sigef();
	}

	protected static void sncr() throws IOException {
		List<ImovelSncr> imoveisSncr = new LeitorImovelSncr().carregar();
		System.out.println(imoveisSncr.size());
		System.out.println(imoveisSncr.get(0).getCodigoSncrImovel());
		System.out.println(imoveisSncr.get(0).getNomeImovel());
		System.out.println(imoveisSncr.get(0).getAreaImovel());
		System.out.println(imoveisSncr.get(0).getCidadeImovel());
		System.out.println(imoveisSncr.get(0).getEstadoImovel());
		System.out.println(imoveisSncr.get(0).getDocumentoProprietario());
		System.out.println(imoveisSncr.get(0).getNomeProprietario());
		System.out.println(imoveisSncr.get(0).getDividaProprietario());
	}

	protected static void sigef() throws IOException {
		List<ImovelSigef> imoveisSigef = new LeitorImovelSigef().carregar();
		System.out.println(imoveisSigef.size());
		System.out.println(imoveisSigef.get(0).getCodigoSncrImovel());
	}

	protected static void ccir() throws IOException {
		List<ImovelCcir> imoveisCcir = new LeitorImovelCcir().carregar();
		System.out.println(imoveisCcir.size());
		System.out.println(imoveisCcir.get(0).getCodigoSncrImovel());
	}

}
