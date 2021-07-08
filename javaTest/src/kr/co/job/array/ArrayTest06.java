/*
 * 문자에 맞는 바이너리코드값 찾기
	[index 구하기]
	0~9사이의 문자는
	      index = hex[i]-'0'
	그게 아니면 (A,B,C,D,E,F)
	      index = hex[i]-'A' + 10
	bianry[index] 구해짐.
 */
package kr.co.job.array;

public class ArrayTest06 {

	public static void main(String[] args) {
		char[] hex = {'C','A','F','E','8','5'}; // 16진수
		
		String[] binary = {     // 2진수
				"0000","0001","0010","0011"
			   ,"0100","0101","0110","0111"
			   ,"1000","1001","1010","1011"
			   ,"1100","1101","1110","1111"				
		};
		String result ="";
		int index = 0;
		
		for(int i=0;i<hex.length;i++) {
			if(hex[i]>='0' && hex[i]<'9') {
				index = hex[i] - '0';
			}
			else {
				index = hex[i] - 'A' + 10;
			}
			result = result + binary[index];
		}
		System.out.println("hex : " + new String(hex));
		System.out.println("binary : " + result);

	}

}
