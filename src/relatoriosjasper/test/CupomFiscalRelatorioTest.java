package relatoriosjasper.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import relatoriosjasper.model.CupomFiscal;
import relatoriosjasper.model.CupomFiscalProduto;
import relatoriosjasper.model.Garcom;
import relatoriosjasper.model.Produto;
import relatoriosjasper.relatorios.ImprimirRelatorios;

public class CupomFiscalRelatorioTest {

	public static void main(String[] args) throws Exception {

		try {
			List<CupomFiscal> listCupomFiscal = new ArrayList<CupomFiscal>();
			CupomFiscal cupomFiscal = new CupomFiscal();

			cupomFiscal.setOrdem(new Long("8559533"));
			cupomFiscal.setData(Calendar.getInstance());
			cupomFiscal.setGarcom(newGarcom());
			cupomFiscal.setProdutos(newProdutos());
			cupomFiscal.getTotal();

			listCupomFiscal.add(cupomFiscal);
			new ImprimirRelatorios().imprimir("cupom_fiscal.jrxml",
					"cupom_fiscal.pdf", listCupomFiscal);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static Garcom newGarcom() {
		Garcom garcom = new Garcom();
		garcom.setId(new Long("1"));
		garcom.setNome("CHRISTIAM");

		return garcom;
	}

	private static List<CupomFiscalProduto> newProdutos() {
		List<CupomFiscalProduto> produtos = new ArrayList<CupomFiscalProduto>();

		CupomFiscalProduto cupomFiscalProduto1 = new CupomFiscalProduto();
		cupomFiscalProduto1.setProduto(newProdutoSuco());
		cupomFiscalProduto1.setQuantidade(new BigDecimal("1"));

		CupomFiscalProduto cupomFiscalProduto2 = new CupomFiscalProduto();
		cupomFiscalProduto2.setProduto(newProdutoSelfService());
		cupomFiscalProduto2.setQuantidade(new BigDecimal("1.225"));

		produtos.add(cupomFiscalProduto1);
		produtos.add(cupomFiscalProduto2);

		return produtos;
	}

	private static Produto newProdutoSuco() {
		Produto produto = new Produto();

		produto.setCodigo("M57-1");
		produto.setNome("SUCO COPO 300 ML");
		produto.setPreco(new BigDecimal("2.48"));

		return produto;
	}

	private static Produto newProdutoSelfService() {
		Produto produto = new Produto();

		produto.setCodigo("M39-1");
		produto.setNome("SELF-SERVICE");
		produto.setPreco(new BigDecimal("32.35"));

		return produto;
	}
}
