package Classes;
import java.lang.*;
import java.util.*;
import fileio.*;
//import Interfaces.*;



public class AdminMenu
{



    public void menu()
    {
        Scanner sc = new Scanner(System.in);
        HomeMenu hm = new HomeMenu();
        UserLoginSignupFileReadWriteDemo ufrwd = new UserLoginSignupFileReadWriteDemo() {};
        BookFileReadWriteDemo bfrwd = new BookFileReadWriteDemo() {};
        Transaction tra = new Transaction() {};

        System.out.println("\t\t-------------------------------------------------------------------------------");
        System.out.println("\t\t-------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t---Successfully Logged In!!---");
        System.out.println("\t\t-------------------------------------------------------------------------------");
        System.out.println("\t\t-------------------------------------------------------------------------------");
        System.out.println("\t\t|\t\tWelCome to Group 6's Library Management System                |");
        System.out.println("\t\t|Program by : Avijit Saha Anto, Tarikul Islam Nishat, Mohammad Rafiul Haque   |");
        System.out.println("\t\t-------------------------------------------------------------------------------");
        System.out.println("\t\t-------------------------------------------------------------------------------");


        boolean repeat = true;
        while(repeat)
        {
            System.out.println("");
            System.out.println("\t\t\tWhat do you want to do?");
            System.out.println("\t\t\t1. Employee Management");
            System.out.println("\t\t\t2. Reader Management");
            System.out.println("\t\t\t3. Book Management");
            System.out.println("\t\t\t4. Check Balance");
            System.out.println("\t\t\t5. Transaction History");
            System.out.println("\t\t\t6. Log out");

            System.out.println();

            int choice = 0;

            boolean comitted = true;
            while(comitted)
            {
                try
                {
                    System.out.print("\t\tWhat is your choice: ");//***
                    choice = sc.nextInt();
                    comitted = false;
                }
                catch(InputMismatchException e)
                {
                    String str = sc.nextLine();
                    System.out.println();
                    System.out.println("\t\tThis is a invalid input!!! You entered \"" + str + "\" which is a string");

                    System.out.println("\t\tPleasae Enter a whole number. ");
                    System.out.println();
                }
            }

            switch(choice)
            {
            case 1:

                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tYou have chosen Employee Management");
                System.out.println("\t\t-------------------------------------------------------------------------------");

                System.out.println();
                System.out.println("\t\t\tYou have the following options:");
                System.out.println("\t\t\t1. Insert New Employee");
                System.out.println("\t\t\t2. Remove Existing Employee");
                System.out.println("\t\t\t3. Search an Employee");
                System.out.println("\t\t\t4. Show All Employees");
                System.out.println("\t\t\t5. Pay an Employee");
                System.out.println("\t\t\t6. Update employees salary");
                System.out.println("\t\t\t7. Go Back");

                System.out.println();
                System.out.print("\t\tEnter you option: ");
                int option1 = sc.nextInt();

                switch(option1)
                {
                case 1:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chosen to hire an employee ");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    System.out.println("\t\tPlease Enter the following fields without any spaces.Use '_' instead if needed. ");
                    String  skp = sc.nextLine();
                    System.out.print("\t\t\tEnter Employee NID: ");
                    String  enid0 = sc.nextLine();
                    System.out.print("\t\t\tEnter Employee Name: ");
                    String ename0 = sc.nextLine();
                    System.out.print("\t\t\tEnter Employee DOB: ");
                    String edob0 = sc.nextLine();
                    System.out.print("\t\t\tEnter Employee username: ");
                    String euname0 = sc.nextLine();
                    System.out.print("\t\t\tEnter Employee monthly salary: ");
                    String esalary = sc.nextLine();
                    boolean pass = false;
                    while (!pass)
                    {
                        System.out.print("\t\t\tEnter Employee Password: ");
                        String eupassword0 = sc.next();
                        System.out.print("\t\t\tRe-enter Employee Password: ");
                        String ereupassword0 = sc.next();

                        if(eupassword0.equals(ereupassword0))
                        {
                            // Writing employee+save location
                            ufrwd.writeInFile( "_" + enid0.replace(" ", ".") + " " + ename0.replace(" ", ".") + " " +  edob0.replace(" ", ".") + " " + euname0.replace(" ", ".") + " " + eupassword0.replace(" ", ".") + " * " + esalary + " *", "user");
                            System.out.println("\t\tEmployee " + enid0 + " has been Inserted");
                            pass = true;
                        }
                        else
                        {
                            System.out.print("\t\t\tPlease Re-enter Employee Password Correctly: ");
                        }
                    }
                    break;

                case 2:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Remove an Employee");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    System.out.print("\t\t\tEnter an Employee ID for Removing: ");
                    String empId2 = sc.next();
                    ufrwd.delete = 1;
                    ufrwd.verify("_" + empId2, "");
                    if(ufrwd.delete != 0)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tNo such Employee");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        ufrwd.delete = 0;
                    }
                    break;



                case 3:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Search an Employee");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    System.out.print("\t\tEnter an Employee ID for searching: ");
                    String empId3 = sc.next();
                    if(ufrwd.search("_" + empId3) != false)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tNo such Employee");
                        System.out.println("\t\t-------------------------------------------------------------------------------");

                    }



                    break;

                case 4:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Show All Employees");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    ufrwd.search("_");


                    break;
                case 5:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Pay an Employee");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.print("\t\tPlease Enter Employee ID Card Number: ");
                    String  eiD = sc. next();
                    System.out.print("\t\tPlease Enter Employee Credit Card Number: ");
                    String  ecred = sc. next();
                    //System.out.println("enter num");
                    //double  x = sc. nextInt();

                    ;
                    if( ufrwd.pay(ecred, "_" + eiD) != true)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tTransfer Successful!");
                        System.out.println("\t\t-------------------------------------------------------------------------------");

                    }
                    else
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tTransfer Failed!");
                        System.out.println("\t\t-------------------------------------------------------------------------------");

                    }
                    break;
                case 6:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to update Employee Salary");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.print("\t\tPlease Enter Employee ID Card Number: ");
                    String  eiD2 = sc. next();
                    ufrwd.rectify("_" + eiD2, ""); //no otp
                    break;

