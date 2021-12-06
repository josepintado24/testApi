package com.empresa.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.empresa.entity.lco0001tgen;
import com.empresa.entity.lco0001tgenPk;

public interface lcgenRepository extends JpaRepository<lco0001tgen, lco0001tgenPk> {


	@Query(value="{call CrudLcoGen(:opcion, :tablename, :tl_codtabla, :tl_clave, :tl_descri,"
			+ " :tl_descri2, :tl_usrcrea, :tl_feccrea, :tl_hracrea, :tl_usract, :tl_fecact, :tl_hraact)}"
			, nativeQuery = true)
	List<lco0001tgen> listAll(@Param("opcion") int option,
							  @Param("tablename") String tablename,
							  @Param("tl_codtabla") String tl_codtabla,
							  @Param("tl_clave") String tl_clave,
							  @Param("tl_descri") String descri,
							  @Param("tl_descri2") String descri2,
							  @Param("tl_usrcrea") String tl_usrcrea,
							  @Param("tl_feccrea") LocalDate tl_feccrea,
							  @Param("tl_hracrea") LocalTime tl_hracrea,
							  @Param("tl_usract") String tl_usract,
							  @Param("tl_fecact") LocalDate tl_fecact,
							  @Param("tl_hraact") LocalTime tl_hraact);
	
	@Query(value="{call CrudLcoGen(:opcion, :tablename, :tl_codtabla, :tl_clave, :tl_descri,"
			+ " :tl_descri2, :tl_usrcrea, :tl_feccrea, :tl_hracrea, :tl_usract, :tl_fecact, :tl_hraact)}"
			, nativeQuery = true)
	void registrarRegistro(@Param("opcion") int option,
			  			   @Param("tablename") String tablename,
			               @Param("tl_codtabla") String tl_codtabla,
			               @Param("tl_clave") String tl_clave,
			               @Param("tl_descri") String descri,
			               @Param("tl_descri2") String descri2,
		             	   @Param("tl_usrcrea") String tl_usrcrea,
			               @Param("tl_feccrea") LocalDate tl_feccrea,
			               @Param("tl_hracrea") LocalTime tl_hracrea,
			               @Param("tl_usract") String tl_usract,
			               @Param("tl_fecact") LocalDate tl_fecact,
			               @Param("tl_hraact") LocalTime tl_hraact);
	
	@Query(value="{call CrudLcoGen(:opcion, :tablename, :tl_codtabla, :tl_clave, :tl_descri,"
			+ " :tl_descri2, :tl_usrcrea, :tl_feccrea, :tl_hracrea, :tl_usract, :tl_fecact, :tl_hraact)}"
			, nativeQuery = true)
	void actualizaRegistro(@Param("opcion") int option,
			               @Param("tablename") String tablename,
			               @Param("tl_codtabla") String tl_codtabla,
			               @Param("tl_clave") String tl_clave,
			               @Param("tl_descri") String descri,
			               @Param("tl_descri2") String descri2,
			               @Param("tl_usrcrea") String tl_usrcrea,
			               @Param("tl_feccrea") LocalDate tl_feccrea,
			               @Param("tl_hracrea") LocalTime tl_hracrea,
			               @Param("tl_usract") String tl_usract,
			               @Param("tl_fecact") LocalDate tl_fecact,
			               @Param("tl_hraact") LocalTime tl_hraact);
	
	@Query(value="{call CrudLcoGen(:opcion, :tablename, :tl_codtabla, :tl_clave, :tl_descri,"
			+ " :tl_descri2, :tl_usrcrea, :tl_feccrea, :tl_hracrea, :tl_usract, :tl_fecact, :tl_hraact)}"
			, nativeQuery = true)
	void eliminaRegistro(@Param("opcion") int option,
                         @Param("tablename") String tablename,
                         @Param("tl_codtabla") String tl_codtabla,
                         @Param("tl_clave") String tl_clave,
                         @Param("tl_descri") String descri,
                         @Param("tl_descri2") String descri2,
                         @Param("tl_usrcrea") String tl_usrcrea,
                         @Param("tl_feccrea") LocalDate tl_feccrea,
                         @Param("tl_hracrea") LocalTime tl_hracrea,
                         @Param("tl_usract") String tl_usract,
                         @Param("tl_fecact") LocalDate tl_fecact,
                         @Param("tl_hraact") LocalTime tl_hraact);
	
	
}


