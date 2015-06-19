package login_java.mysql;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    public void acceso(String usuario, String clave) {
        //se instancia la variable para hacer una comparación posterior con la base de datos.
        String db_user = "", db_pass = "";

        //inicio un try/catch para situacion de MYSQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/base_caso", "root", ""); //Aqui se cambian los datos de la ubicacion de la DB
            Statement estado = con.createStatement();
            String consulta = "select * from usuario where user='" + usuario + "' && pass='" + clave + "'";
            ResultSet resultado = estado.executeQuery(consulta);
            //Aquí realizaremos la evaluacion de los datos entregados por el usuario con los de la base de datos.
            while (resultado.next()) {
                db_user = usuario;
                db_pass = clave;
            }
            if (usuario.equals((db_user)) && clave.equals(db_pass)) {
                JOptionPane.showMessageDialog(null, "Login correcto");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o clave incorrecto");
            }
        } catch (ClassNotFoundException | SQLException e) {

        }

    }
}
