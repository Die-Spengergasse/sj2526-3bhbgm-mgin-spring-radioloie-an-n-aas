package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Integer> {
    Machine findByType(String type);
}