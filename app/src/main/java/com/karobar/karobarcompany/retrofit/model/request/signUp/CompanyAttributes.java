
package com.karobar.karobarcompany.retrofit.model.request.signUp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyAttributes {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("contact_numer")
    @Expose
    private String contactNumer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getContactNumer() {
        return contactNumer;
    }

    public void setContactNumer(String contactNumer) {
        this.contactNumer = contactNumer;
    }

}
