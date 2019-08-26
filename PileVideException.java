/**
 * Exception levée si on essaie de depiler dans une pile vide
 *
 * @version automne 2012
 */
public class PileVideException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public  PileVideException(){}
		
		//le message est récupérable par getMessage()
		public  PileVideException(String message){
			super(message);
		}
		
}
