#pragma strict

function Start () {

}

function OnTriggerEnter () {
	Application.LoadLevel (Application.loadedLevel + 1);
}