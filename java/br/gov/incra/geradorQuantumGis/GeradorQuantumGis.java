package br.gov.incra.geradorQuantumGis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeradorQuantumGis {

	public static void main(String[] argumentos) throws IOException {
		Leitor leitor = new Leitor();
		Escritor escritor = new Escritor();

		Transformador transformadorReferencia = new TransformadorSncr();
		IteradorCriadorDeEstrutura iteradorEstruturaDeBusca = new IteradorCriadorDeEstrutura();
		leitor.ler(transformadorReferencia, iteradorEstruturaDeBusca);
		Map<String, Imovel> estrutura = iteradorEstruturaDeBusca.obterEstruturaDeBusca();

		Transformador transformador;
		List<Imovel> resultados = new ArrayList<>(estrutura.size());

		resultados.clear();
		transformador = new TransformadorCcir();
		leitor.ler(transformador, new IteradorBuscadorEmEstrutura(estrutura, resultados));
		escritor.incluirAba(transformador, resultados);
		
		resultados.clear();
		transformador = new TransformadorSigef(1);
		leitor.ler(transformador, new IteradorBuscadorEmEstrutura(estrutura, resultados));
		transformador = new TransformadorSigef(2);
		leitor.ler(transformador, new IteradorBuscadorEmEstrutura(estrutura, resultados));
		transformador = new TransformadorSigef(3);
		leitor.ler(transformador, new IteradorBuscadorEmEstrutura(estrutura, resultados));
		escritor.incluirAba(transformador, resultados);

		escritor.escrever("imoveisCertificadosDeDevedores.ods");
	}

}
