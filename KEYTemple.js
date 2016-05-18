var TheKey1 : GameObject;
var button2InRange;
var button2Activated;

public var guiSkin : GUISkin;

private var hasPlayed1 = false;
private var playerNextToKey1 = false;

function Update () 
{
 	if (Input.GetKeyDown(KeyCode.E) && playerNextToKey1 == true)
	{
		TheKey1.active = false;
	}
	if (button2InRange == true)
	{
		if (Input.GetKeyDown ("e"))
		{
			if(!hasPlayed1)
			{
				Destroy(gameObject);
				hasPlayed1 = true;
			
			}
		
		}
	
	}
}

function OnTriggerEnter (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		playerNextToKey1 = true;
		button2InRange = true;
	}
}

function OnTriggerExit (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		playerNextToKey1 = false;
		button2InRange = false;
	}
}


function OnGUI ()
{
	if(button2InRange == true)
	{
		GUI.skin = guiSkin;
		GUI.Label (Rect (Screen.width/2-50, Screen.height/2-55, 120, 50), "Press 'e' to pick up the secret stone");
	
	}

}
