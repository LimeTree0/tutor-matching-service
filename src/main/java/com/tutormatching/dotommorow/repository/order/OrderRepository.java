package com.tutormatching.dotommorow.repository.order;

import com.tutormatching.dotommorow.dto.order.OrderDto;
import com.tutormatching.dotommorow.dto.order.OrderSaveDto;
import com.tutormatching.dotommorow.repository.mapper.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final OrderMapper orderMapper;

    public void save(OrderSaveDto orderSaveDto) {
        orderMapper.save(orderSaveDto);
    }

    public List<OrderDto> findByStudentId(Integer studentId) {
        return orderMapper.findByStudentId(studentId);
    }



}
