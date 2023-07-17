package practiceDay6_Homework;

import java.util.Scanner;

public class No1ForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Scanner inName = new Scanner(System.in);
		System.out.println("Số lượng nhân viên: ");
		int list = input.nextInt();
		String array[] = new String[list];
		for(int i=0;i<list;i++)
		{
			System.out.println("Nhân viên thứ "+i);
			array[i]=inName.nextLine();
		}
		System.out.println("Danh sách nhân viên:");
		for (String i : array)
		{
			System.out.println(i);
		}
		

	}

}
