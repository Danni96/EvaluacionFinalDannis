package operaciones;
import java.sql.*;
public class Conexion {
    private Connection conexion;
    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/rrhh?autoReconnect=true&useSSL=false";
            this.conexion = DriverManager
                    .getConnection(url,"","");
            System.out.println("Conexion OK");
            return this.conexion;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error en la conexion: "+e.getMessage());
            return null;
        }
    }
    public void desconectar(){
        try {
            System.out.println("Conexion cerrada");
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la conexion: "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        conexion.desconectar();
    }
}
