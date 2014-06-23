package uy.edu.ort;

import uy.edu.ort.fachada.FachadaBarco;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import uy.edu.ort.fachada.FachadaArribo;
import uy.edu.ort.fachada.FachadaContenedor;
import uy.edu.ort.fachada.FachadaProfiling;
import uy.edu.ort.fachada.FachadaTracing;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 */
public class MainCliente {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    
        
        //Setear por inyeccion de dependencia
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
//        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        //URL del servicio - donde {userId} es el parametro que le voy a pasar
        //String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restarribo/arribos.htm?mes=6";

        //String json = restTemplate.getForObject(url, String.class, 2);
        //Arribo[] jsonArribos = restTemplate.getForObject(url, Arribo[].class, 1);
        //System.out.println(jsonArribos);
        
        boolean noSalir = true;
        String arg;
        String nombreUsuario = "";
        printHeader();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (!checkArgs(nombreUsuario)) {
            System.out.println(">>Bienvenido! Ingrese un nombre de usuario: \n");
            System.out.print(">> ");
            nombreUsuario = bufferedReader.readLine();
        }
        FachadaTracing.setearUsername(nombreUsuario);
        while (noSalir) {
            printHeader();
            printCommands();

            String line = bufferedReader.readLine();

            String[] read = line.trim().split(" ");
            String comando = read[0];

            String mensaje;
            switch (comando) {
                case "1":
                    System.out.println(">>Agregar Barco: "
                            + "\nIngrese los datos del barco separados por coma "
                            + "(Codigo,Nombre,Bandera,Capacidad(kgs),Año,Cantidad Tripulantes)\n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg)) {
                            FachadaBarco.agregarBarco(arg);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;
                case "2":
                    System.out.println(">>Eliminar Barco: \n");
                    FachadaBarco.listarBarcos();
                    System.out.println(">>Ingrese el codigo del barco que desea eliminar: \n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg)) {
                            FachadaBarco.eliminarBarco(arg);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "3":
                    System.out.println(">>Modificar Barco: \n");
                    FachadaBarco.listarBarcos();
                    System.out.println(">>Ingrese el codigo del barco que desea modificar: \n");
                    System.out.print(">> ");
                    String codBarco = bufferedReader.readLine();
                    try {
                        if (checkArgs(codBarco)) {
                            FachadaBarco.mostrarBarco(codBarco);
                            System.out.println("\nIngrese los datos del barco separados por coma "
                                    + "(Codigo,Nombre,Bandera,Capacidad(kgs),Año,Cantidad Tripulantes)\n");
                            System.out.print(">> ");
                            arg = bufferedReader.readLine();
                            if (checkArgs(arg)) {
                                FachadaBarco.modificarBarco(codBarco, arg);
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "4":
                    System.out.println(">>Listar Barcos\n");
                    try {
                        FachadaBarco.listarBarcos();
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;
                    
                case "4.1":
                    System.out.println(">>Mostrar Barco\n");
                    System.out.println(">>Ingrese el id del barco que desea mostrar: \n");
                    System.out.print(">> ");
                    String idBarco = bufferedReader.readLine();
                        try {
                            if (checkArgs(idBarco)) {
                                FachadaBarco.mostrarBarco(idBarco);
                            }
                        } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "5":
                    System.out.println(">>Agregar Contenedor: "
                            + "\nIngrese los datos del contenedor separados por coma "
                            + "(Codigo,Marca,Modelo,Capacidad(kgs))\n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg)) {
                            FachadaContenedor.agregarContenedor(arg);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;
                case "6":
                    System.out.println(">>Eliminar Contenedor: \n");
                    FachadaContenedor.listarContenedores();
                    System.out.println(">>Ingrese el codigo del contenedor que desea eliminar: \n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg)) {
                            FachadaContenedor.eliminarContenedor(arg);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "7":
                    System.out.println(">>Modificar Contenedor: \n");
                    FachadaContenedor.listarContenedores();
                    System.out.println(">>Ingrese el codigo del contenedor que desea modificar: \n");
                    System.out.print(">> ");
                    String codContenedor = bufferedReader.readLine();
                    try {
                        if (checkArgs(codContenedor)) {
                            FachadaContenedor.mostrarContenedor(codContenedor);
                            System.out.println("\nIngrese los datos del contenedor separados por coma "
                                    + "(Codigo,Marca,Modelo,Capacidad(kgs))\n");
                            System.out.print(">> ");
                            arg = bufferedReader.readLine();
                            if (checkArgs(arg)) {
                                FachadaContenedor.modificarContenedor(codContenedor, arg);
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "8":
                    System.out.println(">>Listar Contenedores\n");
                    try {
                        FachadaContenedor.listarContenedores();
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;
                    
                case "8.1":
                    System.out.println(">>Mostrar Contenedor\n");
                    System.out.println(">>Ingrese el id del contenedor que desea mostrar: \n");
                    System.out.print(">> ");
                    String idContenedor = bufferedReader.readLine();
                        try {
                            if (checkArgs(idContenedor)) {
                                FachadaContenedor.mostrarContenedor(idContenedor);
                            }
                        } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "9":
                    System.out.println(">>Registrar Arribo: \n"
                            + "\nIngrese los datos del arribo separados por coma "
                            + "(Origen,Fecha(dd-MM-yyyy),Descripcion del contenido,Codigo de barco)\n");
                    System.out.print(">> ");
                    String datos = bufferedReader.readLine();
                    System.out.println("\nIngrese el codigo de los contenedores separados por coma (c001,j001,5a0)\n");
                    System.out.print(">> ");
                    String contenedores = bufferedReader.readLine();
                    try {
                        if (checkArgs(datos) && checkArgs(contenedores)) {
                            FachadaArribo.registrarArribos(datos, contenedores);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "10":
                    System.out.println(">>Generar Reporte de arribos por Mes: \n"
                            + "\nIngrese el mes para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg)) {
                            FachadaArribo.generarReporteArribosMes(arg);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "11":
                    System.out.println(">>Generar Reporte de arribos por Mes y Barcos: \n"
                            + "\nIngrese el mes para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    arg = bufferedReader.readLine();
                    System.out.println(">>Ingrese el codigo de barco para el cual desea generar el reporte \n");
                    System.out.print(">> ");
                    codBarco = bufferedReader.readLine();
                    try {
                        if (checkArgs(arg) && checkArgs(codBarco)) {
                            FachadaArribo.generarReporteArribosMesBarco(arg, codBarco);
                        }
                    } catch (Exception ex) {
                        System.out.println("Lo siento a ocurrido un error, Error: " + ex.getMessage());
                    }
                    break;

                case "12":
                    try {
                        FachadaProfiling.obtenerReportesProfiling();
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
        System.out.println(">> 1 -\tAgregar Barco");
        System.out.println(">> 2 -\tEliminar Barco");
        System.out.println(">> 3 -\tModificar Barco");
        System.out.println(">> 4 -\tListar Barcos");
        System.out.println(">> 5 -\tAgregar Contenedor");
        System.out.println(">> 6 -\tEliminar Contenedor");
        System.out.println(">> 7 -\tModificar Contenedor");
        System.out.println(">> 8 -\tListar Contenedores");
        System.out.println(">> 9 -\tRegistrar arribo");
        System.out.println(">> 10 -\tReporte arribos por mes");
        System.out.println(">> 11 -\tReporte arribos por mes y barco");
        System.out.println(">> 12 -\tProfiling");
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
