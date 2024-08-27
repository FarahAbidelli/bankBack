package com.pfe.Bank.model;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prf_client_situation")
@Getter
@Setter
@NoArgsConstructor
public class SituationClientProfes extends FinancialData {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = true)
    private ClientProfes client;

    private long codeRelation;

    public ClientProfes getClient() {
        return client;
    }

    public void setClient(ClientProfes client) {
        this.client = client;
    }

    @Builder
    public SituationClientProfes(Long id, Date dateDeSituation, String numeroComptePrincipal, String consolidationInterne,double mntEnConsolidation, double encoursCT, double encoursMT, double encoursCreditTresorerie, double ratioEngagementCDR, String consolidationAutresBanques, String besoinAccompagnement, String besoinFinancement, String trancheEffectif, int nombreClients, String etatDuResultat, String tailleBesoinFutur, String classeBanqueCentrale, String anneeClassificationCentrale, String ratingActuelleLegacy, String classeRisqueLegacy, int scoreClientLegacy, Date dateRatingLegacy, String impaye, double montantImpayes, double ratioImpayesEngagements, int ancienneteImpayes, double mouvementsTotauxAnneeN, double mouvementsTotauxAnneeN1, double mouvementCreditieurAnneeN, double mouvementCreditieurAnneeN1, double mouvementDebiteurAnneeN, double mouvementDebiteurAnneeN1, double ratioCreditSoldeMoyen, String regulariteEcheances, double dernierSalaireYTD, double soldeMoyenAnnuelAnneeN, double soldeMoyenAnnuelAnneeN1, double totalCreancesGLE, double variationAnnuelleMvtCreditAnneeN, double variationAnnuelleMvtCreditAnneeN1, double variationMvtCredit, double rationSoldeMoyenFC, String iarCentralDesRisquesCDR, double variationEngagementCDR, double mntCreditTresorerieCDR, double variationCreditTresoCDR, String incident, String modeleApplicable, String autresInformation, String commentaire, String variableLibre1, String variableLibre2, String variableLibre3, String variableLibre4, String variableLibre5, String variableLibre6, String variableLibre7,long codeRelation) {
        super();
        super.setId(id);
        super.setDateDeSituation(dateDeSituation);
        super.setNumeroComptePrincipal(numeroComptePrincipal);
        super.setConsolidationInterne(consolidationInterne);
        super.setMntEnConsolidation(mntEnConsolidation);
        super.setEncoursCT(encoursCT);
        super.setEncoursMT(encoursMT);
        super.setEncoursCreditTresorerie(encoursCreditTresorerie);
        super.setRatioEngagementCDR(ratioEngagementCDR);
        super.setConsolidationAutresBanques(consolidationAutresBanques);
        super.setBesoinAccompagnement(besoinAccompagnement);
        super.setBesoinFinancement(besoinFinancement);
        super.setTrancheEffectif(trancheEffectif);
        super.setNombreClients(nombreClients);
        super.setEtatDuResultat(etatDuResultat);
        super.setTailleBesoinFutur(tailleBesoinFutur);
        super.setClasseBanqueCentrale(classeBanqueCentrale);
        super.setAnneeClassificationCentrale(anneeClassificationCentrale);
        super.setRatingActuelleLegacy(ratingActuelleLegacy);
        super.setClasseRisqueLegacy(classeRisqueLegacy);
        super.setScoreClientLegacy(scoreClientLegacy);
        super.setDateRatingLegacy(dateRatingLegacy);
        super.setImpaye(impaye);
        super.setMontantImpayes(montantImpayes);
        super.setRatioImpayesEngagements(ratioImpayesEngagements);
        super.setAncienneteImpayes(ancienneteImpayes);
        super.setMouvementsTotauxAnneeN(mouvementsTotauxAnneeN);
        super.setMouvementCreditieurAnneeN1(mouvementCreditieurAnneeN1);
        super.setMouvementCreditieurAnneeN(mouvementCreditieurAnneeN);
        super.setMouvementCreditieurAnneeN1(mouvementCreditieurAnneeN1);
        super.setMouvementDebiteurAnneeN(mouvementDebiteurAnneeN);
        super.setMouvementDebiteurAnneeN1(mouvementDebiteurAnneeN1);
        super.setRatioCreditSoldeMoyen(ratioCreditSoldeMoyen);
        super.setRegulariteEcheances(regulariteEcheances);
        super.setDernierSalaireYTD(dernierSalaireYTD);
        super.setSoldeMoyenAnnuelAnneeN(soldeMoyenAnnuelAnneeN);
        super.setSoldeMoyenAnnuelAnneeN1(soldeMoyenAnnuelAnneeN1);
        super.setTotalCreancesGLE(totalCreancesGLE);
        super.setVariationAnnuelleMvtCreditAnneeN(variationAnnuelleMvtCreditAnneeN);
        super.setVariationAnnuelleMvtCreditAnneeN1(variationAnnuelleMvtCreditAnneeN1);
        super.setVariationMvtCredit(variationMvtCredit);
        super.setRationSoldeMoyenFC(rationSoldeMoyenFC);
        super.setIarCentralDesRisquesCDR(iarCentralDesRisquesCDR);
        super.setVariationEngagementCDR(variationEngagementCDR);
        super.setMntCreditTresorerieCDR(mntCreditTresorerieCDR);
        super.setVariationCreditTresoCDR(variationCreditTresoCDR);
        super.setIncident(incident);
        super.setModeleApplicable(modeleApplicable);
        super.setAutresInformation(autresInformation);
        super.setCommentaire(commentaire);
        super.setVariableLibre1(variableLibre1);
        super.setVariableLibre2(variableLibre2);
        super.setVariableLibre3(variableLibre3);
        super.setVariableLibre4(variableLibre4);
        super.setVariableLibre5(variableLibre5);
        super.setVariableLibre6(variableLibre6);
        super.setVariableLibre7(variableLibre7);
        this.codeRelation = codeRelation;
    }
}
