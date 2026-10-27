import java.util.*;

public class Agenda {
    private Map<String, Contacto> contactos = new TreeMap<>();
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();



    public void agregarContacto(Contacto c){
        if (contactos.containsKey(c.getNombre())){
            System.out.println("Error: Ya existe un contacto con el nombre '" + c.getNombre() + "'");
            return;
        }
        contactos.put(c.getNombre(), c);
        historial.add(c);
        System.out.println("Contacto agregado: " + c.getNombre());
    }

    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre){
        Contacto eliminado = contactos.remove(nombre);
        if (eliminado == null) {
            return false;
        }
        historial.remove(eliminado);

        for (Set<String> miembros : contactosPorGrupo.values()) {
            miembros.remove(nombre);
        }
        return true;
    }

    public void listarContactos() {
        System.out.println("--- LISTA DE CONTACTOS (orden alfabetico) ---");
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos.");
            return;
        }
        for (Contacto c : contactos.values()) {
            System.out.println(c);
        }
    }


    public void listarHistorial () {
        System.out.println("--- HISTORIAL (orden de insercion) ---");
        if (historial.isEmpty()) {
            System.out.println("No hay contactos en el historial.");
            return;
        }
        for (Contacto c : historial) {
            System.out.println(c);
        }
    }

    public void agregarGrupo (String nombreGrupo){
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe");
            return;
        }
        grupos.add(nombreGrupo);
        contactosPorGrupo.put(nombreGrupo, new TreeSet<>());
        System.out.println("Grupo '" + nombreGrupo + "' creado");
    }

    public void agregarContactoAGrupo (String nombreContacto, String nombreGrupo){
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        if (contactosPorGrupo.get(nombreGrupo).add(nombreContacto)) {
            System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
        } else {
            System.out.println("El contacto '" + nombreContacto + "' ya pertenece al grupo '" + nombreGrupo + "'");
        }
    }


    public void listarGrupos () {
        System.out.println("--- GRUPOS (orden alfabetico) ---");
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos.");
            return;
        }
        for (String grupo : grupos) {
            System.out.println("- " + grupo);
        }
    }

    public void mostrarContactosPorGrupo (String nombreGrupo){
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }
        Set<String> miembros = contactosPorGrupo.get(nombreGrupo);
        if (miembros.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos");
            return;
        }
        System.out.println("Contactos en '" + nombreGrupo + "':");
        for (String nombre : miembros) {
            System.out.println("- " + contactos.get(nombre));
        }
    }
}
