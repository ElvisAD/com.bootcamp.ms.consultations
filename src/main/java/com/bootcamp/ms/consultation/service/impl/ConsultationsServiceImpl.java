package com.bootcamp.ms.consultation.service.impl;

import com.bootcamp.ms.consultation.model.dto.BankAccountDto;
import com.bootcamp.ms.consultation.model.dto.ClientProducts;
import com.bootcamp.ms.consultation.model.dto.CreditsDto;
import com.bootcamp.ms.consultation.model.entity.BankAccountEntity;
import com.bootcamp.ms.consultation.model.entity.ClientEntity;
import com.bootcamp.ms.consultation.model.entity.CreditsEntity;
import com.bootcamp.ms.consultation.repository.BankAccountRepository;
import com.bootcamp.ms.consultation.repository.ClientRepository;
import com.bootcamp.ms.consultation.repository.CreditsRepository;
import com.bootcamp.ms.consultation.service.ConsultationsService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.adapter.rxjava.RxJava3Adapter;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class ConsultationsServiceImpl implements ConsultationsService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private CreditsRepository creditsRepository;

    @Override
    public Single<ClientProducts> getProductosClients(String numberDocument) {
        ClientProducts clientDto = new ClientProducts();
        List<BankAccountDto> listaCuentasBancarias = new ArrayList<>();
        List<CreditsDto> listaCreditos = new ArrayList<>();
        return RxJava3Adapter.monoToSingle(
                clientRepository.findByNumberDocument(numberDocument)
                        .flatMap(clientEntity -> {
                                clientDto.setNumeroDocumento(numberDocument);
                                clientDto.setNombres(clientEntity.getName());
                                clientDto.setApellidos(clientEntity.getLastName());
                            return RxJava3Adapter.singleToMono(bankAccountRepository.findByNumberDocumentClient(numberDocument).toList())
                                    .flatMap(bankAccountEntity -> {
                                        for (BankAccountEntity bank : bankAccountEntity){
                                            BankAccountDto cuentasBancarias = new BankAccountDto();
                                            cuentasBancarias.setTypeAccount(bank.getTypeAccount());
                                            cuentasBancarias.setNumberAccount(bank.getNumberAccount());
                                            cuentasBancarias.setNameAccount(bank.getNameAccount());
                                            cuentasBancarias.setBalance(bank.getBalance());
                                            listaCuentasBancarias.add(cuentasBancarias);
                                            clientDto.setCuentasBancarias(listaCuentasBancarias);
                                        }
                                        return RxJava3Adapter.singleToMono(creditsRepository.findByNumberDocumentClient(numberDocument).toList())
                                                .flatMap(creditsEntity -> {
                                                    for(CreditsEntity credit : creditsEntity){
                                                        CreditsDto creditos = new CreditsDto();
                                                        creditos.setTypeCredit(credit.getTypeCredit());
                                                        creditos.setDescriptionCredit(credit.getDescriptionCredit());
                                                        creditos.setNumberCredit(credit.getNumberCredit());
                                                        creditos.setAmountCredit(credit.getAmountCredit());
                                                        listaCreditos.add(creditos);
                                                        clientDto.setCreditosBancarios(listaCreditos);
                                                    }
                                                    return Mono.just(clientDto);
                                                });
                                    });
                        }));
    }
}