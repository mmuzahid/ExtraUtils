/*
* Developer:            MD. MUZAHIDUL ISLAM
* Email:                MUZAHID.ICT@GMAIL.COM
* Developed Using:      JDK 1.7
* Date:                 04	-MAY-2015
* */
import java.io.IOException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class HelloJasper{

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws JRException, IOException {
		//MUST.. add 'jasperreports-1.2.8.jar' in build path
		
		System.out.println("RUNNING: Hello JasperReport test...");	
		//compile jrxml file
		JasperCompileManager.compileReportToFile("hellojasper.jrxml", "hellojasper.jasper");
		//load jasper file
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject("hellojasper.jasper");
		//fill data
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource());
		//export report
		JasperExportManager.exportReportToPdfFile(jasperPrint, "hellojasper.pdf");
		System.out.println("SUCCESS: Hello JasperReport test...");
	}

}
