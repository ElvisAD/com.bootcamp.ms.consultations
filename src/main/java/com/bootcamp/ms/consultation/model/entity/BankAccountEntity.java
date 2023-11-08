package com.bootcamp.ms.consultation.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa a las cuentas bancarias.
 */
@Data
@Document(collection = "bankaccount")
public class BankAccountEntity {

  /**
   * Identificador único de una cuenta bancaria.
   */
  @Id
  public String id;

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
   * Identificador único de la fecha de cuenta.
   */
  private String dateOpening;

  /**
   * Identificador único del saldo de la cuenta.
   */
  private double balance;

  /**
   * Identificador único del número de documento del cliente.
   */
  private String numberDocumentClient;
}