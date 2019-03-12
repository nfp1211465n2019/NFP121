package question3;
import java.text.Normalizer;

/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version septembre 2009
 * @author à compléter
 * @see java.lang.String, java.lang.Math
 */
public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;
    
    private String regEx = "[- ]";// trouve ce qui contient "-" ou un espace vide
    private String replacedChar = "_"; // le charachtre qu'on doit remplace par
    /**
     * "Création", le constructeur d'un auditeur avec son nom, son prénom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son prénom
     * @param matricule
     *            sur la carte d'inscription, près de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premières lettres du nom suivies de la première
     * lettre du prénom séparées de '_' . le login retourné est en minuscules,
     * le trait d'union, ou spéciaux <i>(pour unix)</i> sont remplacés par des
     * '_' pas de caractères accentués pour le login voir les classes
     * prédéfines, java.lang.String : les méthodes replaceAll, toLowerCase et
     * substring java.lang.Math : la méthode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifié, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() {
         String finalLogin = nom;
        if(nom != ""){
            String tempNom = Normalizer.normalize(nom, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""); 
            //pour remplaces les caracteres accentues par des caracteres non accentues
            tempNom = tempNom.replaceAll(regEx, replacedChar);
            String tempPrenom = prenom.substring(0,1);
            if(nom.length() >= 6){
                tempNom = tempNom.substring(0,6);
                finalLogin = (tempNom + "_" + tempPrenom).toLowerCase();
            }
            else{
                finalLogin = (tempNom + "_" + tempPrenom).toLowerCase();
            }
        }
        return finalLogin;
    }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return nom;
    }

    /**
     * Lecture du prénom de l'auditeur.
     * 
     * @return son prénom
     */
    public String prenom() {
        return nom;
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return matricule;
    }
    public void changeName(String replacementName){
        nom = replacementName;
    }
    
    /**
     * méthode toString ( méthode redéfinie de la classe Object).
     * 
     * @return la concaténation du nom, du prénom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
