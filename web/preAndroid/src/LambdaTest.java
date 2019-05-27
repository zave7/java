import com.kitri.dto.Test;

public class LambdaTest {
	public static void test(Test t) {
		t.m(10);
	}
	public static void main(String[] args) {
//		TestImpl impl = new TestImpl();
//		test(impl);
//		i -> System.out.println(i);
		test(ㄱ -> System.out.println(ㄱ)); //이벤트 프로그램은 재사용성이 높지 않아서 새로운 클래스를 생성하기보다 코딩량을 줄이기 위해 람다 표현식을 쓴다
											//1개의 메소드만 가능 
	}
}
