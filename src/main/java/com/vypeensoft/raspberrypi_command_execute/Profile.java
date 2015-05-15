package com.vypeensoft.raspberrypi_command_execute;

public class Profile {
    public int id;
    public String ipAddress;
    public String port;
    public String userName;
    public String password;

    //=========================================================================================
    public Profile() {
    }
    public Profile(String oneLine) {
        parseLine(oneLine);
    }
    //=========================================================================================
    public void parseLine(String oneLine) {
        try {
            int idPos        = oneLine.indexOf('|');
            int ipAddressPos = oneLine.indexOf('|', idPos+1);
            int portPos      = oneLine.indexOf('|', ipAddressPos+1);
            int userNamePos  = oneLine.indexOf('|', portPos+1);
            int passwordPos  = oneLine.indexOf('|', userNamePos+1);

            if(idPos > -1) {
                id = Integer.valueOf(oneLine.substring(idPos+1, ipAddressPos)).intValue();
            }
            if(ipAddressPos > -1) {
                ipAddress = oneLine.substring(ipAddressPos+1, portPos);
            }
            if(portPos > -1) {
                port = oneLine.substring(portPos+1, userNamePos);
            }
            if(userNamePos > -1) {
                userName = oneLine.substring(userNamePos+1, passwordPos);
            }
            if(passwordPos > -1) {
                password = oneLine.substring(passwordPos+1);
            }
        } catch(Exception e) {
            id=99;
            ipAddress="ipAddresssssss, e="+e.getMessage();
            userName = oneLine;
        }
    }
    //=========================================================================================
    public String convertToLine() {
    	return "|"+id+"|"+ipAddress+"|"+port+"|"+userName+"|"+password;
    }
    //=========================================================================================
    @Override
    public String toString() {
    	return "id="+id+", ipAddress="+ipAddress+", port="+port+", userName="+userName+", password="+password;
    }
    //=========================================================================================
    public static void main(String[] args) {
        Profile p = new Profile("|1|10.10.1.1|22|pi|myPassword");
    }
}
