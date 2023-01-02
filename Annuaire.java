package projetpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import static java.nio.file.StandardCopyOption.*;


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
     List<Boolean> idtemp = new ArrayList<>();
     HashMap<String, String> idmdp = new HashMap<String, String>();



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

public void id (String mail, String mdp)
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

}


public int idnum (String mail)
{
    int i=0;

for (i=0;i<9999;i++)
{
    tabmail [i] = tabcompte [i][0]; 
}

for (String str:tabmail) {
    alist.add(str);
 }

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

  compte = "C:\\Users\\Public\\fichiercompte.txt";

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
    
      profil = "C:\\Users\\Public\\fichierprofil.txt";
    
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
{   int i =0;
    int j =0;
   
       for(i=0; i<9999;i++)
       {

           if ((tabprofil [i][para])!=null)

   {
       if ((tabprofil [i][para]).equals(motRechercher))
       {
       
       for (j=0; j<8; j++)
       {System.out.print(tabprofil [i][j]+" ");}

       }
       else
       System.out.println("3RIEN");
   
   } 

       }    

       ask("Again? Y or N ");
       if (temp.get(2).equals("Y"))
       {recherche();}
       try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
          home();
    }
    home();
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
System.out.print("Enter your "+typeof+" ");
 
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
System.out.print("Enter your "+typeof+ " ");
 
String name = reader.readLine();
queryprocess.add(name);



}

public void recherche() throws IOException
{   
 
    temp.clear();
    queryprocess.clear();

    ask("Choose //nom//email//profil: ");
    ask("Find this word: ");

    switch (temp.get(0)) 
    {
        case "nom":
        rech(0, temp.get(1));
        break;
        case "email":
        rech(2, temp.get(1));
        break;
        case "profil":
        rech(5, temp.get(1));
        break;

    }

    home();

}

