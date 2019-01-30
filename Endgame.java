import java.util.*;
import java.io.*;


class Member implements Serializable{ //추가할것
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
//============== 추가 내용 ================
class FileInOut {
	File dir;
	File f3;
	public FileInOut(String path){
		dir = new File(path);
	}
	public void fileOut(Member outMember) throws IOException{	
	    f3 = new File(dir, outMember.getStNum()+".txt");
	    FileOutputStream fos = new FileOutputStream(f3);
	    BufferedOutputStream bos = new BufferedOutputStream(fos);
	    ObjectOutputStream oos = new ObjectOutputStream(bos);
	    oos.writeObject((Object)outMember);
	    oos.close();
	}
	public Member fileRead(String stNum) throws IOException, ClassNotFoundException{
		Member mb=null;
		f3 = new File(dir, stNum+".txt");
		try{
		FileInputStream fis = new FileInputStream(f3);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		mb = (Member)ois.readObject();
		ois.close();
		}catch(FileNotFoundException e){
			return null;
		}
		return mb;
	}
	public boolean chkFile(String stNum) throws IOException{
	    File f3 = new File(dir, stNum+".txt");
	    if(f3.createNewFile()){  return false;} // 현재 파일이 존재하면 true
	    return true;
	}
}
public class Endgame {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
	    Scanner input = new Scanner(System.in);
	    System.out.print("경로 입력 : ");
	    String path = input.next();
	    FileInOut outMember = new FileInOut(path); // 추가내용
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
				mb = outMember.fileRead(stNum); // 추가내용
				if(bl == true || mb != null){ //추가 내용
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
					bl = outMember.chkFile(stNum); // 추가내용
					if(bl == true ){
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
				outMember.fileOut(mb); //추가 내용
				System.out.println("가입 되셨습니다!!!");
				break;
			case 3:return ;
			}
	    }
	}
}
