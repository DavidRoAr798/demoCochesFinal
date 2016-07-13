package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public void testPersonas() {
        Persona persona = new Persona();
        persona.setNombre("Ivan");
        persona.setApellido("Merino");
        persona.setAge(23);
        personaRepository.save(persona);

        Persona persona2 = new Persona();
        persona2.setNombre("Dimple");
        persona2.setApellido("Ramchandani");
        persona2.setAge(26);
        personaRepository.save(persona2);

        Persona persona3 = new Persona();
        persona3.setNombre("Noelia");
        persona3.setApellido("Villa");
        persona3.setAge(25);
        personaRepository.save(persona3);

        Persona persona4 = new Persona();
        persona4.setNombre("Jordi");
        persona4.setApellido("Portero");
        persona4.setAge(25);
        personaRepository.save(persona4);

        Persona persona5 = new Persona();
        persona5.setNombre("Ricard");
        persona5.setApellido("Sole");
        persona5.setAge(25);
        personaRepository.save(persona5);

        Persona persona6 = new Persona();
        persona6.setNombre("Noelia");
        persona6.setApellido("López");
        persona6.setAge(25);
        personaRepository.save(persona6);

        System.out.println(personaRepository.findOne(2L));
        System.out.println(personaRepository.findByNombre("Noelia"));

        System.out.println("Mostrar todas las personas cuya edad sea mayor de 23:");
        System.out.println(personaRepository.findByAgeGreaterThanEqual(23));

        System.out.println("Buscar por nombre y apellido a: ");
        System.out.println(personaRepository.findByNombreAndApellido("Noelia", "Villa"));

        System.out.println("Buscar por nombre y apellido a: ");
        System.out.println(personaRepository.findByNombreOrApellido("Noelia", "Villa"));


    }
}
