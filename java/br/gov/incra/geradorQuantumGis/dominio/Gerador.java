package br.gov.incra.geradorQuantumGis.dominio;

import java.util.List;

import br.gov.incra.geradorQuantumGis.infraestrutura.Nomeador;

public class Gerador {

	private Nomeador arquivoDevedoresDaReceita;

	public Gerador(Nomeador devedoresDaReceita, Nomeador quantumGis) {
		this.arquivoDevedoresDaReceita = devedoresDaReceita;
	}

	public void gerar() {
		List<DevedorComImovel> devedoresDaReceita = new LeitorDeDevedoresDaReceita(arquivoDevedoresDaReceita).carregar();
		List<DevedorComImovel> imoveisQuantumGis = new LeitorDeDevedoresDaReceita(arquivoDevedoresDaReceita).carregar();
	}

}
