package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CocheRepository extends JpaRepository<Coche,Long> {

    List<Coche> findByAñoGreaterThanEqual (Integer año);

    List<Coche> findByAñoLessThanEqual (Integer año);

    List<Coche> findByAñoBetween (Integer min, Integer max);

    List<Coche> findByAño(Integer año);

    List<Coche> findByPrecioGreaterThanEqual(Double precio);

    List<Coche> findByPrecioLessThanEqual(Double precio);

    List<Coche> findByPrecioBetween(Double min, Double max);

    Coche findByMatricula(String matricula);

    List<Coche> findByMarca(String marca);

    List<Coche> findByMarcaAndModelo(String marca, String modelo);

    List<Coche> findByMarcaAndPrecioLessThanEqual(String marca, Double precio);

    @Query("SELECT AVG (coche.precio) from Coche coche where coche.marca = :marca")
    Double obtenerMediaPorMarca(@Param("marca") String marca);

    List<Coche> findByPropietario(Persona propietario);

    @Query("SELECT (coche)from Coche coche where coche.propietario=:propietario ")
    List<Coche> obtenerCoches(@Param("propietario") Persona propietario); //Lo mismo que findByPropietario pero con un Query

    List<Coche> findByPropietarioAndPrecioGreaterThanEqual(Persona propietario, Double precio);

    @Query("SELECT (coche) from Coche coche where coche.propietario=:propietario" +
            " and coche.precio >= :precio")
    List<Coche> obtenerCocheCaro(@Param("propietario") Persona propietario,
                                 @Param("precio") Double precio); //Lo mismo que findByPropietarioAndPrecioGreaterThanEqual

    @Query("SELECT (coche) from Coche coche where coche.propietario=:propietario" +
            " and coche.año between :minAño and :maxAño")
    List<Coche> obtenerCocheEntreAños(
            @Param("propietario") Persona propietario,
            @Param("minAño") Integer minAño,
            @Param("maxAño") Integer maxAño);

    @Query("SELECT coche from Coche coche where propietario.age >= :age")
    List<Coche> obtenerCocheXEdad(@Param("age") Integer age);

    @Query("SELECT coche from Coche coche where propietario.age between :minAge and :maxAge")
    List<Coche> obtenerCocheXEdadEntre(@Param("minAge") Integer minAge,
                                       @Param("maxAge") Integer maxAge);

    @Query("SELECT coche from Coche coche where coche.matricula LIKE(CONCAT('%', :letras,'%'))")
    List<Coche> obtenerMatriculaByLetras(@Param("letras") String letras);

    @Query("SELECT (coche.marca), AVG(coche.precio), MIN (coche.precio), MAX (coche.precio) from Coche coche GROUP BY marca")
    List<Object[]> obtenerMidMinMax();

    @Query("SELECT coche.año, COUNT (coche) from Coche coche GROUP BY coche.año")
    List<Object[]> obtenerCochesXAño();


}
