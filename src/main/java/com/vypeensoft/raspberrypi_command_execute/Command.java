package com.vypeensoft.raspberrypi_command_execute;

public class Command {
    public int id;
    public String label;
    public String serverProfile;
    public String commandString;

    //=========================================================================================
    public Command() {
    }
    //=========================================================================================
    public Command(String oneLine) {
        parseLine(oneLine);
    }
    //=========================================================================================
    public void parseLine(String oneLine) {
        try {
            int idPos            = oneLine.indexOf('|');
            int labelPos         = oneLine.indexOf('|', idPos+1);
            int serverProfilePos = oneLine.indexOf('|', labelPos+1);
            int commandPos       = oneLine.indexOf('|', serverProfilePos+1);

            if(idPos > -1) {
                id = Integer.valueOf(oneLine.substring(idPos+1, labelPos)).intValue();
            }
            if(labelPos > -1) {
                label = oneLine.substring(labelPos+1, serverProfilePos);
            }
            if(serverProfilePos > -1) {
                serverProfile = oneLine.substring(serverProfilePos+1, commandPos);
            }
            if(commandPos > -1) {
                commandString = oneLine.substring(commandPos+1);
            }
        } catch(Exception e) {
            id=99;
            label="labellll, e="+e.getMessage();
            commandString = oneLine;
        }
    }
    //=========================================================================================
    public static Command createDummyCommand() {
        Command c = new Command();
        c.id            = 1              ;
        c.label         = "My Command Name"  ;
        c.serverProfile = "1"            ;
        c.commandString = "/home/pi/dummy_script.sh";
        return c;
    }
    //=========================================================================================
    @Override
    public String toString() {
    	return "id="+id+", label="+label+", serverProfile="+serverProfile+", command="+commandString;
    }
    //=========================================================================================
    public String convertToLine() {
    	return "|"+id+"|"+label+"|"+serverProfile+"|"+commandString;
    }
    //=========================================================================================
}
