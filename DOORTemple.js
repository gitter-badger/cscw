var doorClip1 : AnimationClip;
var Key1 : GameObject;
private var Door1 = false;

function Start () 
{

}

function Update () 
{
	if (Input.GetKeyDown(KeyCode.E) && Door1 == true && Key1.active == true)
	{
		GameObject.Find("Door1").GetComponent.<Animation>().Play("doorOpen1");
	}
}

function OnTriggerEnter (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		Door1 = true;
	}
}

function OnTriggerExit (theCollider : Collider)
{
	if (theCollider.tag == "Player")
	{
		Door1 = false;
	}
}