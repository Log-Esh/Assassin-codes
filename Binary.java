import java.util.*;

class Binary {
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
int input=s.nextInt();
int div=0;
int val=0;
int orgval=0;
for(int i=1;i<=input;i++)          // loop runs from 1 to input number
{
    orgval=i;
	for(int j=1;j<=i;j=j*2)        // loop to find the  most significant bit 
	{
		 val=j*2;
		if(val>i)
		   {
		      div=j;
		      break;
		   }
		}
		for(int k=div;k>=1;k=k/2)     // loop to determine  bits value of 0 or 1
		{
			
		    if(k<=orgval)
		    {
		       orgval=orgval-k;
		       System.out.print("1");
		    }
		    else if(k>orgval)
	    	{
		        System.out.print("0");
		    }
		
	   }
	   System.out.println();        //empty line to print consecutive inputs;
	
    }
}
}
