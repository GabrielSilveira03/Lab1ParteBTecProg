package lab1;

public class Servico {

	private int id;
	private String nome;
	private String descricao;
	private double valor;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
	   if(id>0)
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.length()>=5)
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if(descricao.length()>=10)
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		if(valor >= 0)
		this.valor = valor;
	}
	
	
}
