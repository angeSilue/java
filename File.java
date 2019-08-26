/**
 * Implémente une file d'objets (simule la généricité sauf que l'utilisation
 * demande de transtyper les objets reçus)
 * 
 *  
 * @version automne 2012
 */
public class File {
    
	  /*
	  *STRATEGIE : Implémentation statique
	  *
	  *            Nous prendrons un tableau avec deux indices qui servent
	  *            à retenir où se trouve l'élément de début et où se trouve
	  *            l'élément de fin.  Le modulo est utilisé pour simuler
	  *            un tableau circulaire.
	  *            
	  *            La file est vide s'il y a 0 éléments
	  *            La file est pleine si le nombre d'éléments est égal à la taille 
	  *            du tableau
	  *            
	  *            Le constructeur par défaut définit une taille de MIN_ELEMENT
	  */
	 /**********************
	 *attributs
	 ***********************/
	//taille par défaut de la file
	 public static int MIN_ELEMENT = 100;
	 
	 //debut et fin de la file
	 int debut = 0;
	 int fin = 0;
		 
	 //Toujours maintenu à jour
	 int nbElements;
	 
	 //la file est un tableau d'objets
	 Object[] file;
	 
    /**
     * Constructeur par défaut
     * 
     * Il y aura File.MIN_ELEMENT possible dans la file
     */
    public File(){
    	file = new Object[MIN_ELEMENT];
    }
    
    /**
     * Construit une file de la taille demandée
     * @param taille La taille voulue pour la file 
     */
    public File(int taille){
    	file = new Object[taille];
    }
    
    
    /**
     * Met la valeur à la fin de la file
     * @param element l'élément à enfiler
     * @throws FilePleineException  Tente d'enfiler dans une file pleine
     */
    public void ajoute (Object element) throws FilePleineException{
    	
    	//Si la file est pleine, on avise à l'aide d'une exception
    	if(nbElements == file.length)
    		throw new FilePleineException("La file est pleine; il y a déjà " + 
    				                       nbElements + " elements");

    	//On enfile à la fin
    	file[fin] = element;
    	
    	//On déplace l'indice.  Le modulo sert 
    	//à obtenir un 
    	//tableau circulaire (Si ++fin == MIN_ELEMENT alors fin = 0)
    	fin = ++fin % file.length;
    	
    	
    	//Un élément de plus
    	nbElements++;
    }

    /**
     * Retourne la valeur du dessus de la file
     * antecedent : la file ne doit pas être vide
     * consequent : l'élément de tête n'est plus dans la file
     * @return le premier de la file
     * @throws FileVideException  
     */
    public Object obtient () throws FileVideException{
    	Object element = null;
    	    	
    	//Si la file est vide, on avise à l'aide d'une exception
		if(nbElements == 0)
			throw new FileVideException("La file est vide; impossible de défiler");
		
		
		//On récupère le premier élément 
		element = file[debut];
		
		//déplace la tête sur la case suivante
		//de façon circulaire(Si ++debut == MIN_ELEMENT alors debut = 0)
		debut = ++debut % file.length;
		
		//Un élément de moins
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
     * Permet de récupérer la valeur du dessus 
     * de la file sans l'enlever de la file
     * antecedent : la file n'est pas vide
     * @return le premier de la file
     * @throws FileVideException      
     */
    public Object defileSansEnlever() throws FileVideException{
    	
    	
    	//Si la file est vide, on avise à l'aide d'une exception
    	if(nbElements == 0)
		    throw new FileVideException("La file est vide; impossible de défiler");
    	
    	return file[debut];
    }
    
    
    /**
     * Vide la file
     * conséquent : estVide() == true
     * @throws FileVideException  
     */    
    public void vider(){
    	
    	//On place la tête et la fin sur la même case
        debut = fin = 0;
    	nbElements = 0;
    }    
}