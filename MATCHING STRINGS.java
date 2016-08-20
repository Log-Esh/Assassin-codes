/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	Scanner s=new Scanner(System.in);
	   
		String input1=s.nextLine().toLowerCase();    // getting input1  and converted to lowercase.
		String input2=s.nextLine();                  // getting input sstring2
		String[] str=input2.split("[:]");            // creating string array by splitting input2 using colon ":"
		for(int i=0;i<str.length;i++)
		{
		    String str1=str[i].toLowerCase();         
		    if((input1.length())==(str1.length()))     // checking both the strings have equal length.
		    {
		        int indexval=input1.indexOf('_');                 //  getting the index value of '_'
		        String substr1=input1.substring(0,indexval);      //  string till occurance of '_'
		        String substr2=input1.substring(indexval+1);      //  string after occurance of '_'
		        boolean res1=str1.startsWith(substr1);            // checking the input1 starts with substring1
		        boolean res2=str1.endsWith(substr2);              // checking the input1 ends with substring2
		        if(res1 && res2)                                  // if equals prints the input2 string
		        {
		            System.out.print(str1.toUpperCase()+" ");
		        }
		    }
		}
		
	}
}
