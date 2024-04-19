package ca.saultcollege.demo.repositories;


import ca.saultcollege.demo.data.DataClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataClassRepository extends JpaRepository<DataClass, Long> {
    DataClass findByIntValue(int intValue);
}


