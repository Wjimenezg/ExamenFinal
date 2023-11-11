package estudiante;

import java.sql.SQLException;
import java.util.Scanner;
public class Estudiante {
    public static void main(String[] args) {
                try {
            // Crear una instancia de operacionesDB para interactuar con la base de datos
            operacionesDB operaciones = new operacionesDB();

            // Usar un objeto Scanner para obtener datos del usuario
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el carnet del estudiante: ");
            int carnet = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente

            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la edad del estudiante: ");
            int edad = scanner.nextInt();

            // Insertar el estudiante en la base de datos
            operaciones.insertarEstudiante(carnet, nombre, edad);

            // Consultar y mostrar los estudiantes en la base de datos
            operaciones.consultarEstudiante();

            // Cerrar el Scanner
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    }
    

