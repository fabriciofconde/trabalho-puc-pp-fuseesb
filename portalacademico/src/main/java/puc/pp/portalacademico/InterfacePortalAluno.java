package puc.pp.portalacademico;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import puc.pp.portalacademico.dominio.Aluno;

public class InterfacePortalAluno {

	private JFrame janela;
	
	private JPanel painelControle;
	
	private JPanel painelConsultaNotas;
	private JPanel painelConsultaHistorico;
	

	public InterfacePortalAluno() {
	}
	
	public void montaTela() {
		
		preparaJanela();

		preparaConsultaNotaFieldSet();
		preparaConsultaHistoricoFieldSet();
		preparaPainelControle();
		
		mostraJanela();
	}
	
	private void preparaJanela() {
		
		janela = new JFrame("Portal Acacêmico - " + Aluno.obterAlunoAutenticado().toString());
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new FlowLayout());
		
		painelControle = new JPanel();
		painelConsultaNotas = new JPanel();
		painelConsultaHistorico = new JPanel();
		
	}
	
	private void preparaPainelControle() {
		
		painelControle.add(preparaBotaoCarregar());
		painelControle.add(preparaBotaoSair());
		janela.add(painelControle);
		
	}
	
	private void preparaConsultaNotaFieldSet() {
		
		JLabel labelConsultaNota = new JLabel("Consultar nota da Disciplina: ");
		final JTextField disciplinaConsultarNota = new JTextField(15);
		disciplinaConsultarNota.setToolTipText("Opções validas: matemática, cálculo, português");
		JButton botaoConsultarNota = new JButton("Consultar Nota");
		
		botaoConsultarNota.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String disciplina = disciplinaConsultarNota.getText();
				String notaDisciplina = PortalDelegate.getInstance().consultarNota(disciplina);
				JOptionPane.showMessageDialog(null, notaDisciplina);
			}
		});
		
		painelConsultaNotas.add(labelConsultaNota);
		painelConsultaNotas.add(disciplinaConsultarNota);
		painelConsultaNotas.add(botaoConsultarNota);
		janela.add(painelConsultaNotas);
	}
	
	private void preparaConsultaHistoricoFieldSet() {
		
		JButton botaoConsultarHistorico = new JButton("Consultar Histórico");
		
		botaoConsultarHistorico.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String historicoAluno = PortalDelegate.getInstance().consultarHistorico(Aluno.obterAlunoAutenticado().toString());
				JOptionPane.showMessageDialog(null, historicoAluno);
			}
		});
		
		painelConsultaHistorico.add(botaoConsultarHistorico);
		janela.add(painelConsultaHistorico);
	}
	
	private JButton preparaBotaoCarregar() {
		
		JButton botaoTrancamento = new JButton("Pedido Trancamento");
		botaoTrancamento.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String resultado = PortalDelegate.getInstance().trancarDisciplina();
				
				JOptionPane.showMessageDialog(null, resultado);
			}
		});
		
		return botaoTrancamento;
	}

	private JButton preparaBotaoSair() {
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		
		return botaoSair;
	}
	
	private void mostraJanela() {
		
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);
	}
}
