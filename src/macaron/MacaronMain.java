package macaron;

import java.util.Scanner;

public class MacaronMain {

   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      String name;
      int count = 0;   // 현재 판매한 총 마카롱 개수
      int totalSell = 100;   // 준비한 마카롱 개수
      
      String[] item = new String[100];
      
            
      // 객체 생성
      MacaronBox mc = new MacaronBox();
      
      while(totalSell > count) {
         // 이름 입력
         System.out.println("이름 입력 : ");
         name = sc.nextLine();
         System.out.print("몇 개의 마카롱을 구매하시겠습니까? : ");
         int num = sc.nextInt();      // 마카롱 주문 개수
         
         if(totalSell - count < num) {   // 마카롱개수가 남아있지 않을 때
            System.out.println("그만한 수량이 남아있지 않습니다.");
            continue;
         } 
      
         
         for(int i = 0; i < num; i++) {
            item[i] = sc.next();
         }
         sc.nextLine();
         
         
         // 주문 메소드 호출
         
         mc.order(name, num, item);
         
         // 초기화 메소드 호출
         mc.reset();
         
         // 주문 출력
         
         
         // 상자담기
         
      }
      
   }


}
