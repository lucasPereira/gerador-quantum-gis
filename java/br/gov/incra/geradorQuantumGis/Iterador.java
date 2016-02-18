package br.gov.incra.geradorQuantumGis;

public interface Iterador {

	public void preparar(Integer quantidadeDeLinhas, Integer quantidadeDeColunas);

	public void iterar(Imovel registro);

}
