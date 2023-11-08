package com.bootcamp.ms.consultation.service;

import com.bootcamp.ms.consultation.model.dto.ClientProducts;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface ConsultationsService {

    Single<ClientProducts> getProductosClients(String numberDocument);
}
