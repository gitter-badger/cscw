#pragma strict

var pauseCanvas : Canvas;


function Start () {

//	Screen.lockCursor = true;
	
	Cursor.visible = false;
	pauseCanvas.enabled = false;

}

function Update () {
	if (Input.GetKeyDown(KeyCode.Escape))
	{
		//(gameObject.Find("Main Camera").GetComponent("MouseLook") as MonoBehaviour).enabled = false;
		pauseCanvas.enabled = true;
		Time.timeScale = 0;
//		Screen.lockCursor = false;
		Cursor.visible = true;
		
	}
}

function ResumeGame () 
{
		pauseCanvas.enabled = false;
		Time.timeScale = 1;
//		Screen.lockCursor = true;
		Cursor.visible = false;
		
}

function ExitGame () 
{
		Application.Quit();
}

function ExitToMain () 
{
		Application.LoadLevel("MainMenu");
		pauseCanvas.enabled = false;
		Time.timeScale = 1;
}