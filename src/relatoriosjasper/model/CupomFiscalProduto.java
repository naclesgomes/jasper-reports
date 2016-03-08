package relatoriosjasper.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CupomFiscalProduto {

	private Produto produto;
	private BigDecimal quantidade;
	private BigDecimal subtotal;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade.setScale(4);
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getSubtotal() {
		if (produto.getPreco() == null
				|| produto.getPreco().compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO;
		}

		if (getQuantidade().compareTo(BigDecimal.ZERO) <= 0) {
			return BigDecimal.ZERO;
		}

		return produto.getPreco().multiply(getQuantidade())
				.setScale(2, RoundingMode.CEILING);
	}
}
