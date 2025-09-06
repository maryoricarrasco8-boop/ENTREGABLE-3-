package com.bootcamp.transactions.repository;

import com.bootcamp.transactions.domain.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.Instant;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
  Flux<Transaction> findBySourceAccountIdOrTargetAccountIdAndDateBetween(
      String sourceId, String targetId, Instant from, Instant to);
}