                case 7:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Go Back");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    break;

                default:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tInvalid Option");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    break;
                }
                System.out.println();
                break;

            case 2:
                boolean rerun0 = true;
                while(rerun0)
                {

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose Reader Management");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    System.out.println();
                    System.out.println("\t\tYou have the following options:");
                    System.out.println("\t\t\t1. Remove Existing Readers");
                    System.out.println("\t\t\t2. Search a Readers");
                    System.out.println("\t\t\t3. Show All Readers");
                    // b.readernum();
                    System.out.println("\t\t\t4. Go Back");

                    System.out.println();
                    boolean done3 = false;
                    int option2 = 0;
                    while(!done3)
                    {
                        try
                        {
                            System.out.print("\t\tEnter you option: ");
                            option2 = sc.nextInt();
                            done3 = true;
                        }
                        catch(InputMismatchException e)
                        {
                            String str = sc.nextLine();
                            System.out.println();
                            System.out.println("\t\tThis is a invalid input!!! You entered \"" + str);

                            System.out.println("\t\tPleasae Enter a whole number. ");
                            System.out.println();
                        }
                    }




                    switch(option2)
                    {

                    case 1: //Inside Reader Management

                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tYou have chose to Remove a Reader");
                        System.out.println("\t\t-------------------------------------------------------------------------------");

                        System.out.print("\t\t\tEnter an Reader NID for Removing: ");
                        String rdNId2 = sc.next();
                        ufrwd.delete = 1;
                        ufrwd.verify("**" + rdNId2, "[Slot Removed]");
                        if(ufrwd.delete != 0)
                        {
                            System.out.println("\t\t-------------------------------------------------------------------------------");
                            System.out.println("\t\tNo such Readers");
                            System.out.println("\t\t-------------------------------------------------------------------------------");
                            ufrwd.delete = 0;
                        }



                        break;

                    case 2: //Inside Reader Management

                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tYou have chose to Search a Reader");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.print("\t\tEnter the NID of the Reader: ");
                        String iD = sc.next();

                        if(ufrwd.search("**" + iD) != false)
                        {
                            System.out.println("\t\t-------------------------------------------------------------------------------");
                            System.out.println("\t\tNo such Readers");
                            System.out.println("\t\t-------------------------------------------------------------------------------");

                        }

                        System.out.println();
                        break;


                    case 3: //Inside Reader Management

                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tYou have chose to Show All Reader");
                        System.out.println("\t\t-------------------------------------------------------------------------------");

                        ufrwd.showAllReaders();

                        break;

                    case 4: //Inside Reader Management

                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tYou have chose to Go Back");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        rerun0 = false;
                        break;

                    default: //Inside Reader Management

                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tInvalid Option");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        break;
                    }  //Inside Reader Management
                    System.out.println();
                    break;//Inside Reader Management
                }//loop
                break;
            case 3:
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tYou have chosen Book Management ");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\t\t1. Insert New Book");
                System.out.println("\t\t\t2. Remove Book");
                System.out.println("\t\t\t3. Search Books");
                System.out.println("\t\t\t4. Show all Books");
                System.out.println("\t\t\t5: Go Back");
                System.out.println("");
                System.out.print("\t\tEnter you option: ");
                int option6 = sc.nextInt();

                switch(option6)
                {
                case 1:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Insert New Book");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    String blnk = sc.nextLine();
                    System.out.print("\t\t\tISBN : ");
                    String isbn = sc.nextLine();
                    System.out.print("\t\t\tBook Title : ");
                    String sbooktitle = sc.nextLine();
                    System.out.print("\t\t\tBook Author Name : ");
                    String sauthorName = sc.nextLine();
                    System.out.print("\t\t\tPrice : ");
                    String sprice = sc.nextLine();
                    System.out.print("\t\t\tAvailable Quantity : ");
                    String savailablequantity = sc.nextLine();
                    System.out.print("\t\t\tCategory : ");
                    String scategory = sc.nextLine();
                    bfrwd.writeInFile("* " + isbn.replace(" ", ".") + " * " + sbooktitle.replace(" ", ".") + " " +  sauthorName.replace(" ", ".") + " " + sprice + " ** " + savailablequantity + " ** " + scategory.replace(" ", ".") + " ");



                    if(bfrwd.markB != false)
                    {
                        System.out.println("\t\t---Story Book inserted---");
                        System.out.println();
                        bfrwd.markB = false;
                    }
                    else
                    {
                        System.out.println("\t\t---Story Book not inserted---");
                        System.out.println();
                    }

                    break;

                case 2:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Remove Books");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.print("\t\tEnter the Isbn of the book: ");
                    String sisbn = sc.next();
                    bfrwd.delete++;//initiating delete
                    bfrwd.search(sisbn);
                    if (bfrwd.markA != true)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tNo Such Books ");
                        System.out.println("\t\t-------------------------------------------------------------------------------");

                    }


                    break;

                case 3:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Search Book");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.print("\t\tEnter the ISBN of the book: ");
                    String rsisbn = sc.next();
                    bfrwd.search(rsisbn);
                    if(bfrwd.markC != false)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tPlease Re-stock! ");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        bfrwd.markC = false; //resetting
                    }
                    else if (bfrwd.markA != true)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tNo Such Books ");
                        System.out.println("\t\t-------------------------------------------------------------------------------");

                    }
                    break;

                case 4:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to show all Books");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    bfrwd.showAllBooks();

                    break;

                case 5:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to Go Back");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    break;

                default:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tInvalid Choice...");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    break;

                }
                break;
            case 4:
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tYou have chosen to Check Balance");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tAdmin       Balance");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                ufrwd.info("Bank", "*123*1");
                break;
            case 5:
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tYou have chosen to see Transaction History");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                bfrwd.showHistory();
                break;

            case 6:

                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tYou have chose to exit");
                System.out.println("\t\t-------------------------------------------------------------------------------");

                repeat = false;
                break;

            default:

                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tInvalid Choice...");
                System.out.println("\t\t-------------------------------------------------------------------------------");

                break;
            }
        }//rerun
    }//method
}