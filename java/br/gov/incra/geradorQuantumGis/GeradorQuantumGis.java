package br.gov.incra.geradorQuantumGis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class GeradorQuantumGis {

	public static void main(String[] argumentos) {
		new GeradorQuantumGis().iniciar();
	}

	private void iniciar() {
		mostrarInstrucoes();
		sigef();
		mostrarTermino();
	}

	private void sigef() {
		Transformador transformadorSncr = new TransformadorSncr();
		IteradorIndexadorPorCodigoImovel indexadorCodigoImovel = new IteradorIndexadorPorCodigoImovel();
		IteradorIndexadorPorDocumentoProprietario indexadorDocumentoProprietario = new IteradorIndexadorPorDocumentoProprietario();
		Leitor leitorSncr = new Leitor(transformadorSncr, indexadorCodigoImovel, indexadorDocumentoProprietario);
		try {
			leitorSncr.ler("entrada/devedores.ods");
			Map<String, Imovel> indicePorCodigoImovel = indexadorCodigoImovel.obterEstruturaDeBusca();
			Map<String, Imovel> indicePorDocumentoProprietario = indexadorDocumentoProprietario.obterEstruturaDeBusca();
			snci(indicePorCodigoImovel);
			sigef(indicePorCodigoImovel, indicePorDocumentoProprietario);
		} catch (FileNotFoundException excecao) {
			mostrarErro("entrada/devedores.ods", "arquivo %s não encontrado");
		} catch (IOException excecao) {
			mostrarErro("entrada/devedores.ods", "problema ao ler o arquivo %s", excecao);
		} catch (RuntimeException excecao) {
			mostrarErro("entrada/devedores.ods", "problema ao processar a planilha %s", excecao);
		}
	}

	private void snci(Map<String, Imovel> indicePorCodigoImovel) {
		Transformador transformadorSnci = new TransformadorSnci();
		List<Imovel> resultadosSnci = new ArrayList<>(indicePorCodigoImovel.size());
		IteradorCombinadorPorCodigoImovel combinadorSnci = new IteradorCombinadorPorCodigoImovel(indicePorCodigoImovel, resultadosSnci);
		try {
			ler("entrada/snci.ods", transformadorSnci, combinadorSnci);
			System.out.println(resultadosSnci.size());
			System.out.println(indicePorCodigoImovel.size());
			escreverSnci(transformadorSnci, resultadosSnci);
		} catch (FileNotFoundException excecao) {
			mostrarAviso("entrada/snci.ods", "arquivo %s não encontrado");
		} catch (IOException excecao) {
			mostrarErro("entrada/snci.ods", "problema ao ler o arquivo %s ", excecao);
		} catch (RuntimeException excecao) {
			mostrarErro("entrada/snci.ods", "problema ao processar a planilha %s", excecao);
		}
	}

	private void sigef(Map<String, Imovel> indicePorCodigoImovel, Map<String, Imovel> indicePorDocumentoProprietario) {
		Transformador transformadorSigef = new TransformadorSigef();
		List<Imovel> resultadosSigefCodigoImovel = new ArrayList<>(indicePorCodigoImovel.size());
		List<Imovel> resultadosSigefDocumentoProprietario = new ArrayList<>(indicePorDocumentoProprietario.size());
		IteradorCombinadorPorCodigoImovel combinadorSigefCodigoImovel = new IteradorCombinadorPorCodigoImovel(indicePorCodigoImovel, resultadosSigefCodigoImovel);
		IteradorCombinadorPorDocumentoProprietario combinadorSigefDocumentoProprietario = new IteradorCombinadorPorDocumentoProprietario(indicePorDocumentoProprietario, resultadosSigefDocumentoProprietario);
		try {
			ler("entrada/sigef.ods", transformadorSigef, combinadorSigefCodigoImovel, combinadorSigefDocumentoProprietario);
			escreverSigefCodigoImovel(transformadorSigef, resultadosSigefCodigoImovel);
			escreverSigefDocumentoProprietario(transformadorSigef, resultadosSigefDocumentoProprietario);
		} catch (FileNotFoundException excecao) {
			mostrarAviso("entrada/sigef.ods", "arquivo %s não encontrado");
		} catch (IOException excecao) {
			mostrarErro("entrada/sigef.ods", "problema ao ler o arquivo %s", excecao);
		} catch (RuntimeException excecao) {
			mostrarErro("entrada/sigef.ods", "problema ao processar a planilha %s", excecao);
		}
	}

	private void escreverSnci(Transformador transformadorSnci, List<Imovel> resultadosSnci) {
		try {
			escrever("saida/snci_devedores.ods", transformadorSnci, resultadosSnci);
			mostrarInformacao("saida/snci_devedores.ods", "planilha %s gerada com sucesso");
		} catch (IOException excecao) {
			mostrarErro("saida/snci_devedores.ods", "problema ao escrever o arquivo %s", excecao);
		}
	}

	private void escreverSigefCodigoImovel(Transformador transformadorSigef, List<Imovel> resultadosSigefCodigoImovel) {
		try {
			escrever("saida/sigef_devedores_codigo_imovel.ods", transformadorSigef, resultadosSigefCodigoImovel);
			mostrarInformacao("entrada/sigef_devedores_codigo_imovel.ods", "planilha %s gerada com sucesso");
		} catch (IOException excecao) {
			mostrarErro("entrada/sigef_devedores_codigo_imovel.ods", "problema ao escrever o arquivo %s", excecao);
		}
	}

	private void escreverSigefDocumentoProprietario(Transformador transformadorSigef, List<Imovel> resultadosSigefDocumentoProprietario) {
		try {
			escrever("saida/sigef_devedores_documento_proprietario.ods", transformadorSigef, resultadosSigefDocumentoProprietario);
			mostrarInformacao("entrada/sigef_devedores_documento_proprietario.ods", "planilha %s gerada com sucesso");
		} catch (IOException excecao) {
			mostrarErro("entrada/sigef_devedores_documento_proprietario.ods", "problema ao escrever o arquivo %s", excecao);
		}
	}

	private void ler(String nome, Transformador transformador, Iterador... iteradores) throws IOException {
		Leitor leitorSigef = new Leitor(transformador, iteradores);
		leitorSigef.ler(nome);
	}

	private void escrever(String nome, Transformador transformador, List<Imovel> resultados) throws IOException {
		new File("saida").mkdirs();
		new File(nome).delete();
		Escritor escritor = new Escritor();
		escritor.incluirAba(transformador, resultados);
		escritor.escrever(nome);
	}

	private void mostrarInstrucoes() {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Instruções:");
		mensagem.append(System.lineSeparator());
		mensagem.append("* Após iniciar a execução, aguarde até ser informado que o processamento foi concluído. Isso pode levar algum tempo.");
		mensagem.append(System.lineSeparator());
		mensagem.append("* O arquivo de devedores DEVE ser colocado em: {pasta do programa}/entrada/devedores.ods.");
		mensagem.append(System.lineSeparator());
		mensagem.append("* O arquivo de imóveis SNCI PODE ser colocado em: {pasta do programa}/entrada/snci.ods.");
		mensagem.append(System.lineSeparator());
		mensagem.append("* O arquivo de imóveis SIGEF PODE ser colocado em: {pasta do programa}/entrada/sigef.ods.");
		mensagem.append(System.lineSeparator());
		mensagem.append(System.lineSeparator());
		mensagem.append("Avisos:");
		mensagem.append(System.lineSeparator());
		mensagem.append("* Caso o arquivo de imóveis SNCI seja fornecido, será gerado o arquivo: {pasta do programa}/saida/snci_devedores.ods");
		mensagem.append(System.lineSeparator());
		mensagem.append("* Caso o arquivo de imóveis SIGEF seja fornecido, será gerado o arquivo: {pasta do programa}/saida/sigef_devedores_codigo_imovel.ods");
		mensagem.append(System.lineSeparator());
		mensagem.append("* Caso o arquivo de imóveis SIGEF seja fornecido, será gerado o arquivo: {pasta do programa}/saida/sigef_devedores_documento_proprietario.ods");
		Integer resposta = JOptionPane.showConfirmDialog(null, mensagem, "Gerador QuantumGis", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (resposta != JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}

	private void mostrarTermino() {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Processamento concluído.");
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private void mostrarInformacao(String parametro, String conteudo) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("INFORMAÇÃO: ");
		mensagem.append(String.format(conteudo, parametro));
		mensagem.append(".");
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private void mostrarAviso(String parametro, String conteudo) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("AVISO: ");
		mensagem.append(String.format(conteudo, parametro));
		mensagem.append(".");
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private void mostrarErro(String parametro, String conteudo) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("ERRRO: ");
		mensagem.append(String.format(conteudo, parametro));
		mensagem.append(".");
		JOptionPane.showMessageDialog(null, mensagem);
	}

	private void mostrarErro(String parametro, String conteudo, Exception excecao) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("ERRRO: ");
		mensagem.append(String.format(conteudo, parametro));
		mensagem.append(".");
		mensagem.append(System.lineSeparator());
		mensagem.append(System.lineSeparator());
		mensagem.append("Mensagem do erro: ");
		mensagem.append(System.lineSeparator());
		mensagem.append(excecao.getMessage());
		mensagem.append(".");
		mensagem.append(System.lineSeparator());
		mensagem.append(System.lineSeparator());
		mensagem.append("Rastreamento do erro: ");
		for (StackTraceElement elemento : excecao.getStackTrace()) {
			if (elemento.getClassName().contains(GeradorQuantumGis.class.getPackage().getName())) {
				mensagem.append(System.lineSeparator());
				mensagem.append(elemento.getClassName());
				mensagem.append(".");
				mensagem.append(elemento.getMethodName());
				mensagem.append(":");
				mensagem.append(elemento.getLineNumber());
				mensagem.append(".");
			}
		}
		JOptionPane.showMessageDialog(null, mensagem);
	}

}
