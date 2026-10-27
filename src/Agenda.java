import java.util.*;

public class Agenda {
    TreeMap<String, Contacto> contactos = new TreeMap<>();
    Set<String> listaContactosSinDuplicados = new TreeSet<>();
    TreeMap<String, Set<String>> listaContactosOrdenados = new TreeMap<>();
    List<Contacto> listaContactos = new ArrayList<>();


    public void AgregarContacto(Contacto c){
        if (contactos.containsKey(c.getNombre())){
            throw new IllegalArgumentException("Contacto ya existe");
        }
        contactos.put(c.getNombre(), c);
    }

    public String buscarContacto(String nombre) {
        if (contactos.containsKey(nombre)){
            return contactos.get(nombre).getNombre();
        }
        return null;
    }

    public boolean eliminarContacto(String nombre){
        // Elimina del Map , del historial y
        //de todos los grupos. Retorna
        //true si se eliminó.
        if (contactos.containsKey(nombre)){
            contactos.remove(nombre);
            return true;
        }
        return false;
    }

    public void listarContactos(){
        for(Map.Entry<String, Contacto> entrada : contactos.entrySet()){
            System.out.println(entrada.getKey() + " - " + entrada.getValue().getNombre());
        }
    }

    public void listarHistorial(){
        for (Contacto c : listaContactos){
            System.out.println(c.getNombre());
        }
    }

    public void agregarGrupo(String nombreGrupo){
        if  (listaContactosSinDuplicados.contains(nombreGrupo)){
            throw new IllegalArgumentException("Grupo ya existe");
        }
        listaContactosSinDuplicados.add(nombreGrupo);
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo){
        if (listaContactosOrdenados.containsKey(nombreContacto)
        && listaContactosOrdenados.get(nombreContacto).contains(nombreGrupo)){
            listaContactosOrdenados.get(nombreContacto).add(nombreGrupo);
        }
        return;
    }

    public void listarGrupos(){
        for (String nombreGrupo : listaContactosSinDuplicados) {
            System.out.println(nombreGrupo + " - " + listaContactosOrdenados.get(nombreGrupo));
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo){
        if (!listaContactosOrdenados.containsKey(nombreGrupo)){
            System.out.println("Grupo no existe");
        }
        for (Map.Entry<String, Set<String>> entrada : listaContactosOrdenados.entrySet()){
            System.out.println(entrada.getKey() + " - " + entrada.getValue().size());
        }
    }


}
