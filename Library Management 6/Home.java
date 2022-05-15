import java.lang.*;
import java.util.*;
import Classes.*;

/*Project: Library management system 
Features:
*Multi-user login
*Insert/Remove/Search Readers,Employee,Books
*Update Password,Employee Salary
*Withdraw,Deposit currency for Reader purchase & Employee Salary
-----------------------------------------------------------------
-----------------------------------------------------------------
This project is based on file handling
Admin username : a
Admin password : p


*/


public class Home
{
    Interfaces itf = new Interfaces() {};
    public static void main(String[] args) 
    {
        try
        {
            HomeMenu hm = new HomeMenu();
            hm.homemenu();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
