package com.art_shop.art_shop.repositories;

import com.art_shop.art_shop.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
