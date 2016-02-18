package br.gov.incra.geradorQuantumGis;

import java.util.List;

import br.gov.incra.geradorQuantumGis.dominio.ImovelCcir;
import br.gov.incra.geradorQuantumGis.dominio.ImovelSigef;
import br.gov.incra.geradorQuantumGis.dominio.ImovelSncr;
import br.gov.incra.geradorQuantumGis.dominio.LeitorImovelCcir;
import br.gov.incra.geradorQuantumGis.dominio.LeitorImovelSigef;
import br.gov.incra.geradorQuantumGis.dominio.LeitorImovelSncr;
import br.gov.incra.geradorQuantumGis.infraestrutura.NomeadorEstaticoCsv;

public class GeradorQuantumGis {

	public static void main(String[] args) {
		sncr();
		ccir();
		sigef();
	}

	protected static void sigef() {
		List<ImovelSigef> imoveisSigef = new LeitorImovelSigef(new NomeadorEstaticoCsv("sigef")).carregar();
		System.out.println(imoveisSigef.size());
		System.out.println(imoveisSigef.get(0).getCodigoSncrImovel());
	}

	protected static void ccir() {
		List<ImovelCcir> imoveisCcir = new LeitorImovelCcir(new NomeadorEstaticoCsv("ccir")).carregar();
		System.out.println(imoveisCcir.get(0).getCodigoSncrImovel());
		System.out.println(imoveisCcir.size());
	}

	protected static void sncr() {
		List<ImovelSncr> imoveisSncr = new LeitorImovelSncr(new NomeadorEstaticoCsv("sncr")).carregar();
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

}
