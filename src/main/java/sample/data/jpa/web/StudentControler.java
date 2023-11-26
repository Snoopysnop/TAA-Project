package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.dto.StudentDto;
import sample.data.jpa.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentControler {
    @Autowired
    private StudentService studentService;
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.create(studentDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.ok().body("Student has been deleted");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.update(studentDto,id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

}
