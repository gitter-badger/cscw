var doorClip : AnimationClip;
var Key : GameObject;
private var Door = false;

function Start () 
{

}

function Update () 
{
	if (Input.GetKeyDown(KeyCode.E) && Door == true && Key.active == false)
	{
		GameObject.Find("Door").GetComponent.<Animation>().Play("doorOpen");
	}
}

function OnTriggerEnter (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		Door = true;
	}
}

function OnTriggerExit (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		Door = false;
	}
}