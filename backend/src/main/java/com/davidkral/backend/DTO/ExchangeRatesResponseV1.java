package com.davidkral.backend.DTO;

import com.davidkral.backend.domain.ExchangeRate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRatesResponseV1 {

    private String shortName;

    private String validFrom;

    private String name;

    private String country;

    private double move;

    private int amount;

    private double valBuy;

    private double valSell;

    private double valMid;

    private double currBuy;

    private double currSell;

    private double currMid;

    private int version;

    private double cnbMid;

    private double ecbMid;

    public ExchangeRate toEntity() {
        return new ExchangeRate(
                getShortName(),
                getValidFrom(),
                getName(),
                getCountry(),
                getMove(),
                getAmount(),
                getValBuy(),
                getValSell(),
                getValMid(),
                getCurrBuy(),
                getCurrSell(),
                getCurrMid(),
                getVersion(),
                getCnbMid(),
                getEcbMid()
        );
    }
}
