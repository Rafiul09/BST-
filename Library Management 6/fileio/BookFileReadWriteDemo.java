package fileio;
import java.lang.*;
import java.util.*;
import Interfaces.*;
import java.io.*;

public  class BookFileReadWriteDemo implements IfileOP
{
    private File ufile;
    private FileWriter uwriter;
    private FileReader ureader;
    private BufferedReader ubfr;
    Transaction ptra = new Transaction() {};

    public void modifyFile( String oldString, String newString, String refline)
    {
        File fileToBeModified = new File("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\BOOK.txt");
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line1 = reader.readLine();
            while (line1 != null)
            {
                oldContent = oldContent + line1 + System.lineSeparator();
                line1 = reader.readLine();
            }
            if(oldContent.startsWith(refline))
            {
                String newContent = oldContent.replace(oldString, newString);
                writer = new FileWriter(fileToBeModified);
                writer.write(newContent);
                reader.close();
                writer.close();
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    public void writeInFile(String s)
    {

        try
        {
            ufile = new File("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\BOOK.txt");
            ufile.createNewFile();
            uwriter = new FileWriter(ufile, true);
            uwriter.write(s + System.lineSeparator());
            uwriter.flush();
            uwriter.close();
            markB = true;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void showAllBooks()
    {
        this.search("*");

    }

    public void writeTransactionHistory(String s)
    {

        try
        {
            ufile = new File("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\TransactionHistory.txt");
            ufile.createNewFile();
            uwriter = new FileWriter(ufile, true);
            uwriter.write(s + System.lineSeparator());
            uwriter.flush();
            uwriter.close();
            //markB= true;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public  void search (String line0)
    {
        String line;
        try
        {
            FileInputStream ufin = new FileInputStream("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\BOOK.txt");
            Scanner sc = new Scanner(ufin);
            while (sc.hasNextLine())
            {   //System.out.println("\t\tDELETE VAL"+delete);
                line = sc.nextLine();
                String retval[] = line.split(" ");
               // System.out.println("\t\tARRAY SIZE : "+retval.length+" "+retval[1]);
                if(line.contains(line0))
                {
                    if(retval[1].equals(line0) && delete==0)
                    {
                        int n = (Integer.parseInt((retval[7])));//quantity
                        if (n != 0)
                        {
                                                  
                            cutprice = (Double.parseDouble((retval[5])));
                            if(ptra.markAA)//for buying
                            {
                            	n=n-1;
                                this.modifyFile("** "+retval[7]+" **" , "** "+ n+" **" , "* "+retval[1]+" *");
                            	//this.modifyFile(line ,retval[0]+ " " + retval[1] + " " +  " " + retval[2] + " " + retval[3] + " " +retval[4] + " " +retval[5] + " " +retval[6] +" " + n + " " +retval[8] +" " +retval[9], "* "+retval[1]);
                                ptra.markAA=false;//REsetting
                            }                // old Sentence              new Sentence       refrenced line
                        }
                        else
                        {
                          markC=true;  //resets at user menu   
                        }
                        System.out.println("\t\t--Book Found--");
                        System.out.println("\t\tBook ISBN : " + retval[1].replace(".", " "));
                        System.out.println("\t\tBook Title : " + retval[3].replace(".", " "));
                        System.out.println("\t\tBook Author Name : " + retval[4].replace(".", " "));
                        System.out.println("\t\tGenre : " + retval[9].replace(".", " "));
                        System.out.println("\t\tBook price : " + retval[5]);
                        System.out.println("\t\tAvailble Qty : " + retval[7]);
                         markA = true; //resets at user menu   

                    }
                    else if (retval[0].startsWith(line0)&& delete==0) //Showing all books
                    {
                        System.out.println("\t\t--Book Found--");
                        System.out.println("\t\tBook ISBN : " + retval[1].replace(".", " "));
                        System.out.println("\t\tBook Title : " + retval[3].replace(".", " "));
                        System.out.println("\t\tBook Author Name : " + retval[4].replace(".", " "));
                        System.out.println("\t\tGenre : " + retval[9].replace(".", " "));
                        System.out.println("\t\tBook price : " + retval[5]);
                        System.out.println("\t\tAvailble Qty : " + retval[7]);
                    }
                    else if (retval[1].equals(line0)&& delete>0) //For deleting
                    {
                     this.modifyFile(line , "[Removed]" , "");
                     delete=0;
                    }

                    

                }
                else
                {}

            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public  void purchase(String cred, String uname)
    {
        
        ptra.withdraw(cutprice, cred); //going to transaction
        this.writeTransactionHistory(uname+ " Have deposited "+cutprice + "$ to account no. : *123*1* And Have been Credited from account no. : " + cred + " *");
       

        //markC = true;

    }
    public void showHistory()
    {
        String line;
        try
        {
            FileInputStream ufin = new FileInputStream("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\TransactionHistory.txt");
            Scanner sc = new Scanner(ufin);
            while (sc.hasNextLine())
            {

                line = sc.nextLine();
                System.out.println("\t\t " + line);
                


            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
       
    }

    public  void verify (String line0)
    {
        String line;
        try
        {
            FileInputStream ufin = new FileInputStream("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\user.txt");
            Scanner sc = new Scanner(ufin);
            while (sc.hasNextLine())
            {
                line = sc.nextLine();
                String retval[] = line.split(" ");
                if(line.contains(line0))
                {
                    if(retval[0].equals(line0))
                    {
                        //counter++;
                    }
                    

                }
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
  
    public  int delete = 0;
    public  double cutprice = 0;
    public  boolean markA = false;//for book search matched
    public  boolean markB = false;
    public  boolean markC = false;//for book search matched but out of stock
    public void writeInFile(String s,String l){}//anonymous class



}