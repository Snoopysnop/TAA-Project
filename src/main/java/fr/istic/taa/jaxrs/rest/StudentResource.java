package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.myDao.StudentDao;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.javaClass.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.javaClass.Student;
import fr.istic.taa.jaxrs.dto.StudentDto;
import fr.istic.taa.jaxrs.mappers.StudentMapper;
import fr.istic.taa.jaxrs.mappers.StudentMapperImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("student")
@Produces({"application/json", "application/xml"})
@Consumes("application/json")
public class StudentResource {
    
    private StudentMapper studentMapper = new StudentMapperImpl();

    @GET
    @Path("/{Id}")
    public Response getStudentById(@PathParam("Id") Long studentNumber)  {
        
        StudentDao studentDao = new StudentDao();

        Student student = studentDao.find(studentNumber);
        
        if(student != null){
            StudentDto studentDto = studentMapper.mapStudentDto(student);
            
            return Response.ok().entity(studentDto).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
        }
        
    }

    
    @POST
    public Response createStudent(@RequestBody(description = "student object that needs to be added in the database ", required = true)Student student){
        
        
        StudentDao studentDAO = new StudentDao();

        Student newStudent = studentDAO.create(student);

        if(newStudent != null){    
            StudentDto studentDto = studentMapper.mapStudentDto(newStudent);
            
            return Response.ok().entity(studentDto).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).entity("student can't be created").build();
        }
    }

}
