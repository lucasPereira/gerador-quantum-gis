package br.gov.incra.geradorQuantumGis.infraestrutura;

public class NomeadorEstaticoCsv implements Nomeador {

	private String nome;

	public NomeadorEstaticoCsv(String nome) {
		this.nome = "csv/" + nome + ".csv";
	}

	@Override
	public String obterNome() {
		return nome;
	}

	@Override
	public String obterDiretorio() {
		return "csv/";
	}

}
