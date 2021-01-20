package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * 자바 8 에서 추가한 스트림(Stream)은 람다를 활용할 수 있는 기술중 하나이다.
 * 스트림은 '데이터의 흐름' 이다.
 * 람다를 이용해서 코드의 양을 줄이고 간결하게 표현할 수 있다.
 * 즉, 배열과 컬렉션을 함수형으로 처리할 수 있다.
 *
 * 또 하나의 장점은 간단하게 병렬처리(multi-threading)가 가능하다.
 *
 * 스트림의 대한 내용은 크게 세가지로 나눌 수 있다.
 * 1. 생성하기 : 스트림 인스턴스 생성
 * 2. 가공하기 : 필터링 및 맵핑 등 원하는 결과를 만들어가는 중간 작업
 * 3. 결과 만들기 : 최종적으로 결과를 만들어내는 작업
 */
public class StreamTest {

    public static void main(String[] args) {
        컬렉션();
    }

    private static void 배열() {

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr); // 배열을 스트림으로 변환
        Stream<String> streamOfArrayPart =
                Arrays.stream(arr, 1, 3); // 배열의 부분을 스트림으로 변환

        stream.forEach(System.out::println);
        streamOfArrayPart.forEach(System.out::println);
    }

    /*
     * Collection 의 구현체는 모두 Stream 으로 변환이 가능하다.
     */
    private static void 컬렉션() {

        //Array -> List
        List<String> list = Arrays.asList("1", "2", "3");

        // List -> Stream
        Stream<String> stream = list.stream();

        // List -> ParallelStream
        Stream<String> parallelStream = list.parallelStream();

        // Stream.builder && add
        Stream<String> builder = Stream.<String>builder().add("t1").add("t2").add("t3").build().parallel();

        stream.forEach(System.out::println);
        parallelStream.forEach(System.out::println);
        builder.forEach(System.out::println);
    }

    /*
     * Stream.generate() 를 이용하면 Supplier<T> 에 해당하는 람다로 값을 넣을 수 있다.
     * Supplier<T> 는 인자는 없고 리턴값만 있는 함수형 인터페이스이다.
     * 람다에서 리턴하는 값이 들어간다.
     */
    private static void 제너레이트() {

    }


}
