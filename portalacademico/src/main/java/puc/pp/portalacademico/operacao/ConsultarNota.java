package puc.pp.portalacademico.operacao;

import puc.pp.portalacademico.fila.MensagemSincrona;

public class ConsultarNota {

	private static String FILA_ENTRADA = "fila.consultar.nota";
	private static String FILA_SAIDA = "fila.resultado.nota";
	
	private MensagemSincrona mensagemSincrona;
	
	public ConsultarNota() {
		mensagemSincrona = new MensagemSincrona(FILA_ENTRADA, FILA_SAIDA);
	}
	
	public String consultar(String disciplina) {
		return mensagemSincrona.enviarMensagem(disciplina);
	}
}
