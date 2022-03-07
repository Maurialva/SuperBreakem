package superBreakem;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.io.InputStream;

import javax.swing.Timer;

import DAO.DAOPuntaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Juego extends JPanel implements KeyListener,ActionListener{

	private boolean play=false;
	private int puntaje=0;
	private int ladrillos=21;
	private Timer tiempo;
	private int vidas=3;
	public int nivel=1;
	private int delay=8;
	private int playerX=310;
	private int bolaX=120;
	private int  bolaY=350;
	private int bolaXdir=-3;
	private int bolaYdir=-3;
	private GeneradordeMapas mapa;
	private boolean restart=false;
	InputStream imgbola;
	Image fondobola;
	InputStream imageFondo;
	Image FondoNivel;
	InputStream imageBarra;
	Image FondoBarra;
	List<String> lista;
	List<Long> listaP;
	 DAOPuntaje DAOpuntajes;

	int dificultad;
	public Juego() throws Exception {
		
		
		DAOpuntajes= new DAOPuntaje();
		listar();
		mapa=new GeneradordeMapas(3,7,nivel);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		Math.floor(Math.random()*(680-10+1)+10);
		bolaX=(int) Math.floor(Math.random()*(680-10+1)+10);
		tiempo=new Timer(delay,this);
		tiempo.start();
		imgbola = Juego.class.getResourceAsStream("/img/ball.png"); 
		
		try {
			fondobola=ImageIO.read(imgbola); 
		} catch(Exception e)
		{
			
		}
		imageFondo = Juego.class.getResourceAsStream("/img/fondoMain2.png"); 
		
		try {
			FondoNivel=ImageIO.read(imageFondo); 
		} catch(Exception e)
		{
			
		}
		imageBarra = Juego.class.getResourceAsStream("/img/bar2.png"); 
		
		try {
			FondoBarra=ImageIO.read(imageBarra); 
		} catch(Exception e)
		{
			
		}
		
	}
	
	public void listar() throws Exception
	{
		lista=DAOpuntajes.Listar();
		listaP=DAOpuntajes.ListaPuntaje();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
	
		
		//fondo
		//g.setColor(Color.black);
		//g.fillRect(1,1,692,592);
		g.drawImage(FondoNivel,1,1,982,560, null);
		
		//mapa
		mapa.dibujar((Graphics2D)g);
		
		//puntaje
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 20));
		
		//g.drawString("SUPER BREAK'EM",730,40);
		
		g.drawString("Puntaje: "+puntaje,720,70);
		g.drawString("Vidas: "+vidas,720,100);
		g.drawString("Nivel: "+nivel,720,125);
		g.drawString("TOP10 PUNTAJES",720,230);
		g.drawString("1     "+lista.get(0),720,250);
		g.drawString("2     "+lista.get(1),720,270);
		g.drawString("3     "+lista.get(2),720,290);
		g.drawString("4     "+lista.get(3),720,310);
		g.drawString("5     "+lista.get(4),720,330);
		g.drawString("6     "+lista.get(5),720,350);
		g.drawString("7     "+lista.get(6),720,370);
		g.drawString("8     "+lista.get(7),720,390);
		g.drawString("9     "+lista.get(8),720,410);
		g.drawString("10   "+lista.get(9),720,430);
		g.drawString(listaP.get(0).toString(),850,250);
		g.drawString(listaP.get(1).toString(),850,270);
		g.drawString(listaP.get(2).toString(),850,290);
		g.drawString(listaP.get(3).toString(),850,310);
		g.drawString(listaP.get(4).toString(),850,330);
		g.drawString(listaP.get(5).toString(),850,350);
		g.drawString(listaP.get(6).toString(),850,370);
		g.drawString(listaP.get(7).toString(),850,390);
		g.drawString(listaP.get(8).toString(),850,410);
		g.drawString(listaP.get(9).toString(),850,430);
		//g.drawString("jamon", 500 , 360);
		
		//bordes
		//g.setColor(Color.yellow);
		//g.fillRect(0,0,3,592);
	//	g.fillRect(0,0,692,3);
		//g.fillRect(691,0,3,592);
		
		//paleta
		//g.setColor(Color.green);
		g.fillRect(playerX,550,100,8);
		g.drawImage(FondoBarra, playerX, 550, 100, 15, null);
		
		//bola
		//g.setColor(Color.red);
		g.drawImage(fondobola, bolaX, bolaY, 25, 25, null);
		//g.fillOval(bolaX,bolaY,20,20);
		g.dispose();
		
		//control de vidas y game over
	
		
	}
	
	
	
	private void gameOver() throws HeadlessException, Exception {
		
		if(DAOpuntajes.top10(puntaje))
		{
			String m = JOptionPane.showInputDialog("Felicidades, rompiste un record. Ingresa 4 letras para tu nombre.");
			
			if(m==null || m.length()==0)
			{
				m="ANON";
			}
			if(m.length()<4)
			{
				m=m+"    ";
			}
			
			m= m.substring(0, Math.min(m.length(), 4));
			DAOpuntajes.Agregar(m.toUpperCase(), puntaje);	
		}
		
		if(nivel==4 && ladrillos==0)
		{
			if (JOptionPane.showConfirmDialog(getRootPane(), "Intentar de Nuevo?",
	                "FELICIDADES COMPLETASTE EL JUEGO: "+puntaje, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    {
				restart();
	     }
		else
	      {
			 System.exit(0);
	      }
			
		}else
		{
			if (JOptionPane.showConfirmDialog(getRootPane(), "Intentar de Nuevo?",
	                "PERDISTE TU PUNTAJE ES: "+puntaje, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    {
				restart();
	     }
		else
	      {
			 System.exit(0);
	      }
			
		}
		
		
	
	}

	
	private void restart() throws Exception {
	listar();
	bolaX=(int) Math.floor(Math.random()*(680-10+1)+10);
	bolaY=300;
	bolaXdir=-3;
	bolaYdir=-3;
	ladrillos=21;
	puntaje=0;
	playerX=300;
	nivel=1;
	vidas=3;
	delay=8;
	mapa=new GeneradordeMapas(3,7,nivel); 
		
	}

	private void SubirNivel() {
		bolaX=(int) Math.floor(Math.random()*(680-10+1)+10);
		bolaY=300;
		bolaXdir=-3;
		bolaYdir=-3;
		playerX=300;
		nivel++;
		ladrillos=21*nivel;
		mapa=new GeneradordeMapas(3,7,nivel); 
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		tiempo.start();
		
		if(play)
		{
			
			
			if(bolaY>570)
			{
				if(vidas<=1)
				{
					vidas--;
					play=false;
					bolaXdir=0;
					
					bolaYdir=0;
					repaint();
					try {
						gameOver();
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else
				{
					vidas--;
					bolaY-=20;
					//bolaXdir=-bolaXdir;
					bolaYdir=-bolaYdir;
				}
			}
			
		
			
			
			
			if(new Rectangle(bolaX,bolaY,20,20).intersects(new Rectangle(playerX,550,100,8)))
			{
				if(bolaXdir==-3)
				{
					if(bolaX<=playerX+50)
					{bolaYdir=-bolaYdir;
					
					}else
					{bolaYdir=-bolaYdir;
					bolaXdir=-bolaXdir;}
					
					//bolaYdir=-bolaYdir;
				}else
				{
					if(bolaX>=playerX+50)
					{bolaYdir=-bolaYdir;
					
					}else
					{bolaYdir=-bolaYdir;
					bolaXdir=-bolaXdir;}
					
					//bolaYdir=-bolaYdir;
				}
				
			}
			
			A: for(int f=0;f<mapa.mapa.length;f++)
			{
				for(int c=0;c<mapa.mapa[0].length;c++)
				{
					if(mapa.mapa[f][c]!=0)
					{
						int ladrilloX=c*mapa.ladrilloancho+80;
						int ladrilloY=f*mapa.ladrillolargo+50;
						int ladrillolargo=mapa.ladrillolargo;
						int ladrilloancho=mapa.ladrilloancho;
						
						Rectangle rectangulo=new Rectangle(ladrilloX,ladrilloY,ladrillolargo,ladrilloancho);
						Rectangle bolaRectangulo= new Rectangle(bolaX,bolaY,20,20);
						Rectangle Ladrillo=rectangulo;
						
						if(bolaRectangulo.intersects(Ladrillo))
						{
							mapa.setLadrillo(f,c);
							
							puntaje+=5;
							dificultad+=1;
							if(dificultad==10)
							{
								if(bolaYdir<0)
								{
									bolaYdir--;
								}
								else {
									bolaYdir++;
								}
								if(delay>1)
								{
									delay--;
								}
							
								dificultad=0;
								
							}
							
							
							ladrillos--;
							if(bolaX+19<=Ladrillo.x||bolaX+1>=Ladrillo.x+Ladrillo.width)
							{
							bolaXdir=-bolaXdir;
							}else
							{
								bolaYdir=-bolaYdir;
							}
							if(ladrillos==0)
							{
								if(nivel<4)
									SubirNivel();
								else
									try {
										gameOver();
									} catch (HeadlessException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
							}
							
							break A;
						}
						
								
					}
				}
			}
			
			bolaX+=bolaXdir;
			bolaY+=bolaYdir;
			if(bolaX<0)
			{
				bolaXdir=-bolaXdir;
			}
			if(bolaY<0)
			{
				bolaYdir=-bolaYdir;
			}
			if(bolaX>670)
			{
				bolaXdir=-bolaXdir;
			}
		}
		
		
		
		repaint();
		
		
		
			
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(playerX>=560)
			{
				playerX =590;
			}else
			{
				moverDer();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(playerX<10)
			{
				playerX =2;
			}else
			{
				moverIzq();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			play=true;
		}
	}

	private void moverIzq() {
	
		if(vidas>=1)
		{
			play=true;
			playerX-=20;
		}
		
		
		
	}

	private void moverDer() {
		if(vidas>=1)
		{
			play=true;
			playerX+=20;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
