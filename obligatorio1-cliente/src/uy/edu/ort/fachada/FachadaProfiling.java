package uy.edu.ort.fachada;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.pdf.PdfUtil;
import uy.edu.ort.service.ProfilingService;

/**
 *
 * @author Bruno Montaner - Victor Nessi
 * 
 * Fachada con las operaciones de profiling
 */
public class FachadaProfiling {
    private static final ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
    private static final ProfilingService profiling = (ProfilingService) ctx.getBean("profilingService");
    
    public static void obtenerReportesProfiling(){
        List<String> masLento = profiling.servicioMasLento();
        List<String> masRapido = profiling.servicioMasRapido();
        List<List<String>> promedios = profiling.promedioEjecucionServicio();
        
        System.out.println(" << Servicio mas rapido >>");
        System.out.println(" Servicio >> " + masRapido.get(0) + " con un tiempo: " + masRapido.get(1) + " (nanosegundos)\n");
        
        System.out.println(" << Servicio mas lento >> ");
        System.out.println(" Servicio >> " + masLento.get(0) + " con un tiempo: " + masLento.get(1) + " (nanosegundos)\n\n");
        
        System.out.println(" << Tiempo promedio de ejecucion por servicio >> \n");
        System.out.print("Servicio \t\t Tiempo promedio(nanosegundos) \n");
        for (List<String> list : promedios) {
                System.out.print(list.get(0) + " \t\t " + list.get(1) + "\n");
        }
        
        PdfUtil.crearReportePDFProfiling(masRapido, masLento, promedios);
        
        
    }
}
