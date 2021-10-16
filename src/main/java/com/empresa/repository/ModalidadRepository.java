package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {
	
	public List<Modalidad> findByNombre(String filtro);
	
	@Query("select m from Modalidad m where "
			+ "( :#{#fil.nombre} is '' or m.nombre like :#{#fil.nombre} )")
	public abstract List<Modalidad> listaPorFiltro(@Param("fil")FiltroModalidad filtro);

	
}
