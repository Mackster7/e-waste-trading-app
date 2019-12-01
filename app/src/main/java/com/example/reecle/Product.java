package com.example.reecle;

class Product {
    private String name, doorno, street,area,city,pincode;

    public Product(){

    }

    public Product(String name, String area, String doorno, String street,String city,String pincode) {
        this.name = name;
        this.area = area;
        this.doorno = doorno;
        this.street = street;
        this.city =city;
        this.pincode=pincode;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getStreet() {
        return street;
    }
    public String getDoorno() {
        return doorno;
    }
    public String getCity() {
        return city;
    }
    public String getPincode() {
        return pincode;
    }

}
