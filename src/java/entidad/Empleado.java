
package entidad;


public class Empleado {

    private int idempleado;
    private String nombre_empleado;
    private double sueldo;
    
    public Empleado(int idempleado, String nombre_empleado, double sueldo) {
        this.idempleado = idempleado;
        this.nombre_empleado = nombre_empleado;
        this.sueldo = sueldo;
    }

    public Empleado() {
        
    }
    
    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    

   
}
