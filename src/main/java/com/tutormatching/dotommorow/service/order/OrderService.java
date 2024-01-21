package com.tutormatching.dotommorow.service.order;

import com.tutormatching.dotommorow.dto.order.OrderDto;
import com.tutormatching.dotommorow.dto.order.OrderSaveDto;
import com.tutormatching.dotommorow.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(OrderSaveDto orderSaveDto) {
        orderRepository.save(orderSaveDto);
    }

    public List<OrderDto> findByStudentId(Integer studentId) {
        return orderRepository.findByStudentId(studentId);
    }

}
