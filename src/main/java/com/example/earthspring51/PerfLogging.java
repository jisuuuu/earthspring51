package com.example.earthspring51;

import java.lang.annotation.*;

/**
 * 이 애노테이션을 사용하면 성능을 로깅 한다.
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface PerfLogging {

}
