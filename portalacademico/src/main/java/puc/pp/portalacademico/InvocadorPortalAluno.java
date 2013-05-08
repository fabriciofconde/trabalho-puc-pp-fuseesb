package puc.pp.portalacademico;

import puc.pp.portalacademico.dominio.Aluno;
import puc.pp.portalacademico.fila.AssinadorFila;
import puc.pp.portalacademico.util.AlunoUtil;


public class InvocadorPortalAluno {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long id = System.currentTimeMillis();
		String nome = AlunoUtil.obterNomeAlunoAleatorio();
		Aluno aluno = new Aluno(id, nome);
		Aluno.definirAlunoAutenticado(aluno);
		
		new AssinadorFila(String.valueOf(aluno.getId()));
		
		InterfacePortalAluno interfacePortalAcademico = new InterfacePortalAluno();
		interfacePortalAcademico.montaTela();
	}
	  
}

