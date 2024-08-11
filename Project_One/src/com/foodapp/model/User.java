package com.foodapp.model;

public class User {
    private int user_id ;
    private String userName;
    private String password;
    private String email;
    private String address;
    private String role;
    private String createDate;
    private String lastLoginDate;
    User(){
    }
    User(int user_id,String userName,String password,String email,String address,String role,String createDate,String lastLoginDate){
        this.user_id = user_id;
        this.userName = userName;
        this.password =password;
        this.email = email;
        this.address = address;
        this.role = role;
        this.createDate = createDate;
        this.lastLoginDate = lastLoginDate;

    }
     public void  setUserId(int user_id){
        this.user_id = user_id;
     }
     public int getUSerId(){
        return user_id;
     }
     public void setUserName(String userName){
        this.userName = userName;
     }
     public String getUserName(){
        return userName;
     }
     public void setPassword(String password){
        this.password = password;
     }
     public String getPassword(){
        return password;
     }
     public void setEmail(String email){
        this.email = email;
     }
     public String getEmail(){
        return email;
     }
     public void setAdress(String address){
        this.address = address;
     }
     public String getAddress(){
        return address;
     }
     public void setRole(String role){
        this.role = role;
     }
     public String getRole(){
        return role;
     }

     public void setDate(String createDate){
        this.createDate = createDate;
     }
     public String getDate(){
        return createDate;
     }
     public void setLastLoginDate(String lastLoginDate){
        this.lastLoginDate = lastLoginDate;
     }
     public String lastLoginDate(){
        return lastLoginDate;
     }
    /**how to overide toString method */
    
    public String toString(){
        return "User [user_id = "+this.user_id +" , user_Name = "+this.userName+" , password = "
                +this.password+" , email = "+this.email+" ,address = "+this.address+" ,role ="
                + this.role+" ,date ="+this.createDate+ " ,lastLoginDate ="+ this.lastLoginDate+ " ]";
    }
    
    
    }
   
