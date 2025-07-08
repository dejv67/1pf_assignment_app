package com.davidkral.backend.controller;

import com.davidkral.backend.domain.ExchangeRate;

import com.davidkral.backend.DTO.ExchangeRatesResponseV1;
import com.davidkral.backend.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ExchangeRateController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/rates")
    public ResponseEntity<?> getExchangeRates(@RequestParam(name = "usedb", defaultValue = "false") boolean useDb) {

        if (useDb) {
            var result = exchangeRateService.findAll();
            if (result.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No exchange rates found");
            }
            return ResponseEntity.ok(result.stream()
                    .map(ExchangeRate::toDto)
                    .collect(Collectors.toList()));
        }

        String url = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";
        ResponseEntity<List<ExchangeRatesResponseV1>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ExchangeRatesResponseV1>>() {}
        );

        List<ExchangeRate> entities = Objects.requireNonNull(response.getBody()).stream()
                .map(ExchangeRatesResponseV1::toEntity)
                .collect(Collectors.toList());

        var result = exchangeRateService.create(entities);
        return ResponseEntity.ok(result.stream()
                .map(ExchangeRate::toDto)
                .collect(Collectors.toList()));
    }
}
