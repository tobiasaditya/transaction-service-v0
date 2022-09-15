package com.obider.transactionservice.dto;

import com.obider.transactionservice.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
public class InputTransaction {
    @NotEmpty
    private TransactionType trxType;
    @NotEmpty
    private String amount;
    @NotEmpty
    private String desc;
    @NotEmpty
    private String trxMethod;
}
