/*
 * Impl�mente une pile d'objets(simule la g�n�ricit� sauf que l'utilisation
 * demande de transtyper les objets re�us)
 * 
 * @version automne 2012
 */
public class Pile {

	/**
	 * STRAT�GIE : impl�mentation dynamique par cha�nage simple
	 * 
	  *            Une pile est un ou pls noeuds li�s ensembles
	  *
	  *            Une r�f�rence pointant toujours sur le premier objet (sommet)
	  *
	  */
	 private class Noeud{
		 
		 //m�me priv�es, les instances peuvent �tre utilis�es directement
		 //par la classe parent cela �vite les observateurs et les mutateurs
		 private Object element;
		 private Noeud suivant;	 
		 
		 //constructeur par copie d'attributs
		 public Noeud(Object element, Noeud lien){
			 this.element = element;
			 suivant = lien;
		 }
	 }
	 
	 /**********************
	 *attributs
	 ***********************/
	 //sommet de la pile
	 Noeud sommet = null;

	 
	 //Toujours maintenu � jour
	 int nbElement;

	 //On laisse accessible le constructeur par d�faut
	 public Pile(){}
	 
    /**
     * Met la valeur au dessus de la pile
     * @param la valeur � empiler
     */
    public void ajoute (Object valeur) throws PilePleineException{

    	//Le sommet est un nouveau noeud
    	//contenant la valeur et un lien sur l'ancien sommet
    	try{
    		sommet = new Noeud(valeur, sommet);
    		nbElement++;
    	}
    	
    	//En allocation dynamique, une pile pleine c'est qu'il
    	//n'y a plus de m�moire.  Il faut en lib�rer
    	//avant de lever la nouvelle exception.
    	catch(OutOfMemoryError e){
    		
    		//On force le ramasse-miettes.
    		System.gc();
    		throw new PilePleineException();
    	}    	
    }

    /**
     * Retourne la valeur du dessus de la pile
     * antecedent : la pile ne doit pas etre vide
     * consequent : la valeur du dessus n'est plus dans la pile
     * @return la valeur du dessus
     * @throws PileVideException  
     */
    public Object obtient () throws PileVideException{
    	
    	//La pile est vide si le sommet est null
    	if(sommet == null)
    		throw new PileVideException();
    	
    	//On retourne l'�l�ment contenu
    	//dans le sommet et on retire le noeud
    	//en mettant le sommet sur le noeud suivant.
    	
    	//Pas besoin de s'occuper de la m�moire � cause
    	//du ramasse-miettes
        Object element = sommet.element;
    	sommet = sommet.suivant;
    	
    	nbElement--;
    	
    	return element;
    }
    
    /**
     * Retourne si la pile est vide
     * @return vrai si la  pile est vide et faux sinon
     */
    public boolean estVide(){
        return sommet == null;
    }
    
    /**
     * Permet de r�cup�rer la valeur du dessus 
     * de la pile sans l'enlever de la pile
     * antecedent : la pile ne doit pas etre vide
     * @return la valeur du dessus
     * @throws PileVideException      
     */
    public Object depileSansEnlever() throws PileVideException{
    	if(sommet == null)
    		throw new PileVideException();
    	
    	//retourne la valeur sans toucher au sommet
    	return sommet.element;
    	
    }
    
    /**
     * @return nombre d'�l�ments actuellement dans la pile
     */
    public int getNbElements(){
    	return nbElement;
    }
    
    /**
     * Vide la pile
     * cons�quent : estVide() == true
     */
    public void vider() throws PileVideException{
    	
    	//Nous assumons l'existence du ramasse-miettes (System.gc())
    	sommet = null;
    }
    
    /**
     * Retourne un tableau dont les objets sont 
     * dispos�s dans le m�me sens que la Pile.
     *
     * Cela signifie que l'�l�ment du dessus de la pile
     * est dans la premi�re case du tableau.
     * 
     * @return Un tableau des objets de la pile
     */
    public Object[] toArray(){
    	
		//Le tableau � retourner
		Object[] tab = new Object[nbElement];
		
		//R�f�rence temporaire pour parrourir la pile
		Noeud tmp = sommet;
		
		//Indice du tableau
		int i = 0;

		//Tant qu'on a pas atteint la fin de la pile
		while(tmp != null){
			
			//On retient dans le tableau
			tab[i] = tmp.element;
			
			//On passe � l'�l�ment suivant dans la pile
			tmp = tmp.suivant;	
			
			//On place l'it�rateur pour le prochain ajout
			i++;
		}
		
		return tab;
		
    }
    	
}