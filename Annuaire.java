package projetpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     HashMap<String, String> idstamped = new HashMap<String, String>();
     HashMap<String, String> oldtonew = new HashMap<String, String>();
     HashMap<String, String> oldtonewindex = new HashMap<String, String>();
     HashMap<Boolean, String> traker = new HashMap<Boolean, String>();
     

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
            tabcompte [1][0] = "parEMAIL";
            tabcompte [1][1] = "par";
            tabcompte [1][2] = "par";
            tabprofil [0][0] = "par";
            tabprofil [0][1] = "par";
            tabprofil [0][2] = "parEMAIL";
            idmdp.put("admin","admin");
            idmdp.put("parEMAIL","par");
            oldtonewindex.put("admin","0");
            oldtonewindex.put("parEMAIL","1");
            oldtonew.put("admin","admin");
            oldtonew.put("parEMAIL","parEMAIL");
 

            suppressfiles();

            File compte = new File("C:\\Users\\Public\\fichiercompte.txt");
            File profil = new File("C:\\Users\\Public\\fichierprofil.txt");
            File profilcopyForModification = new File("C:\\Users\\Public\\profilcopyForModification.txt");
        
            FileWriter icfw = new FileWriter(compte);
            BufferedWriter icbw = new BufferedWriter(icfw);
        
            icbw.write("admin;admin;admin;");
            icbw.newLine();
            icbw.write("parEMAIL;par;par;");
            icbw.flush();
            icbw.close();
            
            FileWriter ipfw = new FileWriter(profil);
            BufferedWriter ipbw = new BufferedWriter(ipfw);
        
            ipbw.write("par;par;parEMAIL;null;null;null;null;null;");
            ipbw.newLine();
            ipbw.flush();
            ipbw.close();
        
            FileWriter cfw = new FileWriter(profilcopyForModification);
            BufferedWriter cbw = new BufferedWriter(cfw);
        
            cbw.write("par;par;parEMAIL;null;null;null;null;null;");
            cbw.newLine();
            cbw.flush();
            cbw.close();
        
        }


        public void rechindex(int para, String motRechercher) throws IOException
        {   int i =0;
         
           
               for(i=0; i<9999;i++)
               {
        
                   if ((tabprofil [i][para])!=null)
        
           {
               if ((tabprofil [i][para]).equals(motRechercher))
               {

                temp.add(Integer.toString(i));
        
               }
               else
               System.out.println("3RIEN");
           
           } 
        
               }    
        
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

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter your "+typeof+ " ");
 
String name = reader.readLine();
queryprocess.add(name);


}

public void recherche() throws IOException
{   

    try {
        System.out.println("Welcome "+traker.get(false));
    } catch (Exception e) {
       
    }
 
    temp.clear();
    queryprocess.clear();

    ask("Choose //nom//email//profil: (ex: Type nom, email or profil)");
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
    try {
        System.out.println("Welcome "+traker.get(false));
    } catch (Exception e) {
       
    }
    
    id("", "");
    idnum("");
    pronum("");
    traker.clear();
    temp.clear();
    queryprocess.clear();
    idtemp.clear();
     
    System.out.println("Bienvenue dans l-Annuaire NFA032");
    System.out.println("1.A. Ajouter un Admin// Add an Account");
    System.out.println("1.B. Ajouter un particulier// Add an Account and Profile");
    System.out.println("Rechercher un ou des particuliers// Seek profile");
    System.out.println("2.A Par nom");
    System.out.println("2.B. Par email");
    System.out.println("2.C. Par profil");
    System.out.println("3. Modifier mes informations personnelles// Modify a profile");
    System.out.println("Faites votre choix : /ex: 3, 2.A, 1.B ");

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
recherche();
// modifierprofil();
}
}


public String Timenow()

{
    LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String date = now.format(formatter);
           datedajout = date.toString();

           return datedajout;
}


