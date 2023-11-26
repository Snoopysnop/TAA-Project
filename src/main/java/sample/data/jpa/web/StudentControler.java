package sample.data.jpa.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            tags={"student"},
            description="get the student by his id"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }
    @PostMapping("/create")
    @Operation(
            tags={"student"},
            description="create a student"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.create(studentDto));
    }
    @DeleteMapping("/delete/{id}")
    @Operation(
            tags={"student"},
            description="delete a student by his id"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.ok().body("Student has been deleted");
    }
    @PutMapping("/update/{id}")
    @Operation(
            tags={"student"},
            description="update a student"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.update(studentDto,id));
    }
    @GetMapping("/all")
    @Operation(
            tags={"student"},
            description="get all the students"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<List<StudentDto>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

}
