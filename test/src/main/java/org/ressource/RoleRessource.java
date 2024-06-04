package org.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jdk.dynalink.linker.LinkerServices;
import org.entity.Role;
import org.service.RoleService;

import java.util.List;

@Path("api/role")
public class RoleRessource {
    @Inject
    RoleService roleService;

    @GET
    public List<Role> getRole(){
        return roleService.roleList();
    }
    @GET
    @Path("{id}")
    public Role getRoleById(long id){
        return roleService.roleById(id);
    }

    @POST
    public Response postRole(Role role){
        roleService.createRole(role);
        return Response.ok(role).build();
    }

    @PUT
    @Path("{id}")
    public Response putRole(long id, Role role){
        roleService.updateRole(id, role);
        return Response.ok(role).build();
    }
    @DELETE
    @Path("{id}")
    public Response deleteRole(long id){
        roleService.deleteRole(id);
        return Response.ok().build();
    }
}
