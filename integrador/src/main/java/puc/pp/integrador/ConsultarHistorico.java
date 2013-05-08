package puc.pp.integrador;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ConsultarHistorico implements Processor {

	@Override
	public void process(Exchange exchng) throws Exception {
		String args = exchng.getIn().getBody(String.class);
		System.out.println("Cobol - Consultar Histórico: " + args);
		exchng.getOut()
				.setBody(
						"2013\n - Padrões de Projetos=100 \n - Sistemas Informação Web=99 \n 2012\n - Princício Arquitetura Software=98 \n - Gerência Projeto=99");
	}

}
