package com.bootcamp.ms.consultation.model.dto;

import com.bootcamp.ms.consultation.model.entity.BankAccountEntity;
import com.bootcamp.ms.consultation.model.entity.CreditsEntity;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientProducts {

    private String numeroDocumento;
    private  String nombres;
    private String apellidos;
    private List<BankAccountDto> cuentasBancarias;
    private List<CreditsDto> creditosBancarios;

}