package br.com.guifroes1984.jwt.dao;

import br.com.guifroes1984.jwt.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer > {
    public List<Product> findAll(Pageable pageable);
}
