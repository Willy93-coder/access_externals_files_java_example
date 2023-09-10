import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Ruta absoluta para llegar al directorio
        String path = "";
        // Creamos un objeto de tipo File que recibe por paramatro la ruta absoluta de un directorio
        File directorio = new File(path + "/ejemplo");
        // Comprobamos la ruta
        System.out.println(directorio.getAbsolutePath());
        // Comprobamos si existe el directorio
        System.out.println(directorio.exists());

        // Creamos un array de strings con los elementos que hay dentro del directorio que hemos pasado
        // El metodo list() devuelve un array de strings de los elementos que haya dentro del directorio
        String[] nombres = directorio.list();
        // Comprobamos que no sea null para controlar que no salte la excepcion NullPointerException
        if (nombres != null) {
            // Recorremos el array con un forEach y pintamos por consola cada archivo
            // y subdirectorios que haya dentro del directorio principal
            for (String nombre : nombres) {
                System.out.println(nombre);
                // Usamos el segundo constructor que recibe por parametro
                // el directorio padre (en este caso seria 'ejemplo')
                // y como segundo parametro recibe el nombre de todos los archivos que tenemos
                File f = new File(directorio.getAbsolutePath(), nombre);
                // Comprobamos si es un directorio
                if (f.isDirectory()) {
                    // Si es un directorio, volvemos a crear un array de strings con los archivos que contenga
                    String[] archivos_subcarpeta = f.list();
                    // Volvemos a comprobar si es nulo
                    if (archivos_subcarpeta != null) {
                        // Si no es nulo, con un bucle forEach lo recorremos e imprimimos
                        // por consola todos los archivos y directorios que contenga
                        for (String archivo : archivos_subcarpeta) System.out.println(archivo);
                    } else System.out.println("El directorio esta vacia");
                }
            }
        } else System.out.println("El directorio esta vacio");
    }
}