package com.pd.jee.ejb.validator.annotations;

import java.lang.annotation.*;

import javax.interceptor.InterceptorBinding;

@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface ClassValidationInterceptorBinding {
    /**
     * Annotation Types Summary
     * 
     * Annotation Type : Description
     * 
     * Documented : Indicates that annotations with a type are to be documented
     * by javadoc and similar tools by default.
     * 
     * 
     * Inherited : Indicates that an annotation type is automatically inherited.
     * 
     * 
     * Retention : Indicates how long annotations with the annotated type are to
     * be retained.
     * 
     * 
     * Target : Indicates the kinds of program element to which an annotation
     * type is applicable.
     * 
     *
     * Enum ElementType : A program element type. The constants of this
     * enumerated type provide a simple classification of the declared elements
     * in a Java program.
     * 
     * ANNOTATION_TYPE Annotation type declaration
     * 
     * CONSTRUCTOR Constructor declaration
     * 
     * FIELD Field declaration (includes enum constants)
     * 
     * LOCAL_VARIABLE Local variable declaration
     * 
     * METHOD Method declaration
     * 
     * PACKAGE Package declaration
     * 
     * PARAMETER Parameter declaration
     * 
     * TYPE Class, interface (including annotation type), or enum declaration
     */

}