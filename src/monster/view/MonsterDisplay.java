package monster.view;

import javax.swing.JOptionPane;

public class MonsterDisplay
{
	public void diplayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null,  textToDisplay);
	}
	
	public String getResponse(String textToDisplay)
	{
		String response = "";
		response+= JOptionPane.showInputDialog(null, textToDisplay);
		return response;
	}
}
