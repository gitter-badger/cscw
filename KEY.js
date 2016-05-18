var TheKey : GameObject;
var button1InRange;
var button1Activated;

public var guiSkin : GUISkin;

private var hasPlayed = false;
private var playerNextToKey = false;

function Update () 
{
 	if (Input.GetKeyDown(KeyCode.E) && playerNextToKey == true)
	{
		TheKey.active = false;
	}
	if (button1InRange == true)
	{
		if (Input.GetKeyDown ("e"))
		{
			if(!hasPlayed)
			{
				Destroy(gameObject);
				hasPlayed = true;
			
			}
		
		}
	
	}
}

function OnTriggerEnter (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		playerNextToKey = true;
		button1InRange = true;
	}
}

function OnTriggerExit (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		playerNextToKey = false;
		button1InRange = false;
	}
}


function OnGUI ()
{
	if(button1InRange == true)
	{
		GUI.skin = guiSkin;
		GUI.Label (Rect (Screen.width/2-50, Screen.height/2-55, 120, 50), "Press 'e' to pick up the secret stone");
	
	}

}
