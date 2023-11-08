package com.bootcamp.ms.consultation.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {

    /**
     * Identificador único de un tipo de cuenta.
     */
    private String typeAccount;

    /**
     * Identificador único del nombre de la cuenta.
     */
    private String nameAccount;

    /**
     * Identificador único del número de cuenta.
     */
    private String numberAccount;
    /**
     * Identificador único del saldo de la cuenta.
     */
    private double balance;
}