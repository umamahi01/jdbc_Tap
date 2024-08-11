package com.foodapp.model;

public class Resturant {
    private int resturant_Id;
    private String resturant_Name;
    private String cuisineType;
    private int deliveredTime;
    private String address;
    private int adminUserId;
    private int rating;
    private int  isActive;
    private String imagePath;

    public void setResturantId(int resturant_Id){
        this.resturant_Id = resturant_Id;
    }
    public int getResturant_Id(){
        return resturant_Id;
    }
    public void setResturnatName(String resturant_Name){
        this.resturant_Name = resturant_Name;
    }
    public String  getResturantName(){
        return resturant_Name;
    }
    public void setcuisineType(String cuisineType){
        this.cuisineType = cuisineType;
    }
    public String getCuisineType(){
        return cuisineType;
    }
    public void  setDeliveredTime(int deliveredTime){
        this.deliveredTime = deliveredTime;
    }
    public int getDeliveredTime(){
        return deliveredTime;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;

    }
    public void setAdminUSerId(int adminUserId){
        this.adminUserId = adminUserId;
    }
    public int getAdminUserId(){
        return adminUserId;

    }
    public void setRating(int rating){
        this.rating = rating;
    }
    public int gatRating(){
        return rating;
    }
    public void setIsActive(int isActive){
        this.isActive = isActive;
    }
    public int getIsActive(){
        return isActive;
    }
    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    
    }
    public String getImagePath(){
        return imagePath;
    }

    Resturant(){

    }
    Resturant(int resturant_Id,String resturant_Name,String cuisineType,int deliveredTime,String address,int adminUserId,int rating,int  isActive,String imagePath){
        this.resturant_Id = resturant_Id;
        this.resturant_Name = resturant_Name;
        this.cuisineType = cuisineType;
        this.deliveredTime= deliveredTime;
        this.address =address;
        this.adminUserId = adminUserId;
        this.rating = rating;
        this.isActive = isActive;
        this.imagePath = imagePath;
    }

    public String toString(){
        return "Resturant [ resturant_id = "+ this.resturant_Id+"resturnat_name = "+this.resturant_Name+ "cuisinType = "+this.cuisineType+"deliveredTime = " +this.deliveredTime+
                "Address = "+this.address+"adminUserId = "+this.adminUserId+"rating = "+this.rating+" isActive = "+this.isActive+"ImagePath = "+this.imagePath+" ]";
    }


}
