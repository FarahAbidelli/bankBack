package com.pfe.Bank.service;
import lombok.*;
import com.opencsv.bean.CsvBindByName;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SituationCsvRepresentation {

    @CsvBindByName(column="code_relation")
    private long codeRelation;
    @CsvBindByName(column = "date_de_situation")
    private String dateDeSituation;
    @CsvBindByName(column = "numero_compte_principal")
    private String numeroComptePrincipal;
    @CsvBindByName(column = "consolidation_interne")
    private String consolidationInterne;
    @CsvBindByName(column = "mnt_en_consolidation")
    private double mntEnConsolidation;
    @CsvBindByName(column = "encours_ct")
    private double encoursCT;

    @CsvBindByName(column = "encours_mt")
    private double encoursMT;

    @CsvBindByName(column = "encours_credit_tresorerie")
    private double encoursCreditTresorerie;

    @CsvBindByName(column = "ratio_engagement_cdr")
    private double ratioEngagementCDR;

    @CsvBindByName(column = "consolidation_autres_banques")
    private String consolidationAutresBanques;


    @CsvBindByName(column = "besoin_accompagnement")
    private String besoinAccompagnement;

    @CsvBindByName(column = "besoin_financement")
    private String besoinFinancement;

    @CsvBindByName(column = "tranche_effectif")
    private String trancheEffectif;
    @CsvBindByName(column="nombre_clients")
    private int nombreClients;

    @CsvBindByName(column = "etat_resultat")
    private String etatDuResultat;

    @CsvBindByName(column = "taille_besoin_futur")
    private String tailleBesoinFutur;
    @CsvBindByName(column = "classe_banque_centrale")
    private String classeBanqueCentrale;

    @CsvBindByName(column = "annee_classification_centrale")
    private String anneeClassificationCentrale;

    @CsvBindByName(column = "rating_actuel_legacy")
    private String ratingActuelleLegacy;
    @CsvBindByName(column = "classe_risque_legacy")
    private String classeRisqueLegacy;


    @CsvBindByName(column = "score_client_legacy")
    private int scoreClientLegacy;
    @CsvBindByName(column = "date_rating_legacy")
    private String dateRatingLegacy;


    @CsvBindByName(column = "impaye")
    private String impaye;

    @CsvBindByName(column = "montant_impayes")
    private double montantImpayes;


    @CsvBindByName(column = "ratio_impayes_engagements")
    private double ratioImpayesEngagements;

    @CsvBindByName(column = "anciennete_impayes")
    private int ancienneteImpayes;

    @CsvBindByName(column = "mouvements_totaux_year_n")
    private double mouvementsTotauxAnneeN;
    @CsvBindByName(column = "mouvements_totaux_year_n1")
    private double mouvementsTotauxAnneeN1;

    @CsvBindByName(column = "mouvement_crediteur_year_n")
    private double mouvementCreditieurAnneeN;

    @CsvBindByName(column = "mouvement_crediteur_year_n1")
    private double mouvementCreditieurAnneeN1;
    @CsvBindByName(column = "mouvement_debiteur_year_n")
    private double mouvementDebiteurAnneeN;


    @CsvBindByName(column = "mouvement_debiteur_year_n1")
    private double mouvementDebiteurAnneeN1;

    @CsvBindByName(column = "ratio_credit_solde_moyen")
    private double ratioCreditSoldeMoyen;


    @CsvBindByName(column = "regularite_echeances")
    private String regulariteEcheances;

    @CsvBindByName(column = "dernier_salaire_ytd")
    private double dernierSalaireYTD;


    @CsvBindByName(column = "solde_moyen_annuel_year_n")
    private double soldeMoyenAnnuelAnneeN;

    @CsvBindByName(column = "solde_moyen_annuel_year_n1")
    private double soldeMoyenAnnuelAnneeN1;
    @CsvBindByName(column = "total_creances_gle")
    private double totalCreancesGLE;

    @CsvBindByName(column = "variation_annual_mouvement_crediteur_n")
    private double variationAnnuelleMvtCreditAnneeN;

    @CsvBindByName(column = "variation_annual_mouvement_crediteur_n1")
    private double variationAnnuelleMvtCreditAnneeN1;
    @CsvBindByName(column = "variation_mvt_crediteur")
    private double variationMvtCredit;

    @CsvBindByName(column = "ratio_solde_moyen_fc")
    private double rationSoldeMoyenFC;


    @CsvBindByName(column = "iar_cdr")
    private String iarCentralDesRisquesCDR;

    @CsvBindByName(column = "variation_engagement_cdr")
    private double variationEngagementCDR;


    @CsvBindByName(column = "mnt_credit_treso_cdr")
    private double mntCreditTresorerieCDR;


    @CsvBindByName(column = "variation_credit_treso_cdr")
    private double variationCreditTresoCDR;


    @CsvBindByName(column = "incident")
    private String incident;

    @CsvBindByName(column = "modele_applicable")
    private String modeleApplicable;

    @CsvBindByName(column = "autres_information")
    private String autresInformation;

    @CsvBindByName(column = "commentaire")
    private String commentaire;


    @CsvBindByName(column = "variable_libre_1")
    private String variableLibre1;

    @CsvBindByName(column = "variable_libre_2")
    private String variableLibre2;

    @CsvBindByName(column = "variable_libre_3")
    private String variableLibre3;

    @CsvBindByName(column = "variable_libre_4")
    private String variableLibre4;

    @CsvBindByName(column = "variable_libre_5")
    private String variableLibre5;

    @CsvBindByName(column = "variable_libre_6")
    private String variableLibre6;

    @CsvBindByName(column = "variable_libre_7")
    private String variableLibre7;

    public long getCodeRelation() {
        return codeRelation;
    }

    public void setCodeRelation(long codeRelation) {
        this.codeRelation = codeRelation;
    }

    public String getDateDeSituation() {
        return dateDeSituation;
    }

    public void setDateDeSituation(String dateDeSituation) {
        this.dateDeSituation = dateDeSituation;
    }

    public String getNumeroComptePrincipal() {
        return numeroComptePrincipal;
    }

    public void setNumeroComptePrincipal(String numeroComptePrincipal) {
        this.numeroComptePrincipal = numeroComptePrincipal;
    }

    public String getConsolidationInterne() {
        return consolidationInterne;
    }

    public void setConsolidationInterne(String consolidationInterne) {
        this.consolidationInterne = consolidationInterne;
    }

    public double getMntEnConsolidation() {
        return mntEnConsolidation;
    }

    public void setMntEnConsolidation(double mntEnConsolidation) {
        this.mntEnConsolidation = mntEnConsolidation;
    }

    public double getEncoursCT() {
        return encoursCT;
    }

    public void setEncoursCT(double encoursCT) {
        this.encoursCT = encoursCT;
    }

    public double getEncoursMT() {
        return encoursMT;
    }

    public void setEncoursMT(double encoursMT) {
        this.encoursMT = encoursMT;
    }

    public double getEncoursCreditTresorerie() {
        return encoursCreditTresorerie;
    }

    public void setEncoursCreditTresorerie(double encoursCreditTresorerie) {
        this.encoursCreditTresorerie = encoursCreditTresorerie;
    }

    public double getRatioEngagementCDR() {
        return ratioEngagementCDR;
    }

    public void setRatioEngagementCDR(double ratioEngagementCDR) {
        this.ratioEngagementCDR = ratioEngagementCDR;
    }

    public String getConsolidationAutresBanques() {
        return consolidationAutresBanques;
    }

    public void setConsolidationAutresBanques(String consolidationAutresBanques) {
        this.consolidationAutresBanques = consolidationAutresBanques;
    }

    public String getBesoinAccompagnement() {
        return besoinAccompagnement;
    }

    public void setBesoinAccompagnement(String besoinAccompagnement) {
        this.besoinAccompagnement = besoinAccompagnement;
    }

    public String getBesoinFinancement() {
        return besoinFinancement;
    }

    public void setBesoinFinancement(String besoinFinancement) {
        this.besoinFinancement = besoinFinancement;
    }

    public String getTrancheEffectif() {
        return trancheEffectif;
    }

    public void setTrancheEffectif(String trancheEffectif) {
        this.trancheEffectif = trancheEffectif;
    }

    public int getNombreClients() {
        return nombreClients;
    }

    public void setNombreClients(int nombreClients) {
        this.nombreClients = nombreClients;
    }

    public String getEtatDuResultat() {
        return etatDuResultat;
    }

    public void setEtatDuResultat(String etatDuResultat) {
        this.etatDuResultat = etatDuResultat;
    }

    public String getTailleBesoinFutur() {
        return tailleBesoinFutur;
    }

    public void setTailleBesoinFutur(String tailleBesoinFutur) {
        this.tailleBesoinFutur = tailleBesoinFutur;
    }

    public String getClasseBanqueCentrale() {
        return classeBanqueCentrale;
    }

    public void setClasseBanqueCentrale(String classeBanqueCentrale) {
        this.classeBanqueCentrale = classeBanqueCentrale;
    }

    public String getAnneeClassificationCentrale() {
        return anneeClassificationCentrale;
    }

    public void setAnneeClassificationCentrale(String anneeClassificationCentrale) {
        this.anneeClassificationCentrale = anneeClassificationCentrale;
    }

    public String getRatingActuelleLegacy() {
        return ratingActuelleLegacy;
    }

    public void setRatingActuelleLegacy(String ratingActuelleLegacy) {
        this.ratingActuelleLegacy = ratingActuelleLegacy;
    }

    public String getClasseRisqueLegacy() {
        return classeRisqueLegacy;
    }

    public void setClasseRisqueLegacy(String classeRisqueLegacy) {
        this.classeRisqueLegacy = classeRisqueLegacy;
    }

    public int getScoreClientLegacy() {
        return scoreClientLegacy;
    }

    public void setScoreClientLegacy(int scoreClientLegacy) {
        this.scoreClientLegacy = scoreClientLegacy;
    }

    public String getDateRatingLegacy() {
        return dateRatingLegacy;
    }

    public void setDateRatingLegacy(String dateRatingLegacy) {
        this.dateRatingLegacy = dateRatingLegacy;
    }

    public String getImpaye() {
        return impaye;
    }

    public void setImpaye(String impaye) {
        this.impaye = impaye;
    }

    public double getMontantImpayes() {
        return montantImpayes;
    }

    public void setMontantImpayes(double montantImpayes) {
        this.montantImpayes = montantImpayes;
    }

    public double getRatioImpayesEngagements() {
        return ratioImpayesEngagements;
    }

    public void setRatioImpayesEngagements(double ratioImpayesEngagements) {
        this.ratioImpayesEngagements = ratioImpayesEngagements;
    }

    public int getAncienneteImpayes() {
        return ancienneteImpayes;
    }

    public void setAncienneteImpayes(int ancienneteImpayes) {
        this.ancienneteImpayes = ancienneteImpayes;
    }

    public double getMouvementsTotauxAnneeN() {
        return mouvementsTotauxAnneeN;
    }

    public void setMouvementsTotauxAnneeN(double mouvementsTotauxAnneeN) {
        this.mouvementsTotauxAnneeN = mouvementsTotauxAnneeN;
    }

    public double getMouvementsTotauxAnneeN1() {
        return mouvementsTotauxAnneeN1;
    }

    public void setMouvementsTotauxAnneeN1(double mouvementsTotauxAnneeN1) {
        this.mouvementsTotauxAnneeN1 = mouvementsTotauxAnneeN1;
    }

    public double getMouvementCreditieurAnneeN() {
        return mouvementCreditieurAnneeN;
    }

    public void setMouvementCreditieurAnneeN(double mouvementCreditieurAnneeN) {
        this.mouvementCreditieurAnneeN = mouvementCreditieurAnneeN;
    }

    public double getMouvementCreditieurAnneeN1() {
        return mouvementCreditieurAnneeN1;
    }

    public void setMouvementCreditieurAnneeN1(double mouvementCreditieurAnneeN1) {
        this.mouvementCreditieurAnneeN1 = mouvementCreditieurAnneeN1;
    }

    public double getMouvementDebiteurAnneeN() {
        return mouvementDebiteurAnneeN;
    }

    public void setMouvementDebiteurAnneeN(double mouvementDebiteurAnneeN) {
        this.mouvementDebiteurAnneeN = mouvementDebiteurAnneeN;
    }

    public double getMouvementDebiteurAnneeN1() {
        return mouvementDebiteurAnneeN1;
    }

    public void setMouvementDebiteurAnneeN1(double mouvementDebiteurAnneeN1) {
        this.mouvementDebiteurAnneeN1 = mouvementDebiteurAnneeN1;
    }

    public double getRatioCreditSoldeMoyen() {
        return ratioCreditSoldeMoyen;
    }

    public void setRatioCreditSoldeMoyen(double ratioCreditSoldeMoyen) {
        this.ratioCreditSoldeMoyen = ratioCreditSoldeMoyen;
    }

    public String getRegulariteEcheances() {
        return regulariteEcheances;
    }

    public void setRegulariteEcheances(String regulariteEcheances) {
        this.regulariteEcheances = regulariteEcheances;
    }

    public double getDernierSalaireYTD() {
        return dernierSalaireYTD;
    }

    public void setDernierSalaireYTD(double dernierSalaireYTD) {
        this.dernierSalaireYTD = dernierSalaireYTD;
    }

    public double getSoldeMoyenAnnuelAnneeN() {
        return soldeMoyenAnnuelAnneeN;
    }

    public void setSoldeMoyenAnnuelAnneeN(double soldeMoyenAnnuelAnneeN) {
        this.soldeMoyenAnnuelAnneeN = soldeMoyenAnnuelAnneeN;
    }

    public double getSoldeMoyenAnnuelAnneeN1() {
        return soldeMoyenAnnuelAnneeN1;
    }

    public void setSoldeMoyenAnnuelAnneeN1(double soldeMoyenAnnuelAnneeN1) {
        this.soldeMoyenAnnuelAnneeN1 = soldeMoyenAnnuelAnneeN1;
    }

    public double getTotalCreancesGLE() {
        return totalCreancesGLE;
    }

    public void setTotalCreancesGLE(double totalCreancesGLE) {
        this.totalCreancesGLE = totalCreancesGLE;
    }

    public double getVariationAnnuelleMvtCreditAnneeN() {
        return variationAnnuelleMvtCreditAnneeN;
    }

    public void setVariationAnnuelleMvtCreditAnneeN(double variationAnnuelleMvtCreditAnneeN) {
        this.variationAnnuelleMvtCreditAnneeN = variationAnnuelleMvtCreditAnneeN;
    }

    public double getVariationAnnuelleMvtCreditAnneeN1() {
        return variationAnnuelleMvtCreditAnneeN1;
    }

    public void setVariationAnnuelleMvtCreditAnneeN1(double variationAnnuelleMvtCreditAnneeN1) {
        this.variationAnnuelleMvtCreditAnneeN1 = variationAnnuelleMvtCreditAnneeN1;
    }

    public double getVariationMvtCredit() {
        return variationMvtCredit;
    }

    public void setVariationMvtCredit(double variationMvtCredit) {
        this.variationMvtCredit = variationMvtCredit;
    }

    public double getRationSoldeMoyenFC() {
        return rationSoldeMoyenFC;
    }

    public void setRationSoldeMoyenFC(double rationSoldeMoyenFC) {
        this.rationSoldeMoyenFC = rationSoldeMoyenFC;
    }

    public String getIarCentralDesRisquesCDR() {
        return iarCentralDesRisquesCDR;
    }

    public void setIarCentralDesRisquesCDR(String iarCentralDesRisquesCDR) {
        this.iarCentralDesRisquesCDR = iarCentralDesRisquesCDR;
    }

    public double getVariationEngagementCDR() {
        return variationEngagementCDR;
    }

    public void setVariationEngagementCDR(double variationEngagementCDR) {
        this.variationEngagementCDR = variationEngagementCDR;
    }

    public double getMntCreditTresorerieCDR() {
        return mntCreditTresorerieCDR;
    }

    public void setMntCreditTresorerieCDR(double mntCreditTresorerieCDR) {
        this.mntCreditTresorerieCDR = mntCreditTresorerieCDR;
    }

    public double getVariationCreditTresoCDR() {
        return variationCreditTresoCDR;
    }

    public void setVariationCreditTresoCDR(double variationCreditTresoCDR) {
        this.variationCreditTresoCDR = variationCreditTresoCDR;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getModeleApplicable() {
        return modeleApplicable;
    }

    public void setModeleApplicable(String modeleApplicable) {
        this.modeleApplicable = modeleApplicable;
    }

    public String getAutresInformation() {
        return autresInformation;
    }

    public void setAutresInformation(String autresInformation) {
        this.autresInformation = autresInformation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getVariableLibre1() {
        return variableLibre1;
    }

    public void setVariableLibre1(String variableLibre1) {
        this.variableLibre1 = variableLibre1;
    }

    public String getVariableLibre2() {
        return variableLibre2;
    }

    public void setVariableLibre2(String variableLibre2) {
        this.variableLibre2 = variableLibre2;
    }

    public String getVariableLibre3() {
        return variableLibre3;
    }

    public void setVariableLibre3(String variableLibre3) {
        this.variableLibre3 = variableLibre3;
    }

    public String getVariableLibre4() {
        return variableLibre4;
    }

    public void setVariableLibre4(String variableLibre4) {
        this.variableLibre4 = variableLibre4;
    }

    public String getVariableLibre5() {
        return variableLibre5;
    }

    public void setVariableLibre5(String variableLibre5) {
        this.variableLibre5 = variableLibre5;
    }

    public String getVariableLibre6() {
        return variableLibre6;
    }

    public void setVariableLibre6(String variableLibre6) {
        this.variableLibre6 = variableLibre6;
    }

    public String getVariableLibre7() {
        return variableLibre7;
    }

    public void setVariableLibre7(String variableLibre7) {
        this.variableLibre7 = variableLibre7;
    }
}
