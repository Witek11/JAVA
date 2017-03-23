package cwiczenie1;

public class Test {

    public static void main(String[] args) {
        
      Punkt punkt1 = new Punkt(); //wykorzystanie konstruktora domyślnego do stworzenia obiektu 
      punkt1.Descript();
      System.out.println("Masa: "+punkt1.returnMasa());
      System.out.println("Moment bezwladnosci: "+punkt1.momInertia());
      System.out.println("Moment bezwladnosci z tw. Steinera: "+punkt1.Steiner(8));
      System.out.println();

      Punkt punkt2 = new Punkt(6); //wykorzystanie konstruktora z parametrem
      punkt2.Descript();
      System.out.println("Masa: "+punkt2.returnMasa());
      System.out.println("Moment bezwladnosci: "+punkt2.momInertia());
      System.out.println("Moment bezwladnosci z tw. Steinera: "+punkt2.Steiner(10));
      System.out.println();
      
      punkt1.changeMasa(12); //zmiana masy pierwszego obiektu
      punkt1.Descript();
      System.out.println("Masa: "+punkt1.returnMasa());
      System.out.println("Glowny moment bezwladnosci: "+punkt1.momInertia());
      System.out.println("Moment bezwladnosci wzgledem nowej osi: "+punkt1.Steiner(8));
      System.out.println();
      
      Punkt[] punkty = new Punkt[3]; //stworzenie tablicy trzech obiektów
      for(int i=0; i<punkty.length; i++){
          Punkt pkt = new Punkt(i+2);
          punkty[i]=pkt;
          pkt.Descript();
          int j=i+1;
          System.out.println("Masa punktu "+j+": "+pkt.returnMasa()+", glowny moment bezwladnosci: "+pkt.momInertia()+", moment wzgledem nowej osi: "+pkt.Steiner(3)+".");
          System.out.println();
          System.out.println();
      }
     
     BrylaSztywna setPoints = new BrylaSztywna();
     setPoints.massCenter();
     setPoints.Infrom();
     setPoints.inertiaX2();
     setPoints.inertiaY2();
     setPoints.inertiaZ2();
         
    }
}

