/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 * @since 06/03/2022 (mm/dd/yyyy)
 * @author Admin
 */
public class Student {
    private String ID;
    private String fullName;
    private boolean isMale;
    private double pT;
    private double ass;
    private double wS;
    private double pE;
    private double fE;

    /**
     * @return String return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return String return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return boolean return the isMale
     */
    public boolean isIsMale() {
        return isMale;
    }

    /**
     * @param isMale the isMale to set
     */
    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    /**
     * @return double return the pT
     */
    public double getPT() {
        return pT;
    }

    /**
     * @param pT the pT to set
     */
    public void setPT(double pT) {
        this.pT = pT;
    }

    /**
     * @return double return the ass
     */
    public double getAss() {
        return ass;
    }

    /**
     * @param ass the ass to set
     */
    public void setAss(double ass) {
        this.ass = ass;
    }

    /**
     * @return double return the wS
     */
    public double getWS() {
        return wS;
    }

    /**
     * @param wS the wS to set
     */
    public void setWS(double wS) {
        this.wS = wS;
    }

    /**
     * @return double return the pE
     */
    public double getPE() {
        return pE;
    }

    /**
     * @param pE the pE to set
     */
    public void setPE(double pE) {
        this.pE = pE;
    }

    /**
     * @return double return the fE
     */
    public double getFE() {
        return fE;
    }

    /**
     * @param fE the fE to set
     */
    public void setFE(double fE) {
        this.fE = fE;
    }

    public Student(String ID, String fullName, boolean isMale, double pT, double wS, double pE, double fE, double Ass) {
        this.ID = ID;
        this.fullName = fullName;
        this.isMale = isMale;
        this.pT = pT;
        this.wS = wS;
        this.pE = pE;
        this.fE = fE;
        this.Ass = Ass;
    }
    
    /**
     * @return true if Student isPassed, false otherwise.
     * {@summary} Result >=5 Final exam>=4 All of other must be grater than 0
     */
    public boolean isPassed()
    {
        if(pT == 0 || pE == 0 || fE == 0 || ass == 0 || wS == 0) return false;
        if(fE < 4) return false;
        if(0.1*(pT+ass+wS) + 0.4 * (pE) + 0.3 * (fE) < 5) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return ID + "\t" + fullName + "\t" + pT + "\t" + ass + "\t" + wS + "\t" + pE + "\t" + fE;
    }

}
