package puc.pp.integrador;

import java.util.Random;

public class PedidoTrancamento {

	private String correlationID;
	
	private String returnAddress;
	
	private String solicitacao;
	
	private boolean sucessoTrancamento = false;

	public String getCorrelationID() {
		return correlationID;
	}

	public void setCorrelationID(String correlationID) {
		this.correlationID = correlationID;
	}

	public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}

	public String getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}

	public boolean sucessoTrancamento() {
		//seta aleatorio se pedido de trancamento foi realizado com sucesso ou nao
		sucessoTrancamento = new Random().nextBoolean();
		return sucessoTrancamento;
	}

	public void setSucessoTrancamento(boolean sucessoTrancamento) {
		this.sucessoTrancamento = sucessoTrancamento;
	}

	@Override
	public String toString() {
		return "PedidoTrancamento [correlationID=" + correlationID
				+ ", returnAddress=" + returnAddress + ", solicitacao="
				+ solicitacao + ", sucessoTrancamento=" + sucessoTrancamento
				+ "]";
	}
	
}