package com.example.ProjectCalcio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
@Getter
public class Database {
    private final String user = "root";
    private final String password = "root1998%";
    private final String percorso = "jdbc:mysql://localhost:3306/";
    private final String addDBConn = "?useSSL=false&serverTimezone=UTC";

    private Connection cn;

    public Database(String nomeDatabase) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(percorso + nomeDatabase + addDBConn, user, password);

        } catch (ClassNotFoundException e) {
            System.err.println("Classe Driver non trovata !!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Impossibile collegarsi al Database");
            e.printStackTrace();
        }
    }

    public void chiudiConnection() {
        try {
            if (cn != null)
                cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void chiudiComunicazioni(PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Errore nella chiusura delle comunicazioni: " + e.getMessage());
        }
    }

    public Map<Integer, Map<String, String>> eseguiQuery(String query, String... parametri) {

        Map<Integer, Map<String, String>> ris = new HashMap<Integer, Map<String, String>>();
        

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cn.prepareStatement(query);
            for (int i = 0; i < parametri.length; i++) {
               
                ps.setString(i + 1, parametri[i]);
            }

            rs = ps.executeQuery();
            Map<String, String> mappaParametri;
            while (rs.next()) {
                mappaParametri = new HashMap<>();

                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

                    mappaParametri.put(rs.getMetaData().getColumnName(i).toLowerCase().replace("_", ""),
                            rs.getString(i));
                            
                }

                ris.put(rs.getInt("id"), mappaParametri);
            }
        } catch (SQLException e) {
            System.err.println("Errore nell'esecuzione della query: " + query);
            e.printStackTrace();
        } finally {
            chiudiComunicazioni(ps, rs);
        }
        return ris;
    }

     public Map<Integer, Map<String, String>> eseguiQuery1(String query, String... parametri) {
        int index = 0;

        Map<Integer, Map<String, String>> ris = new HashMap<Integer, Map<String, String>>();
        

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = cn.prepareStatement(query);
            for (int i = 0; i < parametri.length; i++) {
               
                ps.setString(i + 1, parametri[i]);
            }

            rs = ps.executeQuery();
            Map<String, String> mappaParametri;
            while (rs.next()) {
                mappaParametri = new HashMap<>();

                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

                    mappaParametri.put(rs.getMetaData().getColumnName(i).toLowerCase().replace("_", ""),
                            rs.getString(i));
                            
                }

                ris.put(index++, mappaParametri);
            }
        } catch (SQLException e) {
            System.err.println("Errore nell'esecuzione della query: " + query);
            e.printStackTrace();
        } finally {
            chiudiComunicazioni(ps, rs);
        }
        return ris;
    }

    public boolean eseguiUpdate(String query, String... parametri) {
        PreparedStatement ps = null;
        System.out.println(parametri + "parametri");

        try {
            ps = cn.prepareStatement(query);
            for (int i = 0; i < parametri.length; i++) {
                ps.setString(i + 1, parametri[i]);
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Errore nell'esecuzione della query: " + query);
        }

        return false;
    }

}
