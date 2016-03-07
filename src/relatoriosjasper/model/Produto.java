package relatoriosjasper.model;

import java.math.BigDecimal;

public class Produto {

	/**
	 * attributes
	 * */
	private String codigo;
	private String nome;
	private BigDecimal preco;

	/**
	 * getters & setters
	 * */
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
