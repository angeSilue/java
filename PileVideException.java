/**
 * Exception lev�e si on essaie de depiler dans une pile vide
 *
 * @version automne 2012
 */
public class PileVideException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public  PileVideException(){}
		
		//le message est r�cup�rable par getMessage()
		public  PileVideException(String message){
			super(message);
		}
		
}
