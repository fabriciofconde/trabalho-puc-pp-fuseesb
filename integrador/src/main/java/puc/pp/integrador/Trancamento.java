package puc.pp.integrador;

import java.util.ArrayList;
import java.util.List;

public class Trancamento {

	private static Trancamento instancia;

	private List<PedidoTrancamento> trancamentoPendente;
	private List<PedidoTrancamento> trancamentoProcessado;

	private Trancamento() {
		trancamentoPendente = new ArrayList<PedidoTrancamento>();
		trancamentoProcessado = new ArrayList<PedidoTrancamento>();
	}

	public void processar() {
		synchronized (this) {
			System.out.println("adicionando processo para execução:" + trancamentoPendente);
			trancamentoProcessado.addAll(trancamentoPendente);
			trancamentoPendente.clear();
		}
	}

	public void adicionarTrancamento(PedidoTrancamento pedido) {
		synchronized (this) {
			System.out.println("(Classe Trancamento:)adicionando pedido na fila : " + pedido);
			trancamentoPendente.add(pedido);
		}
	}

	public PedidoTrancamento proximoPedidoProcessado() {
		synchronized (this) {
			if (!trancamentoProcessado.isEmpty()) {
				
				return trancamentoProcessado.remove(0);
			}			
		}
		return null;
	}
	
	public static Trancamento getInstancia() {
		if (instancia == null) {
			instancia = new Trancamento();
		}
		return instancia;
	}
}
