package ma.emsi.nyazi.tp3_nyazi.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import jakarta.enterprise.context.Dependent;

@Dependent
public class LlmClient {
    public interface GuideTouristique {

        @SystemMessage("""
        Tu es un guide touristique expert.
        N'utilise pas Markdown.
        Tu dois indiquer STRICTEMENT le nombre d'endroits donné par l'utilisateur. Donne uniquement la réponse au format JSON suivant:
        {
          "ville_ou_pays": "nom",
          "endroits_a_visiter": ["endroit 1","endroit 2", ...],
          "prix_moyen_repas": "<prix> <devise>"
        }
    """)
        @UserMessage("Donne des informations touristiques sur : {{ville_ou_pays}} Nombre d'endroits à visiter : {{nb}}")
        String genererGuide(@V("ville_ou_pays") String ville_ou_pays, @V("nb") int nb);
    }

    private final GuideTouristique guideTouristique;

    public LlmClient() {
        String apiKey = System.getenv("GEMINI_KEY");
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();

        this.guideTouristique = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .build();
    }
    public GuideTouristique getGuide() {
        return guideTouristique;
    }
}
