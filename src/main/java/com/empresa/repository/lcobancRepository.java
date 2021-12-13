package com.empresa.repository;

import com.empresa.entity.lcobanc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface lcobancRepository extends JpaRepository<lcobanc, String> {

    @Query(value = "{call SP_CrudLcoBanc(:opcion, :p_ciacont, :bl_codbco, :bl_nombco," +
            " :bl_tipmon, :bl_numcta, :bl_estado, :bl_cuenta, :bl_desccta, :bl_entfina," +
            " :bl_tipocta, :bl_flcaja, :bl_usrcrea, :bl_feccrea, :bl_hracrea, :bl_usract," +
            " :bl_fecact, :bl_hraact)}", nativeQuery = true)
    List<Object[]> listarBanc(@Param("opcion") int opcion,
                              @Param("p_ciacont") String p_ciacont,
                              @Param("bl_codbco") String bl_codbco,
                              @Param("bl_nombco") String bl_nombco,
                              @Param("bl_tipmon") String bl_tipmon,
                              @Param("bl_numcta") String bl_numcta,
                              @Param("bl_estado") String bl_estado,
                              @Param("bl_cuenta") String bl_cuenta,
                              @Param("bl_desccta") String bl_desccta,
                              @Param("bl_entfina") String bl_entfina,
                              @Param("bl_tipocta") String bl_tipocta,
                              @Param("bl_flcaja") String bl_flcaja,
                              @Param("bl_usrcrea") String bl_usrcrea,
                              @Param("bl_feccrea") LocalDate bl_feccrea,
                              @Param("bl_hracrea") LocalTime bl_hracrea,
                              @Param("bl_usract") String bl_usract,
                              @Param("bl_fecact") LocalDate bl_fecact,
                              @Param("bl_hraact") LocalTime bl_hraact);
}

