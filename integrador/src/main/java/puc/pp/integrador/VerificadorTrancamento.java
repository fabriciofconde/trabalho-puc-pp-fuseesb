package puc.pp.integrador;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class VerificadorTrancamento implements Processor {
	
	@Override
	public void process(Exchange exchange) throws Exception {
		PedidoTrancamento pedido = Trancamento.getInstancia().proximoPedidoProcessado();
		if (pedido != null) {
			exchange.getOut().setHeader("processado", true);
			exchange.getOut().setHeader("JMSCorrelationID", pedido.getCorrelationID());
			exchange.getOut().setHeader("ReturnAddress", pedido.getReturnAddress());
			exchange.getOut().setHeader("Trancado", pedido.sucessoTrancamento());
			exchange.getOut().setBody(String.format("Pedido de trancamento de %s foi aceito? %s", pedido.getSolicitacao(), pedido.sucessoTrancamento() ? "Sim":"Nao"));
			System.out.println("Verifiquei trancamento, status: processado pedido: " + pedido);
		} else {
			exchange.getOut().setHeader("processado", false);
			System.out.println("Verifiquei trancamento, status: não existe nada a processar");
		}
	}

}
