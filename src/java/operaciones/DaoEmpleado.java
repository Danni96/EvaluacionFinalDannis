package operaciones;
import java.util.ArrayList;
import entidad.Empleado;
import java.sql.*;

public class DaoEmpleado {
    
    public ArrayList<Empleado> consultarEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            String sql = "SELECT idempleado, nombre_empleado, sueldo FROM empleados";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado(
                        rs.getInt("idempleado"),
                        rs.getString(2),
                        rs.getDouble(3));
                lista.add(e);
            }
            con.close();
            return lista;
        } catch (SQLException e) {
            
            return null;
        }
    }

    public int insertarEmpleado(Empleado e) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            String sql = "INSERT INTO empleados(nombre_empleado, sueldo) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre_empleado());
            ps.setDouble(2, e.getSueldo());
            int result = ps.executeUpdate();
            con.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    }

    public Empleado obtenerEmpleado(int id) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            String sql = "SELECT idempleado, nombre_empleado, sueldo FROM empleados WHERE idempleado = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("idempleado"),
                        rs.getString("nombre_empleado"),
                        rs.getDouble("sueldo"));
                con.close();
                return empleado;
            } else {
                con.close();
                return null;
            }
        } catch (SQLException e) {
            
            return null;
        }
    }
    
    
    public int eliminarEmpleado(int idempleado) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            String sql = "delete from empleados where idempleado =" + idempleado;
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        } 
    }
    public int modificarEmpleado(Empleado e) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            String sql = "update empleados set nombre_empleado = ?, sueldo = ? where idempleado = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre_empleado());
            ps.setDouble(2, e.getSueldo());
            ps.setInt(3, e.getIdempleado());
            return ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        } 
    }
    
}
