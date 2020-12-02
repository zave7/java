package annotation;

// interface 키워드 앞에 @을 붙인다

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // JVM 이 실행시에 감지할 수 있도록 설정
public @interface Count100 {
}
