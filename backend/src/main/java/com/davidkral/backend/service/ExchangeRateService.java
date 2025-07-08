package com.davidkral.backend.service;

import com.davidkral.backend.domain.ExchangeRate;
import com.davidkral.backend.repository.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Transactional(readOnly = true)
    public List<ExchangeRate> findAll() {
        var iterable = exchangeRateRepository.findAll();

        List<ExchangeRate> result = new ArrayList<ExchangeRate>(iterable);
        return result;
    }

    @Transactional
    public List<ExchangeRate> create(List<ExchangeRate> rates) {
        return exchangeRateRepository.saveAll(rates);
    }
}
