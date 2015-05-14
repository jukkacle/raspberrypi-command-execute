package com.vypeensoft.raspberrypi_command_execute;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.content.Context;
 
 
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.ByteArrayOutputStream;

import com.jcraft.jsch.*;

public class MainActivity extends Activity {

  OnClickListener listener1 = null;
  Button button01;
  Button button02;
  Button button03;
  Button button04;
  Button button05;
  Button button06;
  Button button07;
  Button button08;
  Button button09;
  Button button10;
  Button button11;
  Button button12;
  Button button13;
  Button button14;
  Button button15;
  Button button16;
  Button button17;
  Button button18;
  Button button19;
  Button button20;
  List<Button> buttonList = new ArrayList();
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    listener1 = new OnClickListener() {
      public void onClick(View v) {
        int id = v.getId();
        setTitle("button_" + (id+id));
        try {
            //executeRemoteCommand("pi","password","192.168.1.10",22);
            List<String> list = FileUtil.readFileContentsAsStringList(MainActivity.this, getString(R.string.command_file_name));
            setTitle("1");

            Command currentCommand = null;
            for (int i = 0; i < list.size(); i++) {
            setTitle("2=="+i);
                String oneLine = list.get(i);
                Command co = new Command(oneLine);
                setTitle("3=="+co.id +","+id);
                if(co.id == id) {
                    setTitle("4");
                    currentCommand = co;
                }
            }
            if(true) throw new RuntimeException("Shibu");
            setTitle("button_" + currentCommand.commandString);
            showToast("button_" + currentCommand.commandString);
        } catch(Exception e) {
            //setTitle("error");
            showToast("error="+e.getMessage());
        }
      }
    };

    setContentView(R.layout.main);
    try { 

        button01 = (Button) findViewById(R.id.button01);    button01.setOnClickListener(listener1);    button01.setVisibility(View.INVISIBLE);    buttonList.add(button01);
        button02 = (Button) findViewById(R.id.button02);    button02.setOnClickListener(listener1);    button02.setVisibility(View.INVISIBLE);    buttonList.add(button02);
        button03 = (Button) findViewById(R.id.button03);    button03.setOnClickListener(listener1);    button03.setVisibility(View.INVISIBLE);    buttonList.add(button03);
        button04 = (Button) findViewById(R.id.button04);    button04.setOnClickListener(listener1);    button04.setVisibility(View.INVISIBLE);    buttonList.add(button04);
        button05 = (Button) findViewById(R.id.button05);    button05.setOnClickListener(listener1);    button05.setVisibility(View.INVISIBLE);    buttonList.add(button05);
        button06 = (Button) findViewById(R.id.button06);    button06.setOnClickListener(listener1);    button06.setVisibility(View.INVISIBLE);    buttonList.add(button06);
        button07 = (Button) findViewById(R.id.button07);    button07.setOnClickListener(listener1);    button07.setVisibility(View.INVISIBLE);    buttonList.add(button07);
        button08 = (Button) findViewById(R.id.button08);    button08.setOnClickListener(listener1);    button08.setVisibility(View.INVISIBLE);    buttonList.add(button08);
        button09 = (Button) findViewById(R.id.button09);    button09.setOnClickListener(listener1);    button09.setVisibility(View.INVISIBLE);    buttonList.add(button09);
        button10 = (Button) findViewById(R.id.button10);    button10.setOnClickListener(listener1);    button10.setVisibility(View.INVISIBLE);    buttonList.add(button10);
        //button11 = (Button) findViewById(R.id.button11);    button11.setOnClickListener(listener1);    button11.setVisibility(View.INVISIBLE);    buttonList.add(button11);
        //button12 = (Button) findViewById(R.id.button12);    button12.setOnClickListener(listener1);    button12.setVisibility(View.INVISIBLE);    buttonList.add(button12);
        //button13 = (Button) findViewById(R.id.button13);    button13.setOnClickListener(listener1);    button13.setVisibility(View.INVISIBLE);    buttonList.add(button13);
        //button14 = (Button) findViewById(R.id.button14);    button14.setOnClickListener(listener1);    button14.setVisibility(View.INVISIBLE);    buttonList.add(button14);
        //button15 = (Button) findViewById(R.id.button15);    button15.setOnClickListener(listener1);    button15.setVisibility(View.INVISIBLE);    buttonList.add(button15);
        //button16 = (Button) findViewById(R.id.button16);    button16.setOnClickListener(listener1);    button16.setVisibility(View.INVISIBLE);    buttonList.add(button16);
        //button17 = (Button) findViewById(R.id.button17);    button17.setOnClickListener(listener1);    button17.setVisibility(View.INVISIBLE);    buttonList.add(button17);
        //button18 = (Button) findViewById(R.id.button18);    button18.setOnClickListener(listener1);    button18.setVisibility(View.INVISIBLE);    buttonList.add(button18);
        //button19 = (Button) findViewById(R.id.button19);    button19.setOnClickListener(listener1);    button19.setVisibility(View.INVISIBLE);    buttonList.add(button19);
        //button20 = (Button) findViewById(R.id.button20);    button20.setOnClickListener(listener1);    button20.setVisibility(View.INVISIBLE);    buttonList.add(button20);

        /////////////////////////////////////////////////////////////////////////////////////
        String oneLine1 = "";
        oneLine1 = "|1|Rasp 1 - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh";
        FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name), oneLine1);

        oneLine1 = "|2|Rasp 2|/home/pi/Deluge_restart.sh";
        FileUtil.appendStringToFile(this, getString(R.string.command_file_name), oneLine1);

        oneLine1 = "|3|Rasp 3|/home/pi/Curl_restart.sh";
        FileUtil.appendStringToFile(this, getString(R.string.command_file_name), oneLine1);

        oneLine1 = "|4|Rasp 4|/home/pi/Curl_restart.sh";
        FileUtil.appendStringToFile(this, getString(R.string.command_file_name), oneLine1);

        oneLine1 = "|5|Rasp 5|/home/pi/Curl_restart.sh";
        FileUtil.appendStringToFile(this, getString(R.string.command_file_name), oneLine1);
        /////////////////////////////////////////////////////////////////////////////////////
        
        List<String> list = FileUtil.readFileContentsAsStringList(this, getString(R.string.command_file_name));

        for (int i = 0; i < list.size(); i++) {
            String oneLine = list.get(i);
            Command co = new Command(oneLine);
            Button currentButton = buttonList.get(i);
            currentButton.setVisibility(View.VISIBLE);
            currentButton.setId(co.id);
            currentButton.setText(co.label);
        }
       setTitle("file write true" );
    } catch (Exception ioe) {
        ioe.printStackTrace();
        setTitle("file write false" );
    }
    

  } //end of onCreate()
  
  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

     public static String executeRemoteCommand(String username,String password,String hostname,int port) throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, hostname, port);
        session.setPassword(password);

        // Avoid asking for key confirmation
        Properties prop = new Properties();
        prop.put("StrictHostKeyChecking", "no");
        session.setConfig(prop);

        session.connect();

        // SSH Channel
        ChannelExec channelssh = (ChannelExec) session.openChannel("exec");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        channelssh.setOutputStream(baos);

        //Execute command
        channelssh.setCommand("/home/pi/rasp_test.sh");
        channelssh.connect();
        channelssh.disconnect();

        return baos.toString();
    }  
    
    public void showToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
   }
    
}