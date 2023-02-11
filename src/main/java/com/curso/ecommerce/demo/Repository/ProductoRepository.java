package com.curso.ecommerce.demo.Repository;

import com.curso.ecommerce.demo.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {



}
