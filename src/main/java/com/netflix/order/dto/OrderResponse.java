package com.netflix.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.netflix.order.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 08/11/2019 22:14
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long clientID;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant insertDate;

    private OrderStatus orderStatus;

}
