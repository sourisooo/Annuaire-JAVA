package projetpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Particulier { String nom; String prénom; String email; String adressepostal; 
    String datedenaissance; String profill; String datedajout; String datedemodification;
     String mdp;
     String role;

    String [][] tabprofil = new String[9999][8];
     String [][] tabcompte = new String[9999][3];
     String [] tabmail = new String [9999];
     String [] tabmdp = new String [9999];
     String [] tabid = new String [9999];
     List<String> alist = new ArrayList<>();
     List<String> blist = new ArrayList<>();
     List<String> clist = new ArrayList<>();
     List<String> zlist = new ArrayList<>();
     String [] tabpro = new String [9999];
     List<String> temp = new ArrayList<>();
     List<String> queryprocess = new ArrayList<>();


public Particulier(String nom, String prénom, String email, String adressepostal, 
String datedenaissance, String profill, String datedajout, String datedemodification)
    {
    this.nom = nom;
    this.prénom = prénom; 
    this.email = email;
    this.adressepostal = adressepostal;
    this.datedenaissance = datedenaissance;
    profill="";
    datedajout="";
    datedemodification="";
    }

public Particulier(String email, String mdp, String role)

{
    this.email = email;
    this.mdp = mdp; 
    this.role = role;
}

public boolean id (String mail, String mdp)
{
int i=0;

for (i=0;i<9999;i++)
{
    tabmail [i] = tabcompte [i][0]; 
    tabmdp [i] = tabcompte [i][1]; 
    tabid [i] = tabcompte [i][2]; 
}

for (String str:tabmail) {
    alist.add(str);
 }

 for (String str:tabmdp) {
    blist.add(str);
 }

 for (String str:tabid) {
    clist.add(str);
 }

 if(alist.indexOf(mail)==blist.indexOf(mdp))
 
 {
 return true;
 }

 return false;}


public int idnum (String mail)
{id(mail,"");
return alist.indexOf(mail);}


public int pronum (String mail)
{
    int i=0;

    for (i=0;i<9999;i++)
    {
        tabpro [i] = tabprofil [i][2]; 
 
    }
    
    for (String str:tabpro) {
        zlist.add(str);
     }

     return zlist.indexOf(mail);
}


public int nbdecpt () throws IOException
{ String compte;
   int compteur=0;

  compte = "C:\\Users\\souri\\Desktop\\fichiercompte.txt";

    FileReader fr = new FileReader(compte);
    BufferedReader br = new BufferedReader(fr);

    String ligne = br.readLine();

   while (ligne != null) {

compteur++;
ligne = br.readLine();
    
    }

    br.close();
    return compteur+1;
  
    }
    

    public int nbdepro () throws IOException
    {  String profil;
       int compteur=0;
    
      profil = "C:\\Users\\souri\\Desktop\\fichierprofil.txt";
    
        FileReader fr = new FileReader(profil);
        BufferedReader br = new BufferedReader(fr);
    
        String ligne = br.readLine();
    
       while (ligne != null) {
    
    compteur++;
    ligne = br.readLine();
        
        }
    
        br.close();
        return compteur+1;
      
        }


public void rech(int para, String motRechercher) throws IOException
{int i =0;
 int j =0;

    for(i=0; i<9999;i++)
    {
    if (tabprofil [i][para] == motRechercher)
    {
    
    for (j=0; j<8; j++)
    {System.out.println(tabprofil [i][j]);}
    
    }
    else
    i++;
    }    
}

public void ask(String typeof) throws IOException
{
    // System.out.println("Entrez"+typeof+" : ");
    // Scanner scanner = new Scanner(System.in);
    // typeof = scanner.nextLine();
    // temp.add(typeof);
    // scanner.close();

////////////////////////////////////////////////////////

    // Console console = System.console();
    // if (console == null) {
    //     System.out.println("No console: non-interactive mode!");
    //     System.exit(0);
    // }
     
    // System.out.print("Enter your"+typeof);
    // String username = console.readLine();
    // temp.add(username);

    // String passport = console.readLine("Enter your  "+typeof, 2);
    // temp.add(passport);

/////////////////////////////////////////////////////////

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter your"+typeof);
 
String name = reader.readLine();
temp.add(name);


}

public void askList(String typeof) throws IOException
{
    // System.out.println("Entrez"+typeof+" : ");
    // Scanner scanner = new Scanner(System.in);
    // typeof = scanner.nextLine();
    // queryprocess.add(typeof);
    // scanner.close();

    //////////////////////////////////////////////////////////////

    // Console console = System.console();
    // if (console == null) {
    //     System.out.println("No console: non-interactive mode!");
    //     System.exit(0);
    // }

    // System.out.print("Enter your: "+typeof);
    // String username = console.readLine();
    // temp.add(username);

        // String passport = console.readLine("Enter your : "+typeof, 2);
    // queryprocess.add(passport);


//////////////////////////////////////////////////////////////////

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter your"+typeof);
 
String name = reader.readLine();
temp.add(name);



}

public void recherche() throws IOException
{   
    temp.clear();
    queryprocess.clear();
    ask("typeRechercher");
    ask("motRechercher");

    switch (temp.get(0)) 
    {
        case "nom":
        rech(0, temp.get(1));
        case "email":
        rech(1, temp.get(1));
        case "profil":
        rech(2, temp.get(1));

    }

    temp.clear();
    home();

}

public void home() throws IOException
{
temp.clear();
queryprocess.clear();

System.out.println("Bienvenue dans l’Annuaire NFA032");
System.out.println("Administrateur :");
System.out.println("1.A. Ajouter un Admin");
System.out.println("1.B. Ajouter un particulier");
System.out.println("Particulier :");
System.out.println("Rechercher un ou des particuliers");
System.out.println("2.A Par nom");
System.out.println("2.B. Par email");
System.out.println("2.C. Par profil");
System.out.println("3. Modifier mes informations personnelles");
System.out.println("Faites votre choix : ");
ask("choix");

switch (temp.get(0)) {
case "1.A":  
System.out.println("Vous ne disposez pas des habilitations requises.");
home();
case "1.B":  
System.out.println("Vous ne disposez pas des habilitations requises.");
home();
case "2.A":  
recherche();
case "2.B":  
recherche();
case "2.C":  
recherche();
case "3":  
modifierprofil();
}
}

public void login(String email) throws IOException
{       
        ask("mdp");
        if (id(email, temp.get(0))==false)

        temp.clear();
        {home();}
}



public void modifierprofil() throws IOException 
{  String datedemodification;
   
    String profil="";
    int index;

    temp.clear();
    queryprocess.clear();

LocalDate date = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    ask("nom");
    ask("mail");
    id(temp.get(1),"");
    login(temp.get(1));
    pronum(temp.get(1));

    if ((tabprofil [pronum(temp.get(1))][0] == temp.get(0))&&(tabprofil [pronum(temp.get(1))][2] == temp.get(1)))
    {
    
        askList("nom");
        tabprofil [pronum(temp.get(1))][0] = queryprocess.get(0);
        
        askList("prénom");
        tabprofil [pronum(temp.get(1))-1][1] = queryprocess.get(1);
       
        askList("email");
        tabprofil [pronum(temp.get(1))-1][2] = queryprocess.get(2);
        
        askList("adressepostal");
        tabprofil [pronum(temp.get(1))-1][3] = queryprocess.get(3);
        
        askList("datedenaissance");
        tabprofil [pronum(temp.get(1))-1][4] = queryprocess.get(4);
        
        askList("profill");
        tabprofil [pronum(temp.get(1))-1][5] = queryprocess.get(5);
        
            datedemodification = date.format(formatter);
            tabprofil [pronum(temp.get(1))-1][7] = datedemodification;
         
    int j=0;

    for (j=0; j<8; j++)
    {profil= profil + tabprofil[pronum(temp.get(1))][j];}
    index = pronum(temp.get(1));

   
    FileWriter fw = new FileWriter("C:\\Users\\souri\\Desktop\\fichierprofil.txt");
    BufferedWriter bw = new BufferedWriter(fw);

    bw.write(profil, index, index);
    bw.flush();
    bw.close();
    
    temp.clear();
    queryprocess.clear();
    home();

    }}


    public void creationcompte() throws IOException
    { int index;

        temp.clear();
        queryprocess.clear();

       ask("email");
        id(temp.get(0),"");
        login(temp.get(0));
   
        ask("email");
       
        if (pronum(temp.get(1))!=-1)
            {home();};
            id(temp.get(1),"");

            tabcompte [idnum(temp.get(0))][0] = temp.get(1);
        
            ask("mdp");
            tabcompte [idnum(temp.get(0))-1][1] = temp.get(2);
        
            ask("role");
            tabcompte [idnum(temp.get(0))-1][2] = temp.get(3);;
    

     index = idnum(temp.get(0));

     FileWriter fw = new FileWriter("C:\\Users\\souri\\Desktop\\fichiercompte.txt");
     BufferedWriter bw = new BufferedWriter(fw);
 
     bw.write((temp.get(1)+";"+temp.get(2)+";"+temp.get(3)), index, index);
     bw.flush();
     bw.close();

    temp.clear();
    home();
    
        }


}


