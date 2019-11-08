package com.netflix.order.repository;

import com.netflix.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 08/11/2019 19:27
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}