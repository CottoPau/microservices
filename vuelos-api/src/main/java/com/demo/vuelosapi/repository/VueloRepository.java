package com.demo.vuelosapi.repository;
import com.demo.vuelosapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Flight,Long> {

}
