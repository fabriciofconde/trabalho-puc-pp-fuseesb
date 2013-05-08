package puc.pp.portalacademico.fila;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class RecebedorMensagem {

	private String fila;

	private GerenciadorSessaoFila gerenciador = new GerenciadorSessaoFila();

	private String correlationID;

	public RecebedorMensagem(String fila) {
		this.fila = fila;
	}

	/**
	 * Lê uma mensagem da fila.
	 * 
	 * @return A mensagem.
	 */
	public String receberMensagem() {
		String mensagemTexto = null;
		try {
			Session sessao = gerenciador.criarSessao();
			Destination destino = sessao.createQueue(fila);
			MessageConsumer consumer = sessao.createConsumer(destino);
			Message mensagem = consumer.receive(1000);
			consumer.close();
			if (mensagem == null) {
				return "";
			}
			if (mensagem instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) mensagem;
				mensagemTexto = textMessage.getText();
			}
			System.out.println("Mensagem recebida: " + mensagemTexto);
			try {
				correlationID = mensagem.getJMSCorrelationID();
			} catch (JMSException e) {
				e.printStackTrace();
			}
			gerenciador.fecharSessao();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return mensagemTexto;
	}

	public String getCorrelationID() {
		return correlationID;
	}
}
