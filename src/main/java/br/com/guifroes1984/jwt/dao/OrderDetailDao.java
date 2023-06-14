package br.com.guifroes1984.jwt.dao;

import br.com.guifroes1984.jwt.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {
}
