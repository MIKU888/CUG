package pojo;

public class Adminastrator {
    private String AID;
    private String passwd;

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Adminastrator{" +
                "AID='" + AID + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
