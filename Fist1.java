import java.util.*;
public class Fist1 { //multiples of 5
	public static void main(String[]args)
	{
		Scanner input=new Scanner(System.in);
		int num;
		System.out.print("enter number: ");
		num=input.nextInt();
		if(num%5==0)
		{
			System.out.println(num+":multiple of 5.");
			
		}
		else 
		{
			System.out.println(num+":not multiple of 5.");
		}
	}
}
