package com.vypeensoft.raspberrypi_command_execute;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
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
import android.content.Context;
import android.widget.EditText;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
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
import java.io.StringWriter;
import java.io.PrintWriter;

import com.jcraft.jsch.*;

public class MainActivity extends Activity {
  private String LOG_FILE_NAME       = "rasp_execute.log.txt";
  private OnClickListener            commandExecuteButtonListener  = null;
  private OnClickListener            commandEditButtonListener     = null;
  private OnMenuItemClickListener    popupMenuClickListener = null;
  private OnClickListener            btnPopupCancelButtonClickListener = null;
  private OnClickListener            editCommandButtonClickListener = null;
  private OnClickListener            profilesButtonClickListener = null;
  private OnClickListener            exitCommandButtonListener = null;

  private PopupWindow                popupEditMenuWindow;
  private PopupWindow                popupEditCommandWindow;

  //---------------------------------------------------------------------------------------------------------------------
  Button btnProfiles;
  Button btnExit;
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
        try {
            List<String> list = FileUtil.readFileContentsAsStringList(MainActivity.this, getString(R.string.command_file_name));
            list = FileUtil.removeBlanks(list);
            Command currentCommand = null;
            for (int i = 0; i < list.size(); i++) {
                String oneLine = list.get(i);
                Command co = new Command(oneLine);
                if(co.id == id) {
                    currentCommand = co;
                }
            }
            
            list = FileUtil.readFileContentsAsStringList(MainActivity.this, getString(R.string.profile_file_name));
            list = FileUtil.removeBlanks(list);
            Profile currentProfile = null;
            for (int i = 0; i < list.size(); i++) {
                String oneLine = list.get(i);
                Profile co = new Profile(oneLine);
                if(co.id == Integer.valueOf((currentCommand.serverProfile))) {
                    currentProfile = co;
                }
            }
            
            //executeRemoteCommand("pi","Remote$Access","192.168.1.20",22, "/home/pi/Deluge-disable.sh");
            executeRemoteCommand(currentProfile.userName, currentProfile.password, currentProfile.ipAddress, Integer.valueOf(currentProfile.port).intValue(), currentCommand.commandString);
            
        } catch(Exception e) {
            showToast("error="+e.getMessage());
            writeToLog(e);
        }
      }
    };
    //---------------------------------------------------------------------------------------------------------------------
    commandEditButtonListener = new OnClickListener() {
      public void onClick(View v) {
        int id = v.getId();
        initiateEditMenuPopupWindow(id);
      }
    };
    //---------------------------------------------------------------------------------------------------------------------
    exitCommandButtonListener = new OnClickListener() {
      public void onClick(View v) {
        finish();
        System.exit(-1);
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
    btnProfiles.setOnClickListener(profilesButtonClickListener);
    //---------------------------------------------------------------------------------------------------------------------
    btnExit = (Button) findViewById(R.id.button_exit);
    btnExit.setOnClickListener(exitCommandButtonListener);
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
        //FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name), "|1|Rasp 1|9252|/home/pi/Deluge-disable.sh");
        //FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), "|2|Rasp 2|9252|/home/pi/Deluge-enable.sh");
        /////////////////////////////////////////////////////////////////////////////////////
        refreshMainScreen();
    } catch (Exception e) {
        e.printStackTrace();
        showToast(e.getMessage());
    }


  } //end of onCreate()
  //***********************************************************************************************************************//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.popup_menu, menu);
        return true;
    }
  //***********************************************************************************************************************//
     public String executeRemoteCommand(String username,String password,String hostname,int port, String shellScript) throws Exception {
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
        channelssh.setCommand(shellScript);
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
    public void writeToLog(String msg) {
        try {
            FileUtil.appendStringToFile(MainActivity.this, LOG_FILE_NAME, msg);
        } catch(Exception e) {
            showToast("Unable to write to log file");
        }
   }
    public void writeToLog(Throwable t) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            String msg1 = sw.toString(); // stack trace as a string
            writeToLog(msg1);
        } catch(Exception e) {
            showToast("Unable to write to log file");
        }
   }
  //***********************************************************************************************************************//
    private void initiateEditMenuPopupWindow(final int id) {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_edit_menu_window, (ViewGroup) findViewById(R.id.popup_edit_menu_window));
            popupEditMenuWindow = new PopupWindow(layout, 100, 255, true);
            popupEditMenuWindow.setBackgroundDrawable(new BitmapDrawable()); // this line makes the popup window to disappear when clicked outside (or the back button)
            popupEditMenuWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

            //---------------------------------------------------------------------------------------------------------------------
            Button btnEditCommand = (Button) layout.findViewById(R.id.btn_popup_edit);
            btnEditCommand.setId(id);
            btnEditCommand.setOnClickListener(new OnClickListener() {
              public void onClick(View v) {
                 int id = v.getId();
                 initiateEditCommandPopupWindow(id);
              }
            });
            //------------------------------------------------------------------------------------
            Button btnDeleteCommand = (Button) layout.findViewById(R.id.btn_popup_delete);
            btnDeleteCommand.setId(id);
            btnDeleteCommand.setOnClickListener(new OnClickListener() {
              public void onClick(View v) {
                 int id = v.getId();
                 try {
                    deleteCommand(id);
                    popupEditMenuWindow.dismiss();
                    refreshMainScreen();
                 } catch(Exception e) {
                    showToast(e.getMessage());
                 }
              }
            });
            //------------------------------------------------------------------------------------
            Button btnCopyCommand = (Button) layout.findViewById(R.id.btn_popup_copy);
            btnCopyCommand.setId(id);
            btnCopyCommand.setOnClickListener(new OnClickListener() {
              public void onClick(View v) {
                 int id = v.getId();
                 try {
                    copyCommand(id);
                    popupEditMenuWindow.dismiss();
                    refreshMainScreen();
                    showToast("Command copied.  The last item in the list is the new command...");
                 } catch(Exception e) {
                    showToast(e.getMessage());
                 }
              }
            });
            //------------------------------------------------------------------------------------
            Button btnAddCancel = (Button) layout.findViewById(R.id.btn_popup_add);
            btnAddCancel.setOnClickListener(new OnClickListener() {
              public void onClick(View v) {
                popupEditMenuWindow.dismiss();
                showToast("Please copy an existing command and then edit it...");
              }
            });
            //------------------------------------------------------------------------------------
            Button btnPopupCancel = (Button) layout.findViewById(R.id.btn_popup_cancel);
            btnPopupCancel.setOnClickListener(new OnClickListener() {
              public void onClick(View v) {
                 popupEditMenuWindow.dismiss();
              }
            });
            //------------------------------------------------------------------------------------
        } catch (Exception e) {
            e.printStackTrace();
            showToast(e.getMessage());
        }
    }
  //***********************************************************************************************************************//
    private void initiateEditCommandPopupWindow(final int id) {
        final HashMap<String, Profile> spinnerHashMap = new HashMap();
        try {
            if(popupEditMenuWindow != null) {
                popupEditMenuWindow.dismiss();
            }
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.popup_command_edit_window, (ViewGroup) findViewById(R.id.popup_command_edit_window));
            popupEditMenuWindow = new PopupWindow(layout, 300, 250, true);

            // ---------------- populate screen - start -----------------------
            Command currentCommand = null;
            if(id > -1) {
                List<String> list = FileUtil.readFileContentsAsStringList(MainActivity.this, getString(R.string.command_file_name));
                list = FileUtil.removeBlanks(list);
                for (int i = 0; i < list.size(); i++) {
                    String oneLine = list.get(i);
                    Command co = new Command(oneLine);
                    if(co.id == id) {
                        currentCommand = co;
                    }
                }
                EditText editTextLabel          = (EditText) layout.findViewById(R.id.command_name      );                         editTextLabel        .setText(currentCommand.label);
                EditText editTextCommandString  = (EditText) layout.findViewById(R.id.shell_script_path );                         editTextCommandString.setText(currentCommand.commandString );
            }
            // ---------------- populate screen - end -----------------------
            
            // ---------------- populate dropdown - start -----------------------
            List<String> daysArray = new ArrayList();
            List<String> list = FileUtil.readFileContentsAsStringList(MainActivity.this, getString(R.string.profile_file_name));
            list = FileUtil.removeBlanks(list);
            Profile currentProfile = null;
            int selectedIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                String oneLine = list.get(i);
                Profile co = new Profile(oneLine);
                spinnerHashMap.put(String.valueOf(i), co);
                if(co.id == Integer.valueOf((currentCommand.serverProfile))) {
                    currentProfile = co;
                    selectedIndex = i;
                }
                daysArray.add(co.ipAddress + "_("+co.userName+")");
            }
            spinner1 = (Spinner) layout.findViewById(R.id.server_profile_spinner);
            ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item,daysArray);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter);
            spinner1.setSelection(selectedIndex);
            // ---------------- populate dropdown - end -----------------------

            popupEditMenuWindow.setBackgroundDrawable(new BitmapDrawable()); // this line makes the popup window to disappear when clicked outside (or the back button)
            popupEditMenuWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

            //------------------------------------------------------------------------------------
            Button btnCommandSave = (Button) layout.findViewById(R.id.command_save_button);
            btnCommandSave.setOnClickListener(new OnClickListener() {
               public void onClick(View v) {
                 try {
                    Command currentCommand = new Command();
                    currentCommand.id = id;
                    
                    EditText editTextCommandName     = (EditText) layout.findViewById(R.id.command_name          );         
                    currentCommand.label         = editTextCommandName.getText().toString();
                    
                    Spinner  spinnerServerProfile    = (Spinner)  layout.findViewById(R.id.server_profile_spinner);
                    int spinnerPos = spinnerServerProfile.getSelectedItemPosition();
                    Profile selectedProfile = spinnerHashMap.get(String.valueOf(spinnerPos));
                    currentCommand.serverProfile = String.valueOf(selectedProfile.id);
                    
                    EditText editTextShellScriptPath = (EditText) layout.findViewById(R.id.shell_script_path     );         
                    currentCommand.commandString = editTextShellScriptPath.getText().toString();

                    saveCommand(currentCommand);
                    popupEditMenuWindow.dismiss();
                    refreshMainScreen();
                 } catch(Exception e) {
                    showToast(e.getMessage());
                 }
               }
            });
            //------------------------------------------------------------------------------------
            Button commandEditCancelButton = (Button) layout.findViewById(R.id.command_cancel_button);
            commandEditCancelButton.setOnClickListener(new OnClickListener() {
              public void onClick(View v) {
                 popupEditMenuWindow.dismiss();
              }
            });
            //---------------------------------------------------------------------------------------------------------------------
        } catch (Exception e) {
            showToast(e.getMessage());
        }
    }
  //***********************************************************************************************************************//
  private void initiateProfilesPopupWindow() {
    Intent s = new Intent(MainActivity.this, ProfileActivity.class);
    this.startActivity(s);
  }
  //***********************************************************************************************************************//
  private void saveCommand(Command oneCommand) throws Exception {
    if(oneCommand.id == -1) {
        // get new high ID
        oneCommand.id = (new Random()).nextInt(10000);
        String oneLine = oneCommand.convertToLine();
        FileUtil.appendStringToFile  (this, getString(R.string.command_file_name), oneLine);
    } else {
        List<String> list = FileUtil.readFileContentsAsStringList(MainActivity.this, getString(R.string.command_file_name));
        list = FileUtil.removeBlanks(list);
        Command currentCommand = null;
        for (int i = 0; i < list.size(); i++) {
            String oneLine = list.get(i);
            Command co = new Command(oneLine);
            if(co.id != oneCommand.id) {
                //if different profiles, then copy existing line
                FileUtil.appendStringToFile  (this, getString(R.string.command_file_name_temp), "\n"+oneLine+"\n");
            } else {
                //else copy the incoming Profile
                FileUtil.appendStringToFile  (this, getString(R.string.command_file_name_temp), "\n"+oneCommand.convertToLine()+"\n");
            }
        }
        String tempFileContents = FileUtil.readFileContentsAsString(this, getString(R.string.command_file_name_temp));
        FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name), tempFileContents); // copy contents of temp file to the main command file
        FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name_temp), ""); // empty the contents...
    }

  }
  //***********************************************************************************************************************//
  private void deleteCommand(int id) throws Exception {
        List<String> list = FileUtil.readFileContentsAsStringList(MainActivity.this, getString(R.string.command_file_name));
        list = FileUtil.removeBlanks(list);
        Command currentCommand = null;
        for (int i = 0; i < list.size(); i++) {
            String oneLine = list.get(i);
            Command co = new Command(oneLine);
            if(co.id != id) {
                //if different profiles, then copy existing line
                FileUtil.appendStringToFile  (this, getString(R.string.command_file_name_temp), "\n"+oneLine+"\n");
            } else {
                //else skip the incoming Profile
            }
        }
        String tempFileContents = FileUtil.readFileContentsAsString(this, getString(R.string.command_file_name_temp));
        FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name), tempFileContents); // copy contents of temp file to the main command file
        FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name_temp), ""); // empty the contents...
  }
  //***********************************************************************************************************************//
  private void copyCommand(int id) throws Exception {
        List<String> list = FileUtil.readFileContentsAsStringList(MainActivity.this, getString(R.string.command_file_name));
        list = FileUtil.removeBlanks(list);
        Command currentCommand = null;
        for (int i = 0; i < list.size(); i++) {
            String oneLine = list.get(i);
            Command co = new Command(oneLine);
            if(co.id == id) {
                currentCommand = co;
                currentCommand.id = (new Random()).nextInt(10000);
            }
        }

        FileUtil.appendStringToFile(this, getString(R.string.command_file_name), "\n"+currentCommand.convertToLine()+"\n");
  }
  //***********************************************************************************************************************//
  private void refreshMainScreen() throws Exception {
    try {
		for(int i=0;i<buttonList.size();i++) {
			buttonList.get(i).setVisibility(View.INVISIBLE);
		}
		for(int i=0;i<imageButtonList.size();i++) {
			imageButtonList.get(i).setVisibility(View.INVISIBLE);
		}
        List<String>  profileStrList = null;
        try {
            profileStrList = FileUtil.readFileContentsAsStringList(this, getString(R.string.profile_file_name));
        } catch(Exception e) {
            FileUtil.writeStringToNewFile(this, getString(R.string.profile_file_name), Profile.createDummyProfile().convertToLine());
            profileStrList = FileUtil.readFileContentsAsStringList(this, getString(R.string.profile_file_name));
        }
		profileStrList = FileUtil.removeBlanks(profileStrList);
        if(profileStrList.size() == 0) {
            FileUtil.writeStringToNewFile(this, getString(R.string.profile_file_name), Profile.createDummyProfile().convertToLine());
        }
        profileStrList = FileUtil.readFileContentsAsStringList(this, getString(R.string.profile_file_name));
		profileStrList = FileUtil.removeBlanks(profileStrList);
		Map<String, Profile> profileMap = new HashMap();
        for (int i = 0; i < profileStrList.size(); i++) {
            String oneLine = profileStrList.get(i);
            Profile co = new Profile(oneLine);
			profileMap.put(String.valueOf(co.id), co);
        }
        writeToLog("profileMap="+profileMap);
        //----------------------------------------------------------------------------------------------------------------
        List<String> commandList = null;
		try {
			commandList = FileUtil.readFileContentsAsStringList(this, getString(R.string.command_file_name));
		} catch(Exception e) {
			//if file not found..
	        FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name), Command.createDummyCommand().convertToLine());
			commandList = FileUtil.readFileContentsAsStringList(this, getString(R.string.command_file_name));
		}
		commandList = FileUtil.removeBlanks(commandList);
		if(commandList.size() == 0) {
	        FileUtil.writeStringToNewFile(this, getString(R.string.command_file_name), Command.createDummyCommand().convertToLine());
		}
        writeToLog("commandList="+commandList);

        for (int i = 0; i < commandList.size(); i++) {
            writeToLog("15");
            String oneLine = commandList.get(i);
            Command co = new Command(oneLine);
            Button currentButton = buttonList.get(i);
            currentButton.setVisibility(View.VISIBLE);
            currentButton.setId(co.id);
			Profile serverProfile = profileMap.get(co.serverProfile);
            if(serverProfile == null) {
                // if no coresponding Profile exists, create a dummy profile with that ID
                Profile tempProfile = Profile.createDummyProfile();
                tempProfile.id = Integer.valueOf(co.serverProfile).intValue();
       	        FileUtil.appendStringToFile(this, getString(R.string.profile_file_name), tempProfile.convertToLine());
                serverProfile = tempProfile;
            }
            writeToLog("serverProfile="+serverProfile);
			String profileName = serverProfile.ipAddress + "_(" + serverProfile.userName +")";
            currentButton.setText(co.label +"\n"+ profileName);

            ImageButton currentImageButton = imageButtonList.get(i);
            currentImageButton.setVisibility(View.VISIBLE);
            currentImageButton.setId(co.id);
        }
     } catch(Exception e) {
        showToast(e.getMessage());
        writeToLog(e);
     }
  }

  //***********************************************************************************************************************//
  //***********************************************************************************************************************//
  //***********************************************************************************************************************//

}
