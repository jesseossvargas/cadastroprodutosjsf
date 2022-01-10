package org.jesse.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class ConexaoFactory {

    public static Connection getConexao(){
        Connection conexao = null;
        try{
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mavenwebapparchetype");
            conexao = dataSource.getConnection();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        System.out.println(conexao);
        return conexao;
    }

}
