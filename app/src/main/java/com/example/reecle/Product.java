package com.example.reecle;

class Product {
    private String name, doorno, street,area,city,pincode,category,brand,price;

    public Product(){

    }

    public Product(String name, String area, String doorno, String street,String city,String pincode,String category,String brand,String price) {
        this.name = name;
        this.area = area;
        this.doorno = doorno;
        this.street = street;
        this.city =city;
        this.pincode=pincode;
        this.category=category;
        this.brand=brand;
        this.price=price;
    }

    public String getname() {
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
    public String getcategory() {
        return category;
    }
    public String getbrand() {
        return brand;
    }
    public String getprice() {
        return price;
    }

}
