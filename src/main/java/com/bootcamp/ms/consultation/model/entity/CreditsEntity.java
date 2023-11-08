package com.bootcamp.ms.consultation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa un Credito de un cliente.
 */
@Data
@Document(collection = "credits")
public class CreditsEntity {

  /**
   * Identificador único que representa un crédito.
   */
  @Id
  public String id;

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
   * Identificador único que representa la fecha del crédito.
   */
  private String dateCredit;

  /**
   * Identificador único que representa el monto de un crédito.
   */
  private double amountCredit;

  /**
   * Identificador único que representa la fecha de pago de un crédito.
   */
  private String datePay;

  /**
   * Identificador único del número de documento del cliente.
   */
  private String numberDocumentClient;
}