/**
 *
 */
package com.civilservice.dto;

/**
 *
 */
public class User {

    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String ip_address;
    private String latitude;
    private String longitude;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ip_address
     */
    public String getIp_address() {
        return ip_address;
    }

    /**
     * @param ip_address the ip_address to set
     */
    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longtitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longtitude the longtitude to set
     */
    public void setLongitude(String longtitude) {
        this.longitude = longtitude;
    }

    @Override
    public String toString() {
        return "User [" + (id != null ? "id=" + id + ", " : "")
                + (first_name != null ? "first_name=" + first_name + ", " : "")
                + (last_name != null ? "last_name=" + last_name + ", " : "")
                + (email != null ? "email=" + email + ", " : "")
                + (ip_address != null ? "ip_address=" + ip_address + ", " : "")
                + (latitude != null ? "latitude=" + latitude + ", " : "")
                + (longitude != null ? "longitude=" + longitude : "") + "]";
    }




}
