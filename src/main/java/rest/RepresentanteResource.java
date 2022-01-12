/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.RepresentanteFacade;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import model.Representante;

/**
 *
 * @author jonat
 */
@Path("/representante")
public class RepresentanteResource {

    @EJB
    private RepresentanteFacade ejbRepresentante;
    
    

    @GET
    @Path("/sesion")
    @Produces(MediaType.TEXT_PLAIN)
    public Response get(@QueryParam("correo") String usuario, @QueryParam("contrasena") String contrasena) throws Exception {

        Representante p = ejbRepresentante.obtenerUsuario(usuario, contrasena);
        if (p != null) {
            return Response.ok("SE A INICIADO SESION CORRECTAMENTE" + p.getPersona().getNombre()).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
            // return "INICIO DE SESION CORRECTO!";
        } else {
            return Response.status(202).entity("CLIENTE NO REGISTRADO").build();

        }
    }

    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Representante personaModificada) {
        Representante persona = ejbRepresentante.buscarId(id);
        if (persona != null) {
            ejbRepresentante.editar(personaModificada);
            System.out.println("PERSONA MODIFICADA" + personaModificada);
            return Response.ok().entity(personaModificada).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }


    

}
