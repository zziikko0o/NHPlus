package model;


public class Caregiver extends Person{
    private long pId;
    private String Telephone;

    public Caregiver(String firstname, String surname, String Telephone){
        super(firstname, surname);
        this.Telephone = Telephone;
    }

    public Caregiver(long pId, String firstname, String surname, String Telephone){
        super(firstname, surname);
        this.pId = pId;
        this.Telephone = Telephone;
    }

    public long getPid() {
        return pId;
    }

    public String getTelephone(){
        return Telephone;
    }

    public void setTelephone(String Telephone){
        this.Telephone = Telephone;
    }

    public String toString() {
        return "Caregiver" + "\nMNID: " + this.pId +
                "\nFirstname: " + this.getFirstName() +
                "\nSurname: " + this.getSurname() +
                "\nTelephone: " + this.Telephone +
                "\n";
    }

    public String labelTreatmentView() {
        return this.getFirstName() + " " + this.getSurname() + " " + this.Telephone;
    }

}