class Admin extends Particulier {

public Admin(String email,  String mdp, String role)

{
    super( email, mdp, role);

    
}

    public void creationprofil() throws IOException
     {   String datedajout;
        int id; String profil; int index;

        temp.clear();
        queryprocess.clear();

        ask("email");
        
        id(temp.get(0),"");
        login(temp.get(0));

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
   
        nbdepro();
        id= nbdepro();

        askList("email");

        if (pronum(queryprocess.get(0))!=-1)
        {home();};
        id(queryprocess.get(0),"");
        tabprofil [id][2] = queryprocess.get(0);
    
        askList("nom");
             tabprofil [id-1][0] = queryprocess.get(1);
        
    
        askList("prénom");
            tabprofil [id-1][1] = queryprocess.get(2);
        

        askList("adressepostal");
            tabprofil [id-1][3] = queryprocess.get(3);
        
    
        askList("datedenaissance");
            tabprofil [id-1][4] = queryprocess.get(4);
        

        askList("profill");
        tabprofil [id-1][5] = queryprocess.get(5);
        
            datedajout = date.format(formatter);
            tabprofil [id-1][6] = datedajout;
            datedemodification = "";
            tabprofil [id-1][7] = "";
         
        int j=0;
        profil = "";

        for (j=0; j<8; j++)
        {profil= profil + tabprofil[id][j];}
        index = id;
    
        FileWriter fw = new FileWriter("C:\\Users\\souri\\Desktop\\fichierprofils.txt");
        BufferedWriter bw = new BufferedWriter(fw);
    
        bw.write(profil, index, index);
        bw.flush();
        bw.close();

        temp.clear();
        queryprocess.clear();
        creationcompte();
        
    }


