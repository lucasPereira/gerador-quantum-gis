package br.gov.incra.geradorQuantumGis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeradorQuantumGis {

	public static void main(String[] argumentos) throws IOException {
		Leitor leitor = new Leitor();

		Transformador transformadorReferencia = new TransformadorSncr();
		IteradorCriadorDeEstrutura iteradorEstruturaDeBusca = new IteradorCriadorDeEstrutura();
		leitor.ler(transformadorReferencia, iteradorEstruturaDeBusca);
		Map<String, Imovel> estrutura = iteradorEstruturaDeBusca.obterEstruturaDeBusca();
		List<Imovel> resultados = new ArrayList<>(estrutura.size());

		IteradorBuscadorEmEstrutura iteradorBuscadorEmEstrutura = new IteradorBuscadorEmEstrutura(estrutura, resultados);
		leitor.ler(new TransformadorCcir(), iteradorBuscadorEmEstrutura);
		leitor.ler(new TransformadorSigef(1), iteradorBuscadorEmEstrutura);
		leitor.ler(new TransformadorSigef(2), iteradorBuscadorEmEstrutura);
		leitor.ler(new TransformadorSigef(3), iteradorBuscadorEmEstrutura);

		System.out.println(resultados.size());
	}

}
