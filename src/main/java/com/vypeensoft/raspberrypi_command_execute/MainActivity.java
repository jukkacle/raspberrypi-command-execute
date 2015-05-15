package com.vypeensoft.raspberrypi_command_execute;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.content.Context;
import android.content.Intent;
import android.widget.PopupWindow;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

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

  private OnClickListener            commandExecuteButtonListener  = null;
  private OnClickListener            commandEditButtonListener     = null;
  private OnMenuItemClickListener    popupMenuClickListener = null;
  private OnClickListener            btnPopupCancelButtonClickListener = null;
  private OnClickListener            editCommandButtonClickListener = null;
  private OnClickListener            profilesButtonClickListener = null;

  private PopupWindow                popupEditMenuWindow;
  private PopupWindow                popupEditCommandWindow;

  //---------------------------------------------------------------------------------------------------------------------
  Button btnProfiles;
  Button btnPopupCancel;
  Button btnEditCommand;
  //---------------------------------------------------------------------------------------------------------------------
  Button button01;     ImageButton imageButton01;
  Button button02;     ImageButton imageButton02;
  Button button03;     ImageButton imageButton03;
  Button button04;     ImageButton imageButton04;
  Button button05;     ImageButton imageButton05;
  Button button06;     ImageButton imageButton06;
  Button button07;     ImageButton imageButton07;
  Button button08;     ImageButton imageButton08;
  Button button09;     ImageButton imageButton09;
  Button button10;     ImageButton imageButton10;
  Button button11;     ImageButton imageButton11;
  Button button12;     ImageButton imageButton12;
  Button button13;     ImageButton imageButton13;
  Button button14;     ImageButton imageButton14;
  Button button15;     ImageButton imageButton15;
  Button button16;     ImageButton imageButton16;
  Button button17;     ImageButton imageButton17;
  Button button18;     ImageButton imageButton18;
  Button button19;     ImageButton imageButton19;
  Button button20;     ImageButton imageButton20;


  List<Button> buttonList = new ArrayList();
  List<ImageButton> imageButtonList = new ArrayList();
  Spinner spinner1;
  //***********************************************************************************************************************//
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //---------------------------------------------------------------------------------------------------------------------
    commandExecuteButtonListener = new OnClickListener() {
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
    //---------------------------------------------------------------------------------------------------------------------
    commandEditButtonListener = new OnClickListener() {
      public void onClick(View v) {
        int id = v.getId();
        setTitle("button_" + id);
        initiateEditPopupWindow();
      }
    };
    //---------------------------------------------------------------------------------------------------------------------
    btnPopupCancelButtonClickListener = new OnClickListener() {
      public void onClick(View v) {
         popupEditMenuWindow.dismiss();
      }
    };
    //---------------------------------------------------------------------------------------------------------------------
    editCommandButtonClickListener = new OnClickListener() {
      public void onClick(View v) {
         initiateEditCommandPopupWindow();
      }
    };
    //---------------------------------------------------------------------------------------------------------------------
    profilesButtonClickListener = new OnClickListener() {
      public void onClick(View v) {
         initiateProfilesPopupWindow();
      }
    };
    //---------------------------------------------------------------------------------------------------------------------

    setContentView(R.layout.main);


    //---------------------------------------------------------------------------------------------------------------------
    btnProfiles = (Button) findViewById(R.id.button_profile);
    showToast("1="+btnProfiles);
    btnProfiles.setOnClickListener(profilesButtonClickListener);
    //---------------------------------------------------------------------------------------------------------------------



    try {

        button01      = (Button)      findViewById(R.id.button01);         button01.setOnClickListener(commandExecuteButtonListener);         button01.setVisibility(View.INVISIBLE);         buttonList.add(button01);
        button02      = (Button)      findViewById(R.id.button02);         button02.setOnClickListener(commandExecuteButtonListener);         button02.setVisibility(View.INVISIBLE);         buttonList.add(button02);
        button03      = (Button)      findViewById(R.id.button03);         button03.setOnClickListener(commandExecuteButtonListener);         button03.setVisibility(View.INVISIBLE);         buttonList.add(button03);
        button04      = (Button)      findViewById(R.id.button04);         button04.setOnClickListener(commandExecuteButtonListener);         button04.setVisibility(View.INVISIBLE);         buttonList.add(button04);
        button05      = (Button)      findViewById(R.id.button05);         button05.setOnClickListener(commandExecuteButtonListener);         button05.setVisibility(View.INVISIBLE);         buttonList.add(button05);
        button06      = (Button)      findViewById(R.id.button06);         button06.setOnClickListener(commandExecuteButtonListener);         button06.setVisibility(View.INVISIBLE);         buttonList.add(button06);
        button07      = (Button)      findViewById(R.id.button07);         button07.setOnClickListener(commandExecuteButtonListener);         button07.setVisibility(View.INVISIBLE);         buttonList.add(button07);
        button08      = (Button)      findViewById(R.id.button08);         button08.setOnClickListener(commandExecuteButtonListener);         button08.setVisibility(View.INVISIBLE);         buttonList.add(button08);
        button09      = (Button)      findViewById(R.id.button09);         button09.setOnClickListener(commandExecuteButtonListener);         button09.setVisibility(View.INVISIBLE);         buttonList.add(button09);
        button10      = (Button)      findViewById(R.id.button10);         button10.setOnClickListener(commandExecuteButtonListener);         button10.setVisibility(View.INVISIBLE);         buttonList.add(button10);
        button11      = (Button)      findViewById(R.id.button11);         button11.setOnClickListener(commandExecuteButtonListener);         button11.setVisibility(View.INVISIBLE);         buttonList.add(button11);
        button12      = (Button)      findViewById(R.id.button12);         button12.setOnClickListener(commandExecuteButtonListener);         button12.setVisibility(View.INVISIBLE);         buttonList.add(button12);
        button13      = (Button)      findViewById(R.id.button13);         button13.setOnClickListener(commandExecuteButtonListener);         button13.setVisibility(View.INVISIBLE);         buttonList.add(button13);
        button14      = (Button)      findViewById(R.id.button14);         button14.setOnClickListener(commandExecuteButtonListener);         button14.setVisibility(View.INVISIBLE);         buttonList.add(button14);
        button15      = (Button)      findViewById(R.id.button15);         button15.setOnClickListener(commandExecuteButtonListener);         button15.setVisibility(View.INVISIBLE);         buttonList.add(button15);
        button16      = (Button)      findViewById(R.id.button16);         button16.setOnClickListener(commandExecuteButtonListener);         button16.setVisibility(View.INVISIBLE);         buttonList.add(button16);
        button17      = (Button)      findViewById(R.id.button17);         button17.setOnClickListener(commandExecuteButtonListener);         button17.setVisibility(View.INVISIBLE);         buttonList.add(button17);
        button18      = (Button)      findViewById(R.id.button18);         button18.setOnClickListener(commandExecuteButtonListener);         button18.setVisibility(View.INVISIBLE);         buttonList.add(button18);
        button19      = (Button)      findViewById(R.id.button19);         button19.setOnClickListener(commandExecuteButtonListener);         button19.setVisibility(View.INVISIBLE);         buttonList.add(button19);
        button20      = (Button)      findViewById(R.id.button20);         button20.setOnClickListener(commandExecuteButtonListener);         button20.setVisibility(View.INVISIBLE);         buttonList.add(button20);

        imageButton01 = (ImageButton) findViewById(R.id.imageButton01);    imageButton01.setOnClickListener(commandEditButtonListener);    imageButton01.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton01);
        imageButton02 = (ImageButton) findViewById(R.id.imageButton02);    imageButton02.setOnClickListener(commandEditButtonListener);    imageButton02.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton02);
        imageButton03 = (ImageButton) findViewById(R.id.imageButton03);    imageButton03.setOnClickListener(commandEditButtonListener);    imageButton03.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton03);
        imageButton04 = (ImageButton) findViewById(R.id.imageButton04);    imageButton04.setOnClickListener(commandEditButtonListener);    imageButton04.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton04);
        imageButton05 = (ImageButton) findViewById(R.id.imageButton05);    imageButton05.setOnClickListener(commandEditButtonListener);    imageButton05.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton05);
        imageButton06 = (ImageButton) findViewById(R.id.imageButton06);    imageButton06.setOnClickListener(commandEditButtonListener);    imageButton06.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton06);
        imageButton07 = (ImageButton) findViewById(R.id.imageButton07);    imageButton07.setOnClickListener(commandEditButtonListener);    imageButton07.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton07);
        imageButton08 = (ImageButton) findViewById(R.id.imageButton08);    imageButton08.setOnClickListener(commandEditButtonListener);    imageButton08.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton08);
        imageButton09 = (ImageButton) findViewById(R.id.imageButton09);    imageButton09.setOnClickListener(commandEditButtonListener);    imageButton09.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton09);
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);    imageButton10.setOnClickListener(commandEditButtonListener);    imageButton10.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton10);
        imageButton11 = (ImageButton) findViewById(R.id.imageButton11);    imageButton11.setOnClickListener(commandEditButtonListener);    imageButton11.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton11);
        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);    imageButton12.setOnClickListener(commandEditButtonListener);    imageButton12.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton12);
        imageButton13 = (ImageButton) findViewById(R.id.imageButton13);    imageButton13.setOnClickListener(commandEditButtonListener);    imageButton13.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton13);
        imageButton14 = (ImageButton) findViewById(R.id.imageButton14);    imageButton14.setOnClickListener(commandEditButtonListener);    imageButton14.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton14);
        imageButton15 = (ImageButton) findViewById(R.id.imageButton15);    imageButton15.setOnClickListener(commandEditButtonListener);    imageButton15.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton15);
        imageButton16 = (ImageButton) findViewById(R.id.imageButton16);    imageButton16.setOnClickListener(commandEditButtonListener);    imageButton16.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton16);
        imageButton17 = (ImageButton) findViewById(R.id.imageButton17);    imageButton17.setOnClickListener(commandEditButtonListener);    imageButton17.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton17);
        imageButton18 = (ImageButton) findViewById(R.id.imageButton18);    imageButton18.setOnClickListener(commandEditButtonListener);    imageButton18.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton18);
        imageButton19 = (ImageButton) findViewById(R.id.imageButton19);    imageButton19.setOnClickListener(commandEditButtonListener);    imageButton19.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton19);
        imageButton20 = (ImageButton) findViewById(R.id.imageButton20);    imageButton20.setOnClickListener(commandEditButtonListener);    imageButton20.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton20);


        /////////////////////////////////////////////////////////////////////////////////////
        String oneLine1 = "";
        oneLine1 = "|1|Rasp 1 - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh";
        int k = 1;
        FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|"+k+"|Rasp " + k++ + " - /home/pi/Youtube/Youtube_restart.sh|/home/pi/Youtube/Youtube_restart.sh");
        /////////////////////////////////////////////////////////////////////////////////////

        List<String> list = FileUtil.readFileContentsAsStringList(this, getString(R.string.command_file_name));

        for (int i = 0; i < list.size(); i++) {
            String oneLine = list.get(i);
            Command co = new Command(oneLine);
            Button currentButton = buttonList.get(i);
            currentButton.setVisibility(View.VISIBLE);
            currentButton.setId(co.id);
            currentButton.setText(co.label);

            ImageButton currentImageButton = imageButtonList.get(i);
            currentImageButton.setVisibility(View.VISIBLE);
            currentImageButton.setId(co.id);

        }
       setTitle("file write true" );
    } catch (Exception ioe) {
        ioe.printStackTrace();
        setTitle("file write false" );
    }


  } //end of onCreate()
  //***********************************************************************************************************************//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu, menu);
        return true;
    }
  //***********************************************************************************************************************//
     public String executeRemoteCommand(String username,String password,String hostname,int port) throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, hostname, port);
        session.setPassword(password);

        // Avoid asking for key confirmation
        Properties prop = new Properties();
        prop.put("StrictHostKeyChecking", "no");
        session.setConfig(prop);
		showToast("1");
        session.connect();
		showToast("2");

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
  //***********************************************************************************************************************//
    public void showToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
   }
  //***********************************************************************************************************************//
    private void initiateEditPopupWindow() {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_edit_menu_window, (ViewGroup) findViewById(R.id.popup_edit_menu_window));
            popupEditMenuWindow = new PopupWindow(layout, 100, 255, true);
            popupEditMenuWindow.setBackgroundDrawable(new BitmapDrawable()); // this line makes the popup window to disappear when clicked outside (or the back button)
            popupEditMenuWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

            btnEditCommand = (Button) layout.findViewById(R.id.btn_popup_edit);
            btnEditCommand.setOnClickListener(editCommandButtonClickListener);

            btnPopupCancel = (Button) layout.findViewById(R.id.btn_popup_cancel);
            btnPopupCancel.setOnClickListener(btnPopupCancelButtonClickListener);

			showToast("dude 2  ");
        } catch (Exception e) {
            e.printStackTrace();
			showToast(e.getMessage());
        }
    }
  //***********************************************************************************************************************//
    private void initiateEditCommandPopupWindow() {
        try {
            if(popupEditMenuWindow != null) {
                popupEditMenuWindow.dismiss();
            }
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_command_edit_window, (ViewGroup) findViewById(R.id.popup_command_edit_window));
            popupEditMenuWindow = new PopupWindow(layout, 300, 250, true);

            String[] daysArray = {"Sunday", "Monday", "Tuesday", "Wednesday"};
            spinner1 = (Spinner) layout.findViewById(R.id.server_profile_spinner);
            ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item,daysArray);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter);

            popupEditMenuWindow.setBackgroundDrawable(new BitmapDrawable()); // this line makes the popup window to disappear when clicked outside (or the back button)
            popupEditMenuWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);


            //btnPopupCancel = (Button) layout.findViewById(R.id.btn_popup_cancel);
            //btnPopupCancel.setOnClickListener(btnPopupCancelButtonClickListener);
			showToast("india 1  ");
        } catch (Exception e) {
            //e.printStackTrace();
			//showToast(e.getMessage());
        }
    }
  //***********************************************************************************************************************//
  private void initiateProfilesPopupWindow() {
    Intent s = new Intent(MainActivity.this, ProfileActivity.class);
    this.startActivity(s);
  }
}