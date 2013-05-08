package puc.pp.portalacademico;

import puc.pp.portalacademico.dominio.Aluno;
import puc.pp.portalacademico.operacao.ConsultarHistorico;
import puc.pp.portalacademico.operacao.ConsultarNota;
import puc.pp.portalacademico.operacao.TrancarDisciplina;

public class PortalDelegate {
	
	private static PortalDelegate instancia;
	
	private PortalDelegate() {}
	
	public static PortalDelegate getInstance() {
		
		if(instancia == null) {
			instancia = new PortalDelegate();
		}
		
		return instancia;
	}

	public String consultarNota(String disciplina) {
		ConsultarNota c = new ConsultarNota();
		return c.consultar(disciplina);
	}

	public String consultarHistorico(String aluno) {
		ConsultarHistorico c = new ConsultarHistorico();
		return c.consultar(aluno);
	}

	public String trancarDisciplina() {
		TrancarDisciplina t = new TrancarDisciplina(String.valueOf(Aluno.obterAlunoAutenticado().getId()));
		return t.trancar(Aluno.obterAlunoAutenticado().toString(), "Matemática");
	}
}
