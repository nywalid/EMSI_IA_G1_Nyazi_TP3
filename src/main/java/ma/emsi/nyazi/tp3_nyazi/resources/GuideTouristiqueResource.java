package ma.emsi.nyazi.tp3_nyazi.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/guide")
public class GuideTouristiqueResource {
//    @GET
//    @Path("lieu/{ville_ou_pays}")
//    @Produces("application/json")
//    public String guide(@PathParam("ville_ou_pays") String lieu) {
//        return lieu;
//    }

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public String[] guide(@PathParam("ville_ou_pays") String lieu) {
        return new String[]{lieu};
    }
}