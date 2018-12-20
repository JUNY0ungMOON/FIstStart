import java.util.*;
public class Adress0001 {
	public static void main(String[]args)
	{
		Scanner bear=new Scanner(System.in);
		String home=null, office=null;
		int num;
		while(true) {
			System.out.println("1.HOME ADD");
			System.out.println("2.OFFICE ADD");
			System.out.println("3.LIST");
			System.out.println("4.END");
			num=bear.nextInt();
			switch(num) {
			case 1:System.out.print("HOME ADDRES:");
			home= bear.next(); System.out.println("confirm"); break;
			case 2:System.out.print("OFFICE ADDRES:");office=bear.next();
			System.out.println("confirm"); break;
			case 3:System.out.println("HOME:"+home);
			System.out.println("OFFICE:"+office);
			case 4:System.out.println("END");
			break;
			}
		}
	}
}
