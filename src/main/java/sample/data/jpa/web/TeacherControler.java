package sample.data.jpa.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.dto.TeacherDto;
import sample.data.jpa.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
public class TeacherControler {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/{id}")
    @Operation(
            tags={"teacher"},
            description="get a teacher by his id"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.findById(id));
    }
    @PostMapping("/create")
    @Operation(
            tags={"teacher"},
            description="create a teacher"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<TeacherDto> create(@RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(teacherService.create(teacherDto));
    }
    @DeleteMapping("/delete/{id}")
    @Operation(
            tags={"teacher"},
            description="delete a teacher"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        teacherService.deleteById(id);
        return ResponseEntity.ok().body("Teacher has been deleted");
    }
    @PutMapping("/update/{id}")
    @Operation(
            tags={"teacher"},
            description="update a teacher"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<TeacherDto> update(@PathVariable Long id, @RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(teacherService.update(teacherDto,id));
    }
    @GetMapping("/all")
    @Operation(
            tags={"teacher"},
            description="get all the teachers"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<List<TeacherDto>> findAll(){
        return ResponseEntity.ok(teacherService.findAll());
    }
}
