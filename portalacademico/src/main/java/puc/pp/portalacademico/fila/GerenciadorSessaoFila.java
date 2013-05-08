package puc.pp.portalacademico.fila;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class GerenciadorSessaoFila {

	private static String SERVIDOR = "localhost";
	private static String PORTA = "61616";

	private Connection conexao;
	private Session sessao;

	public Session criarSessao() throws JMSException {
		if (conexao == null) {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					"tcp://" + SERVIDOR + ":" + PORTA + "");
			conexao = connectionFactory.createConnection();
			conexao.start();
		}
		if (sessao == null) {
			sessao = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
		}
		return sessao;
	}

	public void fecharSessao() {
		try {
			sessao.close();
			conexao.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			sessao = null;
			conexao = null;
		}
	}

}
