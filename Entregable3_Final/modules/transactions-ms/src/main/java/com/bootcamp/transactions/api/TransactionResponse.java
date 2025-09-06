package com.bootcamp.transactions.api;
import lombok.Builder; import lombok.Data;
import java.math.BigDecimal; import java.time.Instant;
@Data @Builder public class TransactionResponse {
  private String id; private String type; private BigDecimal amount; private String currency;
  private Instant date; private String sourceAccountId; private String targetAccountId;
  private String status; private String reason;
}