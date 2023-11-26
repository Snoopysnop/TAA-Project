package fr.istic.taa.jaxrs.rest;
    
import fr.istic.taa.jaxrs.dao.myDao.AppointmentDao;
import fr.istic.taa.jaxrs.dao.myDao.AppointmentDao;
import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.domain.javaClass.Appointment;
import fr.istic.taa.jaxrs.dto.AppointmentDto;
import fr.istic.taa.jaxrs.dto.AppointmentDto;
import fr.istic.taa.jaxrs.mappers.AppointmentMapper;
import fr.istic.taa.jaxrs.mappers.AppointmentMapperImpl;
import fr.istic.taa.jaxrs.mappers.AppointmentMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("appointment")
@Produces({"application/json", "application/xml"})
@Consumes("application/json")
public class AppointmentResource {
    
    private AppointmentMapper appointmentMapper = new AppointmentMapperImpl();

    @GET
    @Path("/{Id}")
    public Response getAppointmentById(@PathParam("Id") Long id)  {
        
        AppointmentDao appointmentDao = new AppointmentDao();

        Appointment appointment = appointmentDao.find(id);
        
        if(appointment != null){
            AppointmentDto appointmentDto = appointmentMapper.mapAppointmentDto(appointment);
            
            return Response.ok().entity(appointmentDto).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).entity("appointment not found").build();
        }
        
    }

    @POST
    public Response createAppointment(@RequestBody(description = "Appointment object that needs to be added in the database ", required = true)AppointmentDto appointmentDto){
        
        AppointmentDao appointmentDAO = new AppointmentDao();
        Appointment appointment = appointmentMapper.mapAppointment(appointmentDto);
        appointmentDAO.create(appointment);

        return Response.ok().entity("appointment Created").build();
    }

}