public void login(String email) throws IOException
{       
    

        ask("mdp(admin) or any Account register");
          
        int i =0;


        try {
            
               for(i=0; i<9999;i++)
               {
        
                  try {
                    
           {
               if ((tabcompte[i][0]).equals(email))
               {
              
                temp.add(Integer.toString(i));

                // System.out.println("success");
        
               }
               else
               System.out.println("3RIENIF");
           
           } 

        } catch (Exception e) {
            int k =9999;
        
            System.out.println("Skipping current line...Please wait..."+(k-i)+"    "+Timenow());
          }

               }  

            } catch (Exception e) { try {
                System.out.println("No match datas!");
                Thread.sleep(1000);
                home();
    
    
            } catch (Exception f) {
                System.out.println("No match datas!");
                home();
            }
                
            }

try {
    


        if (temp.get(2)!=null)

        System.out.println("success to reach your mail!");

       if ((idmdp.containsKey(email))&&(idmdp.containsValue(temp.get(1))))


             if ((idmdp.get(email)).equals(temp.get(1)))
         
             System.out.println("success to match datas!");

       else 
       
       {
        try {
            System.out.println("No match datas!");
            Thread.sleep(1000);
            home();


        } catch (Exception f) {
            System.out.println("No match datas!");
            home();
        }
            }


        } catch (Exception e) {
          home();
        }

    
    }



    public void creationcompte() throws IOException
    {   
        int index;
        String newaccount;

        temp.clear();
        queryprocess.clear();
        idtemp.clear();
       
       ask("Authentification email(admin) or any registered Account: ");
    
        login(temp.get(0));


        if (traker.isEmpty()==true)

        {

   
        ask("Set a email for you ACCOUNT : ");
       

        if (idnum(temp.get(3))!=-1)
            {

                try {
                    System.out.println("Cant add an existing mail!");
                    Thread.sleep(1000);
                    home();
                } catch (InterruptedException e) {
                      home();
                }
            
            };
            
            // System.out.println("Case TRAKER ON");
            tabcompte [nbdecpt()][0] = temp.get(3);
            traker.put(false, temp.get(3));
            oldtonew.putIfAbsent(temp.get(3),temp.get(3));
            oldtonewindex.put(temp.get(3),String.valueOf(nbdecpt()));
      

        }

        else

        {

            tabcompte [nbdecpt()][0] = traker.get(false);
            temp.add("fakedata DO NOT delete me!");
            oldtonew.putIfAbsent(traker.get(false),traker.get(false));
            oldtonewindex.put(traker.get(false),String.valueOf(nbdecpt()));

        }
        
        
            ask("Set a password of for the new ACCOUNT: ");
            tabcompte [nbdecpt()][1] = temp.get(4);
            idmdp.put(temp.get(3),temp.get(4));
            
            ask("role: ");
            tabcompte [nbdecpt()][2] = temp.get(5);
            idstamped.put(temp.get(3),temp.get(5));


            newaccount = tabcompte [nbdecpt()][0] +";"+ tabcompte [nbdecpt()][1] +";"+ tabcompte [nbdecpt()][2]+";";

            index = nbdecpt();
    
     Path r = Paths.get("C:\\Users\\Public\\fichiercompte.txt");
     FileWriter fw = new FileWriter("C:\\Users\\Public\\fichiercompte.txt", true);
     BufferedWriter bw = new BufferedWriter(fw);
 
     bw.newLine();
     bw.write(newaccount);
     bw.flush();
     bw.close();
  

     System.out.println("Adding done for this NEW ACCOUNT "+(newaccount));

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
      
        ask("Authentification email(admin) or any registed ACCOUNT");
        
        login(temp.get(0));

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = now.format(formatter);
     
        id= nbdepro();

        askList("Choose your PROFIL email:(is also going to be your ACCOUNT email if no already created)");

        if (pronum(queryprocess.get(0))!=-1)
        {
             try {
                    System.out.println("Cant add an existing mail!");
                    Thread.sleep(1000);
                    home();
                } catch (InterruptedException e) {
                      home();
                }
        };

        id(queryprocess.get(0),"");
        tabprofil [id][2] = queryprocess.get(0);
    
        askList("nom");
             tabprofil [id][0] = queryprocess.get(1);
        
    
        askList("prénom");
            tabprofil [id][1] = queryprocess.get(2);
        

        askList("adressepostal");
            tabprofil [id][3] = queryprocess.get(3);
        
            idstamped.put("Newdate",temp.get(0));
            tabprofil [id][4] = "Create by "+idstamped.get("Newdate");
            idstamped.clear();
  
            tabprofil [id][5] = null;

            datedajout = date.toString();
            tabprofil [id][6] = datedajout;
          
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

        System.out.println("This NEW PROFILE has been created: "+profil+" at"+source);

        idtemp.clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
    
            traker.put(false, queryprocess.get(0));
            System.out.println(traker.get(false));
            creationcompte();
        }

  
        traker.put(false, queryprocess.get(0));
        System.out.println(traker.get(false));
        creationcompte();
        
    }


    public void modifierprofil() throws IOException 
    {  String datedemodification;
        
        String profil="";
        String oldprofil="";
        int index;
        int j;
    
        temp.clear();
        queryprocess.clear();
        idtemp.clear();
    
        ask("Authentification mail(admin) or any registed Account: ");
        login(temp.get(0));
        traker.put(false, temp.get(0));
    
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = now.format(formatter);
    
        ask("NAME of the profil to modify");
        ask("EMAIL of the profil to modify");
   
        rechindex(2,temp.get(4));

try {
    
            if ((tabprofil [Integer.parseInt(temp.get(5))][2])!=null)
           
    {        
        // System.out.println("mail find");
        if ((tabprofil [Integer.parseInt(temp.get(5))][2]).equals(temp.get(4)))
        

        {
            // System.out.println("mail match");
     if ((tabprofil [Integer.parseInt(temp.get(5))][0]).equals(temp.get(3)))

     
        {   
            // System.out.println("name match");
                askList("new nom");
                temp.add(tabprofil [Integer.parseInt(temp.get(5))][0]);
                tabprofil [Integer.parseInt(temp.get(5))][0] = queryprocess.get(0);
            
                askList("new prénom");
                temp.add(tabprofil [Integer.parseInt(temp.get(5))][1]);
                tabprofil [Integer.parseInt(temp.get(5))][1] = queryprocess.get(1);


                if (tabprofil [Integer.parseInt(temp.get(5))][2].equals(oldtonew.get(temp.get(4))))

                {
                    // System.out.println("CASE MATCH");
                    askList("new email");
                    temp.add(tabprofil [Integer.parseInt(temp.get(5))][2]);
                    pronum(queryprocess.get(2));
        
                    if (pronum(queryprocess.get(2))!=-1)
                    {
                        try {
                            System.out.println("Cant add an existing mail!");
                            Thread.sleep(1000);
                            modifierprofil();
                        } catch (InterruptedException e) {
                              modifierprofil();
                        }
                    
                    };
                    
                    tabprofil [Integer.parseInt(temp.get(5))][2] = queryprocess.get(2);

                    tabcompte [Integer.parseInt(oldtonewindex.get(oldtonew.get(temp.get(4))))][0] = queryprocess.get(2);
                    System.out.println("MAIL Modification have been done one your ACCOUNT, Please check at: C:\\Users\\Public\\fichiercompte.txt");

                    oldtonew.remove(temp.get(4));
                    oldtonew.put(queryprocess.get(2),queryprocess.get(2));

                }

                else

                {

                // System.out.println("CASE NO MATCH");
                askList("new email");
                temp.add(tabprofil [Integer.parseInt(temp.get(5))][2]);
                pronum(queryprocess.get(2));
    
                if (pronum(queryprocess.get(2))!=-1)
                {
                    try {
                        System.out.println("Cant add an existing mail!");
                        Thread.sleep(1000);
                        modifierprofil();
                    } catch (InterruptedException e) {
                          modifierprofil();
                    }
                
                };

                tabprofil [Integer.parseInt(temp.get(5))][2] = queryprocess.get(2);

            }


                askList("new adressepostal");
                temp.add(tabprofil [Integer.parseInt(temp.get(5))][3]);
                tabprofil [Integer.parseInt(temp.get(5))][3] = queryprocess.get(3);
                        
                temp.add(tabprofil [Integer.parseInt(temp.get(5))][4]);
                
                temp.add(tabprofil [Integer.parseInt(temp.get(5))][5]);
                idstamped.put("Modifieddate",temp.get(0));
                tabprofil [Integer.parseInt(temp.get(5))][5] = "Modified by "+idstamped.get("Modifieddate");
                idstamped.clear();

                temp.add(tabprofil [Integer.parseInt(temp.get(5))][6]);

                datedemodification = date.toString();
                
                temp.add(tabprofil [Integer.parseInt(temp.get(5))][7]);
                tabprofil [Integer.parseInt(temp.get(5))][7] = datedemodification;
                

            for (j=0; j<8; j++)
             {profil= profil + tabprofil[Integer.parseInt(temp.get(5))][j]+";";}
             index = Integer.parseInt(temp.get(5));

            oldprofil="";

             for (j=6; j<14; j++)
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

        
                    }}
                        
                    }
                    else
                    System.out.println("3RIEN");
        
    
                } catch (Exception e) {

            System.out.println("Dont have any match for: "+temp.get(2)+"and"+temp.get(3)+"index 2 & 3");

                    temp.clear();
                    queryprocess.clear();
                    idtemp.clear();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException f) {
                          home();
                    }
                    home();
              
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



public void home() throws IOException
{

try {
    System.out.println("Welcome "+traker.get(false));
} catch (Exception e) {
   
}

id("", "");
idnum("");
pronum("");
traker.clear();
temp.clear();
queryprocess.clear();
idtemp.clear();

System.out.println("Bienvenue dans l-Annuaire NFA032");
System.out.println("1.A. Ajouter un Admin// Add an Account to Stamped new profile with your account name: ");
System.out.println("1.B. Ajouter un particulier// Add an Profile ");
System.out.println("Rechercher un ou des particuliers// Seek profile");
System.out.println("2.A Par nom");
System.out.println("2.B. Par email");
System.out.println("2.C. Par profil");
System.out.println("3. Modifier mes informations personnelles// Modify a profile");
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
Particulier part= new Particulier("parEMAIL", "par", "par");

admin.init();
admin.home();

// part.init();
// part.home();

}
}