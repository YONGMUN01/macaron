package macaron;

public class MacaronBox {

   // 필드
   String name;   // 이름 변수
   int count;   // 주문 개수 변수
   int totalPrice;   // 총 가격 변수

   String[] menu = { "초코맛", "딸기맛", "민트맛", "커피맛", "바닐라맛" };   // 메뉴명 배열
   int[] price = { 2000, 2000, 2500, 3000, 3000 };   // 메뉴별 가격 배열
   String[] item = new String[100];   // 주문받은 메뉴 저장 배열
   int[] printPrice = new int[100];   // 주문받은 메뉴 값 저장 배열

   // order메소드
   void order(String name, int count, String item[]) {   // 이름, 주문개수, 주문메뉴들 매개변수로 받기
      this.name = name;   // name필드에 이름 저장
      this.count = count;   // count필드에 주문개수 저장
      for (int i = 0; i < count; i++) {   // 주문한 개수만큼 item[]에 저장하기위해 반복
         for (int j = 0; j < 5; j++) {   // 5개의 메뉴 중 일치하는게 있는지 확인하기 위해 반복
            if (item[i].equals(this.menu[j])) {      // 일치하는게 있는지 확인 있다면?
               this.item[i] = item[i];      // item필드에 주문 저장
               this.printPrice[i] = price[j];   // printPrice필드에 가격 저장
               totalPrice += price[j];   // 총합 가격 저장
            }
         }
      }

   }

   // print 메소드
   void print() {   // 영수증 출력 메소드

      System.out.println("[" + this.name + "님의 주문 메뉴] \n -------------------");
      for (int i = 0; i < count; i++) {   // 주문개수만큼 주문메뉴와 가격 출력

         System.out.println(this.item[i] + " : " + printPrice[i] + "원");
      }
      System.out.println();
      System.out.println("-------------------\n총 금액은: " + totalPrice + "원\n-------------------");
               // 주문한 총 금액 출력
   }

   // addMacaron 메소드
   void addMacaron() {      // 박스 포장 메소드
      int num = 1;   // 박스 1개부터 시작
      for (int i = 0; i < count; i++) {   // 주문한 마카롱들 박스에 포장
         if (i % 4 == 0) {   // 앞에 몇번째 박스인지 표기
            System.out.print("박스" + num + " : ");
            num++;
         }
         System.out.print(" [" + this.item[i] + "] ");   // 무슨맛이 들었는지 표기
         if (i % 4 == 3) {   // 1박스에 4개씩 들어가도록 설정
            System.out.println("\n------------------------------------------");
         }

      }   
      System.out.println("\n");
      System.out.println(this.name + "님 주문한 메뉴가 준비완료되었습니다.\n");
   }

   // reset 메소드
   int reset(String reorder) {   // 주문이 맞는지, 초기화할지 선택하는 메소드

      // "주문이 맞는지, 초기화할지" yes or no 두가지만 선택) 입력받아서
      // if o 경우 주문메소드 호출
      // else x 경우주문을 끝내기 "주문이 완료되었습니다"

      int num = 0;   // num 초기값 설정

      if (reorder.equals("yes")) {   // 입력받은 값이 "yes"이면
         num = 0;   // 0저장
      } else if (reorder.equals("no")) {   // 입력받은 값이 "no"이면
         this.name = null;   // name 초기화
         for (int i = 0; i < count; i++) {   // 배열 초기화
            this.item[i] = null;
            this.count = 0;
         }
         num = 1;   // 1저장

      } 
      
      return num;      // num값 리턴
   }

}
