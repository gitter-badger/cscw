	 var treasure : int = 0;
     var treasuresToWin : int = 30;		//number to win!
    
     function OnTriggerEnter( other : Collider )
      {
        	if (other.gameObject.tag == "treasure")
        	{
           	  	treasure += 1;
           	  	Debug.Log("A treasure was picked up. Total treasure = " + treasure);
           	  	Destroy(other.gameObject);
        	 }
      }
	 
     function OnGUI()
     {
         if (treasure < treasuresToWin)
         {
             GUI.Box(Rect((Screen.width/2)-100, 10, 200, 35), "" + treasure + " treasure");
         }
         else
         {
             GUI.Box(Rect((Screen.width/2)-100, 10, 200, 35), "All Treasures Collected!");
             Application.LoadLevel (Application.loadedLevel + 1);
         }
     }