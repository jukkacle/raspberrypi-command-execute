package com.vypeensoft.raspberrypi_command_execute;

public class Command {
    public int id;
    public String label;
    public String commandString;

    //=========================================================================================
    public Command(String oneLine) {
        parseLine(oneLine);
    }
    //=========================================================================================
    public void parseLine(String oneLine) {
        try {
            int idPos = oneLine.indexOf('|');
            int labelPos = oneLine.indexOf('|', idPos+1);
            int commandPos = oneLine.indexOf('|', labelPos+1);

            if(idPos > -1) {
                id = Integer.valueOf(oneLine.substring(idPos+1, labelPos)).intValue();
            }
            if(labelPos > -1) {
                label = oneLine.substring(labelPos+1, commandPos);
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
    @Override
    public String toString() {
    	return "id="+id+", label="+label+", command="+commandString;
    }
    //=========================================================================================
}
