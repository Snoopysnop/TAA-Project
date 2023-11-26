package sample.data.jpa.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            tags={"appointment"},
            description="get an appointment by his id"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.findById(id));
    }
    @PostMapping("/create")
    @Operation(
            tags={"appointment"},
            description="create an appointment"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<AppointmentDto> create(@RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok(appointmentService.create(appointmentDto));
    }
    @DeleteMapping("/delete/{id}")
    @Operation(
            tags={"appointment"},
            description="delete an appointment"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        appointmentService.deleteById(id);
        return ResponseEntity.ok().body("Appointment has been deleted");
    }
    @PutMapping("/update/{id}")
    @Operation(
            tags={"appointment"},
            description="update an appointment"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<AppointmentDto> update(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok(appointmentService.update(appointmentDto,id));
    }
    @GetMapping("/all")
    @Operation(
            tags={"appointment"},
            description="get all the appointments"
    )
    @ApiResponse(responseCode = "200", description = "successful operation")
    public ResponseEntity<List<AppointmentDto>> findAll(){
        return ResponseEntity.ok(appointmentService.findAll());
    }
}
