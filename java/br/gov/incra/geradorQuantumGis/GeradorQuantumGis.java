package br.gov.incra.geradorQuantumGis;

import java.io.IOException;

public class GeradorQuantumGis {

	public static void main(String[] argumentos) throws IOException {
		Leitor leitor = new Leitor();

		Transformador transformadorSncr = new TransformadorSncr();
		IteradorCriadorDeEstrutura iteradorEstruturaDeBusca = new IteradorCriadorDeEstrutura();
		leitor.ler(transformadorSncr, iteradorEstruturaDeBusca);
		
//		Transformador transformadorCir = new TransformadorCcir();
		Transformador transformadorSigef= new TransformadorSigef();
		Iterador iteradorBuscadorEmEstrutura = new IteradorBuscadorEmEstrutura(iteradorEstruturaDeBusca.obterEstruturaDeBusca());
		leitor.ler(transformadorSigef, iteradorBuscadorEmEstrutura);
	}

}
