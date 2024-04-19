package ca.saultcollege.demo.Controller;



import ca.saultcollege.demo.data.DataClass;
import ca.saultcollege.demo.repositories.DataClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IntValueController {

    @Autowired
    private DataClassRepository dataClassRepository;

    @GetMapping("/int-value")
    public ResponseEntity<Integer> getIntValue() {
        DataClass data = dataClassRepository.findByIntValue(123); // Hardcoded criteria
        return ResponseEntity.ok(data.getIntValue());
    }

    // Endpoint to save data to the new table using HTTP PUT
    @PutMapping("/int-value")
    public ResponseEntity<DataClass> saveIntValue(@RequestBody DataClass newData) {
        DataClass savedData = dataClassRepository.save(newData);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }
}