    public void modifierprofil() throws IOException 
{  String datedemodification;
     
    String profil="";
    int index;

    temp.clear();
    queryprocess.clear();

    ask("email");
    id(temp.get(0),"");
    login(temp.get(0));

    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    ask("nom");
    ask("email");
 
    int i=0;
    int j=0;

    for(i=0; i<9999;i++)
    {
    if ((tabprofil [i][0] == temp.get(1))&&(tabprofil [i][2] == temp.get(2)))
    {
            askList("nom");
            tabprofil [i][0] = queryprocess.get(0);
        
            askList("prénom");
            tabprofil [i][1] = queryprocess.get(1);
        
            askList("email");
            pronum(queryprocess.get(2));

            if (pronum(queryprocess.get(2))!=-1)
            {modifierprofil();};
            tabprofil [i][2] = queryprocess.get(2);
        
            askList("adressepostal");
            tabprofil [i][3] = queryprocess.get(3);
        
            askList("datedenaissance");
            tabprofil [i][4] = queryprocess.get(4);
        
            askList("profill");
             tabprofil [i][5] = queryprocess.get(5);
        
            datedemodification = date.format(formatter);
            tabprofil [i][7] = datedemodification;
         

        for (j=0; j<8; j++)
         {profil= profil + tabprofil[i][j];}
         index = i;
    
         FileWriter fw = new FileWriter("C:\\Users\\souri\\Desktop\\fichierprofils.txt");
         BufferedWriter bw = new BufferedWriter(fw);
     
         bw.write(profil, index, index);
         bw.flush();
         bw.close();

    temp.clear();
    queryprocess.clear();
    home();

    }

    temp.clear();
    queryprocess.clear();
    home();

    }

    temp.clear();
    queryprocess.clear();
    home();

    }

    
public void home() throws IOException
{
tabcompte [0][0] = "admin@cnam.fr";
tabcompte [0][1] = "admin";
tabcompte [0][2] = "admin";
temp.clear();
queryprocess.clear();

System.out.println("Bienvenue dans l’Annuaire NFA032");
System.out.println("Administrateur :");
System.out.println("1.A. Ajouter un Admin");
System.out.println("1.B. Ajouter un particulier");
System.out.println("Particulier :");
System.out.println("Rechercher un ou des particuliers");
System.out.println("2.A Par nom");
System.out.println("2.B. Par email");
System.out.println("2.C. Par profil");
System.out.println("3. Modifier mes informations personnelles");
System.out.println("Faites votre choix : ");
ask("choix");

switch (temp.get(0)) {
case "1.A":  
creationcompte();
case "1.B":  
creationprofil();
case "2.A":  
recherche();
case "2.B":  
recherche();
case "2.C":  
recherche();
case "3":  
modifierprofil();
}

}


}

    
public class Annuaire {
    public static void main(String[] args) throws IOException {
Admin admin= new Admin("admin@cnam.fr", "admin", "admin");

admin.home();

}
}