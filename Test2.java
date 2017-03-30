
package cwiczenie1;
import java.io.*;

public class Test2 {
    
    public static void main(String[] args) {
    
        /*
    Walec cylinder1 = new Walec(6,7);//utworzenie obiektu - walca
    cylinder1.Descript();
    System.out.println("Dlugość primienia wynosi: "+cylinder1.returnPromien());
    System.out.println("Masa wynosi: "+cylinder1.returnMasa());
    System.out.println("Moment bezwładności wynosi: "+cylinder1.momInertia());
    Pret rod1 = new Pret(6,7);//utworzenie elementu - pręta
    rod1.Descript();
    System.out.println("Długość promienia wynosi: "+rod1.returnPromien());
    System.out.println("Masa wynosi: "+rod1.returnMasa());
    System.out.println("Moment bezwładności wynosi: "+rod1.momInertia());
    Kula sphere1 = new Kula(6,7);//utworzenie elementu - kuli
    sphere1.Descript();
    System.out.println("Długość promienia wynosi: "+sphere1.returnPromien());
    System.out.println("Masa wynosi: "+sphere1.returnMasa());
    System.out.println("Moment bezwładności wynosi: "+sphere1.momInertia());
    
    Walec[] cylinders = new Walec[3];//deklaracja trzech tablic z obiektami
    Pret[] rods = new Pret[3];
    Kula[] sphers = new Kula[3];
    
    int d=10;//odleglość od srodka masy (dla Steinera)
    
    for(int i=0;i<cylinders.length;i++){//deklaracja elementów tablic
        Walec cyl = new Walec(i+15,i+2);
        cylinders[i]=cyl;
        Pret rod = new Pret(i+15,i+2);
        rods[i]=rod;
        Kula sph = new Kula(i+15,i+2);
        sphers[i]=sph;
        cylinders[i].Descript();
        int add1=cylinders[i].momInertia()+cylinders[i].returnMasa()*d*d;
        System.out.print("Masa: "+cylinders[i].returnMasa()+", promień: "+cylinders[i].returnPromien());
        System.out.println(", moment bezwładności: "+cylinders[i].momInertia()+", moment bezwładności względem nowej osi: "+add1+".");
        rods[i].Descript();
        int add2=rods[i].momInertia()+rods[i].returnMasa()*d*d;
        System.out.print("Masa: "+rods[i].returnMasa()+", promień: "+rods[i].returnPromien());
        System.out.println(", moment bezwładności: "+rods[i].momInertia()+", moment bezwładności względem nowej osi: "+add2+".");
        sphers[i].Descript();
        int add3=sphers[i].momInertia()+sphers[i].returnMasa()*d*d;
        System.out.print("Masa: "+sphers[i].returnMasa()+", promień: "+sphers[i].returnPromien());
        System.out.println(", moment bezwładności: "+sphers[i].momInertia()+", moment bezwładności względem nowej osi: "+add3+".");  
        }
    */
    //wczytywanie potrzebnych wartości podanych przez użytkownika
    BufferedReader menu = new BufferedReader(new InputStreamReader (System.in));
    BufferedReader masa = new BufferedReader(new InputStreamReader (System.in));
    BufferedReader promien = new BufferedReader(new InputStreamReader (System.in));
    BufferedReader odleglosc = new BufferedReader(new InputStreamReader (System.in));
    BufferedReader numer = new BufferedReader(new InputStreamReader (System.in));

    MENU men = new MENU();//utworzenie obiektu klasy MENU, wywołującej menu

    int numer0=0;
    int masa0;
    int promien0;
    int odleglosc0;
    String numer01;
    String masa01;
    String promien01;
    String odleglosc01;

    try{//obliczanie momentu bezwładności dla dowolnego elementu po wybraniu z menu
        while(numer0!=4){
        System.out.println();
        men.Menu();
        System.out.println("Wybierz numer z listy.");
        numer01 = numer.readLine();
        numer0 = Integer.parseInt(numer01);
        if(numer0!=4){
            System.out.print("Wprowadz masę: "); 
            masa01 = masa.readLine();
             masa0 = Integer.parseInt(masa01);
            System.out.print("Wprowadz promień: "); 
            promien01 = promien.readLine();
            promien0 = Integer.parseInt(promien01);
            System.out.print("Wprowadz odległość od osi: "); 
            odleglosc01 = odleglosc.readLine();
            odleglosc0 = Integer.parseInt(odleglosc01);
            switch(numer0){
                case 1:
                    Walec wa = new Walec(masa0,promien0);
                    System.out.println("Moment bezwladnosci walca wynosi: "+wa.momInertia());
                    System.out.println("Moment bezwladnosci walca względem nowej osi wynosi: "+wa.Steiner(odleglosc0));
                    break;

                case 2:
                    Pret pr = new Pret(masa0,promien0);
                    System.out.println("Moment bezwladnosci pręta wynosi: "+pr.momInertia());
                    System.out.println("Moment bezwladnosci pręta względem nowej osi wynosi: "+pr.Steiner(odleglosc0));
                    break;

                case 3:
                    Kula ku = new Kula(masa0,promien0);
                    System.out.println("Moment bezwladnosci kuli wynosi: "+ku.momInertia());
                    System.out.println("Moment bezwladnosci kuli względem nowej osi wynosi: "+ku.Steiner(odleglosc0));
                    break;

                default:
                    break;
            }
        }
    }
    }
    catch(IOException e){
        System.out.println("Błąd podczas odczytu strumienia.");
    }
    }
}
