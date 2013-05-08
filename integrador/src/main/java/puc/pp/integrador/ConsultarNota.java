package puc.pp.integrador;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ConsultarNota implements Processor {

	@Override
	public void process(Exchange exchng) throws Exception {
		
		String disciplina =  exchng.getIn().getBody(String.class);
		
		
		String resultado = consultaNotaCobolFacade(disciplina);
		
		System.out.println("Cobol - Consultar nota para a disciplina: " + disciplina);
		exchng.getOut().setBody(resultado);
	}

	private String consultaNotaCobolFacade(String disciplina) {

		String notaResultado = "Não existe nota disponível para esta disciplina.";
		
		if (disciplina != null && !"".equals(disciplina)) {
			
			if (disciplina.equalsIgnoreCase("matemática")
					|| disciplina.equalsIgnoreCase("matematica")) {
				
				notaResultado = "75";
				
			} else if (disciplina.equalsIgnoreCase("portugues")
					|| disciplina.equalsIgnoreCase("português")) {
				
				notaResultado = "69";
				
			} else if (disciplina.equalsIgnoreCase("cálculo")
					|| disciplina.equalsIgnoreCase("calculo")) {
				
				notaResultado = "100";
			}
		}
		
		return notaResultado; 
	}

}
