package DAO;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

import javax.swing.JOptionPane;



public class DAOConexion {
	
	Connection cnn;
	
	
	public Connection Conectar()
	{
		try
		{
			//System.out.println(System.getProperty("user.dir")); //Lo usamos para ver donde esta la ruta activa del archivo
			Properties config = new Properties();
			InputStream configInput = null;
			configInput = new FileInputStream("cnf.properties");
		    config.load(configInput);		    
			cnn=DriverManager.getConnection(config.getProperty("url"),config.getProperty("user"),config.getProperty("pass"));
			/*Si quiero modificar una propiedad
			 * 
			 * public  Properties config = new Properties();
				public  InputStream configInput = null;
			public  OutputStream configOutput = null;


	        try{
	            configOutput = new FileOutputStream("data/config.properties");
	            config.setProperty("url", "nuevaruta");
	            config.setProperty("user", "fabian");
	        } catch(Exception e){
	            JOptionPane.showMessageDialog(null, "Error guardando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
    			}
			 * 
			 */
			 
			
		}
		catch(Exception ex)
		{
			
		}
		finally
		{
			
			
			return cnn;
		}
	}
	
	public void cerrarconexion() throws Exception 
	{
		try
		{
			 cnn.close();
			
		}
		catch(SQLException ex)
		{
			throw ex;
		}
	}
	

}
