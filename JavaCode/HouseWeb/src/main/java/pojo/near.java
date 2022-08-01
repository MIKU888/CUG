package pojo;

public class near {
    private String nearclass;
    private String nearName;
    private String communame;

    public String getNearName() {
        return nearName;
    }

    public String getNearclass() {
        return nearclass;
    }

    public void setNearclass(String nearclass) {
        this.nearclass = nearclass;
    }

    public void setNearName(String nearName) {
        this.nearName = nearName;
    }

    public String getCommuname() {
        return communame;
    }

    public void setCommuname(String communame) {
        this.communame = communame;
    }

    @Override
    public String toString() {
        return "near{" +
                "nearclass='" + nearclass + '\'' +
                ", nearName='" + nearName + '\'' +
                ", communame='" + communame + '\'' +
                '}';
    }
}
