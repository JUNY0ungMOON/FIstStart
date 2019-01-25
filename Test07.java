import java.util.*;
class Member{
	private String stNum,stName,stJumsu;
	private int kor,eng,math;
	public String getStNum() {return stNum;	}
	public void setStNum(String stNum) {this.stNum = stNum;	}
	public String getStName() {	return stName;	}
	public void setStName(String stName) {this.stName = stName;	}
	public String getStJumsu() {return stJumsu;	}
	public void setStJumsu(String stJumsu) {this.stJumsu = stJumsu;}
	public int getKor() {return kor;}
	public void setKor(int kor) {this.kor = kor;}
	public int getEng() {return eng;}
	public void setEng(int eng) {this.eng = eng;}
	public int getMath() {return math;}
	public void setMath(int math) {	this.math = math;}
	
	public boolean chkStNum(ArrayList<Member> arr){
		for(Member m:arr){
			if(m.getStNum().equals(this.stNum)==true)
				return true;
		}
		return false;
	}
	public boolean searchSt(ArrayList<Member> arr,String stNum){
		for(Member m:arr){
			if(m.getStNum().equals(stNum)==true){
				setStNum(stNum);
				setStName(m.getStName());
				setKor(m.getKor());
				setEng(m.getEng());
				setMath(m.getMath());
				setStJumsu(m.getStJumsu());
				return true;
			}
		}
		return false;
	}
}
public class Test07 {
	public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
	    ArrayList<Member> arr = new ArrayList<Member>();
	    String stNum,stName,stJumsu;
		int kor,eng,math,avr;
	    int num;
	    boolean bl;
		while(true){
			System.out.println("1.학생 검색");
			System.out.println("2.등록");
			System.out.println("3.종료");
			System.out.print(">>> ");
			num = input.nextInt();
			Member mb = new Member();
			switch(num){
			case 1:
				System.out.print("찾을 학생 학번 입력 : ");
				stNum = input.next();
				bl=mb.searchSt(arr,stNum);
				if(bl == true){
					System.out.println("학번 : "+mb.getStNum());
					System.out.println("이름 : "+mb.getStName());
					System.out.println("국어 : "+mb.getKor());
					System.out.println("영어 : "+mb.getEng());
					System.out.println("수학 : "+mb.getMath());
					System.out.println("등급 : "+mb.getStJumsu());
				}else{
					System.out.println("찾는 학생이 없습니다!!!");
				}
				break;
			case 2:
				bl =true;
				while(bl){
					System.out.print("학번 입력 : ");
					stNum = input.next();
					mb.setStNum(stNum);
					bl = mb.chkStNum(arr);
					if(bl == true){
						System.out.println("존재하는 학번 입니다!!!");
						System.out.println("다시 입력 하세요");
					}
				}
				System.out.print("이름 입력 : ");
				stName = input.next();
				System.out.print("국어 점수 입력 : ");
				kor = input.nextInt();
				System.out.print("영어 점수 입력 : ");
				eng = input.nextInt();
				System.out.print("수학 점수 입력 : ");
				math = input.nextInt();
				mb.setStName(stName);mb.setKor(kor);
				mb.setEng(eng);	mb.setMath(math);
				avr = (kor+eng+math)/3;
				if(avr >= 90) mb.setStJumsu("A");
				else if(avr >= 80) mb.setStJumsu("B");
				else if(avr >= 70) mb.setStJumsu("C");
				else if(avr >= 60) mb.setStJumsu("D");
				else mb.setStJumsu("F");
				arr.add(mb);
				System.out.println("가입 되셨습니다!!!");
				break;
			case 3:return ;
			}
	    }
	}
}
