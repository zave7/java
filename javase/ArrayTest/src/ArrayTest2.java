
public class ArrayTest2 {
	public static void main(String[] args) {
		Car car[] = new Car[6]; //주자창을 만드는 거지 자동차를 만드는것이 아니다
		car[0] = new Car("소나타", "검정", "현대");
		car[1] = new Car("부가티", "검정", "부부");
		car[2] = new Car("k5", "검정", "kia");
		car[3] = new Car("sm55", "검정", "삼성");
		car[4] = new Car("니어로", "비둘기", "기아");
		car[5] = new Car("싼타페", "검정", "현대");
		System.out.println(car[0].getCarName());
		System.out.println("-----------------------");
//		for(Car c : car) {
//			System.out.println(c);
//		}
		String name = "니어로";
		name = "sm5"; //없습니다
		Car findCar = null;
		int area = 0;
		for(int i = 0; i<car.length; i++) {
			if(name.equals(car[i].getCarName())) {
				area = i+1;
				findCar = car[i];
				break;
			}

		}
		if (findCar == null) 
			System.out.println(name + "없습니다");
		else {
			System.out.println(findCar.getColor() + "색 " + findCar.getCarName() + "(" + 
					findCar.getMaker() + ") 는 " + area + "번째에 있습니다.");
		}
		// 비둘기색 니어로 ( 기아)는 5번째에 있습니다
	}
}
