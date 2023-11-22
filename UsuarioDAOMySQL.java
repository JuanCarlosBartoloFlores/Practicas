 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class UsuarioDAOMySQL {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/usuario";
    private static final String usr = "root";
    private static final String pass = "";

    public String id;
    public String nom;
    public String ap;
    public String correo;
    public String con;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }

    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usr, pass);
            System.out.println("Conexion correcta");
        } catch (SQLException e) {
            System.out.println("Error en conexion");
            e.printStackTrace();
        }
        return con;
    }

    public void insertar() {
        try {
            Connection cn = conectar();
            String insertar = "insert into usuarios value (?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(insertar);
            pstm.setString(1, id);
            pstm.setString(2, nom);
            pstm.setString(3, ap);
            pstm.setString(4, correo);
            pstm.setString(5, con);

            pstm.executeUpdate();

            System.out.println("Registro insertado");
            JOptionPane.showMessageDialog(null, "Registro Agregado");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al insertar");
            e.printStackTrace();
        }
    }

    public void selecreg() {
        try {
            Connection cn = conectar();
            // Agregar código para seleccionar un registro según el ID
            // y actualizar los valores de nom, ap, correo, con

            // Ejemplo:
            String seleccionar = "select nombre, apellido, CorreoElectronico, contraseña from usuarios where id=?";
            PreparedStatement pstm = cn.prepareStatement(seleccionar);
            pstm.setString(1, id);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nom = rs.getString("nombre");
                ap = rs.getString("apellido");
                correo = rs.getString("CorreoElectronico");
                con = rs.getString("contraseña");
            }

            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar el registro");
            e.printStackTrace();
        }
    }

    public void actreg() {
        try {
            Connection cn = conectar();
            // Agregar código para actualizar el registro según el ID
            // con los nuevos valores de nom, ap, correo, con

            // Ejemplo:
            String actualizar = "update usuarios set nombre=?, apellido=?, CorreoElectronico=?, contraseña=? where id=?";
            PreparedStatement pstm = cn.prepareStatement(actualizar);
            pstm.setString(1, nom);
            pstm.setString(2, ap);
            pstm.setString(3, correo);
            pstm.setString(4, con);
            pstm.setString(5, id);

            pstm.executeUpdate();

            System.out.println("Registro actualizado");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar el registro");
            e.printStackTrace();
        }
    }

    public void elimreg() {
        try {
            Connection cn = conectar();
            // Agregar código para eliminar el registro según el ID

            // Ejemplo:
            String eliminar = "delete from usuarios where id=?";
            PreparedStatement pstm = cn.prepareStatement(eliminar);
            pstm.setString(1, id);

            pstm.executeUpdate();

            System.out.println("Registro eliminado");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar el registro");
            e.printStackTrace();
        }
    }

    public void crearUsuario(Usuario usuario1) {
        }
        public List<Usuario> obtenerTodosLosUsuarios() {
            return null;
        }
        public void actualizarUsuario(Usuario usuario1) {
        }
        public void eliminarUsuario(int i) {
        }
}
