package com.netflix.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class CreateOrderResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long clientID;

}
