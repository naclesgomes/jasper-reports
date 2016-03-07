package relatoriosjasper.test;

import java.util.ArrayList;
import java.util.List;

import relatoriosjasper.model.Cliente;
import relatoriosjasper.relatorios.ClienteRelatorio;

public class ClienteRelatorioTest {

	public static void main(String[] args) {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			Cliente Cliente1 = new Cliente();
			Cliente1.setNome("RD Tecnologia");
			Cliente1.setEndereco("Rua Guaranis, Ipatinga");
			Cliente1.setComplemento("Sala 105");
			Cliente1.setTelefone("8888-5566");
			Cliente1.setUf("MG");

			Cliente Cliente2 = new Cliente();
			Cliente2.setNome("Romero Gonçalves Dias");
			Cliente2.setEndereco("Av Uruguai, Belo Horizonte");
			Cliente2.setComplemento("3º Andar");
			Cliente2.setUf("MG");

			Cliente Cliente3 = new Cliente();
			Cliente3.setNome("FLC Tecnologia");
			Cliente3.setEndereco("Rua Aricanduva, São Paulo");
			Cliente3.setComplemento("Sala 23");
			Cliente1.setTelefone("98523-1234");
			Cliente3.setUf("SP");

			clientes.add(Cliente1);
			clientes.add(Cliente2);
			clientes.add(Cliente3);
			ClienteRelatorio relatorio = new ClienteRelatorio();

			relatorio.imprimir(clientes);
			// relatorio.imprimirHtml(clientes);
			// relatorio.imprimirExcel(clientes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
