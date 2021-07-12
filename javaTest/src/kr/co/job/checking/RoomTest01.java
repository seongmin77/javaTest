/* 방 예약 : 12개 방
 * -----------[메뉴]----------
 * 1.방 예약 2. 예약취소 3.호실확인(전체) 99.종료
 * 
 * int[] room = {0,};
 * room[3]    => 0 으로 되어있으면예약가능(?)
 * room[3]    => 1 으로 되어있으면 예약불가능(?)
 * 
 * 초기화  => 반복구문  : 메뉴->선택실행 -> 종료
 */
package kr.co.job.checking;

import java.util.Scanner;

public class RoomTest01 {
   static Scanner scan = new Scanner(System.in); //전역
   
   public static void main(String[] args) {  //메인메소드
      int[] roomNumber = new int[12];
      int[] roomRemain = { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 };
//      int choose = 0;
      for (int i = 1; i < 13; i++) {
         roomNumber[i - 1] = i;
      }
      boolean hotel = true;
      while (hotel) {
         
         
         int room = hotelV();

         switch (room) {
         case 1:
            hotelV1(roomRemain);  // 예약메소드 실행
            
            break;

         case 2:
            hotelV2(roomRemain);  // 예약취소 실행
            
            break;

         case 3:
            hotelV3(roomNumber);// 호실확인 실행
            
            break;

         case 99:
            hotel = outExit(hotel);
            break;

         }

      }
   }

   private static boolean outExit(boolean hotel) {
      // TODO Auto-generated method stub
      System.out.println("종료하겠습니다.");
//      hotel=false;
      return !hotel;
   }

   private static void hotelV3(int roomNumber[]) {
      for(int i=1; i<13; i++) {
         roomNumber[i-1]=i;
         System.out.println(roomNumber[i-1]);
      }

      
   }

   private static void hotelV2(int roomRemain[]) {
      System.out.println("몇번 호실을 취소하시겠습니까?");
      int choose = scan.nextInt();
      if (roomRemain[choose - 1] == 1) {
         System.out.println("취소가 완료되었습니다.");
         System.out.println(choose + "호실 : " + (roomRemain[choose - 1] - 1+"/1"));
         roomRemain[choose-1]-=1;
      } else if (roomRemain[choose - 1] == 0) {
         System.out.println("예약한 호실이 아닙니다. 다시 선택해주세요.");
      }
      
   }

   private static void hotelV1(int roomRemain[]) {
      System.out.println("몇 호실을 예약하시겠습니까?");
      System.out.println("1호실 ~ 12호실의 번호를 입력해주세요.");

      int choose = scan.nextInt();

      if (roomRemain[choose - 1] == 1) {
         System.out.println("만실입니다. \n다른 호실을 예약해주세요.");

      } else if(roomRemain[choose-1]==0){
         System.out.println("예약이 가능합니다.\n예약하시겠습니까? 예/아니오로 입력해주세요.");
         String choose2 = scan.next();
         if(choose2.equals("예")) {
            System.out.println("예약이 완료되었습니다.");
            System.out.println("예약 수 : "+(roomRemain[choose-1]+1+"/1"));
            roomRemain[choose-1]+=1;
         }else if(choose2.equals("아니오")) {
            System.out.println("메인화면으로 돌아갑니다.");
         }else {
            System.out.println("번호를 다시 입력해주세요.");
         }
      }
      
   }

   private static int hotelV() {
      System.out.println("-------------[메뉴]-------------");
      System.out.println("1.방 예약 2.예약취소 3.호실확인 99.종료");
      
      return scan.nextInt();
   }

}