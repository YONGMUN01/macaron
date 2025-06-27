package macaron;

import java.util.Scanner;

public class MacaronMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 스캐너 import

		String name; // 이름 저장 변수
		int count = 0; // 현재 판매한 총 마카롱 개수
		int totalSell = 10; // 준비한 마카롱 개수
		int totalPrice = 0;

		String[] item = new String[100]; // 주문받은 마카롱값들 저장할 공간

		// 객체 생성

		while (totalSell > count) { // 준비한 마카롱보다 판매한 마카롱 수가 더 적어야한다
			MacaronBox mc = new MacaronBox(); // MacaronBox 객체 생성
			// 이름 입력
			System.out.print("이름 입력 : "); // 이름 입력
			name = sc.nextLine(); // 이름 입력받기
			System.out.println("\t\t[메뉴]\t\t");
			System.out.println("[초코맛]  [딸기맛]  [민트맛]  [커피맛]  [바닐라맛]");
			System.out.println("   (금일 저희가 준비한 마카롱은 총 " + (totalSell - count) + "개입니다)");
			System.out.print("몇 개의 마카롱을 구매하시겠습니까? : "); // 몇개 구매할지 물어보기

			int num = sc.nextInt(); // 마카롱 주문 개수
			sc.nextLine();	// 위의 sc.nextInt()로 인해 버퍼에 저장되있는 엔터 삭제

			if (totalSell - count < num) { // 마카롱개수가 남아있지 않을 때
				System.out.println("그만한 수량이 남아있지 않습니다.");
				continue; // while 초기로 이동
			}

			for (int i = 0; i < num; i++) { // 입력받은 값 만큼 마카롱 종류 입력받기
				System.out.print("어떤 마카롱을 구매하겠습니까? : "); // 무슨 맛 구매할지 물어보기
				item[i] = sc.next(); // 문자열 값 입력받기
				switch (item[i]) {	// 각 조건에 맞으면 switch문 탈출
				case "초코맛":
					break;
				case "딸기맛":
					break;
				case "민트맛":
					break;
				case "커피맛":
					break;
				case "바닐라맛":
					break;
				default:	// 메뉴에 없는 입력값이 들어오면 다시 주문하도록 유도
					System.out.println("다시 입력해주세요.");
					i--;	
					break;
				}
			}
			sc.nextLine();	// 위의 sc.next()로 인해 버퍼에 저장되있는 엔터 삭제
			System.out.println();

			// 주문 메소드 호출
			mc.order(name, num, item);	// 이름, 주문개수, 주문 종류 인자로 사용

			// 주문 출력 호출
			mc.print();

			// 주문 초기화 호출
			System.out.print("주문 내용이 맞습니까?(yes or no 입력) : ");
			int result = mc.reset(sc.nextLine());	// 주문이 맞는지, 초기화하고 다시 주문할지 질문
			if (result == 0) {	// 리턴값이 0이면 주문완료
				System.out.println("주문을 완료했습니다.");
				count += num;	// 현재까지 판매한 마카롱 수에 방금 팔린 마카롱 개수 추가
			} if (result == 1) {	// 리턴값이 1이면 주문 초기화
				System.out.println("다시 주문하겠습니다.");
				continue;	// while문 초기로 이동
			} 

			System.out.println("주문한 마카롱 개수 : " + num);	// 주문한 마카롱 개수 출력
			System.out.println();

			// 상자담기
			int n = mc.addMacaron();	// 박스에 담아서 포장준비
			totalPrice += n;
			
			System.out.println("현재 남아있는 마카롱 개수 : " + (totalSell - count));	// 현재 남아있는 마카롱 개수
			System.out.println("------------------------------------------");

		}
		System.out.println("오늘 준비한 마카롱이 전부 소진되었습니다. \n다음에 다시 찾아주세요!");
		System.out.println("총 매출 : " + totalPrice);

		sc.close();
	}

}
