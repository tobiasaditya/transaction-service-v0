package com.obider.transactionservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obider.transactionservice.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Transaction {
    @Id
    private String id;
    private TransactionType trxType;
    private String amount;
    private String desc;
    private String trxMethod;
    @JsonIgnore
    private String userId;
    private String trxId;
    private LocalDateTime requestTime;

    public Transaction(TransactionType trxType, String amount, String desc, String trxMethod, String userId, String trxId, LocalDateTime requestTime) {
        this.trxType = trxType;
        this.amount = amount;
        this.desc = desc;
        this.trxMethod = trxMethod;
        this.userId = userId;
        this.trxId = trxId;
        this.requestTime = requestTime;
    }
}
