import java.util.Scanner;

class Calculator{
	public void modCalc(int su1,int su2) {
		System.out.println(su1+"%"+su2+"="+su1%su2);
	}
}

class MyCacl extends Calculator{
	public void modCalc(int su1,int su2)
	{
		int result=0;
		int mod=0;
		result= su1/su2;
		mod=su1% su2;
		System.out.println(result+"¹­À½");
		System.out.println(mod+"³ª¸ÓÁö °¹¼ö");
	}
}

public class Test05 {
	public static void main(String[]args) {
		Scanner input =new Scanner(System.in);
		MyCacl ca= new MyCacl();
		System.out.print("µ· ÀÔ·Â:"); int won01= input.nextInt();
		System.out.print("¹­À»µ· ÀÔ·Â:"); int won02= input.nextInt();
		ca.modCalc(won01,won02);
	}
}
