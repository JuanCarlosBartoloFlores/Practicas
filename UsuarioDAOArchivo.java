import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOArchivo implements UsuarioDAO {

    private static final String ARCHIVO_USUARIOS = "usuarios.dat";

    @Override
    public void crearUsuario(Usuario usuario) {
        List<Usuario> usuarios = leerUsuariosDesdeArchivo();
        usuarios.add(usuario);
        escribirUsuariosEnArchivo(usuarios);
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        List<Usuario> usuarios = leerUsuariosDesdeArchivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return leerUsuariosDesdeArchivo();
    }

    @Override
    public void actualizarUsuario(Usuario usuarioActualizado) {
        List<Usuario> usuarios = leerUsuariosDesdeArchivo();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioActualizado.getId()) {
                usuarios.set(i, usuarioActualizado);
                escribirUsuariosEnArchivo(usuarios);
                return;
            }
        }
    }

    @Override
    public void eliminarUsuario(int id) {
        List<Usuario> usuarios = leerUsuariosDesdeArchivo();
        usuarios.removeIf(usuario -> usuario.getId() == id);
        escribirUsuariosEnArchivo(usuarios);
    }

    private List<Usuario> leerUsuariosDesdeArchivo() {
        List<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Manejar excepciones según tus necesidades (puede que el archivo no exista inicialmente)
        }
        return usuarios;
    }

    private void escribirUsuariosEnArchivo(List<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            // Manejar excepciones según tus necesidades
        }
    }
}
