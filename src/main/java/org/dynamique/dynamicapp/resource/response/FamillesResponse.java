package org.dynamique.dynamicapp.resource.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamillesResponse extends AbstractResponse {
    private String nom;
    private String prenom;


    public static final class FamillesResponseBuilder {
        private String nom;
        private String prenom;

        private FamillesResponseBuilder() {
        }

        public static FamillesResponseBuilder aFamillesResponse() {
            return new FamillesResponseBuilder();
        }

        public FamillesResponseBuilder withNom(String nom) {
            this.nom = nom;
            return this;
        }

        public FamillesResponseBuilder withPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public FamillesResponse build() {
            FamillesResponse famillesResponse = new FamillesResponse();
            famillesResponse.setNom(nom);
            famillesResponse.setPrenom(prenom);
            return famillesResponse;
        }
    }
}
