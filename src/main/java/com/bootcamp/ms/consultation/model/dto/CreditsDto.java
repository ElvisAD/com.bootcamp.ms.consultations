package com.bootcamp.ms.consultation.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditsDto {

    /**
     * Identificador único que representa el número de crédito.
     */
    private String numberCredit;

    /**
     * Identificador único que representa el tipo de crédito.
     */
    private String typeCredit;

    /**
     * Identificador único que representa la descripción del crédito.
     */
    private String descriptionCredit;

    /**
     * Identificador único que representa el monto de un crédito.
     */
    private double amountCredit;
}