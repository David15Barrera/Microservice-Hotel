package com.service.hotelService.reservation.infrastructure.outputadapter.feign.customerFeign;

import com.service.hotelService.reservation.infrastructure.outputadapter.feign.dto.CustomerResponse;
import com.service.hotelService.reservation.infrastructure.outputadapter.feign.fallback.CustomerFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customerClient", url = "https://microservice-authemploye.onrender.com/api/auth-identity", fallbackFactory = CustomerFeignClientFallbackFactory.class)
public interface CustomerFeignClient {
    @GetMapping("/api/v1/customers/{id}")
    CustomerResponse getCustomerById(@PathVariable("id") String id);
}
