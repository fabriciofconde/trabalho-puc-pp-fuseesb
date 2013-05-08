package puc.pp.portalacademico.fila;

public class MensagemSincrona {

	private EnviadorMensagem enviadorMensagem;
	private RecebedorMensagem recebedorMensagem;

	private String correlationID;

	public MensagemSincrona(String filaEntrada, String filaSaida) {
		this(filaEntrada, filaSaida, null);
	}

	public MensagemSincrona(String filaEntrada, String filaSaida, String filaRetorno) {
		this.enviadorMensagem = new EnviadorMensagem(filaEntrada, filaRetorno);
		this.recebedorMensagem = new RecebedorMensagem(filaSaida);
	}

	public String enviarMensagem(String mensagem) {
		enviadorMensagem.enviarMensagem(mensagem);
		String retorno = recebedorMensagem.receberMensagem();
		correlationID = recebedorMensagem.getCorrelationID();
		return retorno;
	}

	public String getCorrelationID() {
		return correlationID;
	}
}
