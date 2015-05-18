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
import android.widget.EditText;


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
import java.util.Random;

import com.jcraft.jsch.*;

public class ProfileActivity extends Activity {

  //private OnClickListener            backButtonListener  = null;
  private OnClickListener            newProfileButtonClickListener    = null;
  private OnClickListener            editProfileButtonClickListener   = null;
  private OnClickListener            deleteProfileButtonClickListener = null;

  private PopupWindow                popupEditProfileWindow;
  
  Button btnBack;
  Button btnNewProfile;
  Button btnDeleteProfile;
  //---------------------------------------------------------------------------------------------------------------------
  Button button01;     ImageButton imageButton01;
  Button button02;     ImageButton imageButton02;
  Button button03;     ImageButton imageButton03;
  Button button04;     ImageButton imageButton04;
  Button button05;     ImageButton imageButton05;
  
  List<Button> buttonList = new ArrayList();
  List<ImageButton> imageButtonList = new ArrayList();

  //***********************************************************************************************************************//
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //---------------------------------------------------------------------------------------------------------------------
    newProfileButtonClickListener = new OnClickListener() {
      public void onClick(View v) {
         initiateEditProfilePopupWindow(-1);
      }
    };
    //---------------------------------------------------------------------------------------------------------------------
    editProfileButtonClickListener = new OnClickListener() {
      public void onClick(View v) {
        int id = v.getId();
        initiateEditProfilePopupWindow(id);
      }
    };
    //---------------------------------------------------------------------------------------------------------------------
    deleteProfileButtonClickListener = new OnClickListener() {
      public void onClick(View v) {
         try {
			int id = v.getId();
			deleteProfile(id);
			refreshProfileList();
		 } catch(Exception e) {
		 }
      }
    };
    //---------------------------------------------------------------------------------------------------------------------
    setContentView(R.layout.profile_list);
    //---------------------------------------------------------------------------------------------------------------------
    btnNewProfile = (Button) findViewById(R.id.button_new_profile);
    btnNewProfile.setOnClickListener(newProfileButtonClickListener);
    //---------------------------------------------------------------------------------------------------------------------
    
    
    try { 

        button01      = (Button)      findViewById(R.id.profile_01);         button01.setOnClickListener(editProfileButtonClickListener);         button01.setVisibility(View.INVISIBLE);         buttonList.add(button01);
        button02      = (Button)      findViewById(R.id.profile_02);         button02.setOnClickListener(editProfileButtonClickListener);         button02.setVisibility(View.INVISIBLE);         buttonList.add(button02);
        button03      = (Button)      findViewById(R.id.profile_03);         button03.setOnClickListener(editProfileButtonClickListener);         button03.setVisibility(View.INVISIBLE);         buttonList.add(button03);
        button04      = (Button)      findViewById(R.id.profile_04);         button04.setOnClickListener(editProfileButtonClickListener);         button04.setVisibility(View.INVISIBLE);         buttonList.add(button04);
        button05      = (Button)      findViewById(R.id.profile_05);         button05.setOnClickListener(editProfileButtonClickListener);         button05.setVisibility(View.INVISIBLE);         buttonList.add(button05);

        imageButton01 = (ImageButton) findViewById(R.id.imageButton01);    imageButton01.setOnClickListener(deleteProfileButtonClickListener);    imageButton01.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton01);
        imageButton02 = (ImageButton) findViewById(R.id.imageButton02);    imageButton02.setOnClickListener(deleteProfileButtonClickListener);    imageButton02.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton02);
        imageButton03 = (ImageButton) findViewById(R.id.imageButton03);    imageButton03.setOnClickListener(deleteProfileButtonClickListener);    imageButton03.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton03);
        imageButton04 = (ImageButton) findViewById(R.id.imageButton04);    imageButton04.setOnClickListener(deleteProfileButtonClickListener);    imageButton04.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton04);
        imageButton05 = (ImageButton) findViewById(R.id.imageButton05);    imageButton05.setOnClickListener(deleteProfileButtonClickListener);    imageButton05.setVisibility(View.INVISIBLE);    imageButtonList.add(imageButton05);

        /////////////////////////////////////////////////////////////////////////////////////
        int k = 1;
        //FileUtil.writeStringToNewFile(this, getString(R.string.profile_file_name), "|"+k+"|10.10.1." + k++ + "|22|pi|myPassword");
        //FileUtil.appendStringToFile  (this, getString(R.string.profile_file_name), "|"+k+"|10.10.1." + k++ + "|22|pi|myPassword");
        //FileUtil.appendStringToFile  (this, getString(R.string.profile_file_name), "|"+k+"|10.10.1." + k++ + "|22|pi|myPassword");
        //FileUtil.appendStringToFile  (this, getString(R.string.profile_file_name), "|"+k+"|10.10.1." + k++ + "|22|pi|myPassword");
        //FileUtil.appendStringToFile  (this, getString(R.string.profile_file_name), "|"+k+"|10.10.1." + k++ + "|22|pi|myPassword");
        /////////////////////////////////////////////////////////////////////////////////////
        refreshProfileList();
    } catch (Exception ioe) {
        ioe.printStackTrace();
        setTitle("file write false" );
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
    public void showToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
   }
  //***********************************************************************************************************************//
    private void initiateEditProfilePopupWindow(final int id) {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) ProfileActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.popup_profile_edit_window, (ViewGroup) findViewById(R.id.popup_profile_edit_window));
            popupEditProfileWindow = new PopupWindow(layout, 300, 250, true);
            popupEditProfileWindow.setBackgroundDrawable(new BitmapDrawable()); // this line makes the popup window to disappear when clicked outside (or the back button)
            popupEditProfileWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
            
            if(id > -1) {
                List<String> list = FileUtil.readFileContentsAsStringList(ProfileActivity.this, getString(R.string.profile_file_name));
				list = FileUtil.removeBlanks(list);
                Profile currentProfile = null;
                for (int i = 0; i < list.size(); i++) {
                    String oneLine = list.get(i);
                    Profile co = new Profile(oneLine);
                    setTitle("33=="+co.id +","+id);
                    if(co.id == id) {
                        setTitle("4");
                        currentProfile = co;
                    }
                }

                EditText ipAddress = (EditText) layout.findViewById(R.id.ip_address      );         ipAddress.setText(currentProfile.ipAddress);
                EditText port      = (EditText) layout.findViewById(R.id.ip_address_port );         port     .setText(currentProfile.port     );
                EditText userName  = (EditText) layout.findViewById(R.id.username        );         userName .setText(currentProfile.userName );
                EditText password  = (EditText) layout.findViewById(R.id.password        );         password .setText(currentProfile.password );
            } else {
                setTitle("id = -1");
			}
            
            //------------------------------------------------------------------------------------
            Button btnProfileSave = (Button) layout.findViewById(R.id.profile_save_button);
            btnProfileSave.setOnClickListener(new OnClickListener() {
               public void onClick(View v) {
                 try {
                    Profile currentProfile = new Profile();
                    currentProfile.id = id;
                    EditText editTextIpAddress = (EditText) layout.findViewById(R.id.ip_address      );         currentProfile.ipAddress = editTextIpAddress.getText().toString();
                    EditText editTextPort      = (EditText) layout.findViewById(R.id.ip_address_port );         currentProfile.port      = editTextPort     .getText().toString();
                    EditText editTextUserName  = (EditText) layout.findViewById(R.id.username        );         currentProfile.userName  = editTextUserName .getText().toString();
                    EditText editTextPassword  = (EditText) layout.findViewById(R.id.password        );         currentProfile.password  = editTextPassword .getText().toString();
                    saveProfile(currentProfile);
					popupEditProfileWindow.dismiss();
					refreshProfileList();
                 } catch(Exception e) {
                    showToast(e.getMessage());
                 }
               }
            });
            //------------------------------------------------------------------------------------
            Button btnPopupCancel = (Button) layout.findViewById(R.id.profile_cancel_button);
            btnPopupCancel.setOnClickListener(new OnClickListener() {
               public void onClick(View v) {
                 popupEditProfileWindow.dismiss();
               }
            });
            //------------------------------------------------------------------------------------
        } catch (Exception e) {
            //e.printStackTrace();
			//showToast(e.getMessage());
        }
    }   
  //***********************************************************************************************************************//
  //private void saveProfile(int id)  throws Exception {
  //  Profile currentProfile = new Profile();
  //  currentProfile.id = id;
  //  LayoutInflater inflater = (LayoutInflater) ProfileActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  //  View layout = inflater.inflate(R.layout.popup_profile_edit_window, (ViewGroup) findViewById(R.id.popup_profile_edit_window));
  //
  //  EditText editTextIpAddress = (EditText) layout.findViewById(R.id.ip_address     );
  //  showToast("aaa="+editTextIpAddress.getText());
  //  //showToast("bbb="+editTextIpAddress.getText().toString());
  //  currentProfile.ipAddress = editTextIpAddress.getText().toString();
  //  EditText editTextPort      = (EditText) layout.findViewById(R.id.ip_address_port);         currentProfile.port      = editTextPort     .getText().toString();
  //  EditText editTextUserName  = (EditText) layout.findViewById(R.id.username       );         currentProfile.userName  = editTextUserName .getText().toString();
  //  EditText editTextPassword  = (EditText) layout.findViewById(R.id.password       );         currentProfile.password  = editTextPassword .getText().toString();
  //  //showToast("currentProfile==="+currentProfile.convertToLine());
  //  saveProfile(currentProfile);
  //}
  //***********************************************************************************************************************//
  private void saveProfile(Profile oneProfile) throws Exception {
    if(oneProfile.id == -1) {
        // get new high ID
        oneProfile.id = (new Random()).nextInt(10000);
        String oneLine = oneProfile.convertToLine();
        FileUtil.appendStringToFile  (this, getString(R.string.profile_file_name), "\n"+oneLine+"\n");
    } else {
        List<String> list = FileUtil.readFileContentsAsStringList(ProfileActivity.this, getString(R.string.profile_file_name));
		list = FileUtil.removeBlanks(list);
        Profile currentProfile = null;
        for (int i = 0; i < list.size(); i++) {
            String oneLine = list.get(i);
            Profile co = new Profile(oneLine);
            if(co.id != oneProfile.id) {
                //if different profiles, then copy existing line
                FileUtil.appendStringToFile  (this, getString(R.string.profile_file_name_temp), "\n"+oneLine+"\n");
            } else {
                //else copy the incoming Profile
                FileUtil.appendStringToFile  (this, getString(R.string.profile_file_name_temp), "\n"+oneProfile.convertToLine()+"\n");
            }
        }
        String tempFileContents = FileUtil.readFileContentsAsString(this, getString(R.string.profile_file_name_temp));
        FileUtil.writeStringToNewFile(this, getString(R.string.profile_file_name), tempFileContents); // copy contents of temp file to the main profile file
        FileUtil.writeStringToNewFile(this, getString(R.string.profile_file_name_temp), ""); // empty the contents...
    }

  }
  //***********************************************************************************************************************//
  private void deleteProfile(int id) throws Exception {
        List<String> list = FileUtil.readFileContentsAsStringList(ProfileActivity.this, getString(R.string.profile_file_name));
		list = FileUtil.removeBlanks(list);
        Profile currentProfile = null;
        for (int i = 0; i < list.size(); i++) {
            String oneLine = list.get(i);
            Profile co = new Profile(oneLine);
            if(co.id != id) {
                //if different profiles, then copy existing line
                FileUtil.appendStringToFile  (this, getString(R.string.profile_file_name_temp), "\n"+oneLine+"\n");
            } else {
                //else skip the incoming Profile
            }
        }
        String tempFileContents = FileUtil.readFileContentsAsString(this, getString(R.string.profile_file_name_temp));
        FileUtil.writeStringToNewFile(this, getString(R.string.profile_file_name), tempFileContents); // copy contents of temp file to the main profile file
        FileUtil.writeStringToNewFile(this, getString(R.string.profile_file_name_temp), ""); // empty the contents...
  }
  //***********************************************************************************************************************//
  private void refreshProfileList() throws Exception {
		for(int i=0;i<buttonList.size();i++) {
			buttonList.get(i).setVisibility(View.INVISIBLE);
		}
		for(int i=0;i<imageButtonList.size();i++) {
			imageButtonList.get(i).setVisibility(View.INVISIBLE);
		}
        List<String> list = FileUtil.readFileContentsAsStringList(this, getString(R.string.profile_file_name));
		list = FileUtil.removeBlanks(list);
        for (int i = 0; i < list.size(); i++) {
            String oneLine = list.get(i);
            Profile co = new Profile(oneLine);
            Button currentButton = buttonList.get(i);
            currentButton.setVisibility(View.VISIBLE);
            currentButton.setId(co.id);
            currentButton.setText(co.ipAddress);
            
            ImageButton currentImageButton = imageButtonList.get(i);
            currentImageButton.setVisibility(View.VISIBLE);
            currentImageButton.setId(co.id);
        }
  }
  //***********************************************************************************************************************//
  //***********************************************************************************************************************//
  //***********************************************************************************************************************//
}
