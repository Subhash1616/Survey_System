public class Data {
    public String name;
    public String phone;
    public String email;
    public String address;
    public String sex;
    public String Occupation;
    public Data( String s,String s1,String s2,String s3,String s4,String s5) {
        name=s;
        phone=s1;
        email=s2;
        address=s3;
        sex=s4;
        Occupation=s5;
        System.out.println("Object created");
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
