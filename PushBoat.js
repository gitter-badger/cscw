var ThePush : GameObject;
var buttonInRangeP;
var buttonActivatedP;

public var guiSkin : GUISkin;

private var hasPlayedP = false;
private var playerNextToPush = false;

function Update () 
{
 	if (Input.GetKeyDown(KeyCode.E) && playerNextToPush == true)
	{
		ThePush.active = true;
	}
	if (buttonInRangeP == true)
	{
		if (Input.GetKeyDown ("e"))
		{
			if(!hasPlayedP)
			{
				//Destroy(gameObject);
				hasPlayedP = true;
			
			}
		
		}
	
	}
}

function OnTriggerEnter (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		playerNextToPush = true;
		buttonInRangeP = true;
	}
}

function OnTriggerExit (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		playerNextToPush = false;
		buttonInRangeP = false;
	}
}


function OnGUI ()
{
	if(buttonInRangeP == true)
	{
		GUI.skin = guiSkin;
		GUI.Label (Rect (Screen.width/2-50, Screen.height/2-55, 120, 50), "Press 'e' to push the boat into the sea");
	
	}

}
