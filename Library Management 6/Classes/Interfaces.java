package Classes;
import java.lang.*;
import java.util.*;
import java.io.*;
import fileio.*;
import Interfaces.*;

public abstract class Interfaces implements IfileOP,IUserLoginSignupFileReadWriteDemo,ITransaction,IBookFileReadWriteDemo,IMenu
{
  public void menu(String username, String password){}//anonymous classes
  public void info(String loc, String empId){}
  public boolean pay(String cred, String uid){return true;}
  public void verify (String line0, String line1){}
  public void initiateReactify(){}
  public void rectify (String name, String otp0){}
  public void showAllReaders(){}
  public void showAllBooks(){}
  public void purchase(String cred, String uname){}
  public void showHistory(){}
  public void modifyFile( String oldString, String newString, String refline){}
  public void writeInFile(String s, String loc){}
  public void search (String line0){}
  public void verify (String line0){}
  public void withdraw (double amount, String accID){}
  public void deposit (double dAmount, String line3){}
 

}