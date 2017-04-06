//package Cwiczenie2b;

import javax.swing.JApplet;
import java.awt.*;


public class SpringApplet extends JApplet {

  @Override
   public void init() {
       float dlugosc1;
       float dlugosc2;
       Vector2D wektor1 = new Vector2D(3,7);//stworzenie obiektów
       Vector2D wektor2 = new Vector2D(4,2);
       Vector2D wektor3 = new Vector2D();
       Vector2D wektor4 = new Vector2D();
       Vector2D wektor5 = new Vector2D();
       Vector2D wektor6 = new Vector2D();
       Vector2D wektor7 = new Vector2D();
       wektor3=wektor1.suma(wektor2); //operacje na wektorach
       wektor4=wektor1.roznica(wektor2);
       wektor5=wektor3.znormal();
       wektor6=wektor4.znormal();
       dlugosc1=wektor3.dlugosc();
       dlugosc2=wektor4.dlugosc();
       wektor7=wektor3.iloczyn(5);
       System.out.println("Wsp. wektora 1 to (3,7)"); //wypisanie informacji o wektorach
       System.out.println("Wsp. wektora 2 to (4,2)");
       System.out.println("Wsp. sumy wektorów to "+wektor3.x+","+wektor3.y);
       System.out.println("Wsp. różnicy wektorów to "+wektor4.x+","+wektor4.y);
       System.out.println("Pierwszy wektor znormalizowany to "+wektor5.x+","+wektor5.y);
       System.out.println("Drugi wektor znormalizowany to "+wektor6.x+","+wektor6.y);
       System.out.println("Długość pierwszego wektora to "+dlugosc1);
       System.out.println("Długość drugiego wektora to "+dlugosc2);
       System.out.println("Pierwszego wektor pomnożony przez stałą 5 to "+wektor7.x+","+wektor7.y);
   }

