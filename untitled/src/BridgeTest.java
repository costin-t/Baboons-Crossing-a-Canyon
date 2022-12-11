import java.util.concurrent.*;

public class BridgeTest
{
    public static void main(String[] args)
    {
        final Bridge bridge = new Bridge(); // se defineste podul
        Thread dreapta = new Thread(new Runnable()  //se defineste traversarea catre stanga
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Baboon baboon = new Baboon(bridge);  //se genereaza un obiect de tip babuin
                    Thread a = new Thread(baboon);  //se creaza un obiect thread folosind obiectul de tip babuin
                    baboon.setNume("Dreapta: "+a.getId());  //afisam pozitia de plecare si starea in care se afla obiectul de tip babuin
                    a.start();
                    try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));//incearca sa traverseze dupa 0-9 secunde
                    }
                    catch(InterruptedException iex) // gestionează excepții și erori la intreruperea executarii blocului try
                    {
                        iex.printStackTrace();
                    }
                }
            }
        });
        Thread stanga = new Thread(new Runnable()// definim traversarea catre dreapta
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Baboon baboon = new Baboon(bridge);  //se genereaza un obiect de tip babuin
                    Thread a = new Thread(baboon);  //se creaza un obiect thread folosind obiectul de tip babuin
                    baboon.setNume("Stanga:  "+a.getId());  //afisam pozitia de plecare si starea in care se afla obiectul de tip babuin
                    a.start();
                    try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10)); //incearca sa traverseze dupa 0-9 secunde
                    }
                    catch(InterruptedException iex) // gestionează excepții și erori la intreruperea executarii blocului try
                    {
                        iex.printStackTrace();
                    }
                }
            }
        });
        dreapta.start();  //porneste threadul din dreapta
        stanga.start();  //porneste threadul din stanga
    }
}
