package pe.edu.upeu.syscenterlife.connx;
// pagina 9 o inicio de 10 copiar el getFileExterno
//corregir par javaniofile patjs
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
public class UtilsX {
    public File getFileExterno(String carpeta, String filex) {
        File newFolder = new File(carpeta);
        String ruta = newFolder.getAbsolutePath();
        Path CAMINO = Paths.get(ruta + "/" + filex);
        return CAMINO.toFile();
    }
}
