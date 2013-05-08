package puc.pp.integrador;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class TrancadorDisciplina implements Processor {

	private static Thread inicializadorTela;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		Message mensagem = exchange.getIn();
		String args = mensagem.getBody(String.class);
		String correlationID = mensagem.getHeader("JMSCorrelationID", String.class);
		
		System.out.println("Cobol - Trancar Matrícula: " + args);

		PedidoTrancamento pedido = new PedidoTrancamento();
		pedido.setCorrelationID(correlationID);
		pedido.setReturnAddress(mensagem.getHeader("ReturnAddress", String.class));
		pedido.setSolicitacao(args);
		Trancamento.getInstancia().adicionarTrancamento(pedido);

		if (inicializadorTela == null) {
			inicializadorTela = new Thread(new InicializadorInterface());
			inicializadorTela.start();
		}

		exchange.getOut().setBody("Solicitação de trancamento enviada com sucesso!");
		exchange.getOut().setHeader("JMSCorrelationID", correlationID);
		exchange.getOut().removeHeader("ReturnAddress");
	}

	class InicializadorInterface implements Runnable {
		@Override
		public void run() {
			new InterfaceCobolCics().montaTela();			
		}
	}
	
}
