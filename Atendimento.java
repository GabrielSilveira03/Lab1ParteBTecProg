package lab1;

import java.util.ArrayList;
import java.util.Calendar;

public class Atendimento {

	private Cliente cliente;
	private ArrayList<Servico> listaServico;
	private Calendar data;
	private Cabeleireiro cabeleireiro;

	public Atendimento(Cliente cliente, Cabeleireiro cabeleireiro) {
		this.cliente = cliente;
		this.data = Calendar.getInstance();
		this.cabeleireiro = cabeleireiro;
		listaServico = new ArrayList<Servico>();
	}
	
	public int getId() {
		return cliente.getId();
	}
	
	public int getTamanhoLista() {
		return listaServico.size();
	}
	
	public String getNomeCliente() {
		return cliente.getNome();
	}
	
	public String getNomeCabeleireiro() {
		return cabeleireiro.getNome();
	}

	public void setListServico(ArrayList<Servico> lista) {
		listaServico= lista;
	}
	public void addServico(Servico serv) {
		listaServico.add(serv);
	}
	
	//Quest1 Parte B
	public double valorAtendimento() {
		double valortotal=0;
		for (Servico servico : listaServico) {
			valortotal += servico.getValor();
		}
		
		return valortotal;
	}

	public String imprimir() {
		String saida = "";

		saida += "----------------------------------------------------\n";
		saida += "\n******* Cliente:  *******";
		saida += "\n id: " + this.cliente.getId();
		saida += "\n Nome: " + this.cliente.getNome();
		saida += "\n CPF:  " + this.cliente.getCPF();

		saida += "\n\n*******  Cabeleiro:  *******  ";
		saida += "\n id: " + this.cabeleireiro.getId();
		saida += "\n Nome: " + this.cabeleireiro.getNome();
		saida += "\n CPF:  " + this.cabeleireiro.getCpf();

		saida += "\n\n*******  Servicos:  *******  ";
		for (Servico servico : listaServico) {
			saida += "\n id: " + servico.getId();
			saida += "\n nome: " + servico.getNome();
			saida += "\n descricao: " + servico.getDescricao();
			saida += "\n valor: " + servico.getValor() + "\n";
		}
		
		//Quest1 parte B
		saida += "\n Valor total do atendimento:" + valorAtendimento();

		saida += "----------------------------------------------------";

		return saida;
	}

}
