package com.bootcamp.ms.consultation.controller;

import com.bootcamp.ms.consultation.model.dto.ClientProducts;
import com.bootcamp.ms.consultation.service.ConsultationsService;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bootcamp/ms/consultations")
@Slf4j
@Api(value = "Consultas Controller", description = "Operaciones de Consultas")
public class ConsultationsController {

    @Autowired
    ConsultationsService consultationsService;

    @GetMapping("/{numberDocument}")
    @ApiOperation(value = "Obtiene el cliente por su numero de docuemento", response = ClientProducts.class, responseContainer = "List")
    public Single<ResponseEntity<ClientProducts>> obtenerNumberDocument(@PathVariable String numberDocument) {

        return consultationsService.getProductosClients(numberDocument)
                .observeOn(Schedulers.io())
                .map(person -> ResponseEntity.ok(person))
                .doOnError(throwable -> log.error("do on Error,{}", throwable))
                .doOnSuccess(response -> log.info("do on Success,{}", response));
    }
}