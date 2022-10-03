package lab1;

import java.util.ArrayList;

public class Agenda {

	private ArrayList<Agendamento> arrayAgendamento;
	
	public Agenda() {
		this.arrayAgendamento = new ArrayList<Agendamento>();
	}

	public ArrayList<Agendamento> getArrayAgendamento() {
		return arrayAgendamento;
	}

	public void addAgendamento(Agendamento agd) {
		this.arrayAgendamento.add(agd);
	}
}
