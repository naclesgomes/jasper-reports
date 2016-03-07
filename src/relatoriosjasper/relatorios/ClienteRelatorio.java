package relatoriosjasper.relatorios;

import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import relatoriosjasper.model.Cliente;

public class ClienteRelatorio {

	private String path; // Caminho base

	// Caminho para o package onde estão
	// armazenados os relatorios Jarper
	// Recupera os caminhos para que a classe possa encontrar os relatórios
	private String pathToReportPackage;

	public ClienteRelatorio() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = "/home/jasper01/workspace/relatoriosjasper/src/relatoriosjasper/jasper/"; // adicionar
		System.out.println(path);
	}

	// Imprime/gera uma lista de Clientes
	public void imprimir(List<Cliente> clientes) throws Exception {
		JasperReport report = JasperCompileManager.compileReport(this
				.getPathToReportPackage() + "relatorio_de_clientes.jrxml"); // alterar

		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(clientes));

		JasperExportManager
				.exportReportToPdfFile(
						print,
						"/home/jasper01/workspace/relatoriosjasper/src/relatoriosjasper/pdf/relatorio_de_clientes.pdf"); // alterar

		System.out.println("Relatório PDF impresso com sucesso."); // adicionar
	}

	public String getPath() {
		return path;
	}

	public String getPathToReportPackage() {
		return pathToReportPackage;
	}
}
