
package scovailciaoezversion;
import java.util.Scanner;
import java.util.Random;

public class ScovaIlCiaoEZversion 
{

    static int rigonne()
    {
        int righecolonne=0,controllo=0;
        Scanner scannervar = new Scanner(System.in);
        Random randomvar = new Random();
        System.out.println("benvenuto! seleziona il numero di righe/colonne: ");
        while(controllo == 0)
        {
            righecolonne = scannervar.nextInt();
            if(righecolonne<100)
                controllo=1;
            else
                System.out.println("andiamo, non esagerare...");
        }
        return righecolonne;
    }
    
    
    static int tentativi()
    {
        Scanner scannervar = new Scanner(System.in);
        int tentativi=-1;
        while(tentativi<0)
        {
            System.out.print("quanti tentativi vuoi a tua disposizione? ");
            tentativi = scannervar.nextInt();
        }
        return tentativi;
    }
    
    static int riempimatrice(int matrice[][], int righecolonne)
    {
        Random randomvar = new Random();
        int a, bi;
        a = randomvar.nextInt(righecolonne);
        bi = randomvar.nextInt(righecolonne);
        matrice[a][bi] = 1;
        a = a*100;
        a = a+bi;
        return a;
    }
    
    static int giocoveroeproprio(int matrice[][], int coordciao, int tentativi)
    {
        Scanner scannervar = new Scanner(System.in);
        Random randomvar = new Random();        
        int coordx=0,coordy=0, controllox=0, controlloy=0, controllotot=0;
        int x_sparata=0, y_sparata=0, esito=0;
        
        
        coordx=coordciao/100;
        coordy=coordciao-coordx*100;

        while(controllotot==0&&tentativi!=0)
        {
            System.out.print("inserisci la x che pensi sia giusta! ");
            x_sparata = scannervar.nextInt();
            if(x_sparata==coordx)
                controllox=1;
            System.out.print("bene, ora inserisci la y: ");
            y_sparata = scannervar.nextInt();
            if(y_sparata==coordy)
                controlloy=1;
            if(controllox==1&&controlloy==1)
                controllotot=1;
            if(controllox!=1||controlloy!=1)
                System.out.println("nope, riprova!");
            tentativi --;
        }
        if(controllotot==1)
            esito=1;
        else
            esito=0;
        return esito;
    }
    
    static void esito(int esito, int matrice[][], int righecolonne)
    {
        if(esito==1)
            System.out.println("Hai indovinato!!");
        else
            System.out.println("Hai finito i tentativi.. avrai più fortuna alla prossima! ");
        System.out.println("la matrice era questa:");
        for(int i=0; i<righecolonne; i++)
        {
            for(int j=0; j<righecolonne; j++)
            {
                if(matrice[i][j]==1)
                    System.out.print("ciao ");
                else
                    System.out.print("---- ");
            }
            System.out.println();
        }
    }
   
    public static void main(String[] args) 
    {
     Scanner scannervar = new Scanner(System.in);
     Random randomvar = new Random();
     int righecolonne=0, coordciao=0, tentativi=0, esito=0;
     righecolonne = rigonne();
     tentativi = tentativi();
     int matrice[][] = new int[righecolonne][righecolonne];
     coordciao = riempimatrice(matrice,righecolonne);
     esito = giocoveroeproprio(matrice,coordciao,tentativi);
     esito(esito, matrice,righecolonne);
     
    }
    
}
