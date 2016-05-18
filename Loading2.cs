using UnityEngine;
using System.Collections;

public class Loading2 : MonoBehaviour {
	
	// Use this for initialization
	void Start () 
	{
		StartCoroutine("Countdown") ;
	}
	
	private IEnumerator Countdown()
	{
		yield return new WaitForSeconds (8);
		Application.LoadLevel (6);
	}
}
