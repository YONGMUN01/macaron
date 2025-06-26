package macaron;

public class MacaronBox {

	// 필드
	String name;
	int count;
	int totlaPrice;

	String[] menu = { "값1", "값2", "값3", "값4", "값5" };
	int[] price = { 1, 10, 100, 1000, 10000 };
	String[] item = new String[100];

	// order메소드
	void order(String name, int count, String item[]) {
		this.name = name;
		this.count = count;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 5; j++) {
				if (item[i].equals(this.menu[j])) {
					this.item[i] = item[i];
					totlaPrice += price[i];
					System.out.println(this.item[i]);
				}
			}
		}
		System.out.println(totlaPrice);

	}

	// print 메소드
	void print() {
	}

	// addMacaron 메소드
	void addMacaron() {

	}

	// reset 메소드
	void reset(String reorder) {

		// "추가 주문 하시겠습니까?" yes or no 두가지만 선택) 입력받아서
		// if o 경우 주문메소드 호출
		// else x 경우주문을 끝내기 "주문이 완료되었습니다"

		System.out.println("추가 주문 하시겠습니까?(yes or no 입력) : ");

		if (reorder == "yes") {
			System.out.println(order());
		} else {
			System.out.println("주문이 완료되었습니다");
		}
	}

}
