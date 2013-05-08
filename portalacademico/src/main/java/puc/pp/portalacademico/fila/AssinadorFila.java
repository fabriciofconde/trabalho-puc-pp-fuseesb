package puc.pp.portalacademico.fila;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.swing.JOptionPane;

import puc.pp.portalacademico.operacao.TrancarDisciplina;

public class AssinadorFila implements MessageListener {

	private GerenciadorSessaoFila gerenciador = new GerenciadorSessaoFila();
	private MessageConsumer consumer;

	public AssinadorFila(String fila) {
		try {
			Session sessao = gerenciador.criarSessao();
			Destination destino = sessao.createQueue(TrancarDisciplina.FILA_RETORNO_ASSINCRONO.concat(fila));
			consumer = sessao.createConsumer(destino);
			consumer.setMessageListener(this);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void onMessage(Message message) {		
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			String mensagemTexto = null;
			try {
				mensagemTexto = textMessage.getText();
			} catch (JMSException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, mensagemTexto);
			System.out.println("Mensagem recebida pelo assinador: " + mensagemTexto);
			try {
				System.out.println("Correlation ID: " + message.getJMSCorrelationID());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void parar() {
		try {
			consumer.setMessageListener(null);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		gerenciador.fecharSessao();
	}
}
