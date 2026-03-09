package com.chaindrenciales.dashboardrh.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.chaindrenciales.dashboardrh.enums.AccionBitacoraEnum;

/**
 * Anotación personalizada para marcar los métodos que deben registrarse en la Bitácora.
 * Funciona en conjunto con BitacoraAspect.
 */
@Target(ElementType.METHOD) // Indica que esta anotación solo se puede usar sobre métodos.
@Retention(RetentionPolicy.RUNTIME)
public @interface RegistroBitacoraAnnotation {
    
    AccionBitacoraEnum accion();
    
    String descripcion() default "";
}