/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.sun.faces.application.resource.LibraryInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class PartidosFile {

    public List<Partido> cargarPartidos(String rutaCSV) throws FileNotFoundException {
        String linea;
        int cont = 0;
        List<Partido> partidos = new ArrayList<>();
        List<Resultado> resultados = new ArrayList<>();
        Scanner scan = new Scanner(new File(rutaCSV));
        Resultado resultado;
        Partido partido;
        String datos[];
        while (scan.hasNextLine()) {
            linea = scan.nextLine();
            datos = linea.split(";");
            resultado = new Resultado(datos);
            resultados.add(resultado);
            cont++;
            if (cont == 3) {
                partido = new Partido(datos[0], datos[1]);
                partido.setResultados(resultados);
                partidos.add(partido);
                cont = 0;
                resultados = new ArrayList<>();
            }
        }
        return partidos;
    }

}
