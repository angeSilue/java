/**
 * Exception lev�e si on essaie de defiler dans une file vide

 * @version automne 2012
 */
public class FileVideException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  FileVideException(){}

	//le message est r�cup�rable par getMessage()
	public  FileVideException(String message){
		super(message);
	}

}
