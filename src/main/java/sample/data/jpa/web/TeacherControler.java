package sample.data.jpa.web;

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
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.findById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<TeacherDto> create(@RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(teacherService.create(teacherDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        teacherService.deleteById(id);
        return ResponseEntity.ok().body("Teacher has been deleted");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherDto> update(@PathVariable Long id, @RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(teacherService.update(teacherDto,id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<TeacherDto>> findAll(){
        return ResponseEntity.ok(teacherService.findAll());
    }
}
