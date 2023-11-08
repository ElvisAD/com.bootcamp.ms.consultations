package com.bootcamp.ms.consultation.repository;

import com.bootcamp.ms.consultation.model.entity.BankAccountEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.lang.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repositorio para operaciones relacionadas con la entidad BankAccount.
 */
public interface BankAccountRepository extends ReactiveMongoRepository<BankAccountEntity, String> {
  Flowable<BankAccountEntity> findByNumberDocumentClient(String numberDocumentClient);
}