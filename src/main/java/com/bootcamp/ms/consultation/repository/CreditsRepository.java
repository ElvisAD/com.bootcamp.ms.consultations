package com.bootcamp.ms.consultation.repository;

import com.bootcamp.ms.consultation.model.entity.CreditsEntity;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.lang.NonNull;
import reactor.core.publisher.Mono;

/**
 * Repositorio para operaciones relacionadas con la entidad Creditos.
 */
public interface CreditsRepository extends ReactiveMongoRepository<CreditsEntity, String> {
  Flowable<CreditsEntity> findByNumberDocumentClient(String numberDocumentClient);
}