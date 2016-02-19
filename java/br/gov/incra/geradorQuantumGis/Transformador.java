package br.gov.incra.geradorQuantumGis;

import java.util.List;

public interface Transformador {

	public String obterNomePlanilha();

	public String obterNomeAba();

	public String[] obterColunas();

	public Imovel criarRegistro(List<String> celulas);


}
