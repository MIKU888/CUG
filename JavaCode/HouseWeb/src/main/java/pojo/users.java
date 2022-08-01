package pojo;

public class users {
    private String ID       ;
    private String passw    ;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    @Override
    public String toString() {
        return "users{" +
                "ID='" + ID + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }
}
