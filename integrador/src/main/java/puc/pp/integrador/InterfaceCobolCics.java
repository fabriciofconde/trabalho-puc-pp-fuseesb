package puc.pp.integrador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceCobolCics {

	private JFrame janela;
	
	private JPanel painelControle;
	
	public InterfaceCobolCics() {
	}
	
	public static void main(String... a) {
		
		new InterfaceCobolCics().montaTela();
	}
	
	public void montaTela() {
		
		preparaJanela();
		preparaPainelControle();
		mostraJanela();
	}
	
	private void preparaJanela() {
		
		janela = new JFrame("COBOL/CISC");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new FlowLayout());
		
		painelControle = new JPanel();
	}
	
	private void preparaPainelControle() {
		painelControle.add(preparaBotaoProcessar());
		painelControle.add(preparaBotaoSair());
		janela.add(painelControle);
		
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
	
	private JButton preparaBotaoProcessar() {
		
		JButton botaoProcessar = new JButton("Processar");
		botaoProcessar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Trancamento.getInstancia().processar();
			}
		});
		
		return botaoProcessar;
	}

	
	private void mostraJanela() {
		
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);
	}
}
