package model;

public class AddressDetails {
    private String doorNo;
    private String street;
    private String city;
    private String district;
    private String state;
    private int pincode;
    private int userId;
    public AddressDetails(String doorNo,String street,String city,String district,String state,int pincode){
        this.doorNo=doorNo;
        this.street=street;
        this.city=city;
        this.district=district;
        this.state=state;
        this.pincode=pincode;
    }
    public AddressDetails(String doorNo,String street,String city,String district,String state,int pincode,int userId){
        this.doorNo=doorNo;
        this.street=street;
        this.city=city;
        this.district=district;
        this.state=state;
        this.pincode=pincode;
        this.userId=userId;
    }
    public String getDoorNo(){return doorNo;}
    public String getStreet(){return street;}
    public String getCity(){return city;}
    public String getDistrict(){return district;}
    public String getState(){return state;}
    public int getPincode(){return pincode;}
    public int getUserId(){return userId;}


}
