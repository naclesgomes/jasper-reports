package relatoriosjasper.model;

import java.math.BigDecimal;

public class CupomFiscalProduto {

	private Produto produto;
	private BigDecimal quantidade;
	private BigDecimal total;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getTotal() {
		if (produto.getPreco() == null
				|| produto.getPreco().compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO;
		}

		if (getQuantidade().compareTo(BigDecimal.ZERO) <= 0) {
			return BigDecimal.ZERO;
		}

		return produto.getPreco().multiply(getQuantidade());
	}
}
