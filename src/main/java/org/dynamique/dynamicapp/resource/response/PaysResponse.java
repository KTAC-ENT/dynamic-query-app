package org.dynamique.dynamicapp.resource.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaysResponse extends AbstractResponse {
    private String abrev;
    private String nom;
    private String indicateur;
    private String code;


    public static final class PaysResponseBuilder {
        private String abrev;
        private String nom;
        private String indicateur;

        private PaysResponseBuilder() {
        }

        public static PaysResponseBuilder aPaysResponse() {
            return new PaysResponseBuilder();
        }

        public PaysResponseBuilder withAbrev(String abrev) {
            this.abrev = abrev;
            return this;
        }

        public PaysResponseBuilder withNom(String nom) {
            this.nom = nom;
            return this;
        }

        public PaysResponseBuilder withIndicateur(String indicateur) {
            this.indicateur = indicateur;
            return this;
        }

        public PaysResponse build() {
            PaysResponse paysResponse = new PaysResponse();
            paysResponse.setAbrev(abrev);
            paysResponse.setNom(nom);
            paysResponse.setIndicateur(indicateur);
            return paysResponse;
        }
    }
}
