package fileio;
import java.lang.*;
import java.util.*;
import java.io.*;
import Interfaces.*;

public class UserLoginSignupFileReadWriteDemo implements IUserLoginSignupFileReadWriteDemo
{
    private File ufile;
    private FileWriter uwriter;
    private FileReader ureader;
    private BufferedReader ubfr;
    Transaction utra = new Transaction() {};



    public void writeInFile(String s, String loc)
    {

        try
        {
            ufile = new File("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\" + loc + ".txt");
            ufile.createNewFile();
            uwriter = new FileWriter(ufile, true);
            uwriter.write(s + System.lineSeparator());
            uwriter.flush();
            uwriter.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    public int delete = 0;

    public  void info(String loc, String empId)
    {
        String line;
        try
        {
            FileInputStream ufin = new FileInputStream("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\" + loc + ".txt");
            Scanner sc = new Scanner(ufin);
            while (sc.hasNextLine())
            {
                line = sc.nextLine();
                String vretval[] = line.split(" ");
                if(loc.equals("contact"))
                {
                    System.out.println("\t\t" + line);
                }
                else if(loc.equals("Bank"))
                {
                    if(line.startsWith(empId))
                    {

                        System.out.println("\t\t" + line);

                    }



                }
                else if(loc.equals("user"))
                {
                    String retval[] = line.split(" ");
                    if(line.contains(empId) && retval.length == 8)
                    {
                        salary = (Double.parseDouble((retval[6])));// storing in salary
                        //System.out.println("\t\tArray Matched!" + retval[1] + " " + retval.length);

                        break;
                    }
                    else
                    {
                        // System.out.println("\t\tArray short!" + retval[1] + " " + retval.length);
                    }
                }
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException aiobe)
        {
            aiobe.printStackTrace();
        }
    }

    public  boolean pay(String cred, String uid)
    {
        boolean success = false;
        this.info("user", uid); // getting info of user and salary
        System.out.println("\t\tPaying salary :" + salary);
        utra.withdraw(salary, "*123*1");
        this.writeInFile( "You Have deposited " + salary + "$ to account no. : " + cred + "For the employee : " + uid.replace("_", "") + " And Have been withdrawn from account no. : *123*1 *", "TransactionHistory");

        return success;


    }


    public  void verify (String line0, String line1) //Login/Delete
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
                    if(retval[3].equals(line0) && retval[4].equals(line1) && delete == 0)
                    {
                        //System.out.println(delete + " before");
                        if (retval.length == 6)
                        {
                            counter++;//user logging in
                        }
                        else
                        {
                            counter--; //employee logging in
                        }


                    }
                    else if(line.contains(line0) && delete > 0) //deleting
                    {
                        //String p= Arrays.toString(retval);
                        //System.out.println(delete + " after");
                        this.modifyFile(line, "[Removed]", line);
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tDeleted Successfully");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        delete = 0; //resetting
                    }



                }


            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public  int counter = 0;

    public void initiateReactify()
    {
        Random rd = new Random();
        int ird = rd.nextInt(9999);
        try
        {

            String srd  = String.valueOf(ird);
            ufile = new File("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\otp.txt");
            ufile.createNewFile();
            uwriter = new FileWriter(ufile, false);
            uwriter.write(srd);
            uwriter.flush();
            uwriter.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

    }

    public  void rectify (String name, String otp0)
    {
        String nameline;
        String otpline;
        try
        {
            Scanner scp = new Scanner(System.in);
            FileInputStream ufin = new FileInputStream("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\user.txt");
            FileInputStream otp = new FileInputStream("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\otp.txt");
            Scanner sc = new Scanner(ufin);
            Scanner sc2 = new Scanner(otp);
            while (sc.hasNextLine())
            {
                nameline = sc.nextLine();
                String retval[] = nameline.split(" ");
                //System.out.println("\t\tArray Size!" + retval[3] + " " + retval.length);
                if(nameline.contains(name))
                {
                    // System.out.println("\t\tArray Size!" + retval[3] + " " + retval.length);
                    if(retval[3].equals(name) ) //user array size
                    {
                        //counter++;
                        while (sc2.hasNextLine())
                        {
                            otpline = sc2.nextLine();
                            String otpretval[] = otpline.split(" ");
                            //System.out.println("\t\tArray Size!"  + " " + otpretval.length);
                            //System.out.println("\t\totp"  + " " + otpline);
                            //System.out.println("\t\totpreceived"  + " " + otp0);

                            if (otpline.equals(otp0))
                            {
                                while(!correct )
                                {
                                    System.out.println("\t\t-------------------------------------------------------------------------------");
                                    System.out.println("\t\t Please Enter New Password: " );
                                    System.out.println("\t\t-------------------------------------------------------------------------------");
                                    System.out.print("\t\t");
                                    String password = scp.next();
                                    System.out.println("\t\t-------------------------------------------------------------------------------");
                                    System.out.println("\t\t Please Re-Enter New Password: " );
                                    System.out.println("\t\t-------------------------------------------------------------------------------");
                                    System.out.print("\t\t");
                                    String repassword = scp.next();
                                    if (password.equals(repassword))
                                    {

                                        if(retval.length == 6)                                                                              //4th index
                                        {
                                            this.modifyFile(nameline, retval[0] + " " + retval[1] + " " + retval[2] + " " + retval[3] + " " + password + " " + retval[5], nameline);//for reader
                                        }
                                        else if(retval.length == 8)
                                        {
                                            this.modifyFile(nameline, retval[0] + " " + retval[1] + " " + retval[2] + " " + retval[3] + " " + password + " " + retval[5] + " " + retval[6] + " " + retval[7], nameline); // for Employee
                                        }


                                        correct = true;
                                    }
                                    else
                                    {
                                        System.out.print("\t\t Please try again" );


                                    }

                                }


                            }
                            else
                            {
                                System.out.print("\t\t Sorry Wrong OTP" );
                            }
                        }
                        break;

                    }
                    else if(retval[0].equals(name) && retval.length == 8) // employee array size// for salary
                    {
                        System.out.println("\t\tRecord Found ");
                        System.out.println("\t\tCurrent Salary :" + retval[6]);
                        System.out.print("\t\tEnter the modified amount: " );
                        String mAmount = scp.next();
                        this.modifyFile(nameline, retval[0] + " " + retval[1] + " " + retval[2] + " " + retval[3] + " " + retval[4] + " " + retval[5] + " " + mAmount + " " + retval[7], nameline);
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tUpdate Validated");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                    }


                    else
                    {
                        System.out.println("\t\tNo such records ");
                    }

                }
            }

        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void modifyFile( String oldString, String newString, String refline)
    {
        File fileToBeModified = new File("E:\\3rd sem\\OOP\\Projects\\Defense\\fileio\\user.txt");
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
    public void showAllReaders()
    {
        this.search("**");

    }
    public  boolean search (String line0)
    {
        String line;
        boolean searchnotmatched = true;
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
                    if(retval[0].startsWith(line0) && retval.length == 6)
                    {

                        System.out.println("\t\t--ID Found--");
                        System.out.println("\t\tReader ID : " + (retval[0].replace("**", "")).replace(".", " "));
                        System.out.println("\t\tReader Name : " + retval[1].replace(".", " "));
                        System.out.println("\t\tReader DOB : " + retval[2].replace(".", " "));
                        System.out.println("\t\tReader username : " + retval[3].replace(".", " "));
                        searchnotmatched = false;

                    }
                    else if (retval[0].startsWith(line0) && retval.length == 8) //Showing all Employees
                    {
                        System.out.println("\t\t--ID Found--");
                        System.out.println("\t\tEmployee ID : " + (retval[0].replace("_", "")).replace(".", " "));
                        System.out.println("\t\tEmployee Name : " + retval[1].replace(".", " "));
                        System.out.println("\t\tEmployee DOB : " + retval[2].replace(".", " "));
                        System.out.println("\t\tEmployee username : " + retval[3].replace(".", " "));
                        System.out.println("\t\tEmployee Salary : " + retval[6]);
                        searchnotmatched = false;
                    }



                }

            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return searchnotmatched;
    }
    // public
    public boolean correct = false;
    //public boolean success = false;
    public  double salary = 0;
    public  void verify (String line0) {}

}