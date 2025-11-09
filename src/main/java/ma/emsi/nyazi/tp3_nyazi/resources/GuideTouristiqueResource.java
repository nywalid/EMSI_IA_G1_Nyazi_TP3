package ma.emsi.nyazi.tp3_nyazi.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import ma.emsi.nyazi.tp3_nyazi.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    LlmClient llmClient;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public String villeOuPays(@PathParam("ville_ou_pays") String ville_ou_pays, @QueryParam("nb") @DefaultValue("2") int nb) {
        return llmClient.getGuide().genererGuide(ville_ou_pays, nb);
    }

//    @GET
//    @Path("lieu/{ville_ou_pays}")
//    @Produces("application/json")
//    public String guide(@PathParam("ville_ou_pays") String lieu) {
//        return lieu;
//    }

//    @GET
//    @Path("lieu/{ville_ou_pays}")
//    @Produces("application/json")
//    public String[] guide(@PathParam("ville_ou_pays") String lieu) {
//        return new String[]{lieu};
//    }
}