package Classes;
import java.lang.*;
import java.util.*;
import fileio.*;
import Interfaces.*;



public class EmployeeMenu
{


    public void menu(String username, String password) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        AdminMenu adm = new AdminMenu();
        HomeMenu hm = new HomeMenu();
        UserLoginSignupFileReadWriteDemo ufrwd = new UserLoginSignupFileReadWriteDemo() {};
        BookFileReadWriteDemo bfrwd = new BookFileReadWriteDemo() {};
        Transaction tra = new Transaction() {};

        ufrwd.verify(username, password);//user verification

        if(ufrwd.counter < 0) //verified
        {


            System.out.println("\t\t-------------------------------------------------------------------------------");
            System.out.println("\t\t-------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t        ---Welcome " + username + " ---");
            System.out.println("");
            boolean edone = true;
            while(edone)
            {
                System.out.println("\t\t\tWhat do you want to do? [Enter a number]");
                System.out.println("\t\t\t1. Reader Management");
                System.out.println("\t\t\t2. Book Management");
                System.out.println("\t\t\t3. Check Balance");
                System.out.println("\t\t\t4. Change Password");
                System.out.println("\t\t\t5. Contact Us ");
                System.out.println("\t\t\t6. Log out");

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
                        ufrwd.delete++;
                        ufrwd.verify("**" + rdNId2, "");
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
                            //ufrwd.searchnotmatched = false;
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
                        //rerun0 = false;
                        break;

                    default: //Inside Reader Management

                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tInvalid Option");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        break;

                    }
                    //Inside Reader Management
                    System.out.println();
                    //break;//Inside Reader Management
                    //Reader loop


                    break;
                case 2:
                    boolean repeat1 = true;
                    while(repeat1)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tYou have chosen Book Management ");
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\t\t1. Insert New Book");
                        System.out.println("\t\t\t2. Remove Book");
                        System.out.println("\t\t\t3. Search Books");
                        System.out.println("\t\t\t4. Show all Books");
                        System.out.println("\t\t\t5: Go Back");
                        System.out.println("");
                        //System.out.print("\t\tEnter you option: ");
                        boolean comitted = true;
                        int option6 = 0;
                        while(comitted)
                        {
                            try
                            {
                                System.out.print("\t\tWhat is your choice: ");//***
                                option6 = sc.nextInt();
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
                            bfrwd.writeInFile("* " + isbn.replace(" ", ".") + " * " + sbooktitle.replace(" ", ".") + " " +  sauthorName.replace(" ", ".") + " " + sprice.replace(" ", ".") + " ** " + savailablequantity.replace(" ", ".") + " ** " + scategory.replace(" ", ".") + " ");
                            if(bfrwd.markB != false)
                            {
                                System.out.println("\t\t--- Book inserted---");
                                System.out.println();
                            }
                            else
                            {
                                System.out.println("\t\t--- Book not inserted---");
                                System.out.println();
                            }
                            break;



                        case 2:

                            System.out.println("\t\t-------------------------------------------------------------------------------");
                            System.out.println("\t\tYou have chose to Remove Books");
                            System.out.println("\t\t-------------------------------------------------------------------------------");
                            System.out.print("\t\tEnter the Isbn of the book: ");
                            String rsisbn = sc.next();
                            bfrwd.delete++;//initiating delete
                            bfrwd.search(rsisbn);
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
                            System.out.print("\t\tEnter the Isbn of the book: ");
                            String sisbn = sc.next();
                            bfrwd.search(sisbn);
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
                            repeat1 = false;
                            break;

                        default:

                            System.out.println("\t\t-------------------------------------------------------------------------------");
                            System.out.println("\t\tInvalid Choice...");
                            System.out.println("\t\t-------------------------------------------------------------------------------");

                            break;

                        }
                        break;
                    }
                    break;// Book management
                case 3:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chosen to Check Balance");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYour       Balance");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    ufrwd.info("Bank", "*11*1");
                    break;

                case 4:
                    ufrwd.initiateReactify();
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chosen to change your password");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    //System.out.print("\t\t Please enter your ID: " );
                    //String user1D = sc.next();

                    System.out.print("\t\t Please the OTP we have sent: " );
                    String oTp = sc.next();
                    ufrwd.rectify(username, oTp);
                    if (ufrwd.correct != false)
                    {
                        System.out.println("\t\t Password changed successfully!" );
                        ufrwd.correct = false;
                    }
                    else
                    {
                        System.out.println("\t\t Please try again" );
                    }

                    break;

                case 5:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tVisit us at");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    ufrwd.info("contact", "0");
                    break;



                case 6:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chosen to log out");
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    edone = false;
                    break;
                default:
                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tInvalid Choice...");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    break;





                }// menu loop
            }
        }// if verify
        else
        {
            System.out.println("\t\t\t\t\t---Not found---");
        }

    }// method
}
