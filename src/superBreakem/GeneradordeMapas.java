package superBreakem;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


import java.awt.BasicStroke;
public class GeneradordeMapas {
	public int mapa[][];
	public int ladrilloancho;
	public int ladrillolargo;
	public int nivel=0;
	InputStream image;
	Image[] FondoLadrillo;
	
	public GeneradordeMapas(int fila,int col, int nivel)
	{
		FondoLadrillo = new Image[4];
		try {
			for (int i=0;i<4;i++) { 
				image=GeneradordeMapas.class.getResourceAsStream("/img/brick-"+(i+1)+".png"); 
				FondoLadrillo[i]=ImageIO.read(image); 
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		
		this.nivel=nivel;
		mapa=new int[fila][col];
		
		for(int f=0;f<mapa.length;f++)
		{
			for(int c=0;c<mapa[0].length;c++)
			{
				mapa[f][c]=nivel;
				
			}
		}
		
		ladrilloancho=540/col;
		ladrillolargo=150/fila;
		
		
	}
	public void dibujar(Graphics2D g)
	{
		for(int f=0;f<mapa.length;f++)
		{
			for(int c=0;c<mapa[0].length;c++)
			{
				if(mapa[f][c]==1)
				{
					
					g.drawImage(FondoLadrillo[0],c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo, null);
					//g.setColor(Color.green);
					//g.fillRect(c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo);
					//g.setStroke(new BasicStroke(3));
					//g.setColor(Color.black);
					g.drawRect(c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo);
				} 
				if(mapa[f][c]==2)
				{
					
					g.drawImage(FondoLadrillo[1],c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo, null);
				//	g.setColor(Color.red);
					//g.fillRect(c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo);
					//g.setStroke(new BasicStroke(3));
					//g.setColor(Color.black);
				//	g.drawRect(c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo);
				}
				if(mapa[f][c]==3)
				{
					g.drawImage(FondoLadrillo[2],c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo, null);
					//g.setColor(Color.yellow);
					//g.fillRect(c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo);
					//g.setStroke(new BasicStroke(3));
					//g.setColor(Color.black);
					//g.drawRect(c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo);
				}
				if(mapa[f][c]==4)
				{
					g.setColor(Color.blue);
					g.fillRect(c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo);
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(c*ladrilloancho+80,f*ladrillolargo+50,ladrilloancho,ladrillolargo);
				}
					
				
			}
		}
	}
	
	public void setLadrillo(int fila,int col)
	{
		mapa[fila][col]=mapa[fila][col]-1;
	}
	
	

}
