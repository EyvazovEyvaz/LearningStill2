package testannopacklevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PACKAGE)
public @interface Myannotation {

    String name() default "Eyvazbdjfrhbid";
}
