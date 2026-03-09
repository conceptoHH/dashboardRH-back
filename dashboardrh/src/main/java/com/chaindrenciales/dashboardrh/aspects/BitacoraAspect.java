package com.chaindrenciales.dashboardrh.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chaindrenciales.dashboardrh.annotations.RegistroBitacoraAnnotation;
import com.chaindrenciales.dashboardrh.models.BitacoraRH;
import com.chaindrenciales.dashboardrh.models.Empresa;
import com.chaindrenciales.dashboardrh.models.Usuario;
import com.chaindrenciales.dashboardrh.repositories.BitacoraRepository;
import com.chaindrenciales.dashboardrh.enums.AccionBitacoraEnum;

import java.time.LocalDateTime;

/**
 * Aspecto encargado de interceptar las llamadas a métodos anotados con @RegistroBitacora
 * y guardar un registro en la base de datos de forma automática.
 */
@Aspect
@Component // Necesario para que Spring lo detecte e instancie
public class BitacoraAspect {

    private static final Logger logger = LoggerFactory.getLogger(BitacoraAspect.class);

    @Autowired
    private BitacoraRepository bitacoraRepository;

    /**
     * @AfterReturning significa que este código se ejecutará SOLO si el método original
     * termina exitosamente (sin lanzar excepciones).
     * @param joinPoint Contiene información sobre el método interceptado (nombre, argumentos).
     * @param registroBitacora La instancia de la anotación que pusimos en el método.
     * @param result El valor que retornó el método original (útil si queremos sacar el ID del objeto creado).
     */
    @AfterReturning(
            pointcut = "@annotation(registroBitacora)", 
            returning = "result"
    )
    public void registrarEnBitacora(JoinPoint joinPoint, RegistroBitacoraAnnotation registroBitacora, Object result) {
        try {
            // 1. Obtener la firma del método interceptado
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            String nombreMetodo = signature.getMethod().getName();
            String clase = signature.getDeclaringType().getSimpleName();

            // 2. Placeholder para el Usuario y Empresa(Relación requerida por el modelo BitacoraRH)
            Usuario usuarioContexto = new Usuario();
            usuarioContexto.setId(316L); // <-- liderRH de la empresa id 9
            
            Empresa empresaContexto = new Empresa();
            empresaContexto.setId(9L); // Mock hasta que se implemente auntenticacion

            // 3. Obtener la acción directamente como Enum (como lo pide tu modelo)
            AccionBitacoraEnum accionEnum = registroBitacora.accion();
            
            // 4. Construir la descripción
            String descripcionFinal = registroBitacora.descripcion();
            if (descripcionFinal.isEmpty()) {
                descripcionFinal = "Ejecución exitosa del método: " + clase + "." + nombreMetodo;
            }

            // 5. Crear la entidad BitacoraRH con los tipos correctos
            BitacoraRH registro = new BitacoraRH();
            registro.setAccion(accionEnum); // Se pasa el Enum directamente
            registro.setDescripcion(descripcionFinal);
            registro.setUsuario(usuarioContexto); // Se pasa la instancia de Usuario
            registro.setEmpresa(empresaContexto);
            
            // 6. Guardar en base de datos
            bitacoraRepository.save(registro);
            
            logger.info("Registro de bitácora guardado: [Acción: {}, Método: {}]", accionEnum.name(), nombreMetodo);

        } catch (Exception e) {
            // Un fallo en la bitácora NO debe tumbar el proceso principal
            logger.error("Error al intentar guardar en la bitácora. Método interceptado: {}", joinPoint.getSignature().getName(), e);
        }
    }
}