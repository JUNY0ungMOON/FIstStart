import java.util.*;

public class Test03 {
	public static void main(String[]args)
	{
		Scanner input=new Scanner(System.in);
		int []arr=new int[10];
		int []oddArr=new int[5];
		int []evenArr=new int[5];
		int []sumArr=new int[5];
		int odd=0,even=0;
		System.out.println("10개의 숫자 입력");
		for(int i=0;i<10;i++)
		{
			arr[i]=input.nextInt();
			if(i%2==0)evenArr[even++]=arr[i];
			else
			oddArr[odd++]=arr[i];
			
		}
		for(int i=0;i<5;i++)
		{
			sumArr[i]=oddArr[i]-evenArr[i];
			System.out.print(sumArr[i]+"");
		}
		System.out.print("\noddArr:");
		for(int i=0;i<5;i++)
			System.out.print(oddArr[i]+"");
		System.out.print("\nevenArr");
		for(int i=0;i<5;i++)
			System.out.print(evenArr[i]+"");
		}

}