public void home() throws IOException
{

temp.clear();
queryprocess.clear();
idtemp.clear();

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
         
        ask("mdp(admin)");
        id(email,temp.get(0));
        
        int i =0;

        for (i=0; i<20;i++)

        {
            idmdp.put(alist.get(i),blist.get(i));            
        }

        System.out.println(idmdp.get(email));
      

try { if (idmdp.get(email).equals(""));
    
} catch (Exception e) {
    home();
}
        
        System.out.println("sucess to reach your mail!");
       

        if((alist.indexOf(email))==(blist.indexOf(temp.get(1))))

        {
         
            System.out.println("sucess to match datas!");
   
        }
        
        else  {

            home();
      
        }

        
    }



    public void modifierprofil() throws IOException 
    {  String datedemodification;
       
        String profil="";
        String oldprofil="";
        int index;
    
        temp.clear();
        queryprocess.clear();
        idtemp.clear();
    
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = now.format(formatter);
    
        ask("Name of profil to modify: ");
        ask("Mail of profil to modify: ");
       
        pronum(temp.get(1));
    
     
            int i=0;
            int j=0;
        
            for(i=0; i<9999;i++)
            {
    
                if ((tabprofil [i][0]).equals(tabprofil [pronum(temp.get(1))][0]))
    
                { if ((tabprofil [i][2]).equals(tabprofil [pronum(temp.get(1))][2]))
    
                {
    
            if (((tabprofil [i][0]).equals(temp.get(0)))&&((tabprofil [i][2]).equals(temp.get(1))))
            {
                    askList("new nom");
                    temp.add(tabprofil [i][0]);
                    tabprofil [i][0] = queryprocess.get(0);
                
                    askList("new prénom");
                    temp.add(tabprofil [i][1]);
                    tabprofil [i][1] = queryprocess.get(1);
                
                    askList("new email");
                    temp.add(tabprofil [i][2]);
                    pronum(queryprocess.get(2));
        
                    if (pronum(queryprocess.get(2))!=-1)
                    {modifierprofil();};
                    tabprofil [i][2] = queryprocess.get(2);
                
                    askList("new adressepostal");
                    temp.add(tabprofil [i][3]);
                    tabprofil [i][3] = queryprocess.get(3);
                
                    askList("new datedenaissance");
                    temp.add(tabprofil [i][4]);
                    tabprofil [i][4] = queryprocess.get(4);
                
                    askList("new profill");
                    temp.add(tabprofil [i][5]);
                     tabprofil [i][5] = queryprocess.get(5);
                
                    temp.add(tabprofil [i][6]);
    
                    datedemodification = date.toString();
                    temp.add(tabprofil [i][7]);
                    tabprofil [i][7] = datedemodification;
                 
        
                for (j=0; j<8; j++)
                 {profil= profil + tabprofil[i][j]+";";}
                 index = i;
    
                oldprofil="";
    
                 for (j=2; j<10; j++)
                 {oldprofil= oldprofil + temp.get(j)+";";}
               
             
                 Path r =  Paths.get("C:\\Users\\Public\\fichierprofil.txt"); 
                 FileReader fr = new FileReader("C:\\Users\\Public\\fichierprofil.txt");
                 FileWriter fw = new FileWriter("C:\\Users\\Public\\profilcopyForModification.txt");
                 BufferedReader br = new BufferedReader(fr);
                 BufferedWriter bw = new BufferedWriter(fw);
              
                 String ligne = br.readLine();
             
                 while(ligne != null) {
                 
                 if (ligne.equals(oldprofil))
             
             {
                 String replace = ligne.replace(oldprofil, profil);
                 bw.write(replace);
                 bw.newLine();
                 bw.flush();
             }
             
             else
             {
                 bw.write(ligne);
                 bw.newLine();
             }
             
                 ligne = br.readLine();
                 
                 }
             
                bw.flush();
                br.close();
                bw.close();

            Path source = Paths.get("C:\\Users\\Public\\profilcopyForModification.txt");
            Path target = Paths.get("C:\\Users\\Public\\fichierprofil.txt");

            Files.copy(source, target, REPLACE_EXISTING);

            System.out.println("This profil has been TRUELY modified: "+oldprofil);
            System.out.println(profil+" is the new profil! Please check at: "+source);


                            }
                            
                            // System.out.println("this profil has been modified "+oldprofil);
                            
    
            }
        
            temp.clear();
            queryprocess.clear();
            idtemp.clear();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                  home();
            }
            home();
        
            }}
        
            temp.clear();
            queryprocess.clear();
            idtemp.clear();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                  home();
            }
            home();
    
       }


    public void creationcompte() throws IOException
    { int index;

        temp.clear();
        queryprocess.clear();
        idtemp.clear();

       ask("Authentification email(admin): ");
    
        login(temp.get(0));
   
        ask("Email of the account currently created: ");
       
        if (idnum(temp.get(2))!=-1)
            {home();};
         

            tabcompte [nbdecpt()][0] = temp.get(2);
        
            ask("mdp");
            tabcompte [nbdecpt()][1] = temp.get(3);
        
            ask("role");
            tabcompte [nbdecpt()][2] = temp.get(4);;
    

     index = nbdecpt();
    
     Path r = Paths.get("C:\\Users\\Public\\fichiercompte.txt");
     FileWriter fw = new FileWriter("C:\\Users\\Public\\fichiercompte.txt", true);
     BufferedWriter bw = new BufferedWriter(fw);
 
     bw.newLine();
     bw.write(temp.get(2)+";"+temp.get(3)+";"+temp.get(4));
     bw.flush();
     bw.close();

     System.out.println("Adding done for "+(temp.get(2)+";"+temp.get(3)+";"+temp.get(4))+" at"+r+" .");

    temp.clear();
    idtemp.clear();
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
          home();
    }
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
        idtemp.clear();

        ask("Authentification email(admin)");
        
        login(temp.get(0));

        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         Date date = new Date();
     
        id= nbdepro();

        askList("Email of the profil currently created");

        if (pronum(queryprocess.get(0))!=-1)
        {home();};
        id(queryprocess.get(0),"");
        tabprofil [id][2] = queryprocess.get(0);
    
        askList("nom");
             tabprofil [id][0] = queryprocess.get(1);
        
    
        askList("prénom");
            tabprofil [id][1] = queryprocess.get(2);
        

        askList("adressepostal");
            tabprofil [id][3] = queryprocess.get(3);
        
    
        askList("datedenaissance");
            tabprofil [id][4] = queryprocess.get(4);
        

        askList("profill");
        tabprofil [id][5] = queryprocess.get(5);

            

            // datedajout = date.toString();
            // tabprofil [id][6] = datedajout;
          

            tabprofil [id][6] = null;

            datedemodification = null;
            tabprofil [id][7] = null;
         
        int j=0;
        profil = "";

        for (j=0; j<8; j++)
        {profil= profil + tabprofil[id][j]+";";}
        index = id;
    
        FileWriter fw = new FileWriter("C:\\Users\\Public\\fichierprofil.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
    
        bw.newLine();
        bw.write(profil);
        bw.flush();
        bw.close();

        
        Path source = Paths.get("C:\\Users\\Public\\fichierprofil.txt");
        Path target = Paths.get("C:\\Users\\Public\\profilcopyForModification.txt");

        Files.copy(source, target, REPLACE_EXISTING);
        // Files.move(source, target);

        System.out.println("This profil has been created: "+profil+" at"+source);

        temp.clear();
        queryprocess.clear();
        idtemp.clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            creationcompte();
        }

        creationcompte();
        
    }


    public void modifierprofil() throws IOException 
    {  String datedemodification;
        
        String profil="";
        String oldprofil="";
        int index;
        int incr;
    
        temp.clear();
        queryprocess.clear();
        idtemp.clear();
    
        ask("Authentification mail(admin): ");
        // id(temp.get(0),"");
        login(temp.get(0));
    
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
    
        ask("Name of the profil to modify");
        ask("Email of the profil to modify");
   
        int i=0;
        int j=0;
        

        System.out.println(tabprofil [0][0]);
        System.out.println(tabprofil [2][0]);
        System.out.println(tabprofil [0][2]);
        System.out.println(tabprofil [2][2]);
        
        pronum("testdur");

         incr = zlist.indexOf("testdur");

         System.out.println(incr);

            if ((tabprofil [incr][0])!=null)


            { if ((tabprofil [incr][2])!=null)

                
            {

                
        if ((tabprofil [incr][0]).equals(temp.get(2)))
        
        {

            if ((tabprofil [incr][2]).equals(temp.get(3)))

       
        {       

            for(i=0; i<15;i++)
            {

            System.out.println("doubles check ok");
            System.out.println(tabprofil [0][0]!=null);
            System.out.println(tabprofil [2][0]!=null);

                askList("new nom");
                temp.add(tabprofil [i][0]);
                tabprofil [i][0] = queryprocess.get(0);
            
                askList("new prénom");
                temp.add(tabprofil [i][1]);
                tabprofil [i][1] = queryprocess.get(1);
            
                askList("new email");
                temp.add(tabprofil [i][2]);
                pronum(queryprocess.get(2));
    
                if (pronum(queryprocess.get(2))!=-1)
                {modifierprofil();};
                tabprofil [i][2] = queryprocess.get(2);

                askList("new adressepostal");
                temp.add(tabprofil [i][3]);
                tabprofil [i][3] = queryprocess.get(3);
            
                askList("new datedenaissance");
                temp.add(tabprofil [i][4]);
                tabprofil [i][4] = queryprocess.get(4);
            
                askList("new profill");
                temp.add(tabprofil [i][5]);
                 tabprofil [i][5] = queryprocess.get(5);
            
                 
                //  tabprofil [i][6] = null;
                temp.add(tabprofil [i][6]);

                datedemodification = date.toString();
                // tabprofil [i][7] = null;
                
                temp.add(tabprofil [i][7]);
                tabprofil [i][7] = datedemodification;
                
               
                
            for (j=0; j<8; j++)
             {profil= profil + tabprofil[i][j]+";";}
             index = i;

            oldprofil="";

             for (j=4; j<12; j++)
             {oldprofil= oldprofil + temp.get(j)+";";}

        

             Path r =  Paths.get("C:\\Users\\Public\\fichierprofil.txt"); 
             Path w =  Paths.get("C:\\Users\\Public\\profilcopyForModification.txt"); 
             FileReader fr = new FileReader("C:\\Users\\Public\\fichierprofil.txt");
             FileWriter fw = new FileWriter("C:\\Users\\Public\\profilcopyForModification.txt");
             BufferedReader br = new BufferedReader(fr);
             BufferedWriter bw = new BufferedWriter(fw);
          
             String ligne = br.readLine();
         
             while(ligne != null) {
             
             if (ligne.equals(oldprofil))
         
         {
             String replace = ligne.replace(oldprofil, profil);
             bw.write(replace);
             bw.newLine();
             bw.flush();
         }
         
         else
         {
             bw.write(ligne);
             bw.newLine();
         }
         
             ligne = br.readLine();
             
             }
             
             bw.flush();
             br.close();
             bw.close();
         

             Path source = Paths.get("C:\\Users\\Public\\profilcopyForModification.txt");
             Path target = Paths.get("C:\\Users\\Public\\fichierprofil.txt");

             Files.copy(source, target, REPLACE_EXISTING);
       
               System.out.println("This profil has been TRUELY modified: "+oldprofil);
               System.out.println(profil+" is the new profil! Please check at: "+source);

                        }
                        
                        // System.out.println("this profil has been modified "+oldprofil);
                       
                        

        }   }
    
        temp.clear();
        queryprocess.clear();
        idtemp.clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
              home();
        }
        home();
    
        }
    }
    
        temp.clear();
        queryprocess.clear();
        idtemp.clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
              home();
        }
        home();
    
        }



        public void suppressfiles()

        {

            Path compte = Paths.get("C:\\Users\\Public\\fichiercompte.txt");
            Path profil = Paths.get("C:\\Users\\Public\\fichierprofil.txt");
            Path profilcopyForModification = Paths.get("C:\\Users\\Public\\profilcopyForModification.txt");

            try {
                (compte.toFile()).delete();
                (profil.toFile()).delete();
                (profilcopyForModification.toFile()).delete();
            } catch (Exception e) {
                System.out.println("Cant reach files");
            }
           

        }

    
        public void init() throws IOException

        {
            tabcompte [0][0] = "admin";
            tabcompte [0][1] = "admin";
            tabcompte [0][2] = "admin";
            tabprofil [0][0] = "par";
            tabprofil [0][1] = "par";
            tabprofil [0][2] = "par";
        
            suppressfiles();

            File compte = new File("C:\\Users\\Public\\fichiercompte.txt");
            File profil = new File("C:\\Users\\Public\\fichierprofil.txt");
            File profilcopyForModification = new File("C:\\Users\\Public\\profilcopyForModification.txt");
        
            FileWriter icfw = new FileWriter(compte);
            BufferedWriter icbw = new BufferedWriter(icfw);
        
            icbw.write("admin;admin;admin;");
            icbw.newLine();
            icbw.write("particulier;particulier;particulier;");
            icbw.flush();
            icbw.close();
            
            FileWriter ipfw = new FileWriter(profil);
            BufferedWriter ipbw = new BufferedWriter(ipfw);
        
            ipbw.write("par;par;par;null;null;null;null;null;");
            ipbw.newLine();
            ipbw.flush();
            ipbw.close();
        
            FileWriter cfw = new FileWriter(profilcopyForModification);
            BufferedWriter cbw = new BufferedWriter(cfw);
        
            cbw.write("par;par;par;null;null;null;null;null;");
            cbw.newLine();
            cbw.flush();
            cbw.close();
        
        }



public void home() throws IOException
{
  
temp.clear();
queryprocess.clear();
idtemp.clear();

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
System.out.println("Faites votre choix : /ex: 3, 2.A, 1.B ");
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

Admin admin= new Admin("admin", "admin", "admin");
Particulier part= new Particulier("par", "par", "par");

admin.init();
admin.home();
// part.home();

}
}