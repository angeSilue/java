/**
 * Exception levée si on essaie de empiler dans une pile pleine
 *
 * @version automne 2012
 */
public class PilePleineException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public  PilePleineException(){}
		
		//le message est récupérable par getMessage()
		public  PilePleineException(String message){
			super(message);
		}
		
}
