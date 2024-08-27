package com.pfe.Bank.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
        import java.util.Date;
@Getter
@Setter
@Entity
@Inheritance(strategy = javax.persistence.InheritanceType.TABLE_PER_CLASS)
public class FinancialData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDeSituation() {
        return dateDeSituation;
    }

    public void setDateDeSituation(Date dateDeSituation) {
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

    public Date getDateRatingLegacy() {
        return dateRatingLegacy;
    }

    public void setDateRatingLegacy(Date dateRatingLegacy) {
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
    public FinancialData(){};
    public FinancialData(Long id, Date dateDeSituation, String numeroComptePrincipal, String consolidationInterne, double mntEnConsolidation, double encoursCT, double encoursMT, double encoursCreditTresorerie, double ratioEngagementCDR, String consolidationAutresBanques, String besoinAccompagnement, String besoinFinancement, String trancheEffectif, int nombreClients, String etatDuResultat, String tailleBesoinFutur, String classeBanqueCentrale, String anneeClassificationCentrale, String ratingActuelleLegacy, String classeRisqueLegacy, int scoreClientLegacy, Date dateRatingLegacy, String impaye, double montantImpayes, double ratioImpayesEngagements, int ancienneteImpayes, double mouvementsTotauxAnneeN, double mouvementsTotauxAnneeN1, double mouvementCreditieurAnneeN, double mouvementCreditieurAnneeN1, double mouvementDebiteurAnneeN, double mouvementDebiteurAnneeN1, double ratioCreditSoldeMoyen, String regulariteEcheances, double dernierSalaireYTD, double soldeMoyenAnnuelAnneeN, double soldeMoyenAnnuelAnneeN1, double totalCreancesGLE, double variationAnnuelleMvtCreditAnneeN, double variationAnnuelleMvtCreditAnneeN1, double variationMvtCredit, double rationSoldeMoyenFC, String iarCentralDesRisquesCDR, double variationEngagementCDR, double mntCreditTresorerieCDR, double variationCreditTresoCDR, String incident, String modeleApplicable, String autresInformation, String commentaire, String variableLibre1, String variableLibre2, String variableLibre3, String variableLibre4, String variableLibre5, String variableLibre6, String variableLibre7) {
        this.id = id;
        this.dateDeSituation = dateDeSituation;
        this.numeroComptePrincipal = numeroComptePrincipal;
        this.consolidationInterne = consolidationInterne;
        this.mntEnConsolidation = mntEnConsolidation;
        this.encoursCT = encoursCT;
        this.encoursMT = encoursMT;
        this.encoursCreditTresorerie = encoursCreditTresorerie;
        this.ratioEngagementCDR = ratioEngagementCDR;
        this.consolidationAutresBanques = consolidationAutresBanques;
        this.besoinAccompagnement = besoinAccompagnement;
        this.besoinFinancement = besoinFinancement;
        this.trancheEffectif = trancheEffectif;
        this.nombreClients = nombreClients;
        this.etatDuResultat = etatDuResultat;
        this.tailleBesoinFutur = tailleBesoinFutur;
        this.classeBanqueCentrale = classeBanqueCentrale;
        this.anneeClassificationCentrale = anneeClassificationCentrale;
        this.ratingActuelleLegacy = ratingActuelleLegacy;
        this.classeRisqueLegacy = classeRisqueLegacy;
        this.scoreClientLegacy = scoreClientLegacy;
        this.dateRatingLegacy = dateRatingLegacy;
        this.impaye = impaye;
        this.montantImpayes = montantImpayes;
        this.ratioImpayesEngagements = ratioImpayesEngagements;
        this.ancienneteImpayes = ancienneteImpayes;
        this.mouvementsTotauxAnneeN = mouvementsTotauxAnneeN;
        this.mouvementsTotauxAnneeN1 = mouvementsTotauxAnneeN1;
        this.mouvementCreditieurAnneeN = mouvementCreditieurAnneeN;
        this.mouvementCreditieurAnneeN1 = mouvementCreditieurAnneeN1;
        this.mouvementDebiteurAnneeN = mouvementDebiteurAnneeN;
        this.mouvementDebiteurAnneeN1 = mouvementDebiteurAnneeN1;
        this.ratioCreditSoldeMoyen = ratioCreditSoldeMoyen;
        this.regulariteEcheances = regulariteEcheances;
        this.dernierSalaireYTD = dernierSalaireYTD;
        this.soldeMoyenAnnuelAnneeN = soldeMoyenAnnuelAnneeN;
        this.soldeMoyenAnnuelAnneeN1 = soldeMoyenAnnuelAnneeN1;
        this.totalCreancesGLE = totalCreancesGLE;
        this.variationAnnuelleMvtCreditAnneeN = variationAnnuelleMvtCreditAnneeN;
        this.variationAnnuelleMvtCreditAnneeN1 = variationAnnuelleMvtCreditAnneeN1;
        this.variationMvtCredit = variationMvtCredit;
        this.rationSoldeMoyenFC = rationSoldeMoyenFC;
        this.iarCentralDesRisquesCDR = iarCentralDesRisquesCDR;
        this.variationEngagementCDR = variationEngagementCDR;
        this.mntCreditTresorerieCDR = mntCreditTresorerieCDR;
        this.variationCreditTresoCDR = variationCreditTresoCDR;
        this.incident = incident;
        this.modeleApplicable = modeleApplicable;
        this.autresInformation = autresInformation;
        this.commentaire = commentaire;
        this.variableLibre1 = variableLibre1;
        this.variableLibre2 = variableLibre2;
        this.variableLibre3 = variableLibre3;
        this.variableLibre4 = variableLibre4;
        this.variableLibre5 = variableLibre5;
        this.variableLibre6 = variableLibre6;
        this.variableLibre7 = variableLibre7;
    }
}
