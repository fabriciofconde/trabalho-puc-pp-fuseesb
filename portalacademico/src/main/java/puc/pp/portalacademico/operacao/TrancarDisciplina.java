package puc.pp.portalacademico.operacao;

import puc.pp.portalacademico.fila.MensagemSincrona;

public class TrancarDisciplina {

	private static String FILA_ENTRADA = "fila.trancar.disciplina";
	private static String FILA_SAIDA = "fila.pedido.trancamento";
	public static String FILA_RETORNO_ASSINCRONO = "fila.resultado.trancamento_";

	private MensagemSincrona mensagemSincrona;

	public TrancarDisciplina(String filaRetorno) {
		mensagemSincrona = new MensagemSincrona(FILA_ENTRADA, FILA_SAIDA, FILA_RETORNO_ASSINCRONO.concat(filaRetorno));
	}

	public String trancar(String nomeAluno, String disciplina) {
		String resultado = mensagemSincrona.enviarMensagem(nomeAluno + "\n" + disciplina);
		System.out.println("Correlation ID: " + mensagemSincrona.getCorrelationID());
		
		return resultado;
	}
}
