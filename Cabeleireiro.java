package lab1;

public class Cabeleireiro {

	private int id;
	private String nome;
	private String cpf;

	public Cabeleireiro(String nome, String cpf) {
		if (nome.length() >= 3)
			this.nome = nome;
		
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id > 0)
			this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

}
