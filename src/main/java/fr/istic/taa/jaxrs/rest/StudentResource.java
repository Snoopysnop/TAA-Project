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
    @Path("/create")
    public Response createStudent(@RequestBody(description = "student object that needs to be added in the database ", required = true)StudentDto studentDto){
        
        StudentDao studentDao = new StudentDao();
        Student newStudent = studentMapper.mapStudent(studentDto);
        studentDao.create(newStudent);
        return Response.ok().entity("Student created").build();
    }


    @PUT
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") long id, @RequestBody(description = "Student object that needs to be updated", required = true) StudentDto studentDto) {

        StudentDao studentDao = new StudentDao();
        Student updatedStudent = studentDao.update(studentMapper.mapStudent(studentDto));

        if (updatedStudent != null) {
            return Response.ok().entity("Student updated").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteStudent(@PathParam("id") long id) {
        StudentDao studentDao = new StudentDao();
        Student currentStudent = studentDao.find(id);
        studentDao.delete(currentStudent);
        
        return Response.ok().entity("Student deleted").build();
    }

}
