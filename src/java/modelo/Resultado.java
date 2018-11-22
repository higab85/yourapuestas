/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sergio
 */
public class Resultado {
    private char resultado;
    private float cuota1;
    private float cuota2;
    private float cuota3;

    public Resultado(char resultado, float cuota1, float cuota2, float cuota3) {
        this.resultado = resultado;
        this.cuota1 = cuota1;
        this.cuota2 = cuota2;
        this.cuota3 = cuota3;
    }

    Resultado(String linea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Resultado(String[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    public float getCuota1() {
        return cuota1;
    }

    public void setCuota1(float cuota1) {
        this.cuota1 = cuota1;
    }

    public float getCuota2() {
        return cuota2;
    }

    public void setCuota2(float cuota2) {
        this.cuota2 = cuota2;
    }

    public float getCuota3() {
        return cuota3;
    }

    public void setCuota3(float cuota3) {
        this.cuota3 = cuota3;
    }

    @Override
    public String toString() {
        return "Resultado{" + "resultado=" + resultado + ", cuota1=" + cuota1 + ", cuota2=" + cuota2 + ", cuota3=" + cuota3 + '}';
    }

    
    
    
    
}
