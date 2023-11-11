package estudiante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
public class operacionesDB {
        private ConexionDB conexiondb;
    public  operacionesDB() throws SQLException{
            conexiondb = new ConexionDB();
    }
    
    
        public void consultarEstudiante(){
        try{
        String estudiante = "SELECT * FROM estudiante";
        ResultSet estu = conexiondb.consultar(estudiante);
        
        while (estu.next()){
        int idEstudiante = estu.getInt("idEstudiante");
        int carnet = estu.getInt("carnet");
        String nombre = estu.getString("nombre");
        int edad = estu.getInt("edad");
        
        System.out.print("id: " + idEstudiante + " - ");
        System.out.print("Juguete: " + carnet + " - ");
        System.out.print("tamanio: " + nombre + " - ");
        System.out.println("precio: " + edad);
                         
            }
    }catch (SQLException e){
        e.printStackTrace();
    } 
}
        public void insertarEstudiante(int carnet, String nombre, int edad) {
        try {
            // Preparar la instrucción INSERT
            String sql = "INSERT INTO estudiante (carnet, nombre, edad) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conexiondb.getConnection().prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setInt(1, carnet);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, edad);

            // Ejecutar la inserción
            pstmt.executeUpdate();
            System.out.println("Estudiante insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
