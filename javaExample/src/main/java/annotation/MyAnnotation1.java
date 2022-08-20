package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target(value = ElementType.TYPE)
public @interface MyAnnotation1 {
}
