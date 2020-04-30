package hr.tvz.stankovic.studapp;

public class StudentDTO {
    String jmbag;
    int ectsCount;
    boolean needsToPay;

    public StudentDTO(String jmbag, int ectsCount, boolean needsToPay) {
        this.jmbag = jmbag;
        this.ectsCount = ectsCount;
        this.needsToPay = needsToPay;
    }

    public String getJMBAG() {
        return jmbag;
    }

    public Integer getNumberOfECTS() {
        return ectsCount;
    }

    public boolean isTuitionShouldBePaid() {
        return needsToPay;
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "JMBAG='" + jmbag + '\'' +
                ", numberOfECTS=" + ectsCount +
                ", tuitionShouldBePaid=" + needsToPay +
                '}';
    }
}
