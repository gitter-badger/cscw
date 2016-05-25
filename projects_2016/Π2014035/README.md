#Τίτλος Εργασίας: Android Sports App
Μέλη Ομάδας:
-Μιχαήλ Χ. Παγκρακιώτης (Α.Μ.: Π2014035)
-Γεώργιος Σκουτέλας (Α.Μ. Π2014113)


##Παραδοτέο 1

...

##Παραδοτέο 2

…

##Παραδοτέο 3

...

##Παραδοτέο 4

...

##Tελική Αναφορά

//#########################################################################################################################
//_______ INFO: ___________________________________________________________________________________________________________
//	SitUps_Lite translation from AppInventor2 to Java via libSimpleAndroidRuntime
//
//_______ Μέλη της Ομάδας: ________________________________________________________________________________________________
//	Παγκρακιώτης Μιχαήλ Χ.	(Π2014035)
//	Σκουτέλας Γεώργιος		(Π2014113)
//
//_______ Links: __________________________________________________________________________________________________________
//	http://3nportal.com/AIBridge/API/
//	https://www.youtube.com/watch?v=FqNTc4DVYW8
//	http://www.newthinktank.com/2014/05/convert-app-inventor-java/
//_________________________________________________________________________________________________________________________
//#########################################################################################################################

package com.myapplication0234.SitUps_Lite;

import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.AccelerometerSensor;
import com.google.devtools.simple.runtime.components.android.Clock;
import com.google.devtools.simple.runtime.components.android.Form;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.TableArrangement;
import com.google.devtools.simple.runtime.events.EventDispatcher;

public class MainActivity extends Form implements HandlesEventDispatching	//this class represents the Screen1
{
    private TableArrangement tableArrangement1;
    private Label stopwatch;
    private Label stopwatchLabel;
    private Label sitUpsCounterLabel;
    private Label sitUpsCounter;
    private AccelerometerSensor accelerometerSensor1;
    private Clock stopwatchClock;

    private boolean counterSitUpsChanged = false;
    private float xAccel;

    public MainActivity(float xAccel) {
        this.xAccel = xAccel;
    }


    void $define()
    {
        this.AlignHorizontal(ALIGNMENT_CENTER);
        this.AlignVertical(ALIGNMENT_CENTER);
        //this.AppName("SitUps_Lite");
        this.ScreenOrientation(LAYOUT_ORIENTATION_HORIZONTAL);
        this.BackgroundColor(COLOR_WHITE);
        this.Scrollable(false);
        this.Title("Screen1");

        //			---initialization---

        tableArrangement1 = new TableArrangement(this);	//"this" refers to this screen (Screen1). It's like saying "Put tableArrangement1 in Screen1"
        tableArrangement1.Columns(2);
        tableArrangement1.Rows(2);


        stopwatch = new Label(tableArrangement1);
        stopwatch.FontBold(true);
        stopwatch.Text("0");		//Στο app inventor το 0 είναι integer γιατί κάνω πράξεις. Εδώ θέλει "0"

        stopwatchLabel = new Label(tableArrangement1);
        stopwatchLabel.Text("Stopwatch:");

        sitUpsCounterLabel = new Label(tableArrangement1);
        sitUpsCounterLabel.Text("Sit-Ups counter:");

        sitUpsCounter = new Label(tableArrangement1);
        sitUpsCounter.FontBold(true);
        sitUpsCounter.Text("Sit-Ups counter:");

        accelerometerSensor1 = new AccelerometerSensor(this);
        //accelerometerSensor1.MinimumInterval(400); // Interval: Refresh rate  //Caution: The number of interval remains default, cannot be changed!
        //accelerometerSensor1.Sensitivity(2); //The choices are: 1 = weak, 2 = moderate, 3 = strong

        stopwatchClock = new Clock(this);
        stopwatchClock.TimerEnabled(true);
        stopwatchClock.TimerAlwaysFires(true);
        stopwatchClock.TimerInterval(1000);

        EventDispatcher.registerEventForDelegation(this, "AccelerometerSensorChanged", "AccelerationChanged");

        EventDispatcher.registerEventForDelegation(this, "ClockTimerChanged", "Timer");
    }

    private void ScreenOrientation(int layoutOrientationHorizontal)
	{
	
	}

    private void AlignVertical(int alignmentCenter)
	{

    }

    private void AlignHorizontal(int alignmentCenter)
	{

    }

    public void MinimumInterval(int interval)
	{
	
	}

    private float XAccel() 
	{
        return xAccel;
    }

    @Override
    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] args)
	{

        if(component.equals(accelerometerSensor1) && eventName.equals("AccelerationChanged"))
        {
            xAccel = XAccel();
            if(xAccel>=8 && xAccel<=10 && counterSitUpsChanged==false)
            {
                sitUpsCounter.Text(sitUpsCounter.Text() + 1);
                counterSitUpsChanged = true;
            }
            else if(xAccel>=0 && xAccel<=4 && counterSitUpsChanged == true)
            {
                counterSitUpsChanged = false;
            }

            return true;
        }

        if(component.equals(stopwatchClock) && (eventName.equals("Timer")))
        {
            stopwatch.Text(stopwatch.Text() + 1);

            return true;
        }

        return false;

        //return super.dispatchEvent(component, componentName, eventName, args);
    }
}
