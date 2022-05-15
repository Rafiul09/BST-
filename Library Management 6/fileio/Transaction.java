package fileio;
import java.lang.*;
import java.util.*;
import Interfaces.*;
import java.io.*;

public  class Transaction implements ITransaction, IfileOP
{
    public void modifyFile( String oldString, String newString, String refline)
    {
        System.out.println("\t\t Updating old >>> new @" + oldString + ">>>" + newString);
        File fileToBeModified = new File("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\Bank.txt");
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
            if(oldContent.contains(refline))
            {
                System.out.println("\t\tupdating  " );

                String newContent = oldContent.replace(oldString, newString);
                writer = new FileWriter(fileToBeModified);
                writer.write(newContent);
                //System.out.println("\t\t modded " + oldContent + ">>>" + newContent);
                // break;


            }
            else
            {
                System.out.println("\t\tcant be updated ");
            }
            reader.close();
            writer.close();


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    //cutprice/
    public  void withdraw (double amount, String accID)
    {
        String line;

        try
        {
            FileInputStream ufin = new FileInputStream("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\Bank.txt");
            Scanner sc = new Scanner(ufin);
            while (sc.hasNextLine())
            {
                /// ttt++;
                line = sc.nextLine();
                if(line.startsWith(accID))
                {
                    String retval[] = line.split(" ");

                    double n = (Double.parseDouble(retval[2]));//balance
                    if (n >= amount)
                    {
                        n = n - amount;
                        String balanceA = String.valueOf(n);
                        System.out.println("\t\tWithdrawing : " + amount);

                        if(retval[0].contains("*123*1"))//paying salary
                        {

                            System.out.println("\t\tDeducted : " + balanceA);
                            //this.modifyFile(line, retval[0] + " " + retval[1] + " " + balanceA + " " + retval[3], line); //format
                            this.modifyFile(" * " + retval[2] + " *", " * " + balanceA + " *", retval[0]);
                            this.deposit(amount, "*11*1");//paying salary
                            //System.out.println("\t\tWithdrawn : " + retval[2]);
                            markAA = true;
                            break;
                        }
                        else if (retval[0].contains(accID))//buying books
                        {

                            System.out.println("\t\tFrom : " + retval[0]);
                            System.out.println("\t\tWithdrawn : " + balanceA);
                            this.modifyFile(" * " + retval[2] + " *", " * " + balanceA + " *", retval[0]);
                            //this.modifyFile(line, retval[0] + " " + retval[1] + " " + balanceA + " " + retval[3], line); //format
                            this.deposit(amount, "*123*1"); //buying books
                            markAA = true;
                            // break;
                        }

                        break;
                    }
                    else
                    {
                        markAA = false;
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tSorry you dont hava enough balance. ");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                    }

                    System.out.println(n);

                }

            }


        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

    }
    //credit card
    public  void deposit (double dAmount, String line3)
    {
        String line2;

        try
        {
            FileInputStream ufin = new FileInputStream("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\Bank.txt");
            Scanner sc = new Scanner(ufin);
            while (sc.hasNextLine())
            {
                /// ttt++;
                line2 = sc.nextLine();
                String retval2[] = line2.split(" ");

                if(line2.contains(line3))
                {
                    System.out.println("\t\tDepositing  " );
                   // System.out.println("\t\t  " + retval2.length );
                    System.out.println("\t\t  " + retval2[2] );
                    double m = (Double.parseDouble(retval2[2])) + dAmount;
                    String balanceC = String.valueOf(m);

                    //this.modifyFile(line2, retval2[0] + " " + retval2[1] + " " + balanceC + "  " + retval2[3], "");
                    this.modifyFile(" * " + retval2[2] + " *", " * " + balanceC + " *", line3);
                    System.out.println("\t\tDepositited  " );



                }
                else
                {
                    //System.out.println("\t\tTransfer Failed!  " );
                }

            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public  boolean markAA = false;
    public void writeInFile(String x, String z) {} //anonymous class
    public void search(String d){}
    public void verify(String c) {}


}