/*
 * 10개 배열을 생성하여 배열의값을 0~9까지 순차적으로 초기화하고
 * 해당 배열값을 섞어보기
 */
package kr.co.job.array;

import java.util.Arrays;

public class ArrayTest04 {

	public static void main(String[] args) {
		// 
		int[] numArr = new int[100];
		int n=0, temp=0;

		// 한줄당 10개씩 출력
		int cnt=0, line=10;
		for(int i=0;i<numArr.length;i++) {
			numArr[i] = i; //배열을 0~99 숫자로 초기화
			System.out.print(numArr[i]+",");
			cnt++;
			if(cnt == line) {
				System.out.println();
				cnt = 0; // 다시 0으로 초기화
			}
		}
		
		for(int i=1;i<1000;i++) {// 1000회
			n = (int)(Math.random()*100);
			
			temp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = temp;
		}
		System.out.println(Arrays.toString(numArr));

	}

}





