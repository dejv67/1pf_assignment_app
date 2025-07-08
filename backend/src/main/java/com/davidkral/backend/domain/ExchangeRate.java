package com.davidkral.backend.domain;

import com.davidkral.backend.DTO.ExchangeRatesResponseV1;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExchangeRate {

    @Id
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

    public ExchangeRatesResponseV1 toDto(){
        return new ExchangeRatesResponseV1(
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
