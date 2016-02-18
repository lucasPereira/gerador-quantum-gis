package br.gov.incra.geradorQuantumGis;

public class IteradorImpressao implements Iterador {

	@Override
	public void preparar(Integer quantidadeDeLinhas, Integer quantidadeDeColunas) {}

	@Override
	public void iterar(Imovel registro) {
		System.out.println(registro.getCodigoSncrImovel());
	}

}
