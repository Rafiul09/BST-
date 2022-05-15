package Interfaces;
import java.lang.*;
import Classes.*;
public interface ITransaction 
{
	
	
	public void writeInFile(String s, String loc);
	public  void withdraw (double amount, String accID);
	public  void deposit (double dAmount, String line3);



}