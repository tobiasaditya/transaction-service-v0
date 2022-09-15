package com.obider.transactionservice.dto;

import com.obider.transactionservice.enums.TransactionType;
import com.obider.transactionservice.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
public class InputTransaction {
    @EnumValidator(
            enumClass = TransactionType.class,
            message = "must be type TransactionType [INCOME,PURCHASE,INVESTMENT]")
    private String trxType;
    @NotEmpty
    private String amount;
    @NotEmpty
    private String desc;
    @NotEmpty
    private String trxMethod;
}
