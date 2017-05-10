import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

//implementacja interfejsów
public class SpringApplet extends JApplet implements MouseListener, MouseMotionListener, ActionListener{
   
    private SimEngine simengine1;
    private SimTask simtask1;
    private Timer timer;
    private boolean MouseDragging=false; //pole mówiące, czy zachodzi przeciąganie kursora
    
    //prywatne pola do przechowywania elementów interfejsu graficznego
    private JLabel masa;
    private JLabel sprezystosc;
    private JLabel tlumienie;
    private JLabel dlugoscspr;
    private JLabel grawitacja;
    
    private JTextField masa1;
    private JTextField sprezystosc1;
    private JTextField tlumienie1;
    private JTextField dlugoscspr1;
    private JTextField grawitacja1;
    
    private JButton ustaw;
    private JButton reset;
        
    @Override
    public void init(){
        SimEngine simengine1tmp = new SimEngine(5,1,2,200,750,100,750,300,10,5);
        this.simengine1=simengine1tmp;
        SimTask simtask1tmp = new SimTask(simengine1,this,1);
        this.simtask1 = simtask1tmp;
        Timer time = new Timer();
        this.timer=time;
        time.scheduleAtFixedRate(this.simtask1, 0, 1);
        MouseDragging=false; //nadanie wartości logicznej 0 polu przechowującemu stan myszy
        addMouseListener(this); //dodanie nasłuchiwacza myszy do appletu
        addMouseMotionListener(this); //dodanie nasłuchiwaca ruchu myszy do appletu
        
        //utworzenie kontenera na powierzchni appletu
        Container ramka=getContentPane();     
        ramka.setLayout(null);
        
        //inicjalizacja stworzonych pól nowymi obiektami
        ustaw=new JButton("Ustaw");
        reset=new JButton("Resetuj");
        masa=new JLabel("Masa");
        masa1=new JTextField("5",10);
        sprezystosc=new JLabel("Współczynnik sprężystosci");
        sprezystosc1=new JTextField("1",10);
        tlumienie=new JLabel("Współczynnik tłumienia");
        tlumienie1=new JTextField("2",10);
        dlugoscspr=new JLabel("Długość sprężyny");
        dlugoscspr1=new JTextField("200",10);
        grawitacja=new JLabel ("Grawitacja");
        grawitacja1=new JTextField("10",10);
        
        //ustawienie położenia elementów appletu
        ustaw.setBounds(110,90,100,50);
        reset.setBounds(5,90,100,50);
        masa.setBounds(5,150,100,20);
        masa1.setBounds(110,150,100,20);
        sprezystosc.setBounds(5,180,100,20);
        sprezystosc1.setBounds(110,180,100,20);
        tlumienie.setBounds(5,210,100,20);
        tlumienie1.setBounds(110,210,100,20);
        dlugoscspr.setBounds(5,240,100,20);
        dlugoscspr1.setBounds(110,240,100,20);
        grawitacja.setBounds(5,270,100,20);
        grawitacja1.setBounds(110,270,100,20);
        
        //dodanie elementów GUI do appletu
        ramka.add(ustaw);
        ramka.add(reset);
        ramka.add(masa);
        ramka.add(masa1);
        ramka.add(sprezystosc);
        ramka.add(sprezystosc1);
        ramka.add(tlumienie);
        ramka.add(tlumienie1);
        ramka.add(dlugoscspr);
        ramka.add(dlugoscspr1);
        ramka.add(grawitacja);
        ramka.add(grawitacja1);
        
        //dodanie nasłuchiwaczów do obiektów reprezentujących przyciski
        ustaw.addActionListener(this);
        reset.addActionListener(this);
    }
        
    public void paint(Graphics g){
        super.paint(g); //mega ważna linijka!!! - bez tego nie działa
        g.clearRect(300,50,1000,500);
        g.drawLine((int)simengine1.returnPunktZawX(), (int)simengine1.returnPunktZawY(), (int)simengine1.returnPolX(), (int)simengine1.returnPolY());
        g.fillOval((int)simengine1.returnPolX()-10, (int)simengine1.returnPolY()-10, 20, 20);
    }

    //metody konieczne do implementacji interfejsów MouseListener i MouseMotionListener
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent event) {
        float wspx = event.getX(); //odczytanie położenia kursora
        float wspy = event.getY();
        //czy kursor jest w obszarze zajętym przez kulkę
        if(simengine1.returnPolX()-10<wspx && simengine1.returnPolX()+10>wspx && simengine1.returnPolY()-10<wspy && simengine1.returnPolY()+10>wspy)
        { 
            timer.cancel(); //wyłączenie timera
            simengine1.Reset(); //zresetowanie symulacji
            MouseDragging=true; //następuje przeciąganie kursora
        }
        event.consume();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (MouseDragging==true){  //sprawdzenie czy wystąpiło przeciąganie kursora
            Timer time1 = new Timer(); //włączenie timera
            this.timer=time1;
            SimTask task1 = new SimTask(simengine1,this,1);
            time1.scheduleAtFixedRate(task1, 0, 1);
            MouseDragging=false; //koniec przeciągania kursora
        }
    event.consume();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (MouseDragging==true){ //sprawdzenie czy następuje przeciąganie kursora
            float wspx = event.getX(); //odczytanie pozycji kursora
            float wspy = event.getY();
            simengine1.setPolX(wspx); //ustawienie pozycji masy zgodnie z pozycją kursora
            simengine1.setPolY(wspy);
            repaint(); //wywołanie metody repaint
        }
        event.consume();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) { //metoda konieczna do implementacji interfejsu ActionListener
        if(ae.getSource()==ustaw){ //sprawdzenie czy źródłem akcji jest stworzony przycisk
            timer.cancel(); //zatrzymanie timera
            simengine1.Reset(); //zresetowanie symulacji
            //ustawienie parametrów symulacji wg wartości pól tekstowych
            simengine1.setMasa(Float.parseFloat(masa1.getText()));
            simengine1.setSprez(Float.parseFloat(sprezystosc1.getText()));
            simengine1.setTlum(Float.parseFloat(tlumienie1.getText()));
            Timer time2 = new Timer(); //ponowne uruchomienie timera
            this.timer=time2;
            SimTask task2 = new SimTask(simengine1,this,1);
            time2.scheduleAtFixedRate(task2, 0, 1);
        }
        if(ae.getSource()==reset){ //sprawdzenie czy źródłem akcji jest stworzony przycisk
            timer.cancel(); //zatrzymanie timera
            simengine1.Reset(); //zresetowanie symulacji
            //ustawienie z powrotem wartości początkowych
            SimEngine simengine2tmp = new SimEngine(5,1,2,200,700,300,700,500,10,5);
            masa1.setText("5");
            sprezystosc1.setText("1");
            tlumienie1.setText("2");
            dlugoscspr1.setText("200");
            Timer time2 = new Timer(); //ponowne uruchomienie timera
            this.timer=time2;
            SimTask task2 = new SimTask(simengine1,this,1);
            time2.scheduleAtFixedRate(task2, 0, 1);
        }
    }
}
