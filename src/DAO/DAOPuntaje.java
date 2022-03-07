package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;


public class DAOPuntaje {

	DAOConexion dcon;
	 ResultSet registro;
	 ArrayList<String> lista;
	
	
	public DAOPuntaje()
	{
		dcon=new DAOConexion();
	}


/*
	public boolean Buscar(int id) throws Exception {
		try
		{
			Connection conx=dcon.Conectar();
			PreparedStatement st=conx.prepareStatement("select id_codigo,nombre,cantidad from articulos where id_codigo=?");
		
		
			st.setInt(1, id);
			
			registro=st.executeQuery();
			if(registro.next())
			{
				ar=new Puntaje(registro.getInt(1),registro.getString(2),registro.getInt(3));
				
			}
			registro.close();
			dcon.cerrarconexion();
			return false;
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}


	@Override
	public Puntaje Buscar(long puntaje) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			Connection conx=dcon.Conectar();
			PreparedStatement st=conx.prepareStatement("select id_codigo,nombre,cantidad from articulos where nombre=?");
		
		
			st.setLong(1, puntaje);
			Puntaje ar=null;
			registro=st.executeQuery();
			if(registro.next())
			{
				ar=new Puntaje(registro.getInt(1),registro.getString(2),registro.getInt(3));
				
			}
			registro.close();
			dcon.cerrarconexion();
			return ar;
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
		
		
*/
	public  ArrayList<String>Listar() throws Exception {
		// TODO Auto-generated method stub
		try
		{
			Connection cnx=dcon.Conectar();
			PreparedStatement comando=cnx.prepareStatement("select Name from scoreboard order by Score desc LIMIT 10");
			 ArrayList<String> lista=new ArrayList<String>();
			registro=comando.executeQuery();
			
			while(registro.next()==true)
			{
				String nombre= registro.getString(1);				
				lista.add(nombre);
			}
			registro.close();
			return lista;
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	public  ArrayList<Long>ListaPuntaje() throws Exception {
		// TODO Auto-generated method stub
		try
		{
			Connection cnx=dcon.Conectar();
			PreparedStatement comando=cnx.prepareStatement("select Score from scoreboard order by Score desc LIMIT 10");
			 ArrayList<Long> lista=new ArrayList<Long>();
			registro=comando.executeQuery();
			
			while(registro.next()==true)
			{
				
				Long puntaje=registro.getLong(1);
				
				
				lista.add(puntaje);
			}
			registro.close();
			return lista;
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	public void Agregar(String nombre, long puntaje)throws Exception {
		// TODO Auto-generated method stub
		
		try
		{
			Connection conx=dcon.Conectar();
			PreparedStatement st=conx.prepareStatement("insert into scoreboard (Score,Name) values(?,?)");
			st.setLong(1, puntaje);
			st.setString(2, nombre);
			st.executeUpdate();		
			
			dcon.cerrarconexion();
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	
	public boolean top10(long puntaje) throws Exception
	{
		 ArrayList<Long> listapuntaje=this.ListaPuntaje();
		for (Long puntajei :listapuntaje) 
		{ 
			if (puntajei<puntaje)
			{
				 return true;
			}
		}
		return false;
	}
	
	

}
