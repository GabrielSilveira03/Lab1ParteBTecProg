package lab1;

import java.util.ArrayList;

public class Balanco {

	private ArrayList<Atendimento> arrayAtendimento;
	
	public Balanco() {
		this.arrayAtendimento = new ArrayList<Atendimento>();
	}

	public ArrayList<Atendimento> getArrayAtendimento() {
		return arrayAtendimento;
	}

	public void addAtendimento(Atendimento atd) {
		this.arrayAtendimento.add(atd);
	}
}
