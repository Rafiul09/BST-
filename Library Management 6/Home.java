import java.lang.*;
import java.util.*;
import Classes.*;

/*Project: Library management system Group 6
Avijit Saha Anto: 21-44630-1
Tarikul Islam Nishat: 21-44632-1
Mohammad Rafiul Haque: 21-44631-1
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
