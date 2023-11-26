/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.istic.taa.jaxrs;

import java.util.HashSet;
import java.util.Set;

import fr.istic.taa.jaxrs.domain.javaClass.TimeSlot;
import fr.istic.taa.jaxrs.rest.AppointmentResource;
import fr.istic.taa.jaxrs.rest.PetResource;
import fr.istic.taa.jaxrs.rest.StudentResource;
import fr.istic.taa.jaxrs.rest.TeacherResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
public class TestApplication extends Application {
	

    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(OpenApiResource.class);
        clazzes.add(PetResource.class);

        
        clazzes.add(AppointmentResource.class);
        clazzes.add(StudentResource.class);
        clazzes.add(TeacherResource.class);
//        clazzes.add(AcceptHeaderOpenApiResource.class);
         

        return clazzes;
    }

}
