package com.endeavour.customAnnotate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface TrackTime
{
    long warnAfter() default 2000;
    String operation() default "";
}
