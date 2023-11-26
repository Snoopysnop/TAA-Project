package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.dto.AppointmentDto;
import sample.data.jpa.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("api/appointments")
public class AppointmentControler {
    @Autowired
    private AppointmentService appointmentService;
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.findById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<AppointmentDto> create(@RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok(appointmentService.create(appointmentDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        appointmentService.deleteById(id);
        return ResponseEntity.ok().body("Appointment has been deleted");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AppointmentDto> update(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok(appointmentService.update(appointmentDto,id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<AppointmentDto>> findAll(){
        return ResponseEntity.ok(appointmentService.findAll());
    }
}
