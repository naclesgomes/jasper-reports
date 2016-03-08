package relatoriosjasper.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class CupomFiscal {

	/**
	 * attributes
	 * */
	private Long ordem;
	private Garcom garcom;
	private Calendar data;
	private List<CupomFiscalProduto> produtos;
	private BigDecimal total;

	/**
	 * getters & setters
	 * */
	public Long getOrdem() {
		return ordem;
	}

	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<CupomFiscalProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<CupomFiscalProduto> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getTotal() {
		if (produtos.isEmpty()) {
			return BigDecimal.ZERO;
		}

		BigDecimal somaDosTotais = BigDecimal.ZERO;
		for (CupomFiscalProduto cupomFiscalProduto : produtos) {
			somaDosTotais = somaDosTotais.add(cupomFiscalProduto.getSubtotal());
		}

		return somaDosTotais;
	}

}
