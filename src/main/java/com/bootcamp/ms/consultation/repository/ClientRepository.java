package com.bootcamp.ms.consultation.repository;

import com.bootcamp.ms.consultation.model.entity.ClientEntity;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.lang.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repositorio para operaciones relacionadas con la entidad Client.
 */
public interface ClientRepository extends ReactiveMongoRepository<ClientEntity, String> {
  Mono<ClientEntity> findByNumberDocument(@NonNull String numberDocument);
}