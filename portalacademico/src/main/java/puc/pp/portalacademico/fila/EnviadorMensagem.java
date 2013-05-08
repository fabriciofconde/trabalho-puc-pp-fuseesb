package puc.pp.portalacademico.fila;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Envia mensagens para uma fila.
 */
public class EnviadorMensagem {

	private String fila;
	private String filaRetorno;

	private GerenciadorSessaoFila gerenciador = new GerenciadorSessaoFila();

	public EnviadorMensagem(String fila) {
		this(fila, null);
	}

	public EnviadorMensagem(String fila, String filaRetorno) {
		this.fila = fila;
		this.filaRetorno = filaRetorno;
	}

	/**
	 * Envia uma mensagem para a fila.
	 * 
	 * @param mensagem
	 *            A mensagem a ser enviada.
	 */
	public void enviarMensagem(String mensagem) {
		try {
			Session sessao = gerenciador.criarSessao();
			Destination destino = sessao.createQueue(fila);
			MessageProducer producer = sessao.createProducer(destino);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage mensagemTexto = sessao.createTextMessage(mensagem);
			if (filaRetorno != null) {
				mensagemTexto.setStringProperty("ReturnAddress", filaRetorno);
			}
			producer.send(mensagemTexto);
			System.out.println("Mensagem enviada: " + mensagem);
			producer.close();
			gerenciador.fecharSessao();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}