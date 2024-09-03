package ca.yorku.eecs.mack.picturescaling;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Author: Mazen Kaseb
 */

public class MainActivity extends Activity
{
    PaintPanel imagePanel; // the panel in which to paint the image
    StatusPanel statusPanel; // a status panel the display the image coordinates, size, and scale
    Button rotateButton; //Defined a rotate button here as my new feature for this program

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // hide title bar
        setContentView(R.layout.main);

        // get references to UI components
        // cast removed (not needed anymore, avoids warning message)
        imagePanel = findViewById(R.id.paintpanel);
        statusPanel = findViewById(R.id.statuspanel);

        // give the image panel a reference to the status panel
        imagePanel.setStatusPanel(statusPanel);

        //Assigned the rotate button to its correct Id, and set an onclicklistener for the button to be able
        //to read our clicks
        rotateButton = findViewById(R.id.rotateImage);
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePanel.setRotation(imagePanel.getRotation() + 90);
            }
        }
        );
    }

    // Called when the "Reset" button is pressed.
    public void clickReset(View view)
    {
        imagePanel.xPosition = 10;
        imagePanel.yPosition = 10;
        imagePanel.scaleFactor = 1f;
        imagePanel.invalidate();
        imagePanel.setRotation(0F); //added a set rotation that allows the image to reset when the reset button is clicked in the case it was rotated
    }
}