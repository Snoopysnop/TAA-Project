package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.myDao.TeacherDao;
import fr.istic.taa.jaxrs.domain.javaClass.Teacher;
import fr.istic.taa.jaxrs.dto.TeacherDto;
import fr.istic.taa.jaxrs.mappers.TeacherMapper;
import fr.istic.taa.jaxrs.mappers.TeacherMapperImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("teacher")
@Produces({"application/json", "application/xml"})
@Consumes("application/json")
public class TeacherResource {
    
    private TeacherMapper TeacherMapper = new TeacherMapperImpl();

    @GET
    @Path("/{Id}")
    public Response getTeacherById(@PathParam("Id") Long TeacherNumber)  {
        
        TeacherDao TeacherDao = new TeacherDao();

        Teacher Teacher = TeacherDao.find(TeacherNumber);
        if(Teacher != null){
            TeacherDto TeacherDto = TeacherMapper.mapTeacherDto(Teacher);
            
            return Response.ok().entity(TeacherDto).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).entity("Teacher not found").build();
        }
        
    }

    @POST
    public Response createTeacher(@RequestBody(description = "Teacher object that needs to be added in the database ", required = true)TeacherDto teacherDto){
        
        TeacherDao teacherDAO = new TeacherDao();
        Teacher teacher = TeacherMapper.mapTeacher(teacherDto);

        teacherDAO.create(teacher);
        
        return Response.ok().entity("teacher created").build();
    
    }
}