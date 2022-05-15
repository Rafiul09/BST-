package Classes;
import java.lang.*;
import java.util.*;
import fileio.*;
import Interfaces.*;



public class HomeMenu
{
    protected String adminusername = "a";
    protected  String adminpassword = "p";
    protected  String readerusername = "r";
    protected String readerpassword = "p";
    protected String nreaderusername;
    protected String nreaderpassword;
    protected String user;
    protected String password;

    public void homemenu () throws Exception
    {
        Scanner sc = new Scanner(System.in);
        boolean rerun = false;
        AdminMenu adm = new AdminMenu();
        UserMenu usm = new UserMenu();
        EmployeeMenu epm = new EmployeeMenu();
        UserLoginSignupFileReadWriteDemo ufrwd = new UserLoginSignupFileReadWriteDemo() {};
        BookFileReadWriteDemo bfrwd = new BookFileReadWriteDemo() {};
        Transaction tra = new Transaction() {};
        while(!rerun)
        {
            int opt0 = 0;
            boolean done = false;
            while(!done)
            {
                System.out.println("");
                System.out.println("\t\t\tWhat do you want to do? [Enter a number]");
                System.out.println("\t\t\t1. Search a Book");
                System.out.println("\t\t\t2. Log in");
                System.out.println("\t\t\t3. Sign up");
                System.out.println("\t\t\t4. Exit");

                System.out.println();

                try
                {
                    System.out.print("\t\tHome What is your choice: ");//***
                    opt0 = sc.nextInt();
                    done = true;
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
            switch(opt0)
            {
            case 1:

                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tYou chose to search a book");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\t\t1. Search Books");
                System.out.println("\t\t\t2. Show all Books");
                System.out.println("\t\t\t3: Go Back");
                System.out.println("");
                int choice1 = 0;
                boolean done1 = false;
                while(!done1)
                {
                    try
                    {
                        System.out.print("\t\tEnter you option: ");
                        choice1 = sc.nextInt();
                        done1 = true;
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



                switch(choice1)

                {
                case 1:

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chosen to Search Book");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    System.out.print("\t\tEnter the isbn of the book: ");
                    String rsisbn = sc.next();

                    bfrwd.search(rsisbn);

                    if(bfrwd.markA != false)
                    {
                        System.out.println("\t\t-------------------------------------------------------------------------------");
                        System.out.println("\t\tPlease Login/Sign up to buy the book  ");
                        System.out.println("\t\t-------------------------------------------------------------------------------");

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

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tYou have chose to show Books");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    bfrwd.showAllBooks();

                    System.out.println("\t\t-------------------------------------------------------------------------------");
                    System.out.println("\t\tPlease Login/Sign up to buy any book  ");
                    System.out.println("\t\t-------------------------------------------------------------------------------");

                    break;

                case 3:
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


            case 2:
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\t\t\t---To access the program please log in first---");
                System.out.println("\t\t\t\t---Sign in with your valid user Name & password---");
                System.out.print("\t\t\t\t\t      User Name : ");
                user = sc.next();
                System.out.print("\t\t\t\t\t      password : ");
                password = sc.next();

                if(user.equals(adminusername) && password.equals(adminpassword))// Goes to Admninmenu
                {
                    adm.menu();
                }


                else if(!adminusername.equals(user) &&  !adminpassword.equals(password))//Goes to usermenu //(user.equals(b.searchReaderUsername(user)) && password.equals(b.searchReaderUserPassword(password)))
                {
                    usm.menu(user, password);
                    epm.menu(user, password);
                }
                else
                {
                    System.out.println("\t\tUser Name or password is incorrect!!!");
                }
                break;
            case 3:
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tYou have chose to Sign up");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                String  blank = sc.nextLine();
                System.out.print("\t\t\tEnter Reader NID: ");
                String  nid0 = sc.nextLine();
                System.out.print("\t\t\tEnter Reader Name: ");
                String name0 = sc.nextLine();
                System.out.print("\t\t\tEnter Reader DOB: ");
                String age0 = sc.nextLine();
                System.out.print("\t\t\tEnter Reader username: ");
                String uname0 = sc.nextLine();
                System.out.print("\t\t\tEnter Reader Password: ");
                String upassword0 = sc.nextLine();
                System.out.print("\t\t\tRe-enter Reader Password: ");
                String reupassword0 = sc.nextLine();

                if(upassword0.equals(reupassword0))
                {

                    ufrwd.writeInFile("**" + nid0.replace(" ", ".") + " " + name0.replace(" ", ".") + " " +  age0.replace(" ", ".") + " " + uname0.replace(" ", ".") + " " + upassword0.replace(" ", ".") + " *", "user");
                    System.out.println("\t\tReader " + nid0 + " has been Inserted");
                }
                else
                {
                    System.out.println("\t\tPlease enter your password correctly");
                }
                break;

            case 4:
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.out.println("\t\tThank you for visiting!");
                System.out.println("\t\t-------------------------------------------------------------------------------");
                System.exit(0);




            } //method switch case
        } //rerun loop

    }//menu method
}