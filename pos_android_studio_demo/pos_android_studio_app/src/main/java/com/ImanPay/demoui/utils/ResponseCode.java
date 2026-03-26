package com.ImanPay.demoui.utils;

import java.util.HashMap;

public class ResponseCode {
    private static HashMap<String, CodeDetails> CodeTable = new HashMap<>();

    public static void setCodeResponses() {
        CodeTable.put("00", new CodeDetails("Venta", true));
        CodeTable.put("01", new CodeDetails("Pago rechazado por tu banco emisor. Llama a tu banco o intenta con otro medio de pago.", true));
        CodeTable.put("02", new CodeDetails("Pago rechazado por tu banco emisor. Llama a tu banco o intenta con otro medio de pago."));
        CodeTable.put("03", new CodeDetails("Error de configuración. Intenta nuevamente. Si el problema persiste contacta a soporte. "));
        CodeTable.put("04", new CodeDetails("Tarjeta bloqueada por el banco emisor. Usa otro medio de pago."));
        CodeTable.put("05", new CodeDetails("Pago rechazado por tu banco emisor. Llama a tu banco o intenta con otro medio de pago."));
        CodeTable.put("06", new CodeDetails("Error de comunicación. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("07", new CodeDetails("Tarjeta bloqueada por el banco emisor. Usa otro medio de pago."));
        CodeTable.put("09", new CodeDetails("Posible pago duplicado. Consulta historial para asegurarte."));
        CodeTable.put("10", new CodeDetails("El banco aprobó solo parte del monto. Completa tu pago con otro medio.", true));
        CodeTable.put("11", new CodeDetails("Aprobada.", true));
        CodeTable.put("12", new CodeDetails("Transacción rechazada por tu banco emisor."));
        CodeTable.put("13", new CodeDetails("Verifica el monto e intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("14", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("15", new CodeDetails("Tu banco emisor no pudo procesar la compra. Intenta nuevamente."));
        CodeTable.put("30", new CodeDetails("Error de conexión. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("31", new CodeDetails("Tarjeta bloqueada por el banco emisor. Usa otro medio de pago."));
        CodeTable.put("33", new CodeDetails("Tarjeta vencida. Usa otra tarjeta."));
        CodeTable.put("34", new CodeDetails("Pago rechazado por seguridad del banco emisor. Usa otro medio de pago."));
        CodeTable.put("35", new CodeDetails("Error de configuración. Contacta a soporte."));
        CodeTable.put("36", new CodeDetails("Pago rechazado por tu banco emisor. Llama a tu banco o intenta con otro medio de pago."));
        CodeTable.put("37", new CodeDetails("Rechazada.")); //*
        CodeTable.put("38", new CodeDetails("Bloqueo de NIP por exceso de intentos. Contacta a tu banco emisor."));
        CodeTable.put("39", new CodeDetails("Rechazada."));//*
        CodeTable.put("41", new CodeDetails("Tarjeta reportada como extraviada. Contacta a tu banco emisor."));
        CodeTable.put("43", new CodeDetails("Tarjeta bloqueada por seguridad. Contacta a tu banco emisor."));
        CodeTable.put("51", new CodeDetails("Fondos insuficientes."));
        CodeTable.put("54", new CodeDetails("Tarjeta vencida. Intenta con otro medio de pago."));
        CodeTable.put("55", new CodeDetails("NIP incorrecto. Intente nuevamente."));
        CodeTable.put("56", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("57", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("58", new CodeDetails("Error de configuración. Intenta nuevamente. Si el problema persiste contacta a soporte."));
        CodeTable.put("61", new CodeDetails("El monto de la tarjeta excede el límite permitido."));
        CodeTable.put("62", new CodeDetails("Tarjeta restringida por el banco emisor."));
        CodeTable.put("65", new CodeDetails("Límite de operaciones en la tarjeta alcanzado."));
        CodeTable.put("68", new CodeDetails("No se pudo completar el pago. Intenta nuevamente"));
        CodeTable.put("75", new CodeDetails("NIP de la tarjeta bloqueado por tu banco emisor."));
        CodeTable.put("76", new CodeDetails("Transacción rechazada. Intente con otra tarjeta."));//*
        CodeTable.put("77", new CodeDetails("Tarjeta no aceptada. Intenta con otro método de pago."));
        CodeTable.put("78", new CodeDetails("Banco emisor rechazo tu pago. Intenta con otro medio."));
        CodeTable.put("79", new CodeDetails("Transacción rechazada. Intenta nuevamente o intenta con otra tarjeta."));//*
        CodeTable.put("80", new CodeDetails("Transacción rechazada. Intenta nuevamente o intenta con otra tarjeta. "));//*
        CodeTable.put("81", new CodeDetails("Tarjeta no aceptada. Intenta con otro método de pago."));//*
        CodeTable.put("82", new CodeDetails("Transacción rechazada. Intenta con otra tarjeta."));//*
        CodeTable.put("83", new CodeDetails("Cuenta no disponible. Intenta nuevamente o usa otra tarjeta."));//*
        CodeTable.put("84", new CodeDetails("Tarjeta no aceptada. Intenta con otro método de pago."));//*
        CodeTable.put("85", new CodeDetails("Tarjeta no aceptada. Intenta con otro método de pago."));//*
        CodeTable.put("86", new CodeDetails("Tarjeta no aceptada. Intenta con otro método de pago."));//*
        CodeTable.put("87", new CodeDetails("Tarjeta no aceptada. Intenta con otro método de pago."));//*
        CodeTable.put("88", new CodeDetails("Transacción rechazada. Intenta con otra tarjeta."));//*
        CodeTable.put("89", new CodeDetails("No podemos procesar tu pago en este momento. Intenta con otra tarjeta."));//*
        CodeTable.put("90", new CodeDetails("Banco emisor rechazo tu pago. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("91", new CodeDetails("Banco emisor rechazo tu pago. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("92", new CodeDetails("No se pudo procesar el pago. Intenta nuevamente."));
        CodeTable.put("94", new CodeDetails("Posible pago duplicado. Consulta historial para asegurarte."));
        CodeTable.put("96", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("N0", new CodeDetails("Transacción no autorizada. Intenta con otra tarjeta."));//*
        CodeTable.put("N1", new CodeDetails("Transacción inválida o bloqueada. Intente nuevamente o con otro medio de pago."));
        CodeTable.put("N2", new CodeDetails("Pago rechazado por tu banco emisor. Llama a tu banco o intenta con otro medio de pago."));
        CodeTable.put("N3", new CodeDetails("Límite de devoluciones alcanzado"));
        CodeTable.put("N4", new CodeDetails("Límite de reembolso superado. Reduce el importe."));//*
        CodeTable.put("N5", new CodeDetails("Error en la transacción. Intenta con otro método de pago."));//*
        CodeTable.put("N6", new CodeDetails("Límite de devoluciones alcanzado"));
        CodeTable.put("N7", new CodeDetails("Transacción rechazada. Verifica NIP o usa otra tarjeta."));
        CodeTable.put("N8", new CodeDetails("El monto excede el límite en la tarjeta permitido. Contacta a tu banco emisor."));
        CodeTable.put("N9", new CodeDetails("Límite de devoluciones alcanzado"));
        CodeTable.put("O0", new CodeDetails("Problema con tu tarjeta. Contacta a tu banco."));//*
        CodeTable.put("O1", new CodeDetails("Importe menor al mínimo permitido. Intenta con más o cambia de tarjeta."));//*
        CodeTable.put("O2", new CodeDetails("El monto en el límite en la tarjeta es menor al permitido. Contacta a tu banco emisor."));
        CodeTable.put("O3", new CodeDetails("Superaste tu límite de crédito. Usa otra tarjeta."));//*
        CodeTable.put("O4", new CodeDetails("PIN requerido para esta compra. Ingresa tu NIP."));//*
        CodeTable.put("O5", new CodeDetails("NIP incorrecto. Intente nuevamente."));
        CodeTable.put("O6", new CodeDetails("Transacción inválida o bloqueada. Intente nuevamente o con otro medio de pago."));
        CodeTable.put("O7", new CodeDetails("PIN requerido para esta compra. Ingresa tu NIP."));//*
        CodeTable.put("O8", new CodeDetails("Tu tarjeta tiene un problema. Llama a tu banco."));//*
        CodeTable.put("O9", new CodeDetails("Problema técnico con tu tarjeta. Intenta con otra."));//*
        CodeTable.put("P0", new CodeDetails("Ya usaste tu límite diario. Intenta mañana o usa otra tarjeta."));//*
        CodeTable.put("P1", new CodeDetails("Límite diario alcanzado en tu tarjeta. Contacta a tu banco o intenta con otro medio de pago."));
        CodeTable.put("P2", new CodeDetails("Importe menor al mínimo. Incrementa el monto o usa otra tarjeta."));//*
        CodeTable.put("P3", new CodeDetails("El monto en el límite en la tarjeta es menor al permitido. Contacta a tu banco emisor."));
        CodeTable.put("P4", new CodeDetails("Cuenta con adeudo. Regulariza con tu banco."));//*
        CodeTable.put("P5", new CodeDetails("Límite excedido. Reduce el monto o usa otra tarjeta."));//*
        CodeTable.put("P6", new CodeDetails("Mínimo no alcanzado. Incrementa la cantidad."));//*
        CodeTable.put("P7", new CodeDetails("El monto en el límite en la tarjeta es menor al permitido. Contacta a tu banco emisor."));
        CodeTable.put("P8", new CodeDetails("Importe muy alto. Reduce o cambia de método de pago."));//*
        CodeTable.put("P9", new CodeDetails("Límite excedido. Reduce el monto o usa otra tarjeta."));//*
        CodeTable.put("Q0", new CodeDetails("Problema al completar. Cambia de tarjeta o intenta después."));//*
        CodeTable.put("Q1", new CodeDetails("Tarjeta vencida. Usa otra tarjeta."));
        CodeTable.put("Q2", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("Q3", new CodeDetails("El monto en el límite en la tarjeta es menor al permitido. Contacta a tu banco emisor."));
        CodeTable.put("Q4", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("Q5", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("Q6", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("Q7", new CodeDetails("El monto excede el límite en la tarjeta permitido. Contacta a tu banco o intenta con otro medio de pago."));
        CodeTable.put("Q8", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("Q9", new CodeDetails("Terminal bloqueada temporalmente. Avisa al establecimiento."));//*
        CodeTable.put("R0", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("R1", new CodeDetails("Sistema detenido. Avisa al cajero de inmediato."));//*
        CodeTable.put("R2", new CodeDetails("Conexión perdida. Vuelve a intentar tu pago."));//*
        CodeTable.put("R3", new CodeDetails("Error de red. Reinicia la operación."));//*
        CodeTable.put("R4", new CodeDetails("Problema al completar. Cambia de tarjeta o intenta después."));//*
        CodeTable.put("R5", new CodeDetails("Problema al completar. Cambia de tarjeta o intenta después."));//*
        CodeTable.put("R6", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("R7", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("R8", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("S4", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("S5", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("S6", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("S7", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("S8", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("S9", new CodeDetails("NIP incorrecto. Intente nuevamente."));
        CodeTable.put("T1", new CodeDetails("Verifica el monto e intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("T2", new CodeDetails("Error técnico. Reinicie la terminal e intente de nuevo."));//*
        CodeTable.put("T3", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("T4", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("T5", new CodeDetails("Tarjeta denegada. Intenta con otro método de pago."));//*
        CodeTable.put("T6", new CodeDetails("No pudimos procesar tu pago. Intenta de nuevo o prueba con otra tarjeta."));//*
        CodeTable.put("T7", new CodeDetails("No pudimos procesar tu pago. Intenta con otra tarjeta."));//*
        CodeTable.put("T8", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("U0", new CodeDetails("Banco emisor rechazo tu pago. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("U1", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("U2", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("U3", new CodeDetails("KEY1 no encontrada"));//*
        CodeTable.put("U4", new CodeDetails("Banco emisor rechazo tu pago. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("U5", new CodeDetails("Banco emisor rechazo tu pago. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("U6", new CodeDetails("Banco emisor rechazo tu pago. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("U7", new CodeDetails("Rechazo del codigo"));//*
        CodeTable.put("U8", new CodeDetails("Banco emisor rechazo tu pago. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("V0", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("V1", new CodeDetails("Error en CVR"));//*
        CodeTable.put("V2", new CodeDetails("Error en TVR"));//*
        CodeTable.put("V3", new CodeDetails("Rechazo del codigo"));//*
        CodeTable.put("V4", new CodeDetails("Error en Fallback"));//*
        CodeTable.put("V7", new CodeDetails("Error en generar ARQC"));//*
        CodeTable.put("V8", new CodeDetails("Error en generar CVR"));//*
        CodeTable.put("V9", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("70", new CodeDetails("Error de lectura. Inserte la tarjeta o intente con otro medio de pago."));
        CodeTable.put("72", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("73", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("1A", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));

        CodeTable.put("000", new CodeDetails("Venta", true));
        CodeTable.put("001", new CodeDetails("Aprobar con ID", true));
        CodeTable.put("002", new CodeDetails("El banco aprobó solo parte del monto. Completa tu pago con otro medio."));
        CodeTable.put("100", new CodeDetails("Banco emisor rechazo tu pago. Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("101", new CodeDetails("Tarjeta vencida. Usa otra tarjeta."));
        CodeTable.put("106", new CodeDetails("NIP de la tarjeta bloqueado por tu banco emisor."));
        CodeTable.put("109", new CodeDetails("Intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("110", new CodeDetails("Verifica el monto e intenta nuevamente o usa otro medio de pago."));
        CodeTable.put("111", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("115", new CodeDetails("Esta tarjeta no es aceptada, usa otro medio.", true));
        CodeTable.put("116", new CodeDetails("Fondos insuficientes.", true));
        CodeTable.put("117", new CodeDetails("NIP incorrecto. Intente nuevamente."));
        CodeTable.put("119", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("121", new CodeDetails("El monto de la tarjeta excede el límite permitido."));
        CodeTable.put("122", new CodeDetails("NIP incorrecto. Intente nuevamente."));
        CodeTable.put("125", new CodeDetails("Tarjeta vencida. Intenta con otro medio de pago."));
        CodeTable.put("130", new CodeDetails("Pago rechazado por tu banco emisor. Llama a tu banco o intenta con otro medio de pago."));
        CodeTable.put("181", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("183", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("187", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("189", new CodeDetails("Error de configuración. Intenta nuevamente. Si el problema persiste contacta a soporte."));
        CodeTable.put("190", new CodeDetails("No se pudo validar la información del pago del Banco Emisor"));
        CodeTable.put("193", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("200", new CodeDetails("Tarjeta inválida o bloqueada. Intente con otro medio de pago."));
        CodeTable.put("900", new CodeDetails("No se pudo completar el pago. Intenta nuevamente."));
        CodeTable.put("909", new CodeDetails("Error de conexión. Intenta nuevamente. Si el problema persiste contacta a soporte."));
        CodeTable.put("912", new CodeDetails("Tu banco emisor no pudo procesar la compra. Intenta nuevamente."));
        CodeTable.put("977", new CodeDetails("Tu banco emisor no pudo procesar la compra. Usa otro medio de pago."));
        CodeTable.put("978", new CodeDetails("Límite diario alcanzado en tu tarjeta. Contacta a tu banco o intenta con otro medio de pago."));
        CodeTable.put("400", new CodeDetails("El pago no se completó. No se realizó el cargo. Intente nuevamente."));
    }

    public static HashMap<String, CodeDetails> getCodeResponses() { return CodeTable; }

    public static CodeDetails getCodeDetails(String key) {
        CodeDetails details = CodeTable.get(key);
        return details != null ? details : new CodeDetails("Error desconocido");
    }

    public static class CodeDetails {
        public String description;
        public boolean isSuccessCode;

        public CodeDetails(String _description,boolean... _isSuccessCode) {
            this.description = _description;
            this.isSuccessCode = _isSuccessCode.length > 0 ? _isSuccessCode[0] : false;
        }

    }

}
