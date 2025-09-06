package com.bootcamp.transactions.api;

import com.bootcamp.transactions.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestController
@RequestMapping("/transacciones")
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionService service;

  @PostMapping("/deposito")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<TransactionResponse> deposit(@RequestBody DepositRequest r) {
    return service.deposit(r);
  }

  @PostMapping("/retiro")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<TransactionResponse> withdraw(@RequestBody WithdrawRequest r) {
    return service.withdraw(r);
  }

  @PostMapping("/transferencia")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<TransactionResponse> transfer(@RequestBody TransferRequest r) {
    return service.transfer(r);
  }

  @GetMapping("/historial")
  public Flux<TransactionResponse> history(
      @RequestParam String accountId,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to) {
    return service.history(accountId, from, to);
  }
}
