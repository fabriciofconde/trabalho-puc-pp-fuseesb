package puc.pp.portalacademico.operacao;

import puc.pp.portalacademico.fila.MensagemSincrona;

public class ConsultarHistorico {

	private static String FILA_ENTRADA = "fila.consultar.historico";
	private static String FILA_SAIDA = "fila.resultado.historico";
	
	private MensagemSincrona mensagemSincrona;
	
	public ConsultarHistorico() {
		mensagemSincrona = new MensagemSincrona(FILA_ENTRADA, FILA_SAIDA);
	}
	
	public String consultar(String aluno) {
		return mensagemSincrona.enviarMensagem(aluno);
	}
}
