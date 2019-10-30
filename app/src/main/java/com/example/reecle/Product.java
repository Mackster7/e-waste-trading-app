package com.example.reecle;

class Product {
    private String name, doorno, street,area,city;

    public Product(){

    }

    public Product(String name, String area, String doorno, String street,String city) {
        this.name = name;
        this.area = area;
        this.doorno = doorno;
        this.street = street;
        this.city =city;
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

}
