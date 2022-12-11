import java.util.concurrent.*;

public class Bridge {
    private final Semaphore sema; //folosesc metoda Semafor si limitez la un thread

    public Bridge(){
        sema = new Semaphore(1); //constructor pentru semafor limita de traversare 1.
    }
    //Functie de traversare a babuinului pe pod
    public void crossBridge(Baboon baboon){
        try
          {
            System.out.printf("%s Asteapta sa traverseze canionul.\n",baboon.getNume()); //afiseaza mesajul "[nume babuin] asteapta sa traverseze canionul"
            sema.acquire(); //permite accesul pentru clasa babuin curenta si blocheaza accesul pentru celalante
            System.out.printf("%s Traverseaza canionul. \n",baboon.getNume());//afiseaza mesajul "[nume babuin] traversează canionul"
            long duration = (long)(Math.random()*10); //seteaza durata de traversare un numar aleatoriu intre 0 si 9 de secunde
            TimeUnit.SECONDS.sleep(duration);   //incearca sa traverseze dupa 0-9 secunde
         }
    catch(InterruptedException iex)
    {
        iex.printStackTrace();//gestionează excepții și erori la intreruperea executarii blocului try
    }

    finally
    {
        System.out.printf("%s A terminat de traversat canionul.\n",baboon.getNume());//afiseaza mesajul [nume babuin] "A terminat de traversat canionul"
        sema.release(); // deblocheaza accesul pentru celalante obiecte de tip babuin
    }
    }
}
