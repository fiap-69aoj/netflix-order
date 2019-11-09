package com.netflix.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 08/11/2019 22:15
 */
@Builder
@Getter
@ToString
public class CreateOrderRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long clientID;

}