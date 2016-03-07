package relatoriosjasper.relatorios;

import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ImprimirRelatorios {

	private final String diretorioProjeto;
	private final String diretorioJaspersJrxml;
	private String diretorioPdf;

	public ImprimirRelatorios() {
		this.diretorioProjeto = System.getProperty("user.dir");
		this.diretorioJaspersJrxml = getDiretorioProjeto()
				+ "/src/relatoriosjasper/jasper/";
		this.diretorioPdf = getDiretorioProjeto()
				+ "/src/relatoriosjasper/pdf/";
	}

	public <T> void imprimir(String nomeJrxml, String nomeArquivoPdf,
			List<T> jasperModel) throws Exception {

		// Compila o arquivo JRXML
		JasperReport report = JasperCompileManager
				.compileReport(getDiretorioJaspersJrxml() + nomeJrxml);

		// Preenche os dados do relatório
		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(jasperModel));

		// Exporta o arquivo PDF
		String diretorioCriacaoArquivoPdf = getDiretorioPdf() + nomeArquivoPdf;
		JasperExportManager.exportReportToPdfFile(print,
				diretorioCriacaoArquivoPdf);

		System.out.println(getMensagemSucesso(nomeArquivoPdf));
	}

	public String getMensagemSucesso(String nomeArquivoPdf) {
		return new StringBuilder().append("Relatório PDF").append("'")
				.append(nomeArquivoPdf).append("'")
				.append("impresso com sucesso.").toString();
	}

	public String getDiretorioProjeto() {
		return diretorioProjeto;
	}

	public String getDiretorioJaspersJrxml() {
		return diretorioJaspersJrxml;
	}

	public String getDiretorioPdf() {
		return diretorioPdf;
	}
}
