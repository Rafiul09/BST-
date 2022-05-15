package Classes;
import java.lang.*;
import java.util.*;
import fileio.*;
import Interfaces.*;


public  class UserMenu
{


    public void menu(String username, String password)
    {
        Scanner sc = new Scanner(System.in);
        AdminMenu adm = new AdminMenu();
        HomeMenu hm = new HomeMenu();
        UserLoginSignupFileReadWriteDemo ufrwd = new UserLoginSignupFileReadWriteDemo() {};
        BookFileReadWriteDemo bfrwd = new BookFileReadWriteDemo() {};
        Transaction tra = new Transaction() {};

        ufrwd.verify(username, password);//user verification

        if(ufrwd.counter > 0)//verified
        {
            System.out.println(ufrwd.counter);

            System.out.println("\t\t-------------------------------------------------------------------------------");
            System.out.println("\t\t-------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t        ---Welcome " + username + " ---");
            System.out.println("");
            boolean done00 = true;
            while(done00)
            {
                System.out.println("\t\t\tWhat do you want to do? [Enter a number]");
                System.out.println("\t\t\t1. Search a Book");
                System.out.println("\t\t\t2. Change Password");
                System.out.println("\t\t\t3. Contact Us ");
                System.out.println("\t\t\t4. Delete your Account ");
                System.out.println("\t\t\t5. Log out");

                System.out.println();
                int uroute = 0;
                boolean udone = false;
                while(!udone)
                {
                    try
                    {
                        System.out.print("\t\tWhat is your choice: ");//***
                        uroute = sc.nextInt();
                        udone = true;
                    }
                    catch(InputMismatchException e)
                    {
                        String ustr = sc.nextLine();
                        System.out.println();
                        System.out.println("\t\tThis is a invalid input!!! You entered \"" + ustr + "\" which is a string");

                        System.out.println("\t\tPleasae Enter a whole number. ");
                        System.out.println();
                    }
                }

                switch (uroute)
                {
                case 1:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chosen to Search Book");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    System.out.print("\t\tEnter the isbn of the book: ");
                    String sisbn = sc.next();

                    bfrwd.search(sisbn);

                    if(bfrwd.markA != false)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tDo you want to buy the book?  [y/n]");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.print("\t\tWhat is your choice: ");
                        String d = sc.next();

                        if (d.equals("y"))
                        {

                            System.out.print("\t\tPlease Enter Your Credit Card Number: ");
                            String  cred = sc. next();
                            //System.out.println("enter num");
                            //double  x = sc. nextInt();
                            bfrwd.purchase(cred, username);//*001*0 cred
                            if(tra.markAA = true)
                            {
                                System.out.println("\t\t-------------------------------------------------------------------------------");
                                System.out.println("\t\tThank you for you purchase!");
                                System.out.println("\t\t-------------------------------------------------------------------------------");
                                tra.markAA = false;//resetting
                            }
                        }
                        else if (d.equals("n"))
                        {
                            break;
                        }
                        bfrwd.markA = false; //resetting
                    }
                    else if(bfrwd.markC != false)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tOops! we are out of stock for that one. Please try something else ");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        bfrwd.markC = false; //resetting
                    }
                    else if (bfrwd.markA != true)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tNo Such Books ");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        bfrwd.markA = false;
                    }


                    break;
                case 2:
                    ufrwd.initiateReactify();
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chosen to change your password");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    //System.out.print("\t\t Please enter your ID: " );
                    //String user1D = sc.next();

                    System.out.print("\t\t Please enter the OTP we have sent: " );
                    String oTp = sc.next();
                    ufrwd.rectify(username, oTp);
                    if (ufrwd.correct != false)
                    {
                        System.out.println("\t\t Password changed successfully!" );
                    }
                    else
                    {
                        System.out.println("\t\t Please try again" );
                    }

                    break;

                case 3:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tVisit us at");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    ufrwd.info("contact", "0");
                    break;
                case 4:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tAre you sure you want to DELETE your Account? [y/n]");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.print("\t\tWhat is your choice: ");
                    String c = sc.next();
                    if(c.equals("y"))
                    {
                        //ufrwd.delete = true;
                        ufrwd.delete = 1;//int value
                        ufrwd.verify(username, password);

                    }
                    break;

                case 5:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chosen to log out");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    done00 = false;
                    break;
                default:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tInvalid Choice...");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    break;


                }


            }// loop
        }// if verify
        else
        {

        }

    }// method
    // public  void verify (String line0, String line1) {}
}