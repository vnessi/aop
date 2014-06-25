package uy.edu.ort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import uy.edu.ort.fachada.FachadaOperaciones;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 */
public class MainCliente {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    
        boolean noSalir = true;
        String arg;
        printHeader();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (noSalir) {
            printCommands();

            String line = bufferedReader.readLine();

            String[] read = line.trim().split(" ");
            String comando = read[0];

            String mensaje;
            switch (comando) {
                case "1":
                    System.out.println(">>Listar Barcos\n");
                    try {
                        FachadaOperaciones.listarBarcos();
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;
                    
                case "2":
                    System.out.println(">>Mostrar Barco\n");
                    System.out.println(">>Ingrese el id del barco que desea mostrar: \n");
                    System.out.print(">> ");
                    String idBarco = bufferedReader.readLine();
                        try {
                            if (checkArgs(idBarco)) {
                                FachadaOperaciones.mostrarBarco(idBarco);
                            }
                        } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "3":
                    System.out.println(">>Listar Contenedores\n");
                    try {
                        FachadaOperaciones.listarContenedores();
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;
                    
                case "4":
                    System.out.println(">>Mostrar Contenedor\n");
                    System.out.println(">>Ingrese el id del contenedor que desea mostrar: \n");
                    System.out.print(">> ");
                    String idContenedor = bufferedReader.readLine();
                        try {
                            if (checkArgs(idContenedor)) {
                                FachadaOperaciones.mostrarContenedor(idContenedor);
                            }
                        } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "5":
                    System.out.println(">>Generar Reporte de arribos por Mes: \n"
                            + "\nIngrese el mes para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg)) {
                            FachadaOperaciones.generarReporteArribosMes(arg);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "6":
                    System.out.println(">>Generar Reporte de arribos por Mes y Barcos: \n"
                            + "\nIngrese el mes para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    System.out.println(">>Ingrese el codigo de barco para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    String codBarco = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg) && checkArgs(codBarco)) {
                            FachadaOperaciones.generarReporteArribosMesBarco(arg, codBarco);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;
                    
                case "7":
                    System.out.println(">>Generar Reporte de partidas por Mes: \n"
                            + "\nIngrese el mes para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg)) {
                            FachadaOperaciones.generarReportePartidasMes(arg);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "8":
                    System.out.println(">>Generar Reporte de partidas por Mes y Barcos: \n"
                            + "\nIngrese el mes para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    System.out.println(">>Ingrese el codigo de barco para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    codBarco = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg) && checkArgs(codBarco)) {
                            FachadaOperaciones.generarReportePartidasMesBarco(arg, codBarco);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;
                
                case "9":
                    System.out.println(">>Generar Reporte de Trazabilidad: \n");
                    try {
                        FachadaOperaciones.listarTrazas();
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "99":
                    System.out.println(">>Salir");
                    noSalir = false;
                    break;
                default:
                    System.out.println("No existe comando!");
                    break;
            }
        }
        System.exit(0);
    }

    private static void printHeader() {
        System.out.println("=====================================================================");
        System.out.println("=====================================================================");
        System.out.println("==============Arquitecturas de Software Livianas con Java==============");
        System.out.println("==============================Obligatorio 1==========================");
        System.out.println("=====================================================================");
        System.out.println("================ Bruno Montaner ========= Victor Nessi ==============\n");
    }

    private static void printCommands() {
        System.out.println("Ingrese la opcion deseada");
        System.out.println("Comandos:");
        System.out.println(">> comando -\tDescripcion ");
        System.out.println(">> 1 -\tListar Barcos");
        System.out.println(">> 2 -\tMostrar Barco");
        System.out.println(">> 3 -\tListar Contenedores");
        System.out.println(">> 4 -\tMostrar Contenedor");
        System.out.println(">> 5 -\tReporte arribos por mes");
        System.out.println(">> 6 -\tReporte arribos por mes y barco");
        System.out.println(">> 7 -\tReporte partidas por mes");
        System.out.println(">> 8 -\tReporte partidas por mes y barco");
        System.out.println(">> 9 -\tReporte trazabilidad");
        System.out.println(">> 99 -\tSalir del sistema");
    }

    private static Boolean checkArgs(String s) {
        if (s.isEmpty()) {
            System.out.println("Debe ingresar un argumento luego del comando");
            return false;
        }
        return true;

    }

}
