package lab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Apresentacao {

	private Agendamento carregarDadosParaTesteAgendamento() {

		// clientes
		Cliente cliente = new Cliente("080.388.788-95");
		cliente.setId(1);
		cliente.setNome("Pedro");

		Cabeleireiro cabeleireiro = new Cabeleireiro("Ana", "033.333.333-13");

		// agendamento
		Agendamento agendamento = new Agendamento(cliente, cabeleireiro);
		Calendar data = Calendar.getInstance();
		data.set(2022, 9, 27, 20, 30);
		agendamento.setData(data);

		return agendamento;

	}

	public Atendimento carregarDadosParaTesteAtendimento() {
		// clientes
		Cliente cliente1 = new Cliente("080.388.788-95");
		cliente1.setId(1);
		cliente1.setNome("Pedro");

		// servicos
		Servico servico1 = new Servico();
		servico1.setId(1);
		servico1.setNome("Corte de cabelo");
		servico1.setDescricao("Corte de cabelo legal");
		servico1.setValor(150);

		Servico servico2 = new Servico();
		servico2.setId(2);
		servico2.setNome("Hidrata��o facial");
		servico2.setDescricao(
				"Hidratante Antissinais para redu��o de linhas de express�o, suavizando sinais de cansa�o");
		servico2.setValor(100);

		Servico servico3 = new Servico();
		servico3.setId(3);
		servico2.setNome("Massagem relaxante");
		servico3.setDescricao(
				"Trata-se de manobras especializadas empregadas no m�sculo, conferindo ao indiv�duo relaxamento e al�vio muscular. Al�m de produzir efeitos nos sistemas muscular e nervoso, essa massagem age com efic�cia nos sistemas linf�tico, circulat�rio e respirat�rio.");
		servico3.setValor(100);

		// cabeleireiro
		Cabeleireiro cabeleireiro1 = new Cabeleireiro("Antonio", "044.444.444-55");

		// atendimentos
		Atendimento atendimento1 = new Atendimento(cliente1, cabeleireiro1);
		atendimento1.addServico(servico1);
		atendimento1.addServico(servico2);
		atendimento1.addServico(servico3);

		return atendimento1;

	}

	public Cliente carregarCliente(Scanner entrada) {
		System.out.println("Informe o cliente: ");
		System.out.println("cpf do cliente: ");
		Cliente c = new Cliente(entrada.next());
		System.out.println("\nid do cliente: ");
		c.setId(entrada.nextInt());
		System.out.println("\nnome do cliente: ");
		c.setNome(entrada.next());
		System.out.println("\n\n");
		return c;
	}

	public ArrayList<Servico> carregarServico(Scanner entrada) {
		ArrayList<Servico> aux = new ArrayList<Servico>();
		System.out.println("Informe dados sobre os servico(s)");
		String op = "";
		do {
			Servico s = new Servico();
			System.out.println("\nNome do servico:");
			s.setNome(entrada.next());

			System.out.println("\nDescricao do servico:");
			s.setDescricao(entrada.next());

			System.out.println("\nValor do servico:");
			s.setValor(entrada.nextFloat());

			aux.add(s);
			System.out.println("Digite sair ou qualquer tecla para adiocar novo servico:");
			op = entrada.next();

		} while (!(op.equals("sair")));
		return aux;
	}

	public Atendimento dadosCarregadosDoTecladoAtendimento() {
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = carregarCliente(entrada);
		Cabeleireiro cabeleireiro = carregarCabeleireiro(entrada);
		Atendimento a = new Atendimento(cliente, cabeleireiro);
		a.setListServico(carregarServico(entrada));
		return a;
	}

	private Cabeleireiro carregarCabeleireiro(Scanner entrada) {

		System.out.println("Informe o cabeleireiro: ");
		System.out.print("\nnome do cabeleireiro: ");
		String nome = entrada.next();
		System.out.print("\ncpf do cabeleireiro: ");
		String cpf = entrada.next();
		Cabeleireiro c = new Cabeleireiro(nome, cpf);

		System.out.print("\nid do cabeleireiro: ");
		c.setId(entrada.nextInt());

		return c;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Apresentacao a = new Apresentacao();
		/* Questao 1 */
		// Atendimento atendimento = a.carregarDadosParaTesteAtendimento();
		// System.out.println(atendimento.imprimir());
		//
		// Agendamento agendamento = a.carregarDadosParaTesteAgendamento();
		// System.out.println(agendamento.imprimir());

		/* Questao 2 */
		Atendimento atendimento2 = a.dadosCarregadosDoTecladoAtendimento();
		System.out.println(atendimento2.imprimir());
		
		//Quest4 Parte B
				Balanco balancogeral = new Balanco();
		
		//Quest10 Parte B
				Agenda agendageral = new Agenda();
		
		//Quest1 Parte B na classe atendimento
		atendimento2.valorAtendimento();
				
		//Quest2 Parte B
		System.out.println("A quantidade de serviços requisitados pleo cliente foi:" + numerosServsCliente(entrada, balancogeral.getArrayAtendimento()));

		//Quest3 Parte B
		nomesDiferentes(null, null);
		
		//Quest5 Parte B
		System.out.println("O cabeleireiro que mais atuou no salão foi:" + maxAtuacaoCabeleireiro(balancogeral.getArrayAtendimento(), null));
		
		///Quest6 Parte B
		System.out.println("O cliente que teve mais gastos com serviço foi:" + clienteMaiorGasto(balancogeral.getArrayAtendimento(), null));
		
		//Quest7 Parte B
		quantidadeServs(balancogeral.getArrayAtendimento());
		
		//Quest8 Parte B
		servicoGratuito(null);
		
		//Quest9 Parte B
		System.out.println("Informe o nome do serviço qeu deseja buscar:");
		String nomeserv = entrada.nextLine();
		buscarServico(null, nomeserv);
		
		//Quest11 Parte B
		System.out.println("Informe a data do agendamento que deseja buscar(informe nesta sequencia:ano,mês,dia,hora,minuto, pressionando enter a cada dado informado):");
		int ano11 = entrada.nextInt();
		int mes11 = entrada.nextInt();
		int dia11 = entrada.nextInt();
		int hor11 = entrada.nextInt();
		int min11 = entrada.nextInt();
		Calendar databusca11 = Calendar.getInstance();
		databusca11.set(ano11, mes11, dia11, hor11, min11);
		buscarAgendamento(agendageral.getArrayAgendamento(), databusca11);
		
		//Quest12 Parte B
		System.out.println("Informe o id do cabeleireiro que deseja buscar os agendamentos:");
		int idcab = entrada.nextInt();
		System.out.println("Informe a data de hoje(formato:ano,mês,dia, pressione enter a cada dado informado");
		int ano12 = entrada.nextInt();
		int mes12 = entrada.nextInt();
		int dia12 = entrada.nextInt();
		Calendar databusca12 = Calendar.getInstance();
		databusca12.set(ano12, mes12, dia12);
		buscarAgendamentoCabeleireiro(agendageral.getArrayAgendamento(), databusca12, idcab);
		
		//Quest13 Parte B
		System.out.println("Informe o id do cabeleireiro que deseja buscar os agendamentos:");
		int idcli = entrada.nextInt();
		System.out.println("Informe a data de hoje(formato:ano,mês,dia, pressione enter a cada dado informado");
		int ano13 = entrada.nextInt();
		int mes13 = entrada.nextInt();
		int dia13 = entrada.nextInt();
		Calendar databusca13 = Calendar.getInstance();
		databusca13.set(ano13, mes13, dia13);
		buscarAgendamentoCliente(agendageral.getArrayAgendamento(), databusca13, idcli);
		
		//Quest14 Parte B
		System.out.println("Informe o nome do cliente que deseja conferir a quantidade de atendimentos:");
		String nomeclienteatd = entrada.next();
		System.out.println("Quantidade de atendimentos do cliente" + nomeclienteatd + " : " + quantidadeAtendimentoCliente(balancogeral.getArrayAtendimento(), nomeclienteatd));
		
		//Quest15 Parte B
				System.out.println("Informe o nome do cliente que deseja conferir a quantidade de atendimentos:");
				String nomeclienteagd = entrada.next();
				System.out.println("Quantidade de atendimentos do cliente" + nomeclienteagd + " : " + quantidadeAgendamentoCliente(agendageral.getArrayAgendamento(), nomeclienteagd));
		
		entrada.close();
	}
	
//Quest2 Parte B
	public static int numerosServsCliente(Scanner entrada, ArrayList<Atendimento> atendimentos) {
		int qtdservicos=0;
		System.out.println("Informe o id do cliente:");
		int idpesquisa = entrada.nextInt();
		for (Atendimento atendimento : atendimentos) {
			if(idpesquisa == atendimento.getId()){
				qtdservicos = atendimento.getTamanhoLista();
			}
		}
		
		return qtdservicos;
	}
	
//Quest3 Parte B
	public static boolean nomesDiferentes(ArrayList<Cliente> clientes, ArrayList<Cabeleireiro> cabelereiros) {
		boolean resultadoteste = true;
		for (Cabeleireiro cabeleireiro : cabelereiros) {
			for (Cliente cliente : clientes) {
				resultadoteste = resultadoteste && !(cliente.getNome().equals(cabeleireiro.getNome()));
			}
		}
		return resultadoteste;
	}
	
//Quest5 Parte B
	public static String maxAtuacaoCabeleireiro(ArrayList<Atendimento> atendimentos, ArrayList<Cabeleireiro> cabeleireiros) {
		int qtdmaxatuacao = 0,qtdaux=0;
		String nomemaxatuacao = new String();
		for (Cabeleireiro cabeleireiro : cabeleireiros) {
			qtdaux=0;
			for (Atendimento atendimento : atendimentos) {
				if(atendimento.getNomeCabeleireiro() == cabeleireiro.getNome()) {
					qtdaux++;
				}
			}
			if(qtdaux > qtdmaxatuacao) {
				qtdmaxatuacao = qtdaux;
				nomemaxatuacao = cabeleireiro.getNome();
			}
		}
		
		return nomemaxatuacao;
	}
	
//Quest6 Parte B
	public static String clienteMaiorGasto(ArrayList<Atendimento> atendimentos, ArrayList<Cliente> clientes) {
		double maxvalor=0,valoraux=0;
		String nomemaxvalor = new String();
		for (Cliente cliente : clientes) {
			valoraux=0;
			for (Atendimento atendimento : atendimentos) {
				if(atendimento.getNomeCabeleireiro() == cliente.getNome()) {
					valoraux += atendimento.valorAtendimento();
				}
			}
			if(valoraux > maxvalor) {
				maxvalor = valoraux;
				nomemaxvalor = cliente.getNome();
			}
		}
		
		return nomemaxvalor;
	}
	
//Quest7 Parte B
	public static void quantidadeServs(ArrayList<Atendimento> atendimentos) {
		for (Atendimento atendimento : atendimentos) {
			System.out.println("A quantidade de serviços do atendimento foi:" +  atendimento.getTamanhoLista());
		}
	}
	
//Quest8 Parte B
	public static void servicoGratuito(ArrayList<Servico> servicos) {
		for (Servico servico : servicos) {
			if(servico.getValor()==0) {
				System.out.println("O serviço, " + servico.getNome() + ",é gratuito");
			}
		}
	}

//Quest9 Parte B
	public static Servico buscarServico(ArrayList<Servico> servicos,String nomeserv) {
		Servico s = new Servico();
		for (Servico servico : servicos) {
			if(nomeserv == servico.getNome()) {
				s = servico;
			}
		}
		
		return s;
	}
	
//Quest11 Parte B
	public static void buscarAgendamento(ArrayList<Agendamento> agendamentos,Calendar data) {
		for (Agendamento agendamento : agendamentos) {
			if(data == agendamento.getData()) {
				System.out.println("Segue as informações do agendamento correspondente a data inserida");
				System.out.println(agendamento.getCliente().getNome());
				System.out.println(agendamento.getCabeleireiro().getNome());
				System.out.println(agendamento.getId());
				System.out.println(agendamento.getData());
			} 
		}
	}
	
//Quest12 Parte B
	public static void buscarAgendamentoCabeleireiro(ArrayList<Agendamento> agendamentos,Calendar datahoje,int idcab) {
		int contador=0;
		for (Agendamento agendamento : agendamentos) {
			if(datahoje == agendamento.getData() && idcab == agendamento.getCabeleireiro().getId()) {
				contador++;
				System.out.println(contador + "° agendamento:");
				System.out.println(agendamento.getCliente().getNome());
				System.out.println(agendamento.getId());
				System.out.println(agendamento.getData());
			}
		}
	}
	
//Quest13 Parte B
	public static void buscarAgendamentoCliente(ArrayList<Agendamento> agendamentos, Calendar datahoje,int idcli) {
		for (Agendamento agendamento : agendamentos) {
			if(datahoje == agendamento.getData() && idcli == agendamento.getCliente().getId() ) {
				System.out.println("Agendamento do cliente" + agendamento.getCliente().getNome() + " : ");
				System.out.println(agendamento.getCabeleireiro().getNome());
				System.out.println(agendamento.getId());
				System.out.println(agendamento.getData());
			}
		}
	}
	
//Quest14 Parte B
	public static int quantidadeAtendimentoCliente(ArrayList<Atendimento> atendimentos,String nome) {
		int quantidade=0;
		for (Atendimento atendimento : atendimentos) {
			if(nome == atendimento.getNomeCliente()) {
				quantidade++;
			}
		}
		
		return quantidade;
	}
	
//Quest15 Parte B
		public static int quantidadeAgendamentoCliente(ArrayList<Agendamento> agendamentos,String nome) {
			int quantidade=0;
			for (Agendamento agendamento : agendamentos) {
				if(nome == agendamento.getCliente().getNome()) {
					quantidade++;
				}
			}
			
			return quantidade;
		}

}
