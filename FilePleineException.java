/**
 * Exception lev�e si on essaie de defiler dans une file pleine

 * @version automne 2012
 */
public class FilePleineException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public  FilePleineException(){}
		
		//le message est r�cup�rable par getMessage()
		public  FilePleineException(String message){
			super(message);
		}
		
}
