package pojo;

public class housesrc {
    private String district  ;
    private String community ;
    private double building  ;
    private double room      ;  //房号
    private double r_layer   ;  //层高
    private String roomtype  ;  //房型
    private double area      ;  //面积
    private double price     ;  //价格
    private double av_price  ;  //均价
    private String turn      ;  //朝向

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public double getBuilding() {
        return building;
    }

    public void setBuilding(double building) {
        this.building = building;
    }

    public double getRoom() {
        return room;
    }

    public void setRoom(double room) {
        this.room = room;
    }

    public double getR_layer() {
        return r_layer;
    }

    public void setR_layer(double r_layer) {
        this.r_layer = r_layer;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAv_price() {
        return av_price;
    }

    public void setAv_price(double av_price) {
        this.av_price = av_price;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "housesrc{" +
                "district='" + district + '\'' +
                ", community='" + community + '\'' +
                ", building=" + building +
                ", room=" + room +
                ", r_layer=" + r_layer +
                ", roomtype='" + roomtype + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", av_price=" + av_price +
                ", turn='" + turn + '\'' +
                '}';
    }
}
