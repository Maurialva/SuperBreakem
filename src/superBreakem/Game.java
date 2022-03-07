package superBreakem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DAOPuntaje;

import java.awt.RenderingHints;



import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Game {



	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Super Break'em");
		Juego juego= new Juego();
		juego.setBounds(0, 0, 984, 561);
		frame.setBounds(10,10,1000,600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.add(juego);
	/*	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(698, 250, 280, 272);
		frame.add(scrollPane);
		
		DefaultTableModel modelo=new DefaultTableModel();
		JTable table = new JTable(modelo);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("PUESTO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("PUNTAJE");
		
		DAOPuntaje daopuntaje=new DAOPuntaje();
		ArrayList <Puntaje>lista=daopuntaje.Listar();
		modelo.setRowCount(0);
		int i=1;
			for(Puntaje a: lista)
			{
			Object []fila=new Object[3];
			
			fila[0]=i;
			fila[1]=a.getNombre();
			fila[2]=a.getPuntaje();
			modelo.addRow(fila);
			i++;
			
			}*/
		
	}
}