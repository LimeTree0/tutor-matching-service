package com.tutormatching.dotommorow.repository.mapper.order;

import com.tutormatching.dotommorow.dto.order.OrderDto;
import com.tutormatching.dotommorow.dto.order.OrderSaveDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    public void save(OrderSaveDto orderSaveDto);

    public List<OrderDto> findByStudentId(Integer studentId);

}
