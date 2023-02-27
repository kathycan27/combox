import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class bto {
    private JComboBox comboBox1;
    private JPanel panel1;
    Connection cr;

    ArrayList mListaMaterias;

    private ArrayList<Materia> materiass;



    public bto() {

        cr=getConection();
        mListaMaterias=new ArrayList();
        llenar();
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenar();
            }
        });
    }


public void llenar() {
        Connection c=getConection();

    comboBox1.removeAllItems();
mListaMaterias=getListMateriass();

    Iterator iterator = mListaMaterias.iterator();
    while (iterator.hasNext()) {
        Materia mMateria = (Materia) iterator.next();
        comboBox1.addItem(mMateria);
    }


}
    public ArrayList getListMateriass()
    {

        ArrayList mListaMaterias=new ArrayList();
        Materia mMateria=null;
        Statement consulta;
        ResultSet resultado;
        cr=getConection();
        try {
            consulta= cr.createStatement();
            resultado=consulta.executeQuery("select * from materias");
            while (resultado.next())
            {
                mMateria=new Materia();
                mMateria.setId_materia(resultado.getInt("materia_id"));
                mMateria.setNombre_materia(resultado.getString("nombre"));
                mListaMaterias.add(mMateria);
            }

        }catch (SQLException e)
        {

        }
        return mListaMaterias;
    }
    public static Connection getConection() {
        Connection con = null;
        String base = "escuela";
        String url = "jdbc:mysql://localhost:3307/" + base;
        String user = "root";
        String password = "Luchito2724";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
             System.out.println("si se conecto");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            System.out.println("noo");
        }
        return con;


    }
    public static void main(String[] args) {
        JFrame frame=new JFrame("Tienda de abarrotes");
        frame.setContentPane(new bto().panel1);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
