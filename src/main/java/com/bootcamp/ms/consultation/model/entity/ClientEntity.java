package com.bootcamp.ms.consultation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa a un cliente.
 */
@Data
@AllArgsConstructor
@Builder
@Document(collection = "client")
public class ClientEntity {

  /**
   * Identificador único de la persona.
   */
  @Id
  public String id;
  /**
   * Identificador tipo de cliente.
   */
  private String typeClient;
  /**
   * Identificador único del nombre del client.
   */
  private String name;
  /**
   * Identificador único de los apellidos del cliente.
   */
  private String lastName;
  /**
   * Identificador único del tipo de documento.
   */
  private String typeDocument;
  /**
   * Identificador único del número de documento.
   */
  private String numberDocument;
  /**
   * Identificador único del telefono del cliente.
   */
  private String phone;
  /**
   * Identificador único del correo del cliente.
   */
  private String email;
  /**
   * Identificador único del sexo del cliente.
   */
  private String sexo;

  /**
   * Identificador único del pefil del cliente.
   */
  private String perfil;
}