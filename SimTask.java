
import java.util.TimerTask;
import java.util.Timer;

public class SimTask extends TimerTask {
 
Timer timer1 = new Timer();
    
private SimEngine simengine1; //obiekt klasy SimEngine
private SpringApplet springapplet1; //obiekt klasy SimTask
private float OdstCzas;

//konstruktor z parametrami
public SimTask(SimEngine simengine1, SpringApplet springapplet1, float OdstCzas){
    this.simengine1=simengine1;
    this.springapplet1=springapplet1;
    this.OdstCzas=OdstCzas;
}
    
@Override 
public void run(){
    simengine1.PrzebiegSym((float)0.001); //uruchomienie obliczenia kolejnego kroku symulacji
    springapplet1.repaint(); //odświeżenie
}
}
