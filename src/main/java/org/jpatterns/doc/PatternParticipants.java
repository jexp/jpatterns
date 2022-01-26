package org.jpatterns.doc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Heinz Kabutz
 * @since 2010-08-09
 * @deprecated Please use the participants = {...} attribute in future
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.LOCAL_VARIABLE,
        ElementType.METHOD,
        ElementType.PARAMETER
})
@Documented
@Inherited
@Deprecated
public @interface PatternParticipants {
    Class[] value();
}
