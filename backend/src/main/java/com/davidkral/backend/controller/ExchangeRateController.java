package com.davidkral.backend.controller;

import com.davidkral.backend.DTO.ExchangeRatesResponseV1;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExchangeRateController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/rates")
    public ResponseEntity<List<ExchangeRatesResponseV1>> getExchangeRates(@RequestParam(name = "usedb", defaultValue = "false") boolean useDb) {

        if (useDb) {
            // TODO: Vrátit data z DB
//            var result = exchangeRateService.findAll();
//            return ResponseEntity.ok(result
//                    .stream()
//                    .map(ExchangeRate::toDto)
//                    .collect(Collectors.toList()));
        }

        String url = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";
        ResponseEntity<List<ExchangeRatesResponseV1>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ExchangeRatesResponseV1>>() {}
        );

        return ResponseEntity.ok(response.getBody());
    }
}
