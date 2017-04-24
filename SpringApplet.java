import javax.swing.JApplet;
import java.awt.*;
import java.util.Timer;
import java.util.*;


public class SpringApplet extends JApplet{
   
    //utworzenie prywatnych pól do przechowywania obiektów
    private SimEngine simengine1; 
    private SimTask simtask1;
    private Timer timer;
        
    @Override
    public void init(){
        SimEngine simengine1 = new SimEngine(5,1,1,1,500,300,500,500,10,5); //utworzenie nowego obiektu klasy SimEngine
        this.simengine1=simengine1;
        SimTask simtask1 = new SimTask(simengine1,this,1); //utworzenie nowego obiektu klasy SimTask
        this.simtask1 = simtask1;
        Timer time = new Timer(); //utworzenie nowego obiektu klasy Timer
        this.timer=time;
        time.scheduleAtFixedRate(this.simtask1, 0, 1); //uruchomienie timera
    }
        
    @Override //metoda wyświetlająca symulację na aplecie
    public void paint(Graphics g){
        g.clearRect(0,0,1000,1000);
        g.drawLine((int)simengine1.returnPunktZawX(), (int)simengine1.returnPunktZawY(), (int)simengine1.returnPolX(), (int)simengine1.returnPolY());
        g.fillOval((int)simengine1.returnPolX()-5, (int)simengine1.returnPolY()-5, 10, 10);
    }
}
