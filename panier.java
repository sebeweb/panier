/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjava;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Sébastien JAVARY
 */
public class panier {

    // fontion qui permet d'ajouter des produits 
    public static void ajout(HashMap panier) {
        //on initialise un nouveau Scanner
        Scanner sc = new Scanner(System.in);
        //on affiche une question
        System.out.println("Quelle produit souhaiter vous ajouter ?");
        //on recupere la reponse
        String produit = sc.nextLine();
        System.out.println("quantite de " + produit + "?");
        int quantite = sc.nextInt();
        //on enregistre les reponses dans la variable panier
        panier.put(produit, quantite);
    }
//la fonction choix affiche les choix et redirige vers le fonction adequat
    public static void choix(HashMap panier) {
        //on initialise un nouveau Scanner
        Scanner sc = new Scanner(System.in);
         //on initialise un flag a false
        boolean flag = false;
        //on boucle tanque le flag est a faux
        while (flag == false) {
            System.out.println("Que souhaitez vous faire ?\r\n1-ajouter des produits au panier");
            // si le panier n'est pas vide
            if (panier.isEmpty() == false) {
                //alors on affiche des option suplemantaire
                System.out.println("2-afficher le panier\r\n3-supprimer un produit du panier");
            }
            System.out.println("q pour quitter");
            String action = sc.nextLine();
            switch (action) {
                case "q":
                    System.exit(0);
                case "1":
                    ajout(panier);
                    break;
                case "2":
                    affichage(panier);
                    break;
                case "3":
                    supprimer(panier);
                    break;
                default:
                    System.out.println("je ne comprent pas");
                    ;
            }
        }
    }

    public static void affichage(HashMap<String, Integer> panier) {
        //pour chaque ligne du tableau
        for (Map.Entry<String, Integer> entry : panier.entrySet()) {
            //on recupere la Key
            String key = entry.getKey();
            //et la value
            int value = entry.getValue();
            //on finit en les affichant separer par :
            System.out.println(key + " : " + value);
        }
    }

    public static void supprimer(HashMap panier) {
        System.out.println("Quelle produit souhaiter vous supprimer ?(a pour annuler)");
        Scanner sc = new Scanner(System.in);
        String action = sc.nextLine();
        //si action est = a "a"
        if ("a".equals(action)) {
//            alors on retourne aux choix
            choix(panier);
//        ou sinon on regarde le mot stoker dans action se trouver dans notre panier 
        } else if (panier.containsKey(action)) {
//            si c'est vrai alors on supprime la ligne
            panier.remove(action);
            System.out.println(action + " a été supprimer du panier");
        }
    }

    public static void main(String[] args) {
        // on initialise une HashMap qui a pour Key une String et pour Valeur un Integer
        HashMap<String, Integer> panier = new HashMap<>();
        //on appel la fonction choix qui prend en parametre panier
        choix(panier);
    }
}
