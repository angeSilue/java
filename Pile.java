/*
 * Implémente une pile d'objets(simule la généricité sauf que l'utilisation
 * demande de transtyper les objets reçus)
 * 
 * @version automne 2012
 */
public class Pile {

	/**
	 * STRATÉGIE : implémentation dynamique par chaînage simple
	 * 
	  *            Une pile est un ou pls noeuds liés ensembles
	  *
	  *            Une référence pointant toujours sur le premier objet (sommet)
	  *
	  */
	 private class Noeud{
		 
		 //même privées, les instances peuvent être utilisées directement
		 //par la classe parent cela évite les observateurs et les mutateurs
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

	 
	 //Toujours maintenu à jour
	 int nbElement;

	 //On laisse accessible le constructeur par défaut
	 public Pile(){}
	 
    /**
     * Met la valeur au dessus de la pile
     * @param la valeur à empiler
     */
    public void ajoute (Object valeur) throws PilePleineException{

    	//Le sommet est un nouveau noeud
    	//contenant la valeur et un lien sur l'ancien sommet
    	try{
    		sommet = new Noeud(valeur, sommet);
    		nbElement++;
    	}
    	
    	//En allocation dynamique, une pile pleine c'est qu'il
    	//n'y a plus de mémoire.  Il faut en libérer
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
    	
    	//On retourne l'élément contenu
    	//dans le sommet et on retire le noeud
    	//en mettant le sommet sur le noeud suivant.
    	
    	//Pas besoin de s'occuper de la mémoire à cause
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
     * Permet de récupérer la valeur du dessus 
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
     * @return nombre d'éléments actuellement dans la pile
     */
    public int getNbElements(){
    	return nbElement;
    }
    
    /**
     * Vide la pile
     * conséquent : estVide() == true
     */
    public void vider() throws PileVideException{
    	
    	//Nous assumons l'existence du ramasse-miettes (System.gc())
    	sommet = null;
    }
    
    /**
     * Retourne un tableau dont les objets sont 
     * disposés dans le même sens que la Pile.
     *
     * Cela signifie que l'élément du dessus de la pile
     * est dans la première case du tableau.
     * 
     * @return Un tableau des objets de la pile
     */
    public Object[] toArray(){
    	
		//Le tableau à retourner
		Object[] tab = new Object[nbElement];
		
		//Référence temporaire pour parrourir la pile
		Noeud tmp = sommet;
		
		//Indice du tableau
		int i = 0;

		//Tant qu'on a pas atteint la fin de la pile
		while(tmp != null){
			
			//On retient dans le tableau
			tab[i] = tmp.element;
			
			//On passe à l'élément suivant dans la pile
			tmp = tmp.suivant;	
			
			//On place l'itérateur pour le prochain ajout
			i++;
		}
		
		return tab;
		
    }
    	
}