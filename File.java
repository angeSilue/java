/**
 * Impl�mente une file d'objets (simule la g�n�ricit� sauf que l'utilisation
 * demande de transtyper les objets re�us)
 * 
 *  
 * @version automne 2012
 */
public class File {
    
	  /*
	  *STRATEGIE : Impl�mentation statique
	  *
	  *            Nous prendrons un tableau avec deux indices qui servent
	  *            � retenir o� se trouve l'�l�ment de d�but et o� se trouve
	  *            l'�l�ment de fin.  Le modulo est utilis� pour simuler
	  *            un tableau circulaire.
	  *            
	  *            La file est vide s'il y a 0 �l�ments
	  *            La file est pleine si le nombre d'�l�ments est �gal � la taille 
	  *            du tableau
	  *            
	  *            Le constructeur par d�faut d�finit une taille de MIN_ELEMENT
	  */
	 /**********************
	 *attributs
	 ***********************/
	//taille par d�faut de la file
	 public static int MIN_ELEMENT = 100;
	 
	 //debut et fin de la file
	 int debut = 0;
	 int fin = 0;
		 
	 //Toujours maintenu � jour
	 int nbElements;
	 
	 //la file est un tableau d'objets
	 Object[] file;
	 
    /**
     * Constructeur par d�faut
     * 
     * Il y aura File.MIN_ELEMENT possible dans la file
     */
    public File(){
    	file = new Object[MIN_ELEMENT];
    }
    
    /**
     * Construit une file de la taille demand�e
     * @param taille La taille voulue pour la file 
     */
    public File(int taille){
    	file = new Object[taille];
    }
    
    
    /**
     * Met la valeur � la fin de la file
     * @param element l'�l�ment � enfiler
     * @throws FilePleineException  Tente d'enfiler dans une file pleine
     */
    public void ajoute (Object element) throws FilePleineException{
    	
    	//Si la file est pleine, on avise � l'aide d'une exception
    	if(nbElements == file.length)
    		throw new FilePleineException("La file est pleine; il y a d�j� " + 
    				                       nbElements + " elements");

    	//On enfile � la fin
    	file[fin] = element;
    	
    	//On d�place l'indice.  Le modulo sert 
    	//� obtenir un 
    	//tableau circulaire (Si ++fin == MIN_ELEMENT alors fin = 0)
    	fin = ++fin % file.length;
    	
    	
    	//Un �l�ment de plus
    	nbElements++;
    }

    /**
     * Retourne la valeur du dessus de la file
     * antecedent : la file ne doit pas �tre vide
     * consequent : l'�l�ment de t�te n'est plus dans la file
     * @return le premier de la file
     * @throws FileVideException  
     */
    public Object obtient () throws FileVideException{
    	Object element = null;
    	    	
    	//Si la file est vide, on avise � l'aide d'une exception
		if(nbElements == 0)
			throw new FileVideException("La file est vide; impossible de d�filer");
		
		
		//On r�cup�re le premier �l�ment 
		element = file[debut];
		
		//d�place la t�te sur la case suivante
		//de fa�on circulaire(Si ++debut == MIN_ELEMENT alors debut = 0)
		debut = ++debut % file.length;
		
		//Un �l�ment de moins
		nbElements--;
		
        return element;
    }
    
    /**
     * @return vrai si la  file est vide et faux sinon
     */
    public boolean estVide(){
        return nbElements == 0;
    }
    
    /**
     * Permet de r�cup�rer la valeur du dessus 
     * de la file sans l'enlever de la file
     * antecedent : la file n'est pas vide
     * @return le premier de la file
     * @throws FileVideException      
     */
    public Object defileSansEnlever() throws FileVideException{
    	
    	
    	//Si la file est vide, on avise � l'aide d'une exception
    	if(nbElements == 0)
		    throw new FileVideException("La file est vide; impossible de d�filer");
    	
    	return file[debut];
    }
    
    
    /**
     * Vide la file
     * cons�quent : estVide() == true
     * @throws FileVideException  
     */    
    public void vider(){
    	
    	//On place la t�te et la fin sur la m�me case
        debut = fin = 0;
    	nbElements = 0;
    }    
}