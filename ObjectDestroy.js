#pragma strict

function OnTriggerEnter (other : Collider )
{
	if(other.tag == "Player")
	{
		yield WaitForSeconds(7);
		Destroy (gameObject);
	}
}