  @Override
  public void paint(Graphics g){
       float dlugosc1;
       float dlugosc2;
       Vector2D wektor1 = new Vector2D(3,7);//stworzenie obiektów
       Vector2D wektor2 = new Vector2D(4,2);
       Vector2D wektor3 = new Vector2D();
       Vector2D wektor4 = new Vector2D();
       Vector2D wektor5 = new Vector2D();
       Vector2D wektor6 = new Vector2D();
       Vector2D wektor7 = new Vector2D();
       wektor3=wektor1.suma(wektor2); //operacje na wektorach
       wektor4=wektor1.roznica(wektor2);
       wektor5=wektor3.znormal();
       wektor6=wektor4.znormal();
       dlugosc1=wektor3.dlugosc();
       dlugosc2=wektor4.dlugosc();
       wektor7=wektor3.iloczyn(2);
      
      g.setColor(Color.BLACK);//rysowanie i podpisanie osi
      g.drawLine(200,10,200,410);
      g.drawString("y", 190, 10);
      g.fillPolygon(new int[] {200, 196, 204}, new int[] {10, 20, 20}, 3);
      g.setColor(Color.BLACK);
      g.drawLine(10, 200, 410, 200);
      g.drawString("x", 410, 210);
      g.fillPolygon(new int[] {410, 400, 400}, new int[] {200, 196, 204}, 3);
      g.setColor(Color.RED);
      g.drawLine(200, 200, 200+10*(int)wektor1.x, 200-10*(int)wektor1.y); //rysowanie wszystkich siedmiu wektorów
     g.fillPolygon(new int[] {200+10*(int)wektor1.x, 200+10*(int)wektor1.x-10, 200+10*(int)wektor1.x-3}, new int[] {200-10*(int)wektor1.y, 200-10*(int)wektor1.y+10, 200-10*(int)wektor1.y+15}, 3);
     g.drawLine(200, 200, 200+10*(int)wektor2.x, 200-10*(int)wektor2.y);
     g.fillPolygon(new int[] {200+10*(int)wektor2.x, 200+10*(int)wektor2.x-10, 200+10*(int)wektor2.x-15}, new int[] {200-10*(int)wektor2.y, 200-10*(int)wektor2.y+10, 200-10*(int)wektor2.y+3}, 3);
     g.setColor(Color.GREEN);
     g.drawLine(200, 200, 200+10*(int)wektor3.x, 200-10*(int)wektor3.y);
     g.fillPolygon(new int[] {200+10*(int)wektor3.x, 200+10*(int)wektor3.x-10, 200+10*(int)wektor3.x-3}, new int[] {200-10*(int)wektor3.y, 200-10*(int)wektor3.y+10, 200-10*(int)wektor3.y+15}, 3);
     g.setColor(Color.CYAN);
     g.drawLine(200, 200, 200+10*(int)wektor4.x, 200-10*(int)wektor4.y);
     g.fillPolygon(new int[] {200+10*(int)wektor4.x, 200+10*(int)wektor4.x+7, 200+10*(int)wektor4.x}, new int[] {200-10*(int)wektor4.y, 200-10*(int)wektor4.y+13, 200-10*(int)wektor4.y+15}, 3);
     g.setColor(Color.YELLOW);
     g.drawLine(200, 200, 200+10*(int)wektor5.x, 200-10*(int)wektor5.y);
     g.fillPolygon(new int[] {200+10*(int)wektor5.x, 200+10*(int)wektor5.x-3, 200+10*(int)wektor5.x-1}, new int[] {200-10*(int)wektor5.y, 200-10*(int)wektor5.y+3, 200-10*(int)wektor5.y+5}, 3);
     g.setColor(Color.PINK);
     g.drawLine(200, 200, 200+10*(int)wektor6.x, 200-10*(int)wektor6.y);
     g.fillPolygon(new int[] {200+10*(int)wektor6.x, 200+10*(int)wektor6.x+2, 200+10*(int)wektor6.x}, new int[] {200-10*(int)wektor6.y, 200-10*(int)wektor6.y+4, 200-10*(int)wektor6.y+5}, 3);
     g.setColor(Color.ORANGE);
     g.drawLine(200, 200, 200+10*(int)wektor7.x, 200-10*(int)wektor7.y);
     g.fillPolygon(new int[] {200+10*(int)wektor7.x, 200+10*(int)wektor7.x-10, 200+10*(int)wektor7.x-3}, new int[] {200-10*(int)wektor7.y, 200-10*(int)wektor7.y+10, 200-10*(int)wektor7.y+15}, 3);
    
     //podpisy oraz współrzędne wektorów
     g.setColor(Color.BLACK);
     g.drawString("Czerwony - wektory podstawowe", 10, 500);
     g.drawString("Wsp.: ("+wektor1.x+" ; "+wektor2.y+") oraz ("+wektor2.x+","+wektor2.y+")", 350, 500);
     g.drawString("Zielony - suma", 10, 520);
     g.drawString("Wsp.: ("+wektor3.x+" ; "+wektor3.y+")", 350, 520);
     g.drawString("Niebieski - różnica", 10, 540);
     g.drawString("Wsp.: ("+wektor4.x+" ; "+wektor4.y+")", 350, 540);
     g.drawString("Żółty - wektor sumy", 10, 560);
     g.drawString("Wsp.: ("+wektor5.x+" ; "+wektor5.y+")", 350, 560);
     g.drawString("Różowy - znormalizowany wektor różnicy",10,580);
     g.drawString("Wsp.: ("+wektor6.x+" ; "+wektor6.y+")", 350, 580);
     g.drawString("Pomarańczowy - wektor sumy pomnożony przez stałą", 10, 600);
     g.drawString("Wsp.: ("+wektor7.x+" ; "+wektor7.y+")", 350, 600);
     g.drawString("Długość wektora sumy: "+dlugosc1, 10, 640);
     g.drawString("Długość wektora różnicy: "+dlugosc2, 10, 660);
  }
}
