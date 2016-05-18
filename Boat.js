var boatClip : AnimationClip;
var Push : GameObject;
private var Boat = false;

function Start () 
{

}

function Update () 
{
	if (Input.GetKeyDown(KeyCode.E) && Boat == true && Push.active == true)
	{
		GameObject.Find("OldBoat").GetComponent.<Animation>().Play("Boat");
	}
}

function OnTriggerEnter (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		Boat = true;
	}
}

function OnTriggerExit (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		Boat = false;
	}
}