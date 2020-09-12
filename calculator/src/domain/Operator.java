package domain;

import enums.Opeators;

/**
 * Classe que representa uma operacao.
 *
 * @author Rodrigo Andrade
 */
public class Operator {

    private String name;
    private Opeators denitionNumber;
    private String simbol;

    public Operator(String name, Opeators denitionNumber, String simbol) {
        this.name = name;
        this.denitionNumber = denitionNumber;
        this.simbol = simbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Opeators getDenitionNumber() {
        return denitionNumber;
    }

    public void setDenitionNumber(Opeators denitionNumber) {
        this.denitionNumber = denitionNumber;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
