import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;


        while (!salir) {
            menuPrincipal();
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Opcion invalida, intenta de nuevo");
                continue;
            }
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 ->{
                    System.out.println("--- AGREGAR CONTACTO ---");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("Error: El nombre no puede estar vacio");
                        return;
                    }
                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine().trim();
                    System.out.print("Email: ");
                    String email = scanner.nextLine().trim();
                    agenda.agregarContacto(new Contacto(nombre, telefono, email));
                }
                case 2 ->{
                    System.out.println("--- BUSCAR CONTACTO ---");
                    System.out.print("Nombre contacto: ");
                    String nombre = scanner.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("Error: El nombre no puede estar vacio");
                        return;
                    }
                    System.out.println("-" + agenda.buscarContacto(nombre));

                }
                case 3 ->{
                    System.out.println("--- ELIMINAR CONTACTO ---");
                    System.out.print("Nombre contacto: ");
                    String nombre = scanner.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("Error: El nombre no puede estar vacio");
                        return;
                    }
                    System.out.println("-" + agenda.eliminarContacto(nombre));
                }
                case 4 ->{
                    System.out.println("--- LISTA DE CONTACTOS (orden alfabetico) ---");
                    agenda.listarContactos();
                }
                case 5 ->{
                    System.out.println("--- HISTORIAL (orden de insercion) ---");
                    agenda.listarHistorial();
                }
                case 6 ->{
                    System.out.print("Nombre del grupo: ");
                    String nombre = scanner.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("Error: El nombre no puede estar vacio");
                        return;
                    }
                    agenda.agregarGrupo(nombre);
                }
                case 7 ->{
                    System.out.print("Nombre del Contacto: ");
                    String nombreContacto = scanner.nextLine().trim();
                    System.out.print("Nombre del Grupo: ");
                    String nombreGrupo = scanner.nextLine().trim();
                    if (nombreContacto.isEmpty() && nombreGrupo.isEmpty()) {
                        System.out.println("Error: El nombre no puede estar vacio");
                        return;
                    }
                    agenda.agregarContactoAGrupo(nombreContacto, nombreGrupo);
                }
                case 8 ->{
                    System.out.println("--- LISTA DE GRUPOS ---");
                    agenda.listarGrupos();
                }
                case 9 ->{
                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = scanner.nextLine().trim();
                    System.out.println("Contactos en " + "'"+ nombreGrupo+ "'");
                    if (nombreGrupo.isEmpty()) {
                        System.out.println("Error: El nombre no puede estar vacio");
                        return;
                    }
                    agenda.mostrarContactosPorGrupo(nombreGrupo);
                }
                case 10 -> {
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                }
                default -> {
                    System.out.println("Numero incorrecto: Saliendo del sistema");
                    salir = true;
                }
            }
        }


    }
    public static void menuPrincipal(){
        System.out.println();
        System.out.println("=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Listar contactos (orden alfabetico)");
        System.out.println("5. Listar historial (orden de insercion)");
        System.out.println("6. Agregar grupo");
        System.out.println("7. Agregar contacto a grupo");
        System.out.println("8. Listar grupos");
        System.out.println("9. Mostrar contactos por grupo");
        System.out.println("10. Salir");
        System.out.println("==========================");
        System.out.print("Elige una opcion: ");
    }
}

