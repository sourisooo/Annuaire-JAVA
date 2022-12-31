package projetpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;




class Particulier { String nom; String prénom; String email; String adressepostal; 
    String datedenaissance; String profill; String datedajout; String datedemodification;
     String mdp;
     String role;

     static String [][] tabprofil = new String[9999][8];
     String [][] tabcompte = new String[9999][3];
     String [] tabmail = new String [9999];
     String [] tabmdp = new String [9999];
     String [] tabid = new String [9999];
     List<String> alist = new ArrayList<>();
     List<String> blist = new ArrayList<>();
     List<String> clist = new ArrayList<>();
     List<String> zlist = new ArrayList<>();
     String [] tabpro = new String [9999];


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
{ String compte; String profil;
   int compteur=0;

  compte = "C:\\Users\\souri\\Desktop\\fichiercompte.txt";
  profil = "C:\\Users\\souri\\Desktop\\fichierprofil.txt";

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
    { String compte; String profil;
       int compteur=0;
    
      compte = "C:\\Users\\souri\\Desktop\\fichiercompte.txt";
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




public void recherche() throws IOException
{

int para;
int i=0;
int j=0;

System.out.println("Entrez un type de recherche : ");
Scanner scanner = new Scanner(System.in);
String typeRechercher = scanner.nextLine();
System.out.println("Entrez le mot recherché : ");
String motRechercher = scanner.nextLine();

switch (typeRechercher) {
    case "nom":  
    para = 0;
    case "email":  
    para = 1;
    case "profil":  
    para = 2;


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

scanner.close();
home();
}

public void home() throws IOException
{
String choix;

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
try (Scanner scanner = new Scanner(System.in)) {
    choix = scanner.nextLine();
}

switch (choix) {
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
home();
}
}

public void login(String email) throws IOException
{ 
String mdp;

        System.out.println("Entrez un mdp : ");
        try (Scanner scanner = new Scanner(System.in)) {
            mdp = scanner.nextLine();
        }

        if (id(email, mdp)==false)
        {home();}
}



public void modifierprofil() throws IOException 
{String recherche; String nom; String prénom; String email; String adressepostal; 
    String datedenaissance; String profill; String datedajout; String datedemodification;
    BufferedWriter cc; BufferedReader bfcc; String ligne;

String profil="";
int index;

LocalDate date = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");



    System.out.println("Entrez un nom : ");
    try (Scanner scanner = new Scanner(System.in)) {
    nom = scanner.nextLine();
    } 

    System.out.println("Entrez un email : ");
    try (Scanner scanner = new Scanner(System.in)) {
        email = scanner.nextLine();
    }

    id(email,"");
    login(email);
    pronum(email);

    if ((tabprofil [pronum(email)][0] == nom)&&(tabprofil [pronum(email)][2] == email))
    {
    
        System.out.println("Entrez un nom : ");
        try (Scanner scanner = new Scanner(System.in)) {
             nom = scanner.nextLine();
             tabprofil [pronum(email)][0] = nom;
        }
     
        System.out.println("Entrez un prénom : ");
        try (Scanner scanner = new Scanner(System.in)) {
            prénom = scanner.nextLine();
            tabprofil [pronum(email)-1][1] = prénom;
        }

        System.out.println("Entrez un email : ");
        try (Scanner scanner = new Scanner(System.in)) {
            email = scanner.nextLine();
            tabprofil [pronum(email)-1][2] = email;
        }
    
        System.out.println("Entrez un adressepostal : ");
        try (Scanner scanner = new Scanner(System.in)) {
            adressepostal = scanner.nextLine();
            tabprofil [pronum(email)-1][3] = adressepostal;
        }
    
        System.out.println("Entrez une date de naissance : ");
        try (Scanner scanner = new Scanner(System.in)) {
            datedenaissance = scanner.nextLine();
            tabprofil [pronum(email)-1][4] = datedenaissance;
        }

        System.out.println("Entrez un profill : ");
        try (Scanner scanner = new Scanner(System.in)) {
            profill = scanner.nextLine();
        tabprofil [pronum(email)-1][5] = profill;
        }

            datedemodification = date.format(formatter);
            tabprofil [pronum(email)-1][7] = datedemodification;
         
    int j=0;

    for (j=0; j<8; j++)
    {profil= profil + tabprofil[pronum(email)][j];}
    index = pronum(email);

    Path r= Paths.get("C:\\Users\\souri\\Desktop\\fichierprofils.txt"); 

    FileReader fr = new FileReader("C:\\Users\\souri\\Desktop\\fichierprofils.txt");
    FileWriter fw = new FileWriter("C:\\Users\\souri\\Desktop\\fichierprofil2.txt");
    BufferedReader br = new BufferedReader(fr);
    BufferedWriter bw = new BufferedWriter(fw);

    int i=0;

    String data;
    
        for(i=0;i<index;i++) 
        
        {   br.readLine();
            data = br.readLine();
            bw.append(new String(data));
            bw.flush();
        }
        
        bw.append(profil);
        bw.flush();
    
        for(i=index+1;i<9999;i++) 
        
        {   br.readLine();
            data = br.readLine();
            bw.append(new String(data));
            bw.flush();
        }

    bw.flush();
    br.close();
    bw.close();
    (r.toFile()).delete();
   
    Path source = Paths.get("C:\\Users\\souri\\Desktop\\fichierprofil2.txt");
    Path target = Paths.get("C:\\Users\\souri\\Desktop\\fichierprofil.txt");
  
    Files.move(source, target);
    home();

    }}


    public void creationcompte() throws IOException
    {String auth; String email; String mdp; String role; String id;
    int index;

        // id = String.valueOf(nbdecpt());
    
        System.out.println("Authentifiez votre email : ");
        try (Scanner scanner = new Scanner(System.in)) {
            auth = scanner.nextLine();
        }

        id(auth,"");
        login(auth);
   
        
        System.out.println("Entrez un email : ");
        try (Scanner scanner = new Scanner(System.in)) {
             email = scanner.nextLine();

        if (pronum(email)!=-1)
            {home();};
            id(email,"");

             tabcompte [idnum(auth)][0] = email;
        }
     
        System.out.println("Entrez un mdp : ");
        try (Scanner scanner = new Scanner(System.in)) {
            mdp = scanner.nextLine();
            tabcompte [idnum(auth)-1][1] = mdp;
        }
    
        System.out.println("Entrez un role : ");
        try (Scanner scanner = new Scanner(System.in)) {
            role = scanner.nextLine();
            tabcompte [idnum(auth)-1][2] = role;}
    
            // tabcompte [idnum(auth)-1][3] = id;
    

     index = idnum(auth);

    Path r= Paths.get("C:\\Users\\souri\\Desktop\\fichiercompte.txt"); 

    FileReader fr = new FileReader("C:\\Users\\souri\\Desktop\\fichiercompte.txt");
    FileWriter fw = new FileWriter("C:\\Users\\souri\\Desktop\\fichiercompte2.txt");
    BufferedReader br = new BufferedReader(fr);
    BufferedWriter bw = new BufferedWriter(fw);

    int i=0;

    String data;
    
        for(i=0;i<index;i++) 
        
        {   br.readLine();
            data = br.readLine();
            bw.append(new String(data));
            bw.flush();
        }
        
        bw.append(email+";"+mdp+";"+role);
        bw.flush();
    
        for(i=index+1;i<9999;i++) 
        
        {   br.readLine();
            data = br.readLine();
            bw.append(new String(data));
            bw.flush();
        }

    bw.flush();
    br.close();
    bw.close();
    (r.toFile()).delete();
   
    Path source = Paths.get("C:\\Users\\souri\\Desktop\\fichiercompte2.txt");
    Path target = Paths.get("C:\\Users\\souri\\Desktop\\fichiercompte.txt");
  
    Files.move(source, target);
    home();
    
        }


}


class Admin extends Particulier {

public Admin(String email,  String mdp, String role)

{
    super( email, mdp, role);

    
}

    public void creationprofil() throws IOException
     {  String auth;
        String nom; String prénom; String email; String adressepostal; 
        String datedenaissance; String profill; String datedajout; String datedemodification;
        int id; String profil; int index;

        System.out.println("Authentifiez votre email : ");
        try (Scanner scanner = new Scanner(System.in)) {
            auth = scanner.nextLine();
        }
        
        id(auth,"");
        login(auth);


        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
   
    nbdepro();
    id= nbdepro()+1;

    System.out.println("Entrez un email : ");
    try (Scanner scanner = new Scanner(System.in)) {
        email = scanner.nextLine();

        if (pronum(email)!=-1)
        {home();};
        id(email,"");
        tabprofil [id][2] = email;
    }

        System.out.println("Entrez un nom : ");
        try (Scanner scanner = new Scanner(System.in)) {
             nom = scanner.nextLine();
             tabprofil [id-1][0] = nom;
        }
     
        System.out.println("Entrez un prénom : ");
        try (Scanner scanner = new Scanner(System.in)) {
            prénom = scanner.nextLine();
            tabprofil [id-1][1] = prénom;
        }

        System.out.println("Entrez un adressepostal : ");
        try (Scanner scanner = new Scanner(System.in)) {
            adressepostal = scanner.nextLine();
            tabprofil [id-1][3] = adressepostal;
        }
    
        System.out.println("Entrez une date de naissance : ");
        try (Scanner scanner = new Scanner(System.in)) {
            datedenaissance = scanner.nextLine();
            tabprofil [id-1][4] = datedenaissance;
        }

        System.out.println("Entrez un profill : ");
        try (Scanner scanner = new Scanner(System.in)) {
            profill = scanner.nextLine();
        tabprofil [id-1][5] = profill;
        }

            datedajout = date.format(formatter);
            tabprofil [id-1][6] = datedajout;
            datedemodification = "";
            tabprofil [id-1][7] = "";
         
        int j=0;
        profil = "";

        for (j=0; j<8; j++)
        {profil= profil + tabprofil[id][j];}
        index = id;
    
        Path r= Paths.get("C:\\Users\\souri\\Desktop\\fichierprofils.txt"); 
    
        FileReader fr = new FileReader("C:\\Users\\souri\\Desktop\\fichierprofils.txt");
        FileWriter fw = new FileWriter("C:\\Users\\souri\\Desktop\\fichierprofil2.txt");
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
    
        int i=0;
    
        String data;
    
        for(i=0;i<index;i++) 
        
        {   br.readLine();
            data = br.readLine();
            bw.append(new String(data));
            bw.flush();
        }
        
        bw.append(profil);
        bw.flush();
    
        for(i=index+1;i<9999;i++) 
        
        {  br.readLine();
            data = br.readLine();
            bw.append(new String(data));
            bw.flush();
        }
    
        bw.flush();
        br.close();
        bw.close();
        (r.toFile()).delete();
       
        Path source = Paths.get("C:\\Users\\souri\\Desktop\\fichierprofil2.txt");
        Path target = Paths.get("C:\\Users\\souri\\Desktop\\fichierprofil.txt");
      
        Files.move(source, target);
        creationcompte();
        
    }


    public void modifierprofil() throws IOException 
{String recherche; String nom; String prénom; String email; String adressepostal; 
    String datedenaissance; String profill; String datedajout; String datedemodification;
    BufferedWriter cc; BufferedReader bfcc; String ligne; String auth;

String profil="";
int index;

System.out.println("Authentifiez votre email : ");
try (Scanner scanner = new Scanner(System.in)) {
    auth = scanner.nextLine();
}

id(auth,"");
login(auth);


LocalDate date = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    System.out.println("Entrez un nom : ");
    try (Scanner scanner = new Scanner(System.in)) {
         nom = scanner.nextLine();
    }
 
    System.out.println("Entrez un email : ");
    try (Scanner scanner = new Scanner(System.in)) {
        email = scanner.nextLine();
    }

    int i=0;
    int j=0;

    for(i=0; i<9999;i++)
    {
    if ((tabprofil [i][0] == nom)&&(tabprofil [i][2] == email))
    {
    
        System.out.println("Entrez un nom : ");
        try (Scanner scanner = new Scanner(System.in)) {
             nom = scanner.nextLine();
             tabprofil [i][0] = nom;
        }
     
        System.out.println("Entrez un prénom : ");
        try (Scanner scanner = new Scanner(System.in)) {
            prénom = scanner.nextLine();
            tabprofil [i][1] = prénom;
        }

        System.out.println("Entrez un email : ");
        try (Scanner scanner = new Scanner(System.in)) {
            email = scanner.nextLine();
            pronum(email);
            if (pronum(email)!=-1)
            {modifierprofil();};
            tabprofil [i][2] = email;
        }
    
        System.out.println("Entrez un adressepostal : ");
        try (Scanner scanner = new Scanner(System.in)) {
            adressepostal = scanner.nextLine();
            tabprofil [i][3] = adressepostal;
        }
    
        System.out.println("Entrez une date de naissance : ");
        try (Scanner scanner = new Scanner(System.in)) {
            datedenaissance = scanner.nextLine();
            tabprofil [i][4] = datedenaissance;
        }

        System.out.println("Entrez un profill : ");
        try (Scanner scanner = new Scanner(System.in)) {
            profill = scanner.nextLine();
        tabprofil [i][5] = profill;
        }

            datedemodification = date.format(formatter);
            tabprofil [i][7] = datedemodification;
         

    for (j=0; j<8; j++)
    {profil= profil + tabprofil[i][j];}
    index = i;

    Path r= Paths.get("C:\\Users\\souri\\Desktop\\fichierprofils.txt"); 

    FileReader fr = new FileReader("C:\\Users\\souri\\Desktop\\fichierprofils.txt");
    FileWriter fw = new FileWriter("C:\\Users\\souri\\Desktop\\fichierprofil2.txt");
    BufferedReader br = new BufferedReader(fr);
    BufferedWriter bw = new BufferedWriter(fw);

    String data;
    
    for(i=0;i<index;i++) 
    
    {   br.readLine();
        data = br.readLine();
        bw.append(new String(data));
        bw.flush();
    }
    
    bw.append(profil);
    bw.flush();

    for(i=index+1;i<9999;i++) 
    
    {   
        br.readLine();
        data = br.readLine();
        bw.append(new String(data));
        bw.flush();
    }

    bw.flush();
    br.close();
    bw.close();
    (r.toFile()).delete();
   
    Path source = Paths.get("C:\\Users\\souri\\Desktop\\fichierprofil2.txt");
    Path target = Paths.get("C:\\Users\\souri\\Desktop\\fichierprofil.txt");
  
    Files.move(source, target);
    home();

    }
    home();
    }}

    
public void home() throws IOException
{
String choix;
tabcompte [0][0] = "admin@cnam.fr";
tabcompte [0][1] = "admin";
tabcompte [0][2] = "admin";

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
try (Scanner scanner = new Scanner(System.in)) {
    choix = scanner.nextLine();
}

switch (choix) {
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