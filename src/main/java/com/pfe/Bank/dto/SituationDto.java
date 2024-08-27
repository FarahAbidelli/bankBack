package com.pfe.Bank.dto;
//import com.example.project.model.ClientSni;
//import com.example.project.model.SituationClientSni;
import com.pfe.Bank.model.SituationClientProfes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class SituationDto {

    private long id ;
    private SituationDto client ;
    private long codeRelation;

    private Date dateDeSituation;
    private String numeroComptePrincipal;
    private String consolidationInterne;
    private double mntEnConsolidation;
    private double encoursCT;
    private double encoursMT;
    private double encoursCreditTresorerie;
    private double ratioEngagementCDR;
    private String consolidationAutresBanques;
    private String besoinAccompagnement;
    private String besoinFinancement;
    private String trancheEffectif;
    private int nombreClients;
    private String etatDuResultat;
    private String tailleBesoinFutur;
    private String classeBanqueCentrale;
    private String anneeClassificationCentrale;
    private String ratingActuelleLegacy;
    private String classeRisqueLegacy;
    private int scoreClientLegacy;

    private Date dateRatingLegacy;
    private String impaye;
    private double montantImpayes;
    private double ratioImpayesEngagements;
    private int ancienneteImpayes;
    private double mouvementsTotauxAnneeN;
    private double mouvementsTotauxAnneeN1;
    private double mouvementCreditieurAnneeN;
    private double mouvementCreditieurAnneeN1;
    private double mouvementDebiteurAnneeN;
    private double mouvementDebiteurAnneeN1;
    private double ratioCreditSoldeMoyen;
    private String regulariteEcheances;
    private double dernierSalaireYTD;
    private double soldeMoyenAnnuelAnneeN;
    private double soldeMoyenAnnuelAnneeN1;
    private double totalCreancesGLE;
    private double variationAnnuelleMvtCreditAnneeN;
    private double variationAnnuelleMvtCreditAnneeN1;
    private double variationMvtCredit;
    private double rationSoldeMoyenFC;
    private String iarCentralDesRisquesCDR;
    private double variationEngagementCDR;
    private double mntCreditTresorerieCDR;
    private double variationCreditTresoCDR;
    private String incident;
    private String modeleApplicable;
    private String autresInformation;
    private String commentaire;
    private String variableLibre1;
    private String variableLibre2;
    private String variableLibre3;
    private String variableLibre4;
    private String variableLibre5;
    private String variableLibre6;
    private String variableLibre7;

    public SituationDto(SituationClientProfes situationClientProfes) {
        this.id=situationClientProfes.getId();
        this.codeRelation =situationClientProfes.getCodeRelation();
        this.dateDeSituation = situationClientProfes.getDateDeSituation();
        this.numeroComptePrincipal = situationClientProfes.getNumeroComptePrincipal();
        this.consolidationInterne = situationClientProfes.getConsolidationInterne();
        this.mntEnConsolidation = situationClientProfes.getMntEnConsolidation();
        this.encoursCT = situationClientProfes.getEncoursCT();
        this.encoursMT = situationClientProfes.getEncoursMT();
        this.encoursCreditTresorerie =situationClientProfes.getEncoursCreditTresorerie();
        this.ratioEngagementCDR = situationClientProfes.getRatioEngagementCDR();
        this.consolidationAutresBanques = situationClientProfes.getConsolidationAutresBanques();
        this.besoinAccompagnement = situationClientProfes.getBesoinAccompagnement();
        this.besoinFinancement = situationClientProfes.getBesoinFinancement();
        this.trancheEffectif =situationClientProfes.getTrancheEffectif();
        this.nombreClients = situationClientProfes.getNombreClients();
        this.etatDuResultat = situationClientProfes.getEtatDuResultat();
        this.tailleBesoinFutur = situationClientProfes.getTailleBesoinFutur();
        this.classeBanqueCentrale =situationClientProfes.getClasseBanqueCentrale();
        this.anneeClassificationCentrale = situationClientProfes.getAnneeClassificationCentrale();
        this.ratingActuelleLegacy = situationClientProfes.getRatingActuelleLegacy();
        this.classeRisqueLegacy = situationClientProfes.getClasseRisqueLegacy();
        this.scoreClientLegacy = situationClientProfes.getScoreClientLegacy();
        this.dateRatingLegacy = situationClientProfes.getDateRatingLegacy();
        this.impaye = situationClientProfes.getImpaye();
        this.montantImpayes = situationClientProfes.getMontantImpayes();
        this.ratioImpayesEngagements = situationClientProfes.getRatioImpayesEngagements();
        this.ancienneteImpayes = situationClientProfes.getAncienneteImpayes();
        this.mouvementsTotauxAnneeN = situationClientProfes.getMouvementsTotauxAnneeN();
        this.mouvementsTotauxAnneeN1 = situationClientProfes.getMouvementsTotauxAnneeN1();
        this.mouvementCreditieurAnneeN = situationClientProfes.getMouvementCreditieurAnneeN();
        this.mouvementCreditieurAnneeN1 = situationClientProfes.getMouvementCreditieurAnneeN1();
        this.mouvementDebiteurAnneeN = situationClientProfes.getMouvementDebiteurAnneeN();
        this.mouvementDebiteurAnneeN1 = situationClientProfes.getMouvementDebiteurAnneeN1();
        this.ratioCreditSoldeMoyen = situationClientProfes.getRatioCreditSoldeMoyen();
        this.regulariteEcheances =situationClientProfes.getRegulariteEcheances();
        this.dernierSalaireYTD = situationClientProfes.getDernierSalaireYTD();
        this.soldeMoyenAnnuelAnneeN = situationClientProfes.getSoldeMoyenAnnuelAnneeN();
        this.soldeMoyenAnnuelAnneeN1 = situationClientProfes.getSoldeMoyenAnnuelAnneeN1();
        this.totalCreancesGLE = situationClientProfes.getTotalCreancesGLE();
        this.variationAnnuelleMvtCreditAnneeN = situationClientProfes.getVariationAnnuelleMvtCreditAnneeN();
        this.variationAnnuelleMvtCreditAnneeN1 = situationClientProfes.getVariationAnnuelleMvtCreditAnneeN1();
        this.variationMvtCredit = situationClientProfes.getVariationMvtCredit();
        this.rationSoldeMoyenFC = situationClientProfes.getRationSoldeMoyenFC();
        this.iarCentralDesRisquesCDR = situationClientProfes.getIarCentralDesRisquesCDR();
        this.variationEngagementCDR = situationClientProfes.getVariationEngagementCDR();
        this.mntCreditTresorerieCDR = situationClientProfes.getMntCreditTresorerieCDR();
        this.variationCreditTresoCDR = situationClientProfes.getVariationCreditTresoCDR();
        this.incident = situationClientProfes.getIncident();
        this.modeleApplicable = situationClientProfes.getModeleApplicable();
        this.autresInformation = situationClientProfes.getAutresInformation();
        this.commentaire = situationClientProfes.getCommentaire();
        this.variableLibre1 = situationClientProfes.getVariableLibre1();
        this.variableLibre2 = situationClientProfes.getVariableLibre2();
        this.variableLibre3 = situationClientProfes.getVariableLibre3();
        this.variableLibre4 = situationClientProfes.getVariableLibre4();
        this.variableLibre5 = situationClientProfes.getVariableLibre5();
        this.variableLibre6 = situationClientProfes.getVariableLibre6();
        this.variableLibre7 = situationClientProfes.getVariableLibre7();
    }
    public static SituationDto of(SituationClientProfes situationClientSni){

        return new SituationDto(situationClientSni);
    }
    public static List<SituationDto> of(List<SituationClientProfes> situationClientProfes){
        return situationClientProfes.stream().map(SituationDto::of).collect(Collectors.toList());
    }

}
//this.id