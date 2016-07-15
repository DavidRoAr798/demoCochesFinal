package com.example;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public void testCoches() {
        Coche seatLeon = new Coche();
        seatLeon.setMarca("Seat");
        seatLeon.setModelo("León");
        seatLeon.setMatricula("2324BXJ");
        seatLeon.setAño(1999);
        seatLeon.setPrecio(2500.0);

        Persona persona = new Persona();
        persona.setNombre("Pedro");
        persona.setApellido("");
        persona.setAge(23);
        personaRepository.save(persona);

        seatLeon.setPropietario(persona);

        cocheRepository.save(seatLeon);

        Coche seatIbiza = new Coche();
        seatIbiza.setMarca("Seat");
        seatIbiza.setModelo("Ibiza");
        seatIbiza.setMatricula("1578LGH");
        seatIbiza.setAño(2015);
        seatIbiza.setPrecio(9500.0);


        Persona ivan = personaRepository.findOne(1L);
        seatIbiza.setPropietario(ivan);
        cocheRepository.save(seatIbiza);


        Coche opelCorsa = new Coche();
        opelCorsa.setMarca("Opel");
        opelCorsa.setModelo("Corsa");
        opelCorsa.setMatricula("7531HGF");
        opelCorsa.setAño(2012);
        opelCorsa.setPrecio(7700.0);
        cocheRepository.save(opelCorsa);

        Persona noelia = personaRepository.findOne(6L);
        opelCorsa.setPropietario(noelia);
        cocheRepository.save(opelCorsa);

        Coche porschePanamera = new Coche();
        porschePanamera.setMarca("Porsche");
        porschePanamera.setModelo("Panamera");
        porschePanamera.setMatricula("7531HGF");
        porschePanamera.setAño(2011);
        porschePanamera.setPrecio(69700.0);
        cocheRepository.save(porschePanamera);

        Persona dimple = personaRepository.findOne(2L);
        porschePanamera.setPropietario(dimple);
        cocheRepository.save(porschePanamera);

        Coche porscheCarrera911 = new Coche();
        porscheCarrera911.setMarca("Porsche");
        porscheCarrera911.setModelo("Carrera911");
        porscheCarrera911.setMatricula("9899BVS");
        porscheCarrera911.setAño(1995);
        porscheCarrera911.setPrecio(55000.0);
        cocheRepository.save(porscheCarrera911);

        Persona ricard = personaRepository.findOne(5L);
        porscheCarrera911.setPropietario(ricard);
        cocheRepository.save(porscheCarrera911);

        Coche opelCorsa2 = new Coche();
        opelCorsa2.setMarca("Opel");
        opelCorsa2.setModelo("Corsa");
        opelCorsa2.setMatricula("6955JFK");
        opelCorsa2.setAño(2012);
        opelCorsa2.setPrecio(8500.0);
        cocheRepository.save(opelCorsa2);

        Persona jordi = personaRepository.findOne(4L);
        opelCorsa2.setPropietario(jordi);
        cocheRepository.save(opelCorsa2);

        Coche bmwX5 = new Coche();
        bmwX5.setMarca("BMW");
        bmwX5.setModelo("X5");
        bmwX5.setMatricula("7569HDP");
        bmwX5.setAño(2012);
        bmwX5.setPrecio(61500.0);
        cocheRepository.save(bmwX5);

        bmwX5.setPropietario(dimple);
        cocheRepository.save(bmwX5);


        System.out.println("Los coches más nuevos de 2007");
        System.out.println(cocheRepository.findByAñoGreaterThanEqual(2007) + System.lineSeparator());

        System.out.println("Los coches más antiguos de 2007");
        System.out.println(cocheRepository.findByAñoLessThanEqual(2007) + System.lineSeparator());

        System.out.println("Los coches comprendidos entre los años 2005 y 2016 son: ");
        System.out.println(cocheRepository.findByAñoBetween(2005, 2016) + System.lineSeparator());

        System.out.println("Los coches con un precio superior a 10.000 son: ");
        System.out.println(cocheRepository.findByPrecioGreaterThanEqual(10000.0) + System.lineSeparator());

        System.out.println("Los coches con un precio inferior a 10.000 son: ");
        System.out.println(cocheRepository.findByPrecioLessThanEqual(10000.0) + System.lineSeparator());

        System.out.println("Los coches comprendidos entre 8.000 y 66.000 son: ");
        System.out.println(cocheRepository.findByPrecioBetween(8000.0, 66000.0) + System.lineSeparator());

        System.out.println("Mostrar el coche con la matricula 9899BVS");
        System.out.println(cocheRepository.findByMatricula("9899BVS") + System.lineSeparator());


        System.out.println("Los coches de la marca Porsche son: ");
        System.out.println(cocheRepository.findByMarca("Porsche") + System.lineSeparator());

        System.out.println("Buscar coche por marca y modelo: Opel Corsa");
        System.out.println(cocheRepository.findByMarcaAndModelo("Opel", "Corsa") + System.lineSeparator());

        System.out.println("Buscar coche por marca y con un precio inferior a 10.000$");
        System.out.println(cocheRepository.findByMarcaAndPrecioLessThanEqual("Opel", 10000.0) + System.lineSeparator());

        System.out.println("La media de precios de los coches de la marca SEAT es la siguiente: ");
        System.out.println(cocheRepository.obtenerMediaPorMarca("Seat") + System.lineSeparator());

        System.out.println("Los coches de Dimple son: ");
        System.out.println(cocheRepository.findByPropietario(dimple));

        System.out.println(cocheRepository.obtenerCoches(dimple) + System.lineSeparator());

        System.out.println("El coche con de un propietario con precio superior a 62000.0");
        System.out.println(cocheRepository.findByPropietarioAndPrecioGreaterThanEqual(dimple, 62000.0) + System.lineSeparator());

        System.out.println(cocheRepository.obtenerCocheCaro(dimple, 62000.0) + System.lineSeparator());

        System.out.println("Mostrar los coches de un propietario (Dimple) entre los años 2005 y 2016");
        System.out.println(cocheRepository.obtenerCocheEntreAños(dimple, 2005, 2016) + System.lineSeparator());

        System.out.println("Mostrar todos los coches cuya edad de los propietarios sea superior o igual a 25");
        System.out.println(cocheRepository.obtenerCocheXEdad(25) + System.lineSeparator());

        System.out.println("Mostrar todos los coches en base a la edad de los propietarios comprendida entre 20 a 25");
        System.out.println(cocheRepository.obtenerCocheXEdadEntre(20, 25) + System.lineSeparator());

        System.out.println("Mostrar un coche por las letras de su matricula, en este caso BVS");
        System.out.println(cocheRepository.obtenerMatriculaByLetras("BVS") + System.lineSeparator());

        System.out.println("Mostrar la media, el minimo y el máximo, del precio de los vehículos de cada marca");
        List<Object[]> marcaList = cocheRepository.obtenerMidMinMax();

        for (Object[] marca : marcaList) {
            System.out.println("Marca: " + marca[0] + " ");
            System.out.println("Media: " + marca[1] + " ");
            System.out.println("MIN: " + marca[2] + " ");
            System.out.println("MAX: " + marca[3] + " " + System.lineSeparator() + System.lineSeparator());
        }

        System.out.println("Mostrar todos los coches de un mismo año ");
        List<Object[]> añoList = cocheRepository.obtenerCochesXAño();

        for (Object[] añoCar : añoList) {

            Integer año = (Integer) añoCar[0];
            System.out.println("Año: " + añoCar[0] + " ");
            System.out.println("Numero de coches de cada año " + añoCar[1]);
            System.out.println("Los coches son: " + cocheRepository.findByAño(año) + System.lineSeparator());
        }

    }